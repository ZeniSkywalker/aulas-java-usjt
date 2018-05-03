public class Data{
   private String mes;
   private int dia;
   
   public Data(int dia, String mes){
      this.dia = dia;
      this.mes = mes;
   }
   
   public int getDia(){
      return this.dia;
   }
   
   public void setDia(){
      this.dia = dia;
   }
   
   public String getMes(){ 
      return this.mes;
   }
   
   public void setMes(){
      this.mes = mes;
   }
   
   public String getDados(){
      return "Dia: " + dia + ", Mes: " + mes;     
   }
}