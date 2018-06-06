import java.util.Date;
public class Pesquisador{
   private String cpf;
   private String rg;
   private String nome;
   private String sexo;
   private Date dataNascimento;
   private String grauAcademico;
   private String instituicaoDeEnsino;
   private Projeto projeto;
   
   public Pesquisador (String cpf, String rg, String nome, String sexo, Date dataNascimento, String grauAcademico, String instituicaoDeEnsino, Projeto projeto){
      this.cpf = cpf;
      this.rg = rg;
      this.nome = nome;
      this.sexo = sexo;
      this.dataNascimento = dataNascimento;
      this.grauAcademico = grauAcademico;
      this.instituicaoDeEnsino = instituicaoDeEnsino;
      this.projeto = projeto;
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

   public Date getDataNascimento(){
      return dataNascimento;
   }

   public String getGrauAcademico(){
      return grauAcademico;
   }

   public String getInstituicaoDeEnsino(){
      return instituicaoDeEnsino;
   }

   public Projeto getProjeto(){
      return projeto;
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

   public void setDataNascimento(Date dataNascimento){
      this.dataNascimento = dataNascimento;
   } 

   public void setGrauAcademico(String grauAcademico){
      this.grauAcademico = grauAcademico;
   } 

   public void setInstituicaoDeEnsino(String instituicaoDeEnsino){
      this.instituicaoDeEnsino = instituicaoDeEnsino;
   } 

   public void setProjeto(Projeto projeto){
      this.projeto = projeto;
   }

   public String toString(){
      return "Pesquisador\n Nome:" + nome + "\n" + "CPF:" + cpf + "\n" + "RG:" + rg + "\n" + "Data de Nascimento:" + dataNascimento + "\n" + "Sexo" + sexo + "\n" + "Grau Academico:" + grauAcademico + "\n" + "Instituicao de Ensino" + instituicaoDeEnsino;
   }
}
