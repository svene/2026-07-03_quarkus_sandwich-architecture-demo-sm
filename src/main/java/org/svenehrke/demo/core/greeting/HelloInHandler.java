package org.svenehrke.demo.core.greeting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
class HelloInHandler implements HelloInPort {

	@Inject
	GreetServicePort greetServicePort;

	@Override
	public String hello() {
		return greetServicePort.hello();
	}
}
