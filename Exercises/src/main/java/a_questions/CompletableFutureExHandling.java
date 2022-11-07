package a_questions;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Beispielprogramm für den Workshop "Java 11 bis 18" / das Buch "Java – die Neuerungen in Java 17 LTS und 18"
 * 
 * @author Michael Inden
 * 
 * Copyright 2021/2022 by Michael Inden 
 */
public class CompletableFutureExHandling {

	static boolean injectEx = true;
	static boolean injectEx2 = false;
	
	public static void main(String[] args) {

		final CompletableFuture<List<String>> cfData = CompletableFuture.supplyAsync(() -> retrieveData())
				.orTimeout(1, TimeUnit.SECONDS).exceptionally((throwable) -> {
					if (throwable instanceof TimeoutException)
						return Collections.emptyList();
					else
						throw new CompletionException(throwable);
				});

		try {
			List<String> result = cfData.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println("HANDLING EXCEPTIONS" + e.getCause());
			
			// UNWRAP
			if (e.getCause().equals(CompletionException.class))
			{
				System.out.println(e.getCause());
				if (e.getCause().getCause().equals(IllegalStateException.class))
					System.out.println("Handle IllegalStateException");
				else if (e.getCause().getCause().equals(UnsupportedOperationException.class))
					System.out.println("Handle UnsupportedOperationException");
				else
					e.printStackTrace();
			}
			else
			{
				System.out.println("UNSPECIFIC");
				e.printStackTrace();
			}
		}
	}

	private static List<String> retrieveData() {
		if (injectEx)
			throw new IllegalStateException("PROCESSING ERROR");

		if (injectEx2)
			throw new UnsupportedOperationException("PROCESSING FAILED");

		try {
			Thread.sleep(1_100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return List.of("PROCESSING", "SUCCESSFUL");
	}
}
