package EqualsAndHashCode;

public class HashCodeAndEqualsInStrings {
    public static void main(String[] args) {
        String s1 = "Soumya";
        String s2 = "Soumya";

        //Both hashcode are same (Output: -1812642788)
        //as it is using Strings's hashcode impl
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        //true, as it is using Strings's equals impl
        System.out.println(s1.equals(s2));

        //true, as both objects are same, thanks to string pool
        //strings pool wont define new string objs if the contents of both strings are same
        System.out.println(s1==s2);
    }
}
