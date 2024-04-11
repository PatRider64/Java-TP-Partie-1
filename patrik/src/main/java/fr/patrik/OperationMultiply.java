package fr.patrik;

import java.util.function.BiFunction;

public class OperationMultiply implements Operation {
   @Override
   public int doOperation(int num1, int num2) {
      BiFunction<Integer, Integer, Integer> multiply = (i, j) -> i*j;
      return multiply.apply(num1, num2);
   }
}