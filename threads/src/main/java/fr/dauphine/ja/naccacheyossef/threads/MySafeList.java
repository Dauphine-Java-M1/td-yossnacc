package fr.dauphine.ja.naccacheyossef.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class MySafeList extends ArrayList<Double> {
	
	private Object obj = new Object();
	
	public void add(double d) {
		synchronized (obj) {
			super.add(d);
		}
	}
	
	public int size() {
		return super.size();
	}
	
	public Double get(int i) {
		return super.get(i);
	}
	
	public static boolean stressTest(int n, final int m){
		final MySafeList myList = new MySafeList();
		
		try {
			Thread[] threads = new Thread[n];
			
			for (int i = 0; i < n; i++) {
				threads[i] = new Thread(
						new Runnable() {
							public void run() {
								for (int j = 0; j < m; j++) {
									myList.add(5.0);
								}
							}
						}
				);
			}
			
			for (int i = 0; i < n; i++) {
				threads[i].start();
			}
			for (int i = 0; i < n; i++) {
		        threads[i].join();
		    }
			System.out.println("Taille de la list : " + myList.size() + " et devrait être : " + n * m);
			
			
		} catch (InterruptedException e) {
			System.out.println("Erreur");
		}
		
		
		return (myList.size() == n * m) ? true : false;
	}
	
	public static void main(String[] args){
		//long startTime = System.nanoTime();
		Instant start = Instant.now();
		
		System.out.println(stressTest(10, 1000000));
		
		Instant end = Instant.now();
		Duration durer = Duration.between(start, end);
		
		//System.out.println((System.nanoTime() - startTime)/1000000);
		System.out.println(durer.getSeconds());
		
	}
	
}
