package ExceptionHandling;

public class DefaultThrowDefaultCatch {
    public static void main(String []args){
        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        //Using default try and catch of java
        //Unchecked Exception - because user input for x/y; y can be anything
        int x = 5/0;
        System.out.println(x);
    }
}
