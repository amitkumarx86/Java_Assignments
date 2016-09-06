package Day2;

class A {
  protected void fun1(){
	  System.out.println("Happy A");
  }
}
class B extends A{
	 
	  protected void fun1(){
		  System.out.println("Happy B");
	  }
	  
	  protected void fun2(){
		  System.out.println("Happy B fun1");
	  }
	  
	}
public class TestDownCasting {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.fun1(); // this will be called from A
		A a1 = (B) b; // this is right but a1 can only access overridden method
		// B b2 = (A) a; this is wrong
		b.fun1(); // this will be called from A
		a1.fun1(); // this will also be called from A
		//a.fun1();
	}
}
