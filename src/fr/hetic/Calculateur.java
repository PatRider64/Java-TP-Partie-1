package fr.hetic;

public class Calculateur {
    public static void main(String[] args) {
        try {
            int leftNumber = Integer.parseInt(args[0]);
            int rightNumber = Integer.parseInt(args[1]);
            String operator = args[2];

            switch (operator) {
                case "+":
                    System.out.println(leftNumber + rightNumber);
                    break;
                case "-":
                    System.out.println(leftNumber - rightNumber);
                    break;
                case "*":
                    System.out.println(leftNumber * rightNumber);
                    break;
                default:
                    System.out.println("L'opération n'est pas supportée");
            }
        } catch(Exception e) {
            System.out.println("L'opération est incorrecte");
        }
    }
}
