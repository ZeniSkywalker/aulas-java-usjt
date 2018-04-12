public class Produto {
   private String nome;
   private double preco;
   private Etiqueta etiqueta;	// uma referência para uma etiqueta 
   public Produto () {
      nome = "produto";
      preco = 10;
	  //veja na aula teórica as diversas formas de instanciar uma 
	  //etiqueta para o produto
	  etiqueta = new Etiqueta("marca do produto", "P");
   }
   public String getNome() {
      return this.nome;
   }
   public double getPreco () {
      return this.preco;
   }
   public Etiqueta getEtiqueta () {
      return this.etiqueta;
   }
   public void setNome (String nome) {
      this.nome = nome;
   }
   public void setPreco (double preco) {
      this.preco = preco;
   }
   public void setEtiqueta (Etiqueta etiqueta) {
      this.etiqueta = etiqueta;
   }
}