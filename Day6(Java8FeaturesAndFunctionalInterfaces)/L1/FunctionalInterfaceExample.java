package java_functional_interfaces;

@FunctionalInterface
interface IntegerSum{
	int add(int a, int b);
}
public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		IntegerSum sumFunction=(a,b)->a+b;
		
		int num1=10,num2=20;
		int result=sumFunction.add(num1, num2);
		System.out.println("Sum of "+num1+" and "+num2+" is: "+result);
	}
}
