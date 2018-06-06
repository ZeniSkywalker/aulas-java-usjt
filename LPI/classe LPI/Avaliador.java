import java.util.Date;

public class Avaliador{
   private String cpf;
   private String rg;
   private String nome;
   private String sexo;
   private Date dataDeNascimento;
   private String grauAcademico;
   private String instituicaoDeEnsino;
   private AreaDePesquisa areaDePesquisa;
   private Projeto projeto;
   
   public Avaliador(String cpf, String rg, String nome, String sexo, Date dataDeNascimento, String grauAcademico, String instituicaoDeEnsino, AreaDePesquisa areaDePesquisa){
      this.cpf = cpf;
      this.rg = rg;
      this.nome = nome;
      this.sexo = sexo;
      this.dataDeNascimento = dataDeNascimento;
      this.grauAcademico = grauAcademico;
      this.instituicaoDeEnsino = instituicaoDeEnsino;
      this.areaDePesquisa = areaDePesquisa;
   }
   
   public String getCpf(){
      return cpf;
   }

   public String getRg(){
      return rg;
   }

   public String getNome(){
      return nome;
   }

   public String getSexo(){
      return sexo;
   }

   public Date getDataDeNascimento(){
      return dataDeNascimento;
   }

   public String getGrauAcademico(){
      return grauAcademico;
   }

   public String getInstituicaoDeEnsino(){
      return instituicaoDeEnsino;
   }            

   public AreaDePesquisa getAreaDePesquisa(){
      return areaDePesquisa;
   }

   public void setCpf(String cpf){
      this.cpf = cpf;
   }

   public void setRg(String rg){
      this.rg = rg;
   }

   public void setNome(String nome){
      this.nome = nome;
   }

   public void setSexo(String sexo){
      this.sexo = sexo;
   }

   public void setDataDeNascimento(Date dataDeNascimento){
      this.dataDeNascimento = dataDeNascimento;
   }

   public void setGrauAcademico(String grauAcademico){
      this.grauAcademico = grauAcademico;
   }

   public void setInstituicaoDeEnsino(String instituicaoDeEnsino){
      this.instituicaoDeEnsino = instituicaoDeEnsino;
   }

   public void setAreaDePesquisa(AreaDePesquisa areaDePesquisa){
      this.areaDePesquisa = areaDePesquisa;
   }
}
