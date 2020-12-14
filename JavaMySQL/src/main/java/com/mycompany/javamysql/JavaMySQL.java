package com.mycompany.javamysql;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;


public class JavaMySQL {
    
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connessione = DriverManager.getConnection("jdbc:mysql://localhost:3306/EsTPSIT?user=root&password=12345&serverTimezone=Europe/Rome");
            Statement statement = connessione.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Studenti");
            while(resultset.next()){
                String nome = resultset.getString("Nome");
                String cognome = resultset.getString("Cognome");
                System.out.println(nome + " " + cognome);
            }
        }
        catch(ClassNotFoundException e){
            e.toString();
        }
        catch(SQLException ex){
            Logger.getLogger(JavaMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
