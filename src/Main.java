import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to the Number Converter!");
        System.out.println("--------------------------------");
        System.out.print("Enter the base of your number : ");
        int base = Integer.parseInt(s.nextLine());
        System.out.print("Enter your number: ");
        String num = s.nextLine();
        System.out.print("Enter the base you want to convert your number to : ");
        int targetBase = Integer.parseInt(s.nextLine());
        s.close();
        System.out.println(num + "(base " + base + ") is " + NumberSystem.convert(num, base, targetBase) + " in base " + targetBase);
    }
}