public class ValidPhoneNumbers {
    public void validPhoneNumbers(String []str){
        Boolean valid = false;

        for(int i=0; i<str.length; i++){
            String s1 = str[i].substring(0,1);
            String s2 = str[i].substring(9,10);

            if(s1.equals("(") &&  s2.equals("-")){
                System.out.println(str[i]);
            }
            else
                System.out.println("hello");


        }

    }
}
class Driver3 {
    public static void main(String[] args) {
        ValidPhoneNumbers rb = new ValidPhoneNumbers();
        String [] str = new String[1];
        str[0] = "(123) 456-7890";
        rb.validPhoneNumbers(str);
    }
}
