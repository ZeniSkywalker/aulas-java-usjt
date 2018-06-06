import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCopia extends JFrame implements ActionListener{
   private JLabel lblOriginal, lblCopia;
   private JTextField txtOriginal, txtCopia;
   private JButton btnLimpar, btnCopiar, btnSair;
   
   public TelaCopia(){
      super("Cópia");
      
      lblOriginal = new JLabel("Original:");
      lblCopia = new JLabel("Cópia");
      txtOriginal = new JTextField(20);
      txtCopia = new JTextField(20);
      btnLimpar = new JButton("Limpar");
      btnCopiar = new JButton("Copiar e Colar");
      btnSair = new JButton("Sair");
      
      Container caixa = getContentPane();
      caixa.setLayout(new FlowLayout());
      
      add(lblOriginal);
      add(txtOriginal);
      add(lblCopia);
      add(txtCopia);
      add(btnLimpar);
      add(btnCopiar);
      add(btnSair);
      
      btnLimpar.addActionListener(this);
      btnCopiar.addActionListener(this);
      btnSair.addActionListener(this);
      
      
      setSize(340,133);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   }
   
   @Override
   public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == btnSair){
         System.exit(0);
      } else if(ae.getSource() == btnLimpar){
         txtOriginal.setText("");
         txtCopia.setText("");
      } else if(ae.getSource() == btnCopiar){
         String texto = txtOriginal.getText();
         txtCopia.setText(texto);
      }
   }

}