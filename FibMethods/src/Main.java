public class Main {
    public static void main(String[] args) {
        System.out.println("5th element of the Fibonacci sequence using a recursive method: " + fib1(5));
        System.out.println("6th element of the Fibonacci sequence using a for loop method: " + fib1(6));
        System.out.println("7th element of the Fibonacci sequence using a while loop method: " + fib1(7));

    }

    //Fib using method recursion
    public static int fib1(int n) {
        int fibNumber = 0;
        if (n == 1) {
            fibNumber = 1;
        } else if (n > 1) {
            fibNumber = fib1(n - 1) + fib1(n - 2);
        }
        return fibNumber;
    }

    //Fib using For loop
    public static int fib2(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int fibValue = 1;
            int fibPrev = 0;
            int fibPrevPrev = 0;

            for (int i = 2; i < n; i++) {
                fibValue = fibPrev + fibPrevPrev;
                fibPrevPrev = fibPrev;
                fibPrev = fibValue;
            }
            return fibValue;
        }
    }

    //Fib with While loop
    public static int fib3(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            int fibValue = 1;
            int fibPrev = 0;
            int fibPrevPrev = 0;

            int i = 2;
            while(i < n){
                fibValue = fibPrev + fibPrevPrev;
                fibPrevPrev = fibPrev;
                fibPrev = fibValue;
                i++;
            }
            return fibValue;
        }
    }
}
