package fr.patrik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CalculateurFichier {
    public static void main(String[] args) throws SQLException {
        File directory = new File("C:/Users/patrik.pucelj/Documents/GitHub/TP-Java/patrik/data"); //args[0] correspond au chemin absolu du dossier

        try (Connection con = DriverManager
          .getConnection("jdbc:postgresql://SG-hetic-mt4-java-5275-pgsql-master.servers.mongodirector.com:5432/TP", "etudiant", "MT4@hetic2324")) {
            try (Statement stmt = con.createStatement()) {
                String selectFiles = "SELECT * FROM fichier f INNER JOIN ligne l on (f.id = l.fichier_id) WHERE f.type = 'OP' order by nom, position";
                try (ResultSet files = stmt.executeQuery(selectFiles)) {
                    while (files.next()) {
                        String fileName = files.getString("nom");
                        int leftNumber = files.getInt("param1");
                        int rightNumber = files.getInt("param2");
                        String operator = files.getString("operateur");
                        String line = "";

                        switch (operator) {
                            case "+":
                                Operation operationAdd = new OperationAdd();
                                line += String.valueOf(operationAdd.doOperation(leftNumber, rightNumber));
                                break;
                            case "-":
                                Operation operationSubstract = new OperationSubstract();
                                line += String.valueOf(operationSubstract.doOperation(leftNumber, rightNumber));
                                break;
                            case "*":
                                Operation operationMultiply = new OperationMultiply();
                                line += String.valueOf(operationMultiply.doOperation(leftNumber, rightNumber));
                                break;
                            default:
                                System.out.println("L'opération n'est pas supportée");
                                line += "ERROR";
                        }
                        
                        try {
                            File resFile = new File(directory, fileName+".res");
                            FileWriter writerRes = new FileWriter(resFile, true);
                            writerRes.write(line+"\n");
                            writerRes.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}