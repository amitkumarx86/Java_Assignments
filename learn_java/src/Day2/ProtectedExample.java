package Day2;


abstract class A1{
protected abstract void f();

}
class B1 extends A1{
	protected void f(){
		System.out.println("Gotcha");
	}
}
public class ProtectedExample {
public static void main(String[] args) {
	B1 b = new B1();
	b.f();
}
}

