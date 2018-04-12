public class Discipline{
   private String name;
   private boolean pratice;
   
   public Discipline(String name, boolean pratice){
      this.setName(name); 
      this.setPratice(pratice);
   }
   
   public String getData(){
      return "Name: " + name + ", Pratice: " + pratice;     
   }
  
   public void setName(String name){
      this.name = name;
   }
   
   public void setPratice(boolean pratice){
      this.pratice = pratice;
   }
}
