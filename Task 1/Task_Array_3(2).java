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
        int tempCaunter = 0;
        while (tempCaunter < arraySize) {
            if (tempCaunter >= 2) {
                mas[tempCaunter] = mas[tempCaunter] * 2;
                tempCaunter = tempCaunter + 3;
            } else
                tempCaunter = tempCaunter + 2;
        }
        System.out.println("New Array after multiplication on 2 each 3 Array index");
        for (int i = 0; i < arraySize; i++) {
            System.out.println(mas[i]);
        }
    }
}
