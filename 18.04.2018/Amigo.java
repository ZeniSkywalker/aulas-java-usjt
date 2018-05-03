public class Amigo{
   private String nome;
   private  Data aniversario;
   
   public Amigo(String nome, Data aniversario){
      this.nome = nome;
      this.aniversario = aniversario;
   }
   
   public String getNome(){
      return this.nome;
   }
   
   public void setNome(){
      this.nome = nome;
   }
   
   public Data getAniversario(){ 
      return this.aniversario;
   }
   
   public void setAniversario(){
      this.aniversario = aniversario;
   }
   
   public String getDados(){
      return "Nome: " + nome + ", Aniversário: " + aniversario;     
   }
}