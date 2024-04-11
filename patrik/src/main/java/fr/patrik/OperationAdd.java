package fr.patrik;

import java.util.function.BiFunction;

public class OperationAdd implements Operation {
   @Override
   public int doOperation(int num1, int num2) {
      BiFunction<Integer, Integer, Integer> add = (i, j) -> i+j;
      return add.apply(num1, num2);
   }
}