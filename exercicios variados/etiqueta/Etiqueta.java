public class Etiqueta {
   private String marca;
   private String tamanho;
   
   public Etiqueta (String marca, String tamanho){
      //this.marca = marca;
      //this.tamanho = tamanho;
	  //validações concentradas nos métodos modificadores
      this.setMarca(marca);
      this.setTamanho(tamanho);
   }
   public String getMarca () {
      return this.marca;
   }
   public String getTamanho () {
      return this.tamanho;
   }
   public void setMarca (String marca) {
      this.marca = marca;
   }
   public void setTamanho (String tamanho) {
      if (tamanho.equals("P") ||
          tamanho.equals("M") ||
          tamanho.equals("G") ||
          tamanho.equals("XG") ||
          tamanho.equals("XXG")) {
            this.tamanho = tamanho;
      }
      else {
          this.tamanho = "P";
      }
   }
}