public class AreaDePesquisa{
   private int codigo;
   private String areaDeConhecimento;
   private TesteGrandeArea grandesAreas;
   private String vetorGrandeAreaConhecimento;
   
   public AreaDePesquisa(int codigo, String areaDeConhecimento, TesteGrandeArea grandesAreas){
      this.codigo = codigo;
      this.areaDeConhecimento = areaDeConhecimento;
      this.grandesAreas = grandesAreas;
   }
   
   public int getCodigo(){
      return codigo;
   }
   
   public String getAreaDeConhecimento(){
      return areaDeConhecimento;
   }
   
   public String getGrandesAreas(){
      return grandesAreas;
   }
   
   public void setCodigo(){
      this.codigo = codigo;
   }
   
   public void setAreaDeConhecimento(){
      this. areaDeConhecimento = areaDeConhecimento;
   }
   
   public void setGrandesAreas(){
      this.grandesAreas = grandesAreas;
   }
}

//NÃO VAI USAR OS SETS PORQUE NAO VAI SER MUDADO AS AREAS E GRANDES AREAS