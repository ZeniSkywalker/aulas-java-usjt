import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Pedido{
   private int idPedido;
   private Date data;
   private double valor;
   
   public Pedido(){   
   }
   
   public Pedido(int idPedido){
      this.idPedido = idPedido;
   }
   
   public Pedido(int idPedido, Date data, double valor) {
      this.idPedido = idPedido;
      this.data = data;
      this.valor = valor;
   }
   
   public int getIdPedido() {
      return idPedido;
   }
   
   public Date getData(){
      return data;
   }
   
   public double getValor(){
      return valor;
   }

   public void setData(Date data) {
      this.data = data;
   }
   
   public void setValor(double valor){
      this.valor = valor;
   }
   
   public void inserir(int idPedido, Connection conn){
      String sqlInsert = 
         "INSERT INTO pedido(id, data, valor) VALUES (?, ?, ?)";
   
      try (PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
         stm.setInt(1, getIdPedido());
         stm.setDate(2, new java.sql.Date(getData().getTime()));         
         stm.setDouble(3, getValor());
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
      String sqlDelete = "DELETE FROM pedido WHERE id = ?";
      try (PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
         stm.setInt(1, getIdPedido());
      
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
         "SELECT * FROM pedido WHERE cliente.id = ?";
   
      try (PreparedStatement stm = conn.prepareStatement(sqlSelect);){
         stm.setInt(1, getIdPedido());
         try (ResultSet rs = stm.executeQuery();){
         /*este outro try e' necessario pois nao da' para abrir o resultset
          *no anterior uma vez que antes era preciso configurar o parametro
          *via setInt; se nao fosse, poderia se fazer tudo no mesmo try
          */
            if (rs.next()) {
               this.setData(rs.getDate(2));
               this.setValor(rs.getDouble(3));
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
      return "Pedido [idPedio:" + idPedido + ", Data:" + data + ", Valor:"
         	+ valor + "]";
   }
 
}