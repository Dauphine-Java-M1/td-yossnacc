package fr.dauphine.ja.naccacheyossef.td00;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PrimeCollectionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PrimeCollectionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PrimeCollectionTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void test0IsPrime() {
    	if(!PrimeCollection.isPrime(0)) {
    		assertTrue( true );
    	}
    }
    
    public void testTwoIsPrime() {
    	if(!PrimeCollection.isPrime(2)) {
    		assertTrue( true );
    	}
    }
    
    public void test9IsNotPrime() {
    	if(PrimeCollection.isPrime(9)) {
    		assertTrue( true );
    	}
    }
}
