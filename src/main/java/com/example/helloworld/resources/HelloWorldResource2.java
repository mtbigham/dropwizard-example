package com.example.helloworld.resources;

import com.example.helloworld.core.Saying;
import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource2{
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	
	public HelloWorldResource2(String template, String defaultName){
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	
	@GET
	@Timed
	public Saying testSaying(@QueryParam("testArg") Optional<String> name, @QueryParam("testArg2") Optional<String> name2){
		if(name.isPresent() && name2.isPresent()){
			final String value = String.format("ARG1: %s, ARG2: %s", name.or(defaultName), name2.or(defaultName));
			return new Saying(counter.incrementAndGet(), value);
		}
		else if(name.isPresent()){
			final String value = String.format(template, name.or(defaultName));
			return new Saying(counter.incrementAndGet(), value);
		}
		else if(name2.isPresent()){
			final String value = String.format("GOTCHA BITCH %s", name2.or(defaultName));
			return new Saying(counter.incrementAndGet(), value);
		}
		else{
			final String value = "You didn't fill any arguments!";
			return new Saying(counter.incrementAndGet(), value);
		}
	}
}