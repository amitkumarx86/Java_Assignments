package GenericStack;



class GenericStack<T>{
	
	class Node{
		private Node next;
		private T entry;
		public Node(T entry) {
		    this.entry = entry;
	    }
		
		//Print Link data
	    public T printLink() {
		    return entry;
	    }
	}// inner class close
	
	private Node top;
	
	//LList constructor
    public GenericStack() {
    	top = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
	    return top == null;
    }
    
  //Push
    public void push(T bookName) {
    	
    	Node link = new Node(bookName);
	    link.next = top;
	    top=link;
    	
    }
    //Pop
    public T pop() {
    	T s;
    	Node link = top;
    	if(top == null)
    		return null;
    	else{
    		s = link.entry;
    		top = top.next;
    	}
	    return s;
    	
    }
    
    
    public void display() {
    	
    	Node link = top;
	    while(link != null){
	    	System.out.println(link.entry);
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
    
    

}


