public class Pagamento{
   private String nomeDoPagador;
   private String cpf;
   private double valorASerPago;
   
   public Pagamento(){
   }
   
   public Pagamento(String nomeDoPagador, String cpf, double valorASerPago){
      this.nomeDoPagador = nomeDoPagador;
      this.cpf = cpf;
      this.valorASerPago = valorASerPago;
   }
   
   public void setNomeDoPagador(String nomeDoPagador){
      this.nomeDoPagador = nomeDoPagador;
   }
   
   public void setCpf(String cpf){ 
      this.cpf = cpf; 
   }
   
   public void setValorASerPago(double valorASerpago){
      this.valorASerPago = valorASerpago;
   }
   
   public String getNomeDoPagador(){ 
      return nomeDoPagador; 
   }
   
   public String getCpf(){ 
       return cpf; 
   }
   
   public double getValorASerPago(){ 
      return valorASerPago;
   }
}