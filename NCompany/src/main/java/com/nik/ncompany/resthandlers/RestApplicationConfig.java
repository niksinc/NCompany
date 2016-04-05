package com.nik.ncompany.resthandlers;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

import com.nik.ncompany.exception.InvalidAcctExResolver;
import com.nik.ncompany.exception.UnknownResourceExResolver;

/*   See web.xml file for Jersey configuration  */
/*   Need to register classes with @PATH annotations and other JAX-RS components */
@ApplicationPath("/")
public class RestApplicationConfig extends Application {
	private Set<Class<?>> restClassSet = new HashSet<Class<?>>();

	public RestApplicationConfig() {
		/*
		 * AuthorizationFilter is a servlet filter that could automatically
		 * perform authorization on all incoming requests
		 */
		// restClassSet.add(AuthorizationFilter.class);
		restClassSet.add(JacksonFeature.class);
		restClassSet.add(EmployeeRestHandler.class);
		restClassSet.add(InvalidAcctExResolver.class);
		restClassSet.add(UnknownResourceExResolver.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return restClassSet;
	}
}
