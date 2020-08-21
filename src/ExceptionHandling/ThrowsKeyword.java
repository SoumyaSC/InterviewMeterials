package ExceptionHandling;

// Used in checked exception classes
// For eg: IOException, ClassNotFoundException
public class ThrowsKeyword {
    public static void main(String []args) throws ClassNotFoundException{
        throw new ClassNotFoundException();


        //This can be either handled using throws beside method declaration or
        //by using try catch as below
        /*try {
            throw  new ClassNotFoundException();
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }*/
    }
}
