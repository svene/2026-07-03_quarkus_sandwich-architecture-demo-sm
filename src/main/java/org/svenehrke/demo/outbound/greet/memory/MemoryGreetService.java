package org.svenehrke.demo.outbound.greet.memory;

import jakarta.enterprise.context.ApplicationScoped;
import org.svenehrke.demo.core.greeting.GreetServicePort;

@ApplicationScoped
class MemoryGreetService implements GreetServicePort {
	@Override
	public String hello() {
		return "Hello from MemoryGreetService";
	}
}
