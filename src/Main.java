import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        int base;
        do {
            System.out.print("Enter the base of your number(2-64) : ");
            base = Integer.parseInt(s.nextLine());
        }while(base<1 || base>64);
        String num;
        do {
            System.out.print("Enter your number: ");
            num = s.nextLine();
        }while(!NumberSystem.valid(num, base));
        System.out.print("Enter the base you want to convert your number to : ");
        int targetBase = Integer.parseInt(s.nextLine());
        s.close();
        System.out.println(num + " (base " + base + ") is " + NumberSystem.convert(num, base, targetBase) + " in base " + targetBase);
        System.out.println("digits: " + Arrays.toString(NumberSystem.convertToArray(num, base, targetBase)));
    }
}