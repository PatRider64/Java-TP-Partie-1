package fr.patrik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CalculateurFichier {
    public static void main(String[] args) {
        File directory = new File(args[0]); //args[0] correspond au chemin absolu du dossier
        String[] flist = directory.list();

        for (int i = 0; i < flist.length; i++) { 
            String filename = flist[i];
            File opFile = new File(directory, filename);
            File resFile = new File(directory, filename.substring(0, filename.length()-3)+".res");

            try {
                Scanner readerOp = new Scanner(opFile);
                FileWriter writerRes = new FileWriter(resFile);

                while (readerOp.hasNextLine()) {
                    String data = readerOp.nextLine();
                    char firstNumber = data.charAt(0);
                    char secondNumber = data.charAt(2);
                    String operator = Character.toString(data.charAt(4));
                    String line = "";

                    try {
                        int leftNumber = Integer.parseInt(String.valueOf(firstNumber));
                        int rightNumber = Integer.parseInt(String.valueOf(secondNumber));

                        switch (operator) {
                            case "+":
                                line = String.valueOf(leftNumber + rightNumber);
                                break;
                            case "-":
                                line = String.valueOf(leftNumber - rightNumber);
                                break;
                            case "*":
                                line = String.valueOf(leftNumber * rightNumber);
                                break;
                            default:
                                System.out.println("L'opération n'est pas supportée");
                                line = "ERROR";
                        }
                    } catch(Exception e) {
                        System.out.println("L'opération est incorrecte");
                        line = "ERROR";
                    }
                    writerRes.write(line+"\n");
                }

                writerRes.close();
                readerOp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}