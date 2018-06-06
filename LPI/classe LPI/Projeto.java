import java.util.Date;
public class Projeto{
   private String nome;
   private double orcamento;
   private int duracao;
   private String instituicao;
   private AreaDePesquisa areaDePesquisa;
   private Date dataEnvio;
   private Date dataResposta;
   private String resultado;
   
   public Projeto (String nome, double orcamento, int duracao, String instituicao, Date dataEnvio, AreaDePesquisa areaDePesquisa){
      this.nome = nome;
      this.orcamento = orcamento;
      this.duracao = duracao;
      this.instituicao = instituicao;
      this.dataEnvio = dataEnvio;
      dataResposta = null;
      resultado = "Aguardando Analise";
      this.areaDePesquisa = areaDePesquisa;
   }

   public String getNome(){
      return nome;
   }

   public double getOrcamento(){
      return orcamento;
   }

   public int getDuracao(){
      return duracao;
   }

   public String getInstituicao(){
      return instituicao;
   }

   public Date getDataEnvio(){
      return dataEnvio;
   }

   public Date getDataResposta(){
      return dataResposta;
   }

   public String getResultado(){
      return resultado; 
   }

   public AreaDePesquisa getAreaDePesquisa(){
      return areaDePesquisa;
   }

   public void setNome(String Nome){
      this.nome = nome;
   }

   public void setOrcamento(double orcamento){
      this.orcamento = orcamento;
   }                

   public void setInstituicao(String instituicao){
      this.instituicao = instituicao;
   }

   public void setDataEnvio(Date dataEnvio){
      this.dataEnvio = dataEnvio;
   } 

   public void setDataResposta(Date dataResposta){
      this.dataResposta = dataResposta;
   }

   public void setAreaDePesquisa(AreaDePesquisa areaDePesquisa){
      this.areaDePesquisa = areaDePesquisa;
   }

   public String toString(){
      return "Projeto\n nome:" + nome + "\n" + "orcamento:" + orcamento + "\n" + "instituicao:" + instituicao + "\n" + "Data de Envio:" + dataEnvio + "\n" + "Data de Resposta" + dataResposta + "\n" + "Resultado:" + resultado + "\n" + "Area de Pesquisa" + areaDePesquisa;
   }           
}         
