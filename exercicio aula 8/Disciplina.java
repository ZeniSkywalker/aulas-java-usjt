import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Disciplina{
   private String codigo;
   private String nome;
   private ArrayList<String> professores;

   public Disciplina(){      
   }
    
   public Disciplina(){
       this.codigo = codigo;
   }

   public Disciplina(String codigo, String nome, Professor professor) {
      this.codigo = codigo;
      this.nome = nome;
      professores = new ArrayList<Professor>();
      professores.add(professor);
   }
   
   public String getCodig() {
      return codigo;
   }
   
   public String getNome(){
      return nome;
   }
   
   public ArrayList getProfessor(){
      return professor;
   }

   public void setCodigo(String codigo) {
      this.codigo = codigo;
   }
   
   public void setNome(String nome){
      this.nome = nome;
   }
   