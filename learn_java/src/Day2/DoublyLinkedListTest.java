package Day2;
class Node2 {
    Object bookName;
    Node2 nextLink;
    Node2 prevLink;
    //Link constructor
    public Node2(Object bookName) {
	    this.bookName = bookName;
    }

    //Print Link data
    public Object printLink() {
	    return bookName;
    }
}
class DoublyLinkedList {
    private Node2 first;
    private Node2 last;
    
    //LList constructor
    public DoublyLinkedList() {
	    first = null;
	    last=null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
	    return first == null;
    }
  //Inserts a new Link at the first of the list
    public void insertatFirst(String bookName) {
    	Node2 link = new Node2(bookName);
    	 if(size() == 0) {
 	        //make it the last link
 	    	//System.out.println("I got there once");
 	        last = link;
 	     }
	    link.nextLink = first;
	    link.prevLink = null;
	    first = link;
	   
	     
    }
   
  //Inserts a new Link at the first of the list
    public void append(String bookName) {
    	Node2 link = new Node2(bookName);
    	 
	    link.prevLink = last;
	    link.nextLink = null;
	    last.nextLink = link;
	    last = link;
	    //System.out.println("No");
    }
  
    
    // insert at position
    public void insert(int pos, String bookName) {
    	Node2 currentLink = first;
    	Node2 tempPrevLink = null;
    	int temp=1;
    	
	    while(temp++ != pos) {
	    	tempPrevLink = currentLink;
	    	currentLink = currentLink.nextLink;
		    
		     
	    }
	     
	    Node2 link = new Node2(bookName);
	    if(currentLink.nextLink != null){
	    	currentLink.prevLink = link;
	    	link.nextLink = currentLink;
	    	link.prevLink = tempPrevLink;
	    	tempPrevLink.nextLink = link;
	    	
	    }
	    else {
	    	currentLink.nextLink = link;
	    	link.prevLink = currentLink;
	    	link.nextLink = null;
	    }
	     
    }
    
  //Get the data
    public String get(int pos) {
    	Node2 currentLink = first;
    	int temp=1;
    	
	    while(temp++ != pos) {
		    currentLink = currentLink.nextLink;
	    }
	     
	    return currentLink.printLink().toString(); 
    }
    // return the position of obj
    public int find(String bookName) { 
    	Node2 currentLink = first;
    	int pos=1;
    	while(currentLink.printLink() != bookName && currentLink.nextLink != null){
    		currentLink = currentLink.nextLink;
    		pos++;
    	}
    	if(currentLink.printLink() != bookName) return -1;
    	else return pos;
    }
    public int size() {
    	Node2 currentLink = first;
    	if(currentLink == null)
    		return 0;
    	int size = 1;
    	while(currentLink.nextLink != null){
    		size++;
    		currentLink = currentLink.nextLink;
    	}
    	return size;
    	
    }
    public void clear() {
    	first = null;
    }
   
    //Deletes the link at the first of the list
    public Node2 delete() {
    	Node2 temp = first;
	    first = first.nextLink;
	    first.nextLink.prevLink = null;
	    return temp;
    }
    
  //Deletes the link from position 
    public void remove(int pos) {
    	Node2 currentLink = first;
    	Node2 tempPrevLink = null;
    	int temp=1;
    	
	    while(temp++ != pos) {
	    	tempPrevLink = currentLink;
		    currentLink = currentLink.nextLink;
	    }
	    currentLink.nextLink.prevLink = tempPrevLink;
	    tempPrevLink.nextLink = currentLink.nextLink; 
    }
    
    //Prints list data
    public String toString() {
    	Node2 currentLink = first;
	    String temp = "List : ";
	    while(currentLink != null) {
		    temp += "{"+ currentLink.printLink()+"}";
	    	currentLink = currentLink.nextLink;
	        //System.out.println(temp);
	    }
	    return temp+"\n";
    }
}

public class DoublyLinkedListTest {
public static void main(String[] args) {
	DoublyLinkedList list = new DoublyLinkedList();
    list.insertatFirst("Harry Potter 1");
    list.insertatFirst("Harry Potter 2");
    list.insertatFirst("Harry Potter 3");
    list.insertatFirst("Harry Potter 4");

    System.out.println(list.toString());
     
    list.append("Harry Potter 5");
    
    System.out.println(list.toString());
    
    list.insert(3, "java");
     
    System.out.println(list.toString());
     
    list.remove(3);
    list.toString();
    System.out.println(list.get(3));
    System.out.println(list.find("java1"));
    System.out.println(list.size());
    list.clear();
    System.out.println(list.size());
}
}
