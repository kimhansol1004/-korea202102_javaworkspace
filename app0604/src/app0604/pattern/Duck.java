package app0604.pattern;

//지금 정의한 Duck 클래스의 인스턴스를 
//오직 1개만 생성하도록 조치해보자!!
//SingleTon patter이라고 GOF가 명명함!!!
public class Duck {
	private static Duck instance; //null
	
	//나만 호출하도록, 아무도 못쓰게 ^__^
	private Duck() {
	}
	
	//허용된 메서드를 통해 인스턴스를 가져가게 끔하자 
	public static Duck getInstace() {
		if(instance ==null) {
			instance = new Duck();
		}
		return instance;
	}
}
