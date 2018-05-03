import java.sql.SQLException;
import java.sql.Connection;

public class Teste {

   public static void main(String[] args) {
      Connection conn = null;
      Cliente cl;
      Vendedor vd;
   
      try {
      	// obtem conexao com o banco
         ConexaoBD bd = new ConexaoBD();
         conn = bd.conectar();
         vd = new Vendedor();
      
      	// *** IMPORTANTE ***: Força o uso de transação.
         conn.setAutoCommit(false);
      	// *** Inclusao do Primeiro Cliente ***
         cl = new Cliente(1001, "Zé das Couves", "1127991999");
         cl.incluir(conn);
      
      	// *** Inclusao do Segundo Cliente ***
         cl = new Cliente();
         cl.setIdCliente(1002);
         cl.setNome("João das Couves");
         cl.setFone("1160606161");
         cl.incluir(conn);
      
      	// *** Inclusao do Terceiro Cliente ***
         cl = new Cliente(1003, "Maria das Couves", "1121212121");
         cl.incluir(conn);
      
      	// *** IMPORTANTE ***: Efetiva inclusões
         conn.commit();
         
         // *** Lista todos os clientes
         System.out.println("\nLista todos os clientes");
         vd.listarClientes(conn);
      
      	// *** Carregar o cliente 1003 a partir do bd ***
         cl = new Cliente(1003);
         System.out.println("\nLista o 1003 antes de carregar os dados");
         System.out.println(cl);
         cl.carregar(conn);
         System.out.println("\nLista o 1003 depois de carregar os dados");
         System.out.println(cl);
      	// *** Excluir o cliente 1003 (carregado em cl) do bd
         cl.excluir(conn);
      
      	// *** IMPORTANTE ***: Efetiva exclusão
         conn.commit();
         
         // *** Lista novamente todos os clientes
         System.out.println("\nLista todos os clientes depois de apagar o 1003");
         vd.listarClientes(conn);
      } 
      catch (Exception e) {
         e.printStackTrace();
         if (conn != null) {
            try {
               conn.rollback();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
         }
      } 
      finally {
         if (conn != null) {
            try {
               conn.close();
            } 
            catch (SQLException e1) {
               System.out.print(e1.getStackTrace());
            }
         }
      }
   }
}