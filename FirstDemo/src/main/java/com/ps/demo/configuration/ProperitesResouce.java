package com.ps.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "ps.demo.properties")
@PropertySource(value = "classpath:application.properties")
public class ProperitesResouce {
	private String name;
	private String eamil;
	private String blog;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the eamil
	 */
	public String getEamil() {
		return eamil;
	}

	/**
	 * @param eamil the eamil to set
	 */
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	/**
	 * @return the blog
	 */
	public String getBlog() {
		return blog;
	}

	/**
	 * @param blog the blog to set
	 */
	public void setBlog(String blog) {
		this.blog = blog;
	}

}
