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
        int tempArrayIndex = 0;
        int j = 0;
        int g = 0;
        for (int i = 0; i < arraySize; i++) {
            tempArrayIndex = mas[i];
            mas[i] = mas[arraySize - 1 -j];
            mas[arraySize - 1-j] = tempArrayIndex;
            j = j + 1;
            if ((arraySize -1 -j) == i || (arraySize - 1 - j) < i){
                i = arraySize;
            }
        }
        for (int q = 0; q < arraySize; q++) {
            System.out.println(mas[q]);
        }
    }
}
