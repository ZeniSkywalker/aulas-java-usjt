import javax.swing.JOptionPane;
public class UrnaEletronica{
   private double[] votos;
   private double numEleitoresRegistrados;
   public final int SAIR = -1;
   public final int BRANCO_NULO = 0;
   public final int CANDIDATO1 = 1;
   public final int CANDIDATO2 = 2;
   public final int CANDIDATO3 = 3;
   public final int CANDIDATO4 = 4;
   
   public UrnaEletronica(double numEleitoresRegistrados){
      this.numEleitoresRegistrados = numEleitoresRegistrados;
      votos = new double[5];
   }
   
   public double comparecimento(){
      double soma = 0;
      for(int i = 0; i < votos.length; i++){
         soma += votos[i];
      }
      return soma;
   }
   
   public double votos(int posicao){
      if(posicao >= 0 && posicao < votos.length){
         return votos[posicao];
      }
      //valor invalido para votos
      return -1.0;
   }
   
   public void votar(int posicao){
      if(posicao >= 0 && posicao < votos.length){
         votos[posicao]++;
      }
   }
   
   public void votacao(){
      int menu;
      do{
         menu = Integer.parseInt(JOptionPane.showInputDialog(
            "Escolha seu candidato"+
            "\n 0 - Branco/Nulo"+
            "\n 1 - Candidato 1"+
            "\n 2 - Candidato 2"+
            "\n 3 - Candidato 3"+
            "\n 4 - Candidato 4"+
            "\n-1 - Sair"));
         switch(menu){
            case SAIR: 
               break;
            case BRANCO_NULO:
               votar(BRANCO_NULO);
               break;
            case CANDIDATO1:
               votar(CANDIDATO1);
               break;
            case CANDIDATO2:
               votar(CANDIDATO2);
               break;
            case CANDIDATO3:
               votar(CANDIDATO3);
               break;
            case CANDIDATO4:
               votar(CANDIDATO4);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Opção Inválida", 
                  "Urna", JOptionPane.ERROR_MESSAGE);        
         }
         
      }while(menu != -1 && comparecimento() < numEleitoresRegistrados); 
      JOptionPane.showMessageDialog(null, resultado());
 
   }
   
   public String resultado(){
      String saida = "";
      saida += "Resultado da Eleição";
      saida += "\nBrancos/Nulos = "+votos[BRANCO_NULO];
      saida += "\nCandidato 1 = "+votos[CANDIDATO1];
      saida += "\nCandidato 2 = "+votos[CANDIDATO2];
      saida += "\nCandidato 3 = "+votos[CANDIDATO3];
      saida += "\nCandidato 4 = "+votos[CANDIDATO4];
      double porcentagemNulosBrancos = 
	  100.0*votos[BRANCO_NULO]/comparecimento();
      saida += "\n% de Brancos e Nulos = "+ porcentagemNulosBrancos + 
	  "%";
      saida += "\nComparecimento Total = "+comparecimento();

      return saida;
   }

}