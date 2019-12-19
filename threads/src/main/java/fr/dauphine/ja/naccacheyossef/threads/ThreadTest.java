package fr.dauphine.ja.naccacheyossef.threads;

/**
 * Hello world!
 *
 */
public class ThreadTest 
{
	private static int  n = 0;
	private static Object obj = new Object();
	
	public static Runnable exo1(final int id) {
		return new Runnable() {
			public void run() {
				while(n<100) {
					synchronized (obj) {
					System.out.println("Je suis le thread " + id + " à l'itération " + n);
					n++;
					}
				}
			}
		};
	}
	
	
    public static void main( String[] args )
    {
        Thread t1 = new Thread(exo1(1));
        Thread t2 = new Thread(exo1(2));
        t1.start();
        t2.start();
    }
}
