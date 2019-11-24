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
        boolean flag = true;
        for (int i = 1; i < arraySize; i++) {
            if (mas[i] <= mas[i - 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Yes, it's an incremental Array");
        } else {
            System.out.println("Array is wrong");
        }
    }
}
