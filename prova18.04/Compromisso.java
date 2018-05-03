public class Compromisso{
   private String descricao;
   private  Horario horario;
   
   public Compromisso(String descricao, Horario horario){
      this.descricao = descricao;
      this.horario = horario;
   }
   
   public String getDescricao(){
      return this.descricao;
   }
   
   public void setDescricao(){
      this.descricao = descricao;
   }
   
   public Horario getHorario(){ 
      return this.horario;
   }
   
   public void setHorario(){
      this.horario = horario;
   }
   
   public String getDados(){
      return "Descricao: " + descricao + ", Horario: " + horario;     
   }
}