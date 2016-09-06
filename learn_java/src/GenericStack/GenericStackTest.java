package GenericStack;



public class GenericStackTest<T> extends GenericStack<T> {
    public static void main(String[] args) {
    	
    	GenericStack<String> list = new GenericStack<String>(); 
	    
    	list.push("Harry Potter 1");
	    list.push("Harry Potter 2");
	    list.push("Harry Potter 3");
	    list.push("Harry Potter 4");
	    
	    GenericStack<Integer> list1 = new GenericStack<Integer>(); 
	    list.display();
	    list1.push(1);
	    list1.push(2);
	    list1.push(3);
	    list1.push(4);
	    //System.out.println(list.toString());
	    list1.display();
	    //System.out.println(list.size());
	}
}

