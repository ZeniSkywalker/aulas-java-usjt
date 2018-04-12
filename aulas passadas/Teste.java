import java.sql.*;
public class Teste{
   public static void main(String[]args){
      Professor prof = new Professor(2,"Thiago",28);
      Disciplina dis = new Disciplina("2","sua mae kaie",prof);
      try{
         ConexaoBD bd = new ConexaoBD();
         Connection conn = bd.conectar();
         
         prof.inserir(conn);
         dis.inserir(conn);
         
         Professor prof1 = new Professor(2);
         prof1.carregar(conn);
         System.out.println("Professor: " + prof1.getNome());
      }
      catch(Exception ex){
         System.out.println(ex);
      }
   }
}