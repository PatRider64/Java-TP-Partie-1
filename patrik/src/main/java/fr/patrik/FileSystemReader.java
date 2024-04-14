package fr.patrik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileSystemReader {
    public void read(String path) {
        File directory = new File(path);
        File[] flist = directory.listFiles(
            file -> file.getName().toLowerCase().endsWith(".op") 
        );

        for (int i = 0; i < flist.length; i++) {
            String filename = flist[i].getName();
            File opFile = new File(directory, filename);
            File resFile = new File(directory, filename.substring(0, filename.length()-3)+".res");

            try {
                Scanner readerOp = new Scanner(opFile);
                FileWriter writerRes = new FileWriter(resFile);

                while (readerOp.hasNextLine()) {
                    String data = readerOp.nextLine();
                    String[] characters = data.split(" ");
                    String firstNumber = characters[0];
                    String secondNumber = characters[1];
                    String operator = characters[2];
                    String line = "";

                    try {
                        int leftNumber = Integer.parseInt(firstNumber);
                        int rightNumber = Integer.parseInt(secondNumber);

                        switch (operator) {
                            case "+":
                                Operation operationAdd = new OperationAdd();
                                line = String.valueOf(operationAdd.doOperation(leftNumber, rightNumber));
                                break;
                            case "-":
                                Operation operationSubstract = new OperationSubstract();
                                line = String.valueOf(operationSubstract.doOperation(leftNumber, rightNumber));
                                break;
                            case "*":
                                Operation operationMultiply = new OperationMultiply();
                                line = String.valueOf(operationMultiply.doOperation(leftNumber, rightNumber));
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
