package stream;

interface HelloA{
	default void m() {
		System.out.println("Default Hello A Interface");
	}
}
interface HelloB{
	default void m() throws Exception {
		System.out.println("Default Hello B Interface");
		throw new Exception();
	}
}
public class DefaultMethodTest implements HelloA,HelloB{

	@Override
	public void m() {
		System.out.println("delegating to respecting method of interface");
		HelloA.super.m();
	}
	public static void main(String[] args) {
		HelloA obj=new DefaultMethodTest();
		obj.m();
	}

}
