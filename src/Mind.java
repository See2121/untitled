import java.util.Scanner;

public class Mind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] massiv = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < massiv.length; i++) {
            System.out.println("Введите индекс и элемент");
            int index = scanner.nextInt();
            int element = scanner.nextInt();
            massiv[i] = element;
            i = index;
            if (index != element) {
                System.out.println("значения не равны");
            } else {
                System.out.println("значения равны");
                break;
            }
        }


    }

}


