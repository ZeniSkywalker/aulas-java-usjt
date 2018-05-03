import javax.swing.JOptionPane;
public class TesteProduto {
   public static void main (String args[]) {
     
	 Produto p = new Produto(); //produto criado com o construtor padrão definido
								//na classe produto
     
     //note que para exibir marca e tamnho que são atributos de Etiqueta, você 
	 //precisa obter a refência de etiqueta, que é um atributo de Produto
	 JOptionPane.showMessageDialog(null, "nome do produto: " + p.getNome() +
     "\npreco = " + p.getPreco() + "\nmarca = " + p.getEtiqueta().getMarca() +
     "\ntamanho = " + p.getEtiqueta().getTamanho());
     
     //você pode pegar a refência e armazenar numa variável auxiliar
	 Etiqueta e = p.getEtiqueta();
	 JOptionPane.showMessageDialog(null, "nome do produto: " + p.getNome() +
     "\npreco = " + p.getPreco() + "\nmarca = " + e.getMarca() +
     "\ntamanho = " + e.getTamanho());

   }   
}
