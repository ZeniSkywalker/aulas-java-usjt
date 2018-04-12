import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.lang.Exception;

public class Professor{
   private String nome;
   private int idade;
   private int matricula;
   
   public Professor(){
      nome = "";
      idade = 0;
      matricula = 0;
   }
   
   public Professor(int matricula){
      nome = "";
      idade = 0;
      this.matricula = matricula;
   }
   
   public Professor(int matricula, String nome, int idade){
      this.matricula = matricula;
      this.nome = nome;
      this.idade = idade;
   }
   
   public void setMatricula(int matricula){ this.matricula = matricula; }
   public int getMatricula(){ return matricula; }
   
   public void setNome(String nome){ this.nome = nome; }
   public String getNome(){ return nome; }
   
   public void setIdade(int idade){ this.idade = idade; }
   public int getIdade(){ return idade; }
   
   public void inserir(Connection conn){
      String sqlInsert = "INSERT INTO PROFESSOR(IdProfessor,Nome,Idade) VALUES (?,?,?)";
      try(PreparedStatement stm = conn.prepareStatement(sqlInsert);){
         stm.setInt(1,getMatricula());
         stm.setString(2,getNome());
         stm.setInt(3,getIdade());
         stm.execute();
      }
      catch(Exception ex){
         try{
            conn.rollback();
         }
         catch(SQLException ex1){
            System.out.println(ex1.getStackTrace());
         }
      }
   }
   
   public void excluir(Connection conn){
      String sqlDelete = "DELETE FROM PROFESSOR WHERE IdProfessor = ?";
      try(PreparedStatement stm = conn.prepareStatement(sqlDelete);){
         stm.setInt(1,getMatricula());
         stm.execute();
      }
      catch(Exception ex){
         try{
            conn.rollback();
         }
         catch(SQLException ex1){
            System.out.println(ex1.getStackTrace());
         }
      }
   }
   
   public void alterar(Connection conn){
      String sqlUpdate = "UPDATE PROFESSOR SET IdProfessor = ?, Nome = ?, Idade = ? WHERE IdProfessor = ?";
      try(PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
         stm.setInt(1,getMatricula());
         stm.setString(2,getNome());
         stm.setInt(3,getIdade());
         stm.setInt(4,getMatricula());
         stm.execute();
      }
      catch(Exception ex){
         try{
            conn.rollback();
         }
         catch(SQLException ex1){
            System.out.println(ex1.getStackTrace());
         }
      }
   }
   
   public void carregar(Connection conn){
      String sqlSelect = "SELECT IdProfessor, Nome, Idade FROM PROFESSOR WHERE IdProfessor = ?";
      try(PreparedStatement stm = conn.prepareStatement(sqlSelect);){
         stm.setInt(1,getMatricula());
         try(ResultSet rs = stm.executeQuery();){
            if(rs.next()){
               setMatricula(rs.getInt(1));
               setNome(rs.getString(2));
               setIdade(rs.getInt(3));
            }
         }
         catch(Exception ex){
            System.out.println(ex.getStackTrace());
         }
      }
      catch(Exception ex1){
         try{
            conn.rollback();
         }
         catch(SQLException ex2){
            System.out.println(ex2.getStackTrace());
         }
      }
   }
   
   public String toString(){
      return "Matricula: " + getMatricula() + " Nome: " + getNome() + " Idade: " + getIdade(); 
   }
}