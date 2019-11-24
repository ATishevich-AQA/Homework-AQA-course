package Working_file;

import java.sql.SQLOutput;
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
        int ammountZeroValues = 0;
        for (int i = 0; i < arraySize; i++) {
            if (mas[i] == 0) {
                System.out.println("index of array with zero value - " + i);
                ammountZeroValues = ammountZeroValues + 1;
            }
        }
        if (ammountZeroValues == 0)
            System.out.println("No zero values");


    }
}
