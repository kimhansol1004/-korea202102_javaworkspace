package app0604.pattern;

public class UseDuck {
	public static void main(String[] args) {
		//이 클래스에서는 어떤 방법으로라도, 결국 Duck
		//인스턴스가 필요하다!!
		Duck d1 = Duck.getInstace();
		Duck d2 = Duck.getInstace();
		Duck d3 = Duck.getInstace();
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}
}
