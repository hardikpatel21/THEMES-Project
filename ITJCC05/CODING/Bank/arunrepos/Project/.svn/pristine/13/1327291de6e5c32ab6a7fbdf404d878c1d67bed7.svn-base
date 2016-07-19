package Database;


public class SingletonPattern{
	private static SingletonPattern instance;
	private SingletonPattern(){} 
public static  SingletonPattern getInstance(){
	if (instance == null)
		{
		instance = new SingletonPattern();
		}
		return instance;
	}
public static void main(String arg[]){
	    System.out.println("The output of two instance:");
		SingletonPattern sp=new SingletonPattern();
		System.out.println("First Instance: "+sp.getInstance());
		SingletonPattern sp1=new SingletonPattern();
		System.out.println("Second Instance:"+sp1.getInstance());
	}
}