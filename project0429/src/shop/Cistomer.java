package shop;

//아래의 클래스에 대해 변수는 private, 이 변수들에 대한 gerrer, serrer
//=은닉화, encapsulation 
public class Customer{
	private String name;
    private int age;
    private boolean isMarry;

	public void setName(String name){
		this.name=name;
	}
	public String getname{
		return=name;
	}
	
	public void setAge(String age){
		this.age=age;
	}
	public String getAge{
		return=age;
	}

	public void setIsMarry(boolean isMarry){
		this.isMarry=isMarry;
	}
	public String getIsMarry(){
		return=isMarry;
	}
}