package fr.patrik;

public class Calculateur {
    public static void main(String[] args) {
        try {
            int leftNumber = Integer.parseInt(args[0]);
            int rightNumber = Integer.parseInt(args[1]);
            String operator = args[2];
            Integer result = null;

            switch (operator) {
                case "+":
                    Operation operationAdd = new OperationAdd();
                    result = operationAdd.doOperation(leftNumber, rightNumber);
                    break;
                case "-":
                    Operation operationSubstract = new OperationSubstract();
                    result = operationSubstract.doOperation(leftNumber, rightNumber);
                    break;
                case "*":
                    Operation operationMultiply = new OperationMultiply();
                    result = operationMultiply.doOperation(leftNumber, rightNumber);
                    break;
                default:
                    System.out.println("L'opération n'est pas supportée");
            }
            System.out.println(result);
        } catch(Exception e) {
            System.out.println("L'opération est incorrecte");
        }
    }
}
