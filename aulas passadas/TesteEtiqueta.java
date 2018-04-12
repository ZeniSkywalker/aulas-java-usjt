import javax.swing.JOptionPane;
public class TesteEtiqueta {
   public static void main (String args[]) {
     String marca = JOptionPane.showInputDialog ("Digite a marca");
     String tamanho = JOptionPane.showInputDialog ("Digite o tamanho");
     
     Etiqueta etiqueta1;	//declara
     etiqueta1 = new Etiqueta(marca, tamanho);	//instancia
     
     marca = JOptionPane.showInputDialog ("Digite a marca");
     tamanho = JOptionPane.showInputDialog ("Digite o tamanho");
     
     Etiqueta etiqueta2 = new Etiqueta(marca, tamanho); //declara e instancia
     
     System.out.println ("etiqueta1:\n" + etiqueta1.getMarca() +
     "\n" + etiqueta1.getTamanho());
     
     System.out.println ("etiqueta2:\n" + etiqueta2.getMarca() +
     "\n" + etiqueta2.getTamanho());

   }
}