package fr.patrik;

public class OperationContext {
   private Operation operation;

   public void Context(Operation operation){
      this.operation = operation;
   }

   public int executeOperation(int num1, int num2){
      return operation.doOperation(num1, num2);
   }
}