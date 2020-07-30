package ExceptionHandling;

public class DefaultThrowOurCatch {
    public static void main(String []args){
        try{
            int x = 5/0;
        }
        catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
