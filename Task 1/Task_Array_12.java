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
        int tempArrayValue = 0;
        for (int j = 0; j < arraySize; j++) {
            if (j + 2 >= arraySize) {
                break;
            } else {
                tempArrayValue = mas[j + 2];
                mas[j + 2] = mas[j];
                mas[j] = tempArrayValue;
            }
        }
        for (int i = 0; i < arraySize; i++) {
            System.out.println(mas[i]);
        }
    }
}
