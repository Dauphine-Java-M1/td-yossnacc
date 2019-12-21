package fr.dauphine.ja.naccacheyossef.threads;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;

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
	
	public static double scalar(MySafeList v1, MySafeList v2) {
		if(v1.size() != v2.size()) throw new IllegalArgumentException("Les listes doivent être de la même taille");
		
		double sum = 0.0;
		for (int i = 0; i < v1.size(); i++) {
			sum += v1.get(i) * v2.get(i);
		}
		return sum;
	}
	
	public static MySafeList generateList(int n) {
		MySafeList myList = new MySafeList();
		for (int i = 0; i < n; i++) {
			myList.add(new Random().nextDouble());
		}
		return myList;
	}
	
	public static double scalar2(MySafeList v1, MySafeList v2, int begin, int end) {
		if(v1.size() != v2.size()) throw new IllegalArgumentException("Les listes doivent être de la même taille");
		
		double sum = 0.0;
		for (int i = begin; i < end; i++) {
			sum += v1.get(i) * v2.get(i);
		}
		return sum;
	}
	
	public static double parallelScalar(MySafeList l1, MySafeList l2, int n) {
		
        ScalarThread[] threads = new ScalarThread[n];
        int portionLength = l1.size() / n;
        double result = 0.0;

        for (int i = 0; i < n-1; i++) {
            threads[i] = new ScalarThread(l1, l2, i * portionLength, (i + 1) * portionLength);
            threads[i].start();
        }
        
        threads[n - 1] = new ScalarThread(l1, l2, (n - 1) * portionLength, l1.size());
        threads[n - 1].start();

        try {
            for (int i = 0; i < n; i++) {
                threads[i].join();
                result += threads[i].getResult();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }
	
	public static void main(String[] args){
		Instant start = Instant.now();
		
		System.out.println(stressTest(10, 10000));
		
		Instant end = Instant.now();
		Duration durer = Duration.between(start, end);
		
		System.out.println(durer.getSeconds());
		
		MySafeList l1 = generateList(10000000);
		MySafeList l2 = generateList(10000000);
		long startTime = System.nanoTime();
		System.out.println(parallelScalar(l1,l2,12));
		System.out.println((System.nanoTime() - startTime)/1000000);
		
	}
	
}
