package a_questions;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.TrustManagerFactory;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class HttpSslExample {

	public static void main(String[] args) throws NoSuchAlgorithmException {

		System.out.println(HttpClient.newHttpClient().sslContext());
		System.out.println(HttpClient.newHttpClient().sslParameters());

		SSLContext sslContext = SSLContext.getInstance("TLS");
		//sslContext.
		
		// https://www.codota.com/code/java/classes/javax.net.ssl.SSLParameters
		SSLParameters sslParameters = new SSLParameters();
		//sslParameters.s		
		
		HttpClient.newBuilder().sslContext(sslContext).sslParameters(sslParameters);
	}

	// https://www.codota.com/code/java/classes/javax.net.ssl.SSLContext
	private static SSLContext sslContext(String keystoreFile, String password)
			throws GeneralSecurityException, IOException {
		KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		try (InputStream in = new FileInputStream(keystoreFile)) {
			keystore.load(in, password.toCharArray());
		}

		KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		keyManagerFactory.init(keystore, password.toCharArray());

		TrustManagerFactory trustManagerFactory = TrustManagerFactory
				.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		trustManagerFactory.init(keystore);

		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());

		return sslContext;
	}
}
