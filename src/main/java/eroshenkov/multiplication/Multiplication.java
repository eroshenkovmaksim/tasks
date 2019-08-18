package eroshenkov.multiplication;

import java.util.Arrays;
import java.util.Random;

public class Multiplication {
  public static void main(String[] args) {
    int n = 3;
    int[] inputArray = new int[n];
    int[] outputArray = new int[n];
    int[] leftComposition = new int[n];
    int[] rightComposition = new int[n];
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
      inputArray[i] = rand.nextInt(10);
      leftComposition[i] = 1;
      rightComposition[i] = 1;
    }
    for (int i = 0; i < n - 1; i++) {
      leftComposition[i + 1] = inputArray[i] * leftComposition[i];
      rightComposition[n - i - 2] *= inputArray[n - i - 1] * rightComposition[n - i - 1];
    }

    for (int i = 0; i < n; i++) {
      outputArray[i] = leftComposition[i] * rightComposition[i];
    }
    Arrays.stream(inputArray).boxed().forEach(element -> System.out.print(element + " "));
    System.out.println();
    Arrays.stream(outputArray).boxed().forEach(element -> System.out.print(element + " "));
  }
}
