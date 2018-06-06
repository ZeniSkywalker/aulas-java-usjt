public class Agencia{
   private String cnpj;
   private int ie;
   private int im;
   private String razaoSocial;
   private String nomeFantasia;
   private Pesquisador pesquisador;
   private Avaliador avaliador;
   
   public Agencia(String cnpj, int ie, int im, String razaoSocial, String nomeFantasia, Avaliador avaliador, Pesquisador pesquisador){
      this.cnpj = cnpj;
      this.ie = ie;
      this.im = im;
      this.razaoSocial = razaoSocial;
      this.nomeFantasia = nomeFantasia;
      this.avaliador = avaliador;
      this.pesquisador = pesquisador;
   }
   
   public String getCnpj(){
      return cnpj;
   }

   public int getIe(){
      return ie;
   }

   public int getIm(){
      return im;
   }

   public String getRazaoSocial(){
      return razaoSocial;
   }

   public String getNomeFantasia(){
      return nomeFantasia;
   }

   public Avaliador getAvaliador(){
      return avaliador;
   }      

   public Pesquisador getPesquisador(){
      return pesquisador;
   }      

   public void setCnpj(String cnpj){
      this.cnpj = cnpj;
   }

   public void setIe(int ie){
      this.ie = ie;
   }

   public void setIm(int im){
      this.im = im;
   }

   public void setRazaoSocial(String razaoSocial){
      this.razaoSocial = razaoSocial;
   }

   public void setNomeFantasia(String nomeFantasia){
      this.nomeFantasia = nomeFantasia;
   }

   public void setAvaliador(Avaliador avaliador){
      this.avaliador = avaliador;
   }

   public void setPesquisador(Pesquisador pesquisador){
      this.pesquisador = pesquisador;
   }   
}
