/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataMapper;
import Dominio.Periodo;
import Dominio.Professor;
import Dominio.Usuario;
import java.sql.*;
import java.util.Calendar;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Leticia
 */
public class PopulateDB {
    
    public static void main (String[]args){
        
        dropDB("prosub", "root", "root");
        createDB("prosub", "root", "root");
        populateDB();
        
        
    }
    
    public static void fullSetupDB(){
                
        dropDB("prosub", "root", "root");
        createDB("prosub", "root", "root");
        populateDB();
    }
    
    public static void recreateDB(){
        dropDB("prosub", "root", "root");
        createDB("prosub", "root", "root");
    }
    
    private static void dropDB(String dbName, String username, String password){
        
    Connection conn = null;
    Statement stmt = null;
    String dbURL = "jdbc:mysql://localhost";

   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(dbURL, username, password);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Deleting database " + dbName + "...");
      stmt = conn.createStatement();
      
      String sql = "DROP DATABASE " + dbName;
      stmt.executeUpdate(sql);
      System.out.println("Database deleted successfully...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Finished!");
   System.out.println("========================================================================");
        
    }
    
    private static void createDB(String dbName, String username, String password){
    Connection conn = null;
    Statement stmt = null;
    String dbURL = "jdbc:mysql://localhost";

   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(dbURL, username, password);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating database " + dbName +  "...");
      stmt = conn.createStatement();
      
      String sql = "CREATE DATABASE " + dbName;
      stmt.executeUpdate(sql);
      System.out.println("Database deleted successfully...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Finished!");
   System.out.println("========================================================================");
        
    }
    
    private static void populateDB(){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProSubPU");
        
        populateUsuario(emf);
        populateProfessores(emf);
        
    }
    
    private static void populateProfessores(EntityManagerFactory emf){
        
        
//        PeriodoJpaController periodoJpa = new PeriodoJpaController(emf);
//        
//        Calendar comeco1 = Calendar.getInstance();
//        Calendar fim1 = Calendar.getInstance();
//        
//        comeco1.set(2013, 06, 10, 10, 10);
//        fim1.set(2013, 06, 10, 10, 20);
//        
//        Periodo periodo = new Periodo(comeco1, fim1);
//        
//        periodoJpa.create(periodo);
//        
//        long id = 1;
//        
//        Periodo p = periodoJpa.findPeriodo(id);
        
//        int hora = p.getLimiteInferior().get(Calendar.HOUR_OF_DAY);
//        int minuto = p.getLimiteInferior().get(Calendar.MINUTE);
//        
        //Calendar 
        
//        Periodo per1 = new Periodo (new Calendar())
        
        Professor p1 = new Professor("Calebe");
        Professor p2 = new Professor("Ana Claudia");
        
        ProfessorJpaController profJpa = new ProfessorJpaController(emf);
        
        profJpa.create(p1);
        profJpa.create(p2);
        
        
    }
    
    public static void populateUsuario(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProSubPU");
        PopulateDB.populateUsuario(emf);
    }
    
    private static void populateUsuario(EntityManagerFactory emf){
        
        UsuarioJpaController usuarioJpa = new UsuarioJpaController(emf);
        
        Usuario u1 = new Usuario("bob");
        Usuario u2 = new Usuario("jane");
        u2.setSenha("mackenzie");
        
        usuarioJpa.create(u1);
        usuarioJpa.create(u2);
        
        Usuario u3 = usuarioJpa.findUsuario("bob");
    }
    
}
