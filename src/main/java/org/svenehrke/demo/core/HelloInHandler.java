package org.svenehrke.demo.core;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloInHandler implements HelloInPort {
	@Override
	public String hello() {
		return "Hello from Quarkus REST";
	}
}
