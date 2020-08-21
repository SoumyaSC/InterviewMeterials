package EqualsAndHashCode;

/*      If two objects have the same hashcode then they are NOT necessarily equal.
        Otherwise you will have discovered the perfect hash function.
        But the opposite is true: if the objects are equal, then they must have the same hashcode.*/

//Hash code method returns integer. If range of integer finishes then also two different object
// will have same hash code. So it is not necessary that two different object will
// have same hash code are equal.


class Book{
    String name;
    String author;

    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }


    @Override
    public boolean equals(Object object){
        Book book = (Book)object;
        if(book.author.equals(this.author) && book.name.equals(this.name)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

/*    @Override
    public int hashCode() {
        return author.hashCode() + name.hashCode();
    }*/


}
public class IfEqualsAreSameHashCodeAreSame {
    public static void main(String[] args) {
        Book book1 = new Book("Three Mistakes", "Chetan Bhagat");
        Book book2 = new Book("Three Mistakes", "Chetan Bhagat");

        //equals comparision
        System.out.println(book1.equals(book2));

/*      Both hashcode are different if we auto-generate code for hashcode

        If we want to make the hashcode same,
        we have to write one efficient hash function for the class
        Now writing hash function for easier classes with less vars are easy
        But for complicated classes it is difficult to write a hashcode function which
        returns same hashcode value if objects are equal in its core

        Attn: Follow the hashcode() impl in the commented code in the Book class
        to get the same hash code in this case
*/
        System.out.println("Book1 hashcode: " + book1.hashCode()
        + " || Book2 hahscode: " + book2.hashCode());
    }
}
