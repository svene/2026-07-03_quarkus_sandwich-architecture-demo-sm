package org.svenehrke.demo.devsupport;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

import com.tngtech.archunit.ArchConfiguration;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ArchitectureTest {
	private static String PKG_ROOT = "org.svenehrke.demo";
	private static String PKG_CORE = PKG_ROOT + ".core";
	private static String PKG_INBOUND = PKG_ROOT + ".inbound";
	private static String PKG_OUTBOUND = PKG_ROOT + ".outbound";

	JavaClasses importedClasses;

	@BeforeEach
	void beforeEach() {
		ArchConfiguration.get().setProperty("import.dependencyResolutionProcess.maxIterationsForMemberTypes", "0");
		ArchConfiguration.get().setProperty("import.dependencyResolutionProcess.maxIterationsForAccessToTypes", "0");
		ArchConfiguration.get().setProperty("import.dependencyResolutionProcess.maxIterationsForSupertypes", "0");
		ArchConfiguration.get().setProperty("import.dependencyResolutionProcess.maxIterationsForEnclosingTypes", "0");
		ArchConfiguration.get().setProperty("import.dependencyResolutionProcess.maxIterationsForGenericSignatureTypes", "0");

		importedClasses = new ClassFileImporter(Arrays.asList(
			ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES,
			ImportOption.Predefined.DO_NOT_INCLUDE_JARS,
			ImportOption.Predefined.DO_NOT_INCLUDE_TESTS
		))
			.importPackages(PKG_ROOT)
		;
	}

	@Test
	void onion_hexagonal_architecture() {
		var arch = onionArchitecture()
			.domainModels(PKG_CORE + "..")
			.domainServices(PKG_CORE + "..")
			.applicationServices(PKG_CORE + "..")
			.adapter("outbound", PKG_OUTBOUND + "..")
			.adapter("inbound", PKG_INBOUND + "..")
			;
		arch.check(importedClasses);
	}
	@Test
	void t1() {
		classes().that().haveNameMatching(".*Handler").should().bePackagePrivate().check(importedClasses);
		classes().that().haveNameMatching(".*Adapter").should().bePackagePrivate().check(importedClasses);
		classes().that().haveNameMatching(".*Port").should().beInterfaces().check(importedClasses);
	}
}
