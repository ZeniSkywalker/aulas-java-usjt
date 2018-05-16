import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela extends JFrame implements ActionListener {
   private JTextField fieldTxt;
   private JLabel labelTxt;
   private JButton btnMostrar, btnLimpar, btnSair;

   public Tela() {
      super("Texto");
      
      JPanel tabela = new JPanel(new GridLayout(3, 1));
      
      JPanel linha1 = new JPanel(new FlowLayout());
      labelTxt = new JLabel("Texto");
      linha1.add(labelTxt);
      
      JPanel linha2 = new JPanel(new FlowLayout());
      fieldTxt = new JTextField(40);
      linha2.add(fieldTxt);
      
      JPanel linha3 = new JPanel(new FlowLayout());
      btnMostrar = new JButton("Mostrar");
      btnLimpar = new JButton("Limpar");
      btnSair = new JButton("Sair");
      linha3.add(btnMostrar);
      linha3.add(btnLimpar);
      linha3.add(btnSair);
      
      Container caixa = getContentPane();
      caixa.setLayout(new BorderLayout());
      caixa.add(linha1, BorderLayout.NORTH);
      caixa.add(linha2, BorderLayout.CENTER);
      caixa.add(linha3, BorderLayout.SOUTH);
      
      btnMostrar.addActionListener(this);
      btnLimpar.addActionListener(this);
      btnSair.addActionListener(this);
      
      setSize(500, 150);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   @Override
   public void actionPerformed(ActionEvent e){
      if (e.getSource() == btnMostrar){
         JOptionPane.showMessageDialog(null,""+fieldTxt.getText());
      }
      else if (e.getSource() == btnLimpar){
         fieldTxt.setText("");
      }
      else{
      System.exit(0);
      }
   }
}
