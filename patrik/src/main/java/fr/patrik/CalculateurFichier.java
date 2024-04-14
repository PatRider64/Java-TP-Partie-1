package fr.patrik;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalculateurFichier {
    public static void main(String[] args) throws SQLException {
        String method = args[0]; // choix de la méthode de lecture
        String path = args[1]; // chemin absolu du dossier
        
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Reader reader = context.getBean("reader", Reader.class);

        if (method.equals("file")) {
            FileSystemReader fileReader = reader.getFileReader();
            fileReader.read(path);
        } else if (method.equals("jdbc")) {
            JdbcReader jdbcReader = reader.getJdbcReader();
            String url = reader.getUrl();
            String username = reader.getUsername();
            String password = reader.getPassword();
            jdbcReader.read(path, url, username, password);
        }
    }
}