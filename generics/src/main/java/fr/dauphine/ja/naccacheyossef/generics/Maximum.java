package fr.dauphine.ja.naccacheyossef.generics;

/**
 * Hello world!
 *
 */
public class Maximum 
{
	
	/*private static int myMax(int... tab) {
        if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Empty array or array is null");
        }

        int Max = tab[0];
        for (Integer i : tab) {
            if (Max < i) {
                Max = i;
            }
        }
        return Max;
    }*/
	
	public static <T extends Comparable<T>> T myMax(T... tab){
		if (tab == null || tab.length == 0) {
            throw new IllegalArgumentException("Pas possible d'avoir un tableau vide");
        }
		
        T Max = tab[0];
        for(T t : tab){
            if(t.compareTo(Max) > 0){
                Max = t;
            }
        }
        return Max;
    }

    public static void main(String[] args)
    {
    	System.out.println(myMax(42,1664)); //1664
    	System.out.println(myMax(2014,86,13)); //2014
    	//System.out.println(myMax()); //ko
    	
    	System.out.println(myMax(8.6,16.64)); //16.64
    	System.out.println(myMax("baa", "aba")); //baa
    	//System.out.println(myMax(8.6, "aba")); // ko !
    }
}
