package Static;

class University{
    static String name = "KIIT University";
    static String founder = "Achyuta Samanta";

    public void setStudentCountByYear(int year, int studentCount){
        System.out.println("Number of students in year " + year + " is " + studentCount);
    }

    public static void getUniversityFounder(){
        System.out.println("Founder is " + founder);
    }
}
public class StaticMethodAndStaticVariable {
    public static void main(String[] args) {
        University university = new University();

        //static members are directly accessed without creating an object
        //they belong to class
        System.out.println(University.name);
        University.getUniversityFounder();

        university.setStudentCountByYear(2020, 10000);
    }


}
