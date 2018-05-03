public class Horario{
   private int hora;
   private int minuto;
   
   public Horario(int hora, int minuto){
      this.hora = hora;
      this.minuto = minuto;
   }
   
   public int getHora(){
      return this.hora;
   }
   
   public void setHora(){
      this.hora = hora;
   }
   
   public int getMinito(){ 
      return this.minuto;
   }
   
   public void setMinuto(){
      this.minuto = minuto;
   }
   
   public String getDados(){
      return "Hora: " + hora + ", Minuto: " + minuto;     
   }
}