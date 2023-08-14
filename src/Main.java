import java.util.Scanner;
import java.lang.Math;


public class Main {
    // we made the base variable a global variable because we weren't able to reach its value when we initialized it in the method.
    // this way we will be able to make the user initialize its value with the scanner class that we used in the main method.
    // the value of the base will be used by in(int n) method.
    static int base;
    static double in(int n){
        // n represents the exponent
        int nAsInt = Math.abs(n);
        if(n == 1){
            return base;
        }else if(n == 0){
            return 1.0;
        }else if(base > 0 && n < 0 ){
            return 1.0 / in(-n);
        // we used bitwise AND operator to check if n is even or odd, it checks the least significant bit(LSB) the bit that is farthest to the right in a binary number
        // for example the number 5 binary number is 101 LSB is 1 ,so it's an odd number for 2 it's 10 LSB is 0 ,so it's an even number.
        // if it's 0 it's even if it's one it's odd. (However if you are working with large numbers it's better if you use modulo operator)
        } else if (base < 0 && (n > 0 && ((nAsInt % 2) == 0))){
            return in(n-1) * base;
        }else if (base < 0 && (n > 0 && ((nAsInt % 2) == 1))){
            return (in(n-1) * (base));
        }else if(base < 0 && (n < 0 && ((-n) % 2) == 0)){
            return 1.0 / in(-n);
        }else if(base < 0 && (n < 0 && (n % 2) == 1)){
            return 1.0 / in(n + 1) * base;
        }else if (base == 0){
            return 0.0;
        }else if(base == 1){
            return 1.0;
        }

        return in(n-1) * base;
    }
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a number for the base : ");
        base =  scanner.nextInt();
        System.out.print("Choose a number for the exponent : ");
        int exponent = scanner.nextInt();
        System.out.println("Chosen base : " + base + "\n" + "Chosen exponent : " + exponent + "\n" + "Final Result : " + in(exponent) );

    }
}