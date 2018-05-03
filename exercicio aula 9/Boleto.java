public class Boleto extends Pagamento{
   private String numeroDoBoleto;
   private int diaVenc;
   private int mesVenc;
   private int anoVenc;
   
   public Boleto(){
   }
   
   public Boleto(String nomeDoPagador, String cpf, double valorASerPago, 
                 String numeroDoBoleto, int diaVenc, int mesVenc, int anoVenc){
      super(nomeDoPagador, cpf, valorASerPago);
      this.numeroDoBoleto = numeroDoBoleto;
      this.diaVenc = diaVenc;
      this.mesVenc = mesVenc;
      this.anoVenc = anoVenc;
   }
   
   public void setNumeroDoBoleto(String numeroDoBoleto){ 
      this.numeroDoBoleto = numeroDoBoleto; 
   }
   
   public void setDiaVenc(int diaVenc){ 
      this.diaVenc = diaVenc; 
   }
   
   public void setMesVenc(int mesVenc){ 
      this.mesVenc = mesVenc;
   }
   
   public void setAnoVenc(int anoVenc){ 
      this.anoVenc = anoVenc; 
   }
   
   public String getNumeroDoBoleto(){ 
      return numeroDoBoleto; 
   }
   
   public int getDiaVenc(){ 
      return diaVenc; 
   }
   
   public int getMesVenc(){ 
      return mesVenc; 
   }
   
   public int getAnoVenc(){ 
      return anoVenc; 
   }
}