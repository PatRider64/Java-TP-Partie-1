package fr.patrik;

public class OperationContext {
   private Operation operation;

   public Context(Operation operation){
      this.operation = operation;
   }

   public int executeOperation(int num1, int num2){
      return strategy.doOperation(num1, num2);
   }
}