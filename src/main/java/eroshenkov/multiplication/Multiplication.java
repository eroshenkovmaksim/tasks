package main.java.eroshenkov.multiplication;

import java.util.Arrays;
import java.util.Random;

public class Multiplication {
  public static void main(String[] args) {
    int n = 5;
    int[] inputArray = new int[n];
    int[] outputArray = new int[n];
    int[] leftProduct = new int[n - 2];
    int[] rightProduct = new int[n - 2];
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
      inputArray[i] = rand.nextInt(10);
    }
    int lProduct = 1;
    int rProduct = 1;
    for (int i = 0; i < n - 1; i++) {
      lProduct *= inputArray[i];
      rProduct *= inputArray[n - i - 1];
      if (i == n - 2) {
        break;
      }
      leftProduct[i] = lProduct;
      rightProduct[n - i - 3] = rProduct;
    }
    outputArray[0] = rProduct;
    outputArray[n - 1] = lProduct;
    for (int i = 0; i < n - 2; i++) {
      outputArray[i + 1] = leftProduct[i] * rightProduct[i];
    }
    Arrays.stream(inputArray).boxed().forEach(element -> System.out.print(element + " "));
    System.out.println();
    Arrays.stream(outputArray).boxed().forEach(element -> System.out.print(element + " "));
  }
}
