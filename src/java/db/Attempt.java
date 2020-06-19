/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import web.DbListener;

/**
 *
 * @author Fernanda
 */
public class Attempt {
    private String name;
    private double result;
    private Date date;
    
     //MÉTODO PARA REGISTRAR UMA TENTATIVA
    public static ArrayList<Attempt> getAttempts() throws Exception{
        ArrayList<Attempt> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(DbListener.jdbcUrl);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM attempt");
        while(rs.next()){
              list.add(new Attempt(
                    rs.getString("result"), 
                    rs.getDouble("result"), 
                    rs.getDate("date")));
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }
    
    //CRIANDO METODO PARA CRIAR UMA TENTATIVA
    public static void addAttempts(String name, double result, Date date) throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection(DbListener.jdbcUrl);
        String SQL = "INSERT INTO users(name, result) VALUES(?,?)";
        PreparedStatement stmt = con.prepareStatement(SQL);
        stmt.setString(1, name);
        stmt.setDouble(2, result);
        stmt.setDate(3, (java.sql.Date) date);
        stmt.execute();
        stmt.close();
        con.close(); 
    }
        public Attempt(String name, double result, Date date) {
        this.name = name;
        this.result = result;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
