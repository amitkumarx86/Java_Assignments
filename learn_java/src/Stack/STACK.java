package Stack;

class STACK extends Node{
    private Node top;

    //LList constructor
    public STACK() {
    	super();
    	top = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
	    return top == null;
    }

   
    
    //Push
    public void push(String bookName) {
    	
    	Node link = new Node(bookName);
	    link.next = top;
	    top=link;
    	
    }
    //Pop
    public Object pop() {
    	Object s;
    	Node link = top;
    	if(top == null)
    		return null;
    	else{
	    s = link.bookName;
	    top = top.next;
    	}
	    return s;
    	
    }
    
    
    public void display() {
    	
    	Node link = top;
	    while(link != null){
	    	System.out.println((String)link.bookName);
	    	link = link.next;
	    }
	    
    }
    
    
   
    public int size() {
    	Node currentLink = top;
    	if(currentLink == null)
    		return 0;
    	int size = 1;
    	while(currentLink.next != null){
    		size++;
    		currentLink = currentLink.next;
    	}
    	return size;
    	
    }
    public void clear() {
    	top = null;
    }
     
    
    
    //Prints list data
    public String toString() {
    	Node currentLink = top;
	    String temp = "Stack : ";
	    while(currentLink != null) {
		    temp += "{"+ currentLink.printLink()+"}";
	    	currentLink = currentLink.next;
	    }
	    return temp+"\n";
    }
}  

