package Working_file;

import java.util.Scanner;

class Working_file {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int mas[];
        System.out.print("Please, input amount of Array values - ");
        int arraySize = scanner.nextInt();
        mas = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Input Array value " + (i + 1) + " - ");
            mas[i] = scanner.nextInt();
        }
        System.out.println("Array with right index order: ");
        for (int i = 0; i < arraySize; i++) {
            System.out.println(mas[i]);
        }
        System.out.println("Array with otherwise index order: ");
        for (int j = mas.length - 1; j >= 0; j--) {
            System.out.println(mas[j]);
        }

    }
}
