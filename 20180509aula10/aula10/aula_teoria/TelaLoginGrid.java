import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class TelaLoginBorder extends JFrame implements ActionListener{

   private JTextField txtNome, txtSenha;
   private JLabel lblNome, lblSenha;
   private JButton btnOk, btnCancela;
   
   public TelaLoginGrid(){
      super("Login");
      txtNome = new JTextField(15);
      txtSenha = new JTextField(15);
      lblNome = new JLabel("Nome");
      lblSenha = new JLabel("Senha");
      btnOk = new JButton("Ok");
      btnCancela = new JButton("Cancela");
      
      Container caixa = getContentPane();
      caixa.setLayout(new GridLayout(3,2));
      
      
      add(lblNome);
      add(txtNome);
      add(lblSenha);
      add(txtSenha);
      add(btnOk);
      add(btnCancela);
      
      btnOk.addActionListener(this);
      btnCancela.addActionListener(this);
      
      setVisible(true);
      //setResizable(false);
      setSize(259,130);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == btnCancela){
         System.exit(0);
      } else if (ae.getSource() == btnOk){
         String usuario = "admin";
         String senha = "123";
         
         String usuarioDigitado = txtNome.getText();
         String senhaDigitada = txtSenha.getText();
         
         if(usuario.equals(usuarioDigitado) &&
            senha.equals(senhaDigitada)){
            JOptionPane.showMessageDialog(this, "Seja bem vindo");
            System.exit(0);
         } else {
            JOptionPane.showMessageDialog(this, "Usuário/senha inválidos.\nTente estes que acabei de escrever para você, amigo.",
               "Login", JOptionPane.ERROR_MESSAGE);
            txtNome.setText("admin");
            txtSenha.setText("123");
               
         }
      }
   
   }

   public static void main(String[] args){
      new TelaLoginBorder();
   }
}