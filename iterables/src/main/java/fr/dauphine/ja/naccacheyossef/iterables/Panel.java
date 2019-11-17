package fr.dauphine.ja.naccacheyossef.iterables;


import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;


public class Panel  implements Iterator<Integer> 
{
	
	private int first;
    private int end;
    private int cursor;
    
    public Panel (int first, int end){
        if(first > end) throw new IllegalArgumentException("Le fisrt number need to be < or = of the second");
        this.first = first;
        this.end = end;
        this.cursor = first;
    }
    
    public static List<Integer> panel(final int first, final int end)
	{
		return new AbstractList<Integer>()
		{
			@Override
		    public int size(){
		        return end - first + 1;
		    }
		    
		    @Override
		    public Integer get(int index){
		        if(index > size() || index < 0) throw new IndexOutOfBoundsException("Index is not right");
		        return first + index;
		    }
		};
	}
    
    public static Iterator<Integer> panel1(final int first,final int end) {
    	//Q1
    	//return new Panel(first ,end);	
    	
    	//Q2
    	Iterator<Integer> it = new Iterator<Integer>(){
    		
    		private int cursor = first;

			public boolean hasNext() {
    			return (cursor <= end);
    		}
			
			public Integer next() {
				return this.cursor++;
			}
    		
    	};
		return it;
	}
    
    public static Iterable<Integer> panel2(final int first,final int end){
        
        return new Iterable<Integer>(){
          
            @Override
            public Iterator<Integer> iterator(){
                return Panel.panel1(first, end);
            }
        };
    }
    
    @Override
	public boolean hasNext() {
		return (this.cursor <= this.end);
	}

	@Override
	public Integer next() {
		return this.cursor++;
	}
	
	
	
	public static void main(String[] args )
	{
		//Q1 & Q2
		/*
		Iterator<Integer> it = panel1(1,5);
		for(;it.hasNext();)
		System.out.println(it.next()); // affiche 1 2 3 4 5
		*/
		
		//Q3
		/*
		for(int i:panel2(1,5))
			System.out.println(i); // affiche 1 2 3 4 5
		*/
		
		List<Integer> l = panel(3,6);
		for(int i:l) {
		System.out.println(i);
		//affiche 3 4 5 6
		}
		System.out.println(l.get(1)); //affiche 4
		
	}
	
	
}
