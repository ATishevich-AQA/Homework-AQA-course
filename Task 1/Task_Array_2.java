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

        int multiplicationArray =1;

        for (int i = 0; i < arraySize; i++) {
        multiplicationArray = multiplicationArray * (mas[i]*mas[arraySize-i-1]);}
        System.out.println("Multiplication of all array values is " + multiplicationArray);

    }
}
