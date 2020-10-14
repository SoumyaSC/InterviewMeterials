package Algorithms;

class Fib{
    public void fiboIterative(int n){
        int t1 =0;
        int t2 =1;

        for(int i=1; i<=n; i++){
            System.out.println(t1 + " ");
            int add = t1 + t2;
            t1 = t2;
            t2 = add;
        }
    }

    public int fiboRecurssive(int n){
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }

        return fiboRecurssive(n-2) + fiboRecurssive(n-1);


    }
}
public class Fibonacci {
    public static void main(String[] args) {
        Fib fib = new Fib();
        fib.fiboIterative(5);

        int number = 5;
        for(int i=0; i<number; i++){
            System.out.println(fib.fiboRecurssive(i) + " ");
        }

    }
}
