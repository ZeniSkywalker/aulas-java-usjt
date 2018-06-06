import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaBorder extends JFrame implements ActionListener{
   private JLabel lblValor;
   private JTextField txtValor;
   private JButton btnSoma, btnSair;
   
   
   public TelaBorder(){
      super("Calculadora Border");
      //instanciar elementos de interface (widgets)
      lblValor = new JLabel("Valor:");
      txtValor = new JTextField(10);
      btnSoma = new JButton("Soma 10");
      btnSair = new JButton("Sair");
      
      //acesso ao canvas
      Container tela = getContentPane();
      tela.setLayout(new BorderLayout());
      
      //colocar no canvas
      add(lblValor, BorderLayout.WEST);
      add(txtValor, BorderLayout.EAST);
      add(btnSoma, BorderLayout.NORTH);
      add(btnSair, BorderLayout.SOUTH);
      
      //configurar listeners
      btnSoma.addActionListener(this);
      btnSair.addActionListener(this);
   
      //ajustes finais
      setLocationRelativeTo(null);
      setSize(220, 100);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == btnSoma){
         int valor = Integer.parseInt(txtValor.getText());
         valor += 10;
         txtValor.setText(""+valor);
      } else if(ae.getSource() == btnSair){
         System.exit(0);
      }
   }
}