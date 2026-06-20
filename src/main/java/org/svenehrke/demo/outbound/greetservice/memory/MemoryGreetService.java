package org.svenehrke.demo.outbound.greetservice.memory;

import jakarta.enterprise.context.ApplicationScoped;
import org.svenehrke.demo.core.GreetServicePort;

@ApplicationScoped
class MemoryGreetService implements GreetServicePort {
	@Override
	public String hello() {
		return "Hello from MemoryGreetService";
	}
}
