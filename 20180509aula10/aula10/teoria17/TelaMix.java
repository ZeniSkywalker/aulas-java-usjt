import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;


public class TelaMix extends JFrame implements ActionListener{
   private JLabel lblValor;
   private JTextField txtValor;
   private JButton btnSoma, btnSair;
   
   
   public TelaMix(){
      super();
      setTitle("Calculadora Mix");
      //instanciar elementos de interface (widgets)
      lblValor = new JLabel("Valor:");
      txtValor = new JTextField(10);
      btnSoma = new JButton("Soma 10");
      btnSair = new JButton("Sair");
      
      //acesso ao canvas
      Container tela = getContentPane();
      tela.setLayout(new BorderLayout());
      
      //colocar nos paineis extras
      JPanel pnlCenter = new JPanel(new GridLayout(1,1));
      pnlCenter.add(lblValor);
      pnlCenter.add(txtValor);
      
      JPanel pnlSouth = new JPanel(new FlowLayout());
      pnlSouth.add(btnSoma);
      pnlSouth.add(btnSair);
      
      //colocar no canvas
      add(pnlCenter, BorderLayout.CENTER);
      add(pnlSouth, BorderLayout.SOUTH);
      
      
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