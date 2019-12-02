package fr.dauphine.ja.naccacheyossef.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Maximum 
{
	
	/*public static int myMax(int... tab) {
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
	
	public static <T> void print(List<T> list) {
		for(T t : list)
		System.out.println(t);
	}

	public static void taille(List<? extends CharSequence> list) {
		for(CharSequence c : list){
            System.out.println(c.length());
        }
	}
	
	public static <T extends CharSequence> List<Integer> listLength(List<T> list) {
		ArrayList length = new ArrayList();
		for(T t : list) {
			length.add(t.length());
		}
		return length;
	}
	
	public static List<Integer> listLength2(List<? extends CharSequence> list) {
        ArrayList<Integer> length=new ArrayList();
        for(CharSequence s : list) {
            length.add(s.length());
        }
        return length;
    }
	
    public static void main(String[] args)
    {
    	System.out.println(myMax(42,1664)); //1664
    	System.out.println(myMax(2014,86,13)); //2014
    	//System.out.println(myMax()); //ko
    	
    	System.out.println(myMax(8.6,16.64)); //16.64
    	System.out.println(myMax("baa", "aba")); //baa car baa est plus grand que aba
    	//System.out.println(myMax(8.6, "aba")); // ko !
    	
    	List<String> list = Arrays.asList("foo", "toto");
    	//List<Integer> list = Arrays.asList(2014,86,13);
    	print(list);
    	taille(list);
    	
    	
    	List l=Arrays.asList("colonel", "reyel");
    	System.out.println(listLength(l));
    	System.out.println(listLength2(l));
    }
}
