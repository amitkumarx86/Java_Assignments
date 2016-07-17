package Day2;

class Node {
    Object bookName;
    Node nextLink;

    //Link constructor
    public Node(Object bookName) {
	    this.bookName = bookName;
    }

    //Print Link data
    public Object printLink() {
	    return bookName;
    }
}

class LList {
    private Node first;

    //LList constructor
    public LList() {
	    first = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
	    return first == null;
    }

    //Inserts a new Link at the first of the list
    public void insertatFirst(String bookName) {
    	Node link = new Node(bookName);
	    link.nextLink = first;
	    first = link;
    }
    
    //Inserts a new Link at the last of the list
    public void append(String bookName) {
    	Node currentLink = first;
	    while(currentLink.nextLink != null) {
		    currentLink = currentLink.nextLink;
	    }
	    Node link = new Node(bookName);
	    currentLink.nextLink = link;
	    link.nextLink = null;
    }
    // insert at position
    public void insert(int pos, String bookName) {
    	Node currentLink = first;
    	int temp=1;
    	
	    while(currentLink.nextLink != null && temp++ != pos) {
		    currentLink = currentLink.nextLink;
	    }
	    Node link = new Node(bookName);
	    if(currentLink.nextLink != null){
	    	link.nextLink = currentLink.nextLink;
	    	currentLink.nextLink = link;
	    }
	    else {
	    	currentLink.nextLink = link;
	    	link.nextLink = null;
	    }

    }
    //Get the data
    public String get(int pos) {
    	Node currentLink = first;
    	int temp=1;
    	
	    while(temp++ != pos) {
		    currentLink = currentLink.nextLink;
	    }
	     
	    return currentLink.printLink().toString(); 
    }
    
    // return the position of obj
    public int find(String bookName) { 
    	Node currentLink = first;
    	int pos=1;
    	while(currentLink.printLink() != bookName && currentLink.nextLink != null){
    		currentLink = currentLink.nextLink;
    		pos++;
    	}
    	if(currentLink.printLink() != bookName) return -1;
    	else return pos;
    }
    
    public int size() {
    	Node currentLink = first;
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
    public Node delete() {
    	Node temp = first;
	    first = first.nextLink;
	    return temp;
    }
    //Deletes the link from position 
    public void remove(int pos) {
    	Node currentLink = first;
    	int temp=1;
    	Node tempNext = null;
	    while(temp++ != pos) {
	    	tempNext = currentLink;
		    currentLink = currentLink.nextLink;
	    }
	    tempNext.nextLink = currentLink.nextLink;
    }
    
    //Prints list data
    public String toString() {
    	Node currentLink = first;
	    String temp = "List : ";
	    while(currentLink != null) {
		    temp += "{"+ currentLink.printLink()+"}";
	    	currentLink = currentLink.nextLink;
	    }
	    return temp+"\n";
    }
}  

public class LinedkListTest {
    public static void main(String[] args) {
    	
	    LList list = new LList();
	    list.insertatFirst("Harry Potter 1");
	    list.insertatFirst("Harry Potter 2");
	    list.insertatFirst("Harry Potter 3");
	    list.insertatFirst("Harry Potter 4");

	    System.out.println(list.toString());
	    list.append("Harry Potter 5");
	    list.toString();
	    
	    list.insert(3, "java");
	    list.toString();
	    
	    list.remove(3);
	    list.toString();
	    System.out.println(list.get(3));
	    System.out.println(list.find("java1"));
	    System.out.println(list.size());
	    list.clear();
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
