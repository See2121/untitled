import java.util.Scanner;

public class ComparingTwoNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("Введите поочередно несколько чисел:");
            s.hasNextInt();
            int number1 = s.nextInt();
            int number2 = s.nextInt();
            if (number1 > number2) {
                System.out.println(number1 + " больше " + number2);
            } else if (number1 < number2) {
                System.out.println(number1 + " меньше " + number2);
            } else {
                System.out.println("значения равны");
            }
        } while (true);

    }
}