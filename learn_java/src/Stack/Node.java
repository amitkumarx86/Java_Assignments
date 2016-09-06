package Stack;

public class Node {
	Object bookName;
    Node next;

    //Link constructor
    public Node(Object bookName) {
	    this.bookName = bookName;
    }

    //Print Link data
    public Object printLink() {
	    return bookName;
    }
    
    public Node(){}
}
