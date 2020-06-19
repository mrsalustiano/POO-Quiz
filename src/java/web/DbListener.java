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
    public static final String jdbcUrl = "jdbc:sqlite:E:\\Fatec\\POO\\WebQuiz\\quiz.db";
    public static String exceptionMessage = null;
  
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String step = "Starting database creation";
        try{
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(jdbcUrl);
            Statement stmt = con.createStatement();
                        
            String SQL = null;
            
            //CRIANDO TABELA DE USUARIOS
            step = "users Table creation";
            
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users("
                    + "name VARCHAR(200) NOT NULL,"
                    + "login VARCHAR(50) UNIQUE NOT NULL,"
                    + "password_hash LONG,"
                    + "media NUMBER NOT NULL"
                    + ")");
            
            
            step = "Default users creation";
            if (User.getUsers().isEmpty()){
            //CRIANDO USUARIOS
                stmt.executeUpdate("INSERT INTO users(name, login, password_hash, media)"
                    + "VALUES('Administrador', 'admin', '"+("123456".hashCode())+"', 10)");  
                }
            
            //CRIANDO TABELA QUESTIONS PARA ARMAZENAR PERGUNTASE E RESPOSTAS
            step = "Table 'questions' questions";
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS questions("
                    + "description VARCHAR(250) PRIMARY KEY,"
                    + "answer VARCHAR(250) NOT NULL,"
                    + "answerwrong1 VARCHAR(250) NOT NULL,"
                    + "answerwrong2 VARCHAR(250) NOT NULL,"
                    + "answerwrong3 VARCHAR(250) NOT NULL"
                    + ")");
            
            //CRIANDO PERGUNTAS E RESPOSTAS
            step = "Default questions creation";
            if (Question.getQuestions().isEmpty()){
               stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('COVID-19 é a doença infecciosa causada pelo novo coronavírus:', 'SARS-COV-2', 'SARS-COV-1', 'SARS-COV-4', 'SARS-COV-3')");
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Qual a capital do Japão?','Fortaleza','Pequim','Roma','Tóquio')");
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Presidente dos Estados Unidos?', 'Barack Obama', 'Donald Trump', 'Dilma Roussef', 'Hilary Clynton')");
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Onde foi realizada as Olimpíadas de 2016?', 'Grécia', 'China','Brasil','Inglaterra')");
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Recursão é um método de programação no qual uma função pode chamar:', 'outra função', 'a si mesma', 'função identificada', 'função não identificada')");
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Quantas vezes o Brasil foi campeão mundial de futebol?', '2', '7', '5', '3')");
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Quem foi o criador do Linux?', 'Bill Gattes', 'Steve Jobs', 'Steve Wozniak', 'Linus Torvalds')");          stmt.executeUpdate(SQL);
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Qual o significado da palavra Listener?','Ouvinte','Falante','Surdo','Mudo')");
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Qual a data da proclamação da República?', '22 de janeiro', '07 de stembro', '15 de novembro', '12 de outubro')");
                stmt.executeUpdate("INSERT INTO categories(description, answer, answerwrong1, answerwrong2, answerwrong3) "
                    + "VALUES('Qual a primeira capital do Brasil?', 'Rio de Janeiro', 'Brasília', 'São Paulo', 'Minas Gerais')");
                }
            
            //CRIANDO TABELA DE USUARIOS
            step = "attempt Table creation";
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS attempt("
                    + "login VARCHAR(200) NOT NULL,"
                    + "result NUMBER NOT NULL,"
                    + "date DATE NOT NULL," 
                    + "FOREIGN KEY(login) REFERENCES users(login))");
            
            step = "Default users creation";
            if (User.getUsers().isEmpty()){
            //CRIANDO USUARIOS
                stmt.executeUpdate("INSERT INTO users(login, media, date) "
                    + "VALUES('Jane', '10', 2020-06-19)");  
                }
            
            
            stmt.close();
            con.close();
        }catch(Exception ex){
            exceptionMessage = step + ": " + ex.getMessage();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}