public class Contatos{
   private Amigo amigo;
   private ArrayList<Amigo> 
      
   public Contatos(Amigo amigo, Data data){
      this.setAmigo();
      this.setData(data);   
   }
   
   
   public String getData(){
      return "Amigo: [ Nome: " + amigo.getAmigo() + ", Data: " + data.getData() + "]";     
   }
   
    public void setAmigo(Amigo amigo){
      this.amigo = amigo;
   }
   
   public void setData(Data data){
      this.data = data;
   }

}