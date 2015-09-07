package com.example.helloworld;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration{
	@NotEmpty
	private String template;
	
	@NotEmpty
	private String defaultName = "Stranger";
	
	@JsonProperty
	public String getTemplate(){
		return template;
	}
	
	@JsonProperty
	public void setTemplate(String template){
		this.template = template;
	}
	
	@JsonProperty
	public String getDefaultName(){
		return defaultName;
	}
	
	@JsonProperty
	public void setDefaultName(String name){
		this.defaultName = name;
	}
	
	
	
	@NotEmpty
	private String template2;
	
	@NotEmpty
	private String defaultName2 = "Stranger";
	
	@JsonProperty
	public String getTemplate2(){
		return template2;
	}
	
	@JsonProperty
	public void setTemplate2(String template2){
		this.template2 = template2;
	}
	
	@JsonProperty
	public String getDefaultName2(){
		return defaultName2;
	}
	
	@JsonProperty
	public void setDefaultName2(String name2){
		this.defaultName2 = name2;
	}
}