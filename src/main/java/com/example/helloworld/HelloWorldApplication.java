package com.example.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.resources.HelloWorldResource;
import com.example.helloworld.resources.HelloWorldResource2;
import com.example.helloworld.health.TemplateHealthCheck;

public class HelloWorldApplication extends Application<HelloWorldConfiguration>{
	public static void main(String[] args) throws Exception{
		new HelloWorldApplication().run(args);
	}
	
	@Override
	public String getName(){
		return "hello-world";
	}
	
	@Override
	public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap){
		//nothing yet
	}
	
	@Override
	public void run(HelloWorldConfiguration configuration, Environment environment){
		//THIS IS WHERE WE CREATE THE RESOURCES SO THAT THE SERVER CAN USE THEM
		
		final HelloWorldResource resource = new HelloWorldResource(
			configuration.getTemplate(),
			configuration.getDefaultName()
		);
		final HelloWorldResource2 resource2 = new HelloWorldResource2(
			configuration.getTemplate2(),
			configuration.getDefaultName2()
		);
		
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
		
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
		environment.jersey().register(resource2);
		
		
	}
}