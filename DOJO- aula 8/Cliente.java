import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Cliente {
   private int idCliente;
   private String nome;
   private String fone;
   private ArrayList<Pedido>pedidos;
   
   public Cliente(){
   }

   public Cliente(int idCliente) {
      this.idCliente = idCliente;
   }

   public Cliente(int idCliente, String nome, String fone) {
      this.idCliente = idCliente;
      this.nome = nome;
      this.fone = fone;
   }

   public int getIdCliente() {
      return idCliente;
   }

   public void setIdCliente(int idCliente) {
      this.idCliente = idCliente;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getFone() {
      return fone;
   }

   public void setFone(String fone) {
      this.fone = fone;
   }

   public void incluir(Connection conn) {
      String sqlInsert = 
         "INSERT INTO cliente(id, nome, fone) VALUES (?, ?, ?)";
   
      try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
         stm.setInt(1, getIdCliente());
         stm.setString(2, getNome());
         stm.setString(3, getFone());
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
      String sqlDelete = "DELETE FROM cliente WHERE id = ?";
      try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
         stm.setInt(1, getIdCliente());
      
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
	
   public void atualizarTelefone(Connection conn, String novoFone) {
      String sqlUpdate = "UPDATE CLIENTE SET FONE = ? WHERE ID = ?";
    
      try (PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
         stm.setString(1, novoFone);
         stm.setInt(2, getIdCliente());
      
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
         "SELECT * FROM cliente WHERE cliente.id = ?";
   
      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);){
         stm.setInt(1, getIdCliente());
         try (ResultSet rs = stm.executeQuery();){
         /*este outro try e' necessario pois nao da' para abrir o resultset
          *no anterior uma vez que antes era preciso configurar o parametro
          *via setInt; se nao fosse, poderia se fazer tudo no mesmo try
          */
            if (rs.next()) {
               this.setNome(rs.getString(2));
               this.setFone(rs.getString(3));
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
   
   public void listarPedidos(Connection conn){
      System.out.println(ResultSet);
   }
   
   public String toString() {
      return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", fone="
         	+ fone + "]";
   }
}
