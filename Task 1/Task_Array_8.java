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
        for (int i = 0; i < arraySize; i++) {                                                //Input
            System.out.print("Input Array value " + (i + 1) + " - ");
            mas[i] = scanner.nextInt();
        }

        int maxArrayIndex = 0;
        int minArrayIndex = mas.length - 1;
        for (int i = 0; i < arraySize; i++) {
            if (mas[i] > mas[maxArrayIndex]) {
                maxArrayIndex = i;
            }
            if (mas[i] < mas[minArrayIndex]) {
                minArrayIndex = i;
            }
        }
        System.out.println( "Min array Index is " + minArrayIndex);
        System.out.println( "Max array Index is " + maxArrayIndex);
    }
}
