package fr.patrik;

import java.util.function.BiFunction;

public class OperationSubstract implements Operation {
   @Override
   public int doOperation(int num1, int num2) {
      BiFunction<Integer, Integer, Integer> substract = (i, j) -> i-j;
      return substract.apply(num1, num2);
   }
}