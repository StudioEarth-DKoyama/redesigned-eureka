package main;

public class Main {


	public static void main(String[] args){

		System.out.println("メインですよテストですよ");

		Main auau = new Main();
		System.out.println(auau.MethodOne());

		ClassOne class1 = new ClassOne();

		System.out.println(class1.ClassOneMethodOne());

	}

	String MethodOne(){
		return "methodOne";
	}

}
