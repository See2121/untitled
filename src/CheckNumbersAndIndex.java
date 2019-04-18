import java.util.Scanner;

public class CheckNumbersAndIndex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("ВВедите размер массива: ");
        int size = input.nextInt();
        int array[] = new int[size];
        System.out.println("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        System.out.println("Полученный массив: ");
        for (int i = 0; i < size; i++) {
            System.out.println("  " + array[i]);
            System.out.println();
        }
        System.out.println("Введите индекс числа: ");
        int num = input.nextInt();
        array[0] = num;
        System.out.println(array[num]*0.1);


    }

}
