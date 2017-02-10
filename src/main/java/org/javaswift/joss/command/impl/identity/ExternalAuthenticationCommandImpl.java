package org.javaswift.joss.command.impl.identity;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.javaswift.joss.client.factory.AuthenticationMethod;
import org.javaswift.joss.model.Access;

public class ExternalAuthenticationCommandImpl extends AbstractSimpleAuthenticationCommandImpl {

	private final AuthenticationMethod.AccessProvider accessProvider;

	public ExternalAuthenticationCommandImpl(HttpClient httpClient, String url, AuthenticationMethod.AccessProvider accessProvider) {
		super(httpClient, url);
		if (accessProvider == null)
			throw new NullPointerException();
		this.accessProvider = accessProvider;
	}

	@Override
	public Access call() {
		return accessProvider.authenticate();
	}

	@Override
	public Access getReturnObject(HttpResponse response) throws IOException {
		return accessProvider.authenticate();
	}

	@Override
	protected HttpGet createRequest(String unused) {
		return null;
	}
}
