import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Professor{
   private int matricula;
   private String nome;
   private int idade;
   
   public Professor(){      
   }
    
   public Professor(int matricula){
      this.matricula = matricula;
   } 

    public Professor(int matricula, String nome, int idade) {
      this.matricula = matricula;
      this.nome = nome;
      this.idade = idade;
   }
   
    public int getMatricula() {
      return matricula;
   }

   public void setMatricula(int matricula) {
      this.matricula = matricula;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public int getIdade() {
      return idade;
   }

   public void setIdade(int idade) {
      this.idade = idade;
   }

    public void inserir(Connection conn) {
      String sqlInsert = 
         "INSERT INTO professor(matricula, nome, idade) VALUES (?, ?, ?)";
   
      try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
         stm.setInt(1, getMatricula());
         stm.setString(2, getNome());
         stm.setInt(3, getIdade());
         stm.execute();
      } 
      catch (Exception e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } 
         catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
         }
      } 
   }
	
   public void alterarNome(Connection conn, String novoNome) {
      String sqlUpdate = "UPDATE professor SET nome = ? WHERE matricula = ?";
    
      try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
         stm.setString(1, novoNome);
         stm.setInt(2, getMatricula());
      
         stm.execute();
      } 
      catch (Exception e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } 
         catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
         }
      } 
   }


   public void excluir(Connection conn) {
      String sqlDelete = "DELETE FROM professor WHERE matricula = ?";
      try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
         stm.setInt(1, getMatricula());
      
         stm.execute();
      } 
      catch (Exception e) {
         e.printStackTrace();
         try {
            conn.rollback();
         } 
         catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
         }
      } 
   }
   public void carregar(Connection conn) {
      String sqlSelect = 
         "SELECT * FROM professor WHERE professor.matricula = ?";
   
      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);){
         stm.setInt(1, getMatricula());
         stm.setInt(3, getIdade());
         try (ResultSet rs = stm.executeQuery();){
            if (rs.next()) {
               this.setNome(rs.getString(2));
               this.setIdade(rs.getInt(3));
            }
         
         } 
         catch (Exception e) {
              e.printStackTrace();
         }
         }
         catch (SQLException e1) {
         System.out.print(e1.getStackTrace());
      }
   }
   
   public String toString() {
      return "Professor [matricula: " + matricula + ", Nome: " + nome + ", Idade: "
         	+ idade + "]";
   }
}