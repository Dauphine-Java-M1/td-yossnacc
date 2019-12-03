package fr.dauphine.ja.naccacheyossef.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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
	
	 private static <T, T1 extends T, T2 extends T> List<T> fusion(List<T1> l1, List<T2> l2){
	 	if (l1.size() != l2.size()) {
            throw new IllegalArgumentException("Il faut les deux listes de la meme taille !");
        }
	 	if (l1.size() == 0 || l2.size()==0) {
	 		throw new IllegalArgumentException("La liste ne peut pas être vide !");
	 	}
	 
        List<T> list = new ArrayList<T>();
        
        Iterator<T1> it1 = l1.iterator();
        Iterator<T2> it2 = l2.iterator();
        
        while(it1.hasNext() && it2.hasNext()){
            list.add(it1.next());
            list.add(it2.next());
        }
        
        return list;
    }
 
 	public <T> void swap(List<T> list, int i, int j){
        if(i >= list.size() || j >= list.size() || i < 0 || j < 0){
            throw new IndexOutOfBoundsException("i or j is out of bounds");
        }
        
        T t1 = list.get(i);
        T t2 = list.get(j);
        
        list.set(i, t2);
        list.set(j, t1);
        
    }
    
    
    public <T> void shuffle(List<T> list){
        
        Random random = new Random();
        
        for(int i = 1; i < list.size(); i++){
            int j = random.nextInt(i + 1);
            swap(list, i , j);
        }
       
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
    	
    	
    	List<String> l1= Arrays.asList("C", "rc");
    	List<StringBuilder> l2= Arrays.asList(new StringBuilder("a ma"), new StringBuilder("he!"));
    	List<? extends CharSequence> r1=fusion(l1,l2);
    	System.out.println(r1);
    	List<?> r2=fusion(l1,l2);
    	System.out.println(r2);
    	List<Integer> l3 = Arrays.asList(1,2);
    	List<Integer> l4 = Arrays.asList(10,20);
    	List<Integer> r3 = fusion(l3,l4);
    	System.out.println(r3);
    	List<?> r4 = fusion(l1,l3);
    	System.out.println(r4);

    	
    }
}
