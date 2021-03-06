import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaGrid extends JFrame implements ActionListener{
   private JTextField txtValor;
   private JLabel lblValor;
   private JButton btnSoma, btnFechar;

   public TelaGrid(){
      //configura o titulo
      super("Calculadora");
      //instanciar elementos de interface
      lblValor = new JLabel("Valor:");
      txtValor = new JTextField(10);
      btnSoma = new JButton("Soma 10");
      btnFechar = new JButton("Fechar");
      //configura o gerenciador de layout
      Container caixa = getContentPane();
      caixa.setLayout(new GridLayout(2,2));
      //adicionar a tela
      caixa.add(lblValor);
      caixa.add(txtValor);
      caixa.add(btnSoma);
      caixa.add(btnFechar);
      //configurar eventos
      btnSoma.addActionListener(this);
      btnFechar.addActionListener(this);
      //retoques finais
      setSize(224,94);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource()==btnSoma){
         String sValor = txtValor.getText();
         int valor = Integer.parseInt(sValor) + 10;
         txtValor.setText(""+valor);       
      } else if (e.getSource()==btnFechar){
         System.exit(0);
      }
   }

   public static void main(String[] args){
      new TelaGrid();
   }
}