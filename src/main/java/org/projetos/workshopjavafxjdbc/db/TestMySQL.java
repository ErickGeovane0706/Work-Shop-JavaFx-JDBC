package org.projetos.workshopjavafxjdbc.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMySQL {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/coursejdbc?useSSL=false&serverTimezone=UTC";
        String user = "developer";
        String password = "549276183";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem-sucedida!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
