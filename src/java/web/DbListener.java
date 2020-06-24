/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import db.Question;
import db.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Fernanda
 */
 public class DbListener implements ServletContextListener {
    public static final String URL  = "jdbc:sqlite:quiz.db";
    
    public static String exceptionMessage = null;
  
  
   
   public void contextInitialized(ServletContextEvent sce) {
        String step = "Starting database creation";
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(URL);
            Statement stmt = con.createStatement();
            
            String SQL = null;
            
            step = "users Table creation";
            SQL = "CREATE TABLE IF NOT EXISTS users("
                    + "name VARCHAR(200) NOT NULL,"
                    + "login VARCHAR(50) UNIQUE NOT NULL,"
                    + "password_hash LONG "
                    + ")";
            stmt.executeUpdate(SQL);
            
            step = "Default users creation";
            if (User.getUsers().isEmpty()){
                SQL = "INSERT INTO users(name, login, password_hash) "
                    + "VALUES('Administrador', 'admin', '"+("123456".hashCode())+"', 'ADMIN')";
                stmt.executeUpdate(SQL);
                SQL = "INSERT INTO users(name, login, password_hash) "
                    + "VALUES('Fulano da Silva', 'fulano', '"+("123456".hashCode())+"', 'USER')";
                stmt.executeUpdate(SQL);
            }
        }catch(Exception ex){
            exceptionMessage = step + ": " + ex.getMessage();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
