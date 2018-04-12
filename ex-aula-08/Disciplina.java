import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.lang.Exception;

public class Disciplina{
   private String codigo;
   private String nome;
   private ArrayList<Professor> professores;
   
   public Disciplina(){
      codigo = "";
      nome = "";
      professores = new ArrayList<>();
   }
   
   public Disciplina(String codigo){
      this.codigo = codigo;
      nome = "";
      professores = new ArrayList<>();
   }
   
   public Disciplina(String codigo, String nome,Professor professor){
      this.codigo = codigo;
      this.nome = nome;
      professores = new ArrayList<>();
      professores.add(professor);
   }
   
   public void setCodigo(String codigo){ this.codigo = codigo; }
   public String getCodigo(){ return codigo; }
   
   public void setNome(String nome){ this.nome = nome; }
   public String getNome(){ return nome; }
   
   public void setProfessor(Professor professor){ professores.set(0, professor); }
   public Professor getProfessor(){ return professores.get(0); }
   
   public void inserir(Connection conn){
      String sqlInsert = "INSERT INTO DISCIPLINA(IdDisciplina,Nome,IdProfessor) VALUES (?,?,?)";
      try(PreparedStatement stm = conn.prepareStatement(sqlInsert);){
         stm.setString(1,getCodigo());
         stm.setString(2,getNome());
         stm.setInt(3,professores.get(0).getMatricula());
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
      String sqlDelete = "DELETE FROM DISCIPLNA WHERE IdDisciplina = ?";
      try(PreparedStatement stm = conn.prepareStatement(sqlDelete);){
         stm.setString(1,getCodigo());
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
      String sqlUpdate = "UPDATE DISCIPLINA SET IdDisciplina = ?, Nome = ?, IdProfessor = ? WHERE IdDisciplina = ?";
      try(PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
         stm.setString(1,getCodigo());
         stm.setString(2,getNome());
         stm.setInt(3,professores.get(0).getMatricula());
         stm.setString(4,getCodigo());
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
      String sqlSelect = "SELECT IdDisciplina, Nome, IdProfessor FROM DISCIPLINA WHERE IdDisciplina = ?";
      try(PreparedStatement stm = conn.prepareStatement(sqlSelect);){
         stm.setString(1,getCodigo());
         try(ResultSet rs = stm.executeQuery();){
            if(rs.next()){
               setCodigo(rs.getString(1));
               setNome(rs.getString(2));
               Professor prof = new Professor(rs.getInt(3));
               prof.carregar(conn);
               setProfessor(prof);
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
      return "Codigo: " + getCodigo() + " Nome: " + getNome() + " Codigo do professor: " + professores.get(0).getMatricula() + " Nome do professor: " + professores.get(0).getNome();
   }
}