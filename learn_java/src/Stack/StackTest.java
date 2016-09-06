package Stack;
 





public class StackTest extends STACK {
    public static void main(String[] args) {
    	
	    STACK list = new STACK();
	    list.push("Harry Potter 1");
	    list.push("Harry Potter 2");
	    list.push("Harry Potter 3");
	    list.push("Harry Potter 4");

	    System.out.println(list.toString());
	    list.push("Harry Potter 5");
	    list.toString();
	    
	  
	    System.out.println(list.size());
	    /*
	    while(!list.isEmpty()) {
		    Link deletedLink = list.delete();
		    System.out.print("deleted: ");
		    deletedLink.printLink();
		    System.out.println("");
	    }
	    list.printList();
	    */
    }
}

