import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Mind {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        do {
            System.out.println("Введите число и индекс элемента");
            int element = scanner.nextInt();
            int index = scanner.nextInt();

            if (index <= 0 || index > array.length) {
                System.out.println("Неверный ввод");
                continue;
            }

            if (array[index - 1] != element) {
                System.out.println("значения не равны");

                shuffleArray(array);
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println("значения равны");
                break;

            }
        }
        while (true);

    }

    static void shuffleArray(int[] ar) {


        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

}

