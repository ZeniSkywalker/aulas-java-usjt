import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener{

   private JLabel lblValorA, lblValorB, lblOperacao, lblResultado;
   private JTextField txtValorA, txtValorB, txtOperacao, txtResultado;
   private JButton btnSoma, btnSubtracao, btnMultiplicacao, btnDivisao;
   
   public Calculadora(){
   
      lblValorA = new JLabel("Valor A");
      lblValorB = new JLabel("Valor B");
      lblOperacao = new JLabel("Operação");
      lblResultado = new JLabel("Resultado");
    
      txtValorA = new JTextField(20);
      txtValorB = new JTextField(20);
      txtOperacao = new JTextField(20);
      txtResultado = new JTextField(20);
    
      btnSoma = new JButton("Soma");
      btnSubtracao = new JButton("Subtração");
      btnMultiplicacao = new JButton("Multiplicação");
      btnDivisao = new JButton("Divisão");            
    
      Container caixa = getContentPane();
      caixa.setLayout(new BorderLayout());
      JPanel pnlLinhas = new JPanel(new GridLayout(4,1));
      JPanel pnlLinha1 = new JPanel(new FlowLayout());
      pnlLinha1.add(lblValorA);
      pnlLinha1.add(txtValorA);
      JPanel pnlLinha2 = new JPanel(new FlowLayout());
      pnlLinha2.add(lblValorB);
      pnlLinha2.add(txtValorB);
      JPanel pnlLinha3 = new JPanel(new FlowLayout());
      pnlLinha3.add(lblOperacao);
      pnlLinha3.add(txtOperacao);
      JPanel pnlLinha4 = new JPanel(new FlowLayout());
      pnlLinha4.add(lblResultado);
      pnlLinha4.add(txtResultado);
      pnlLinhas.add(pnlLinha1);
      pnlLinhas.add(pnlLinha2);
      pnlLinhas.add(pnlLinha3);
      pnlLinhas.add(pnlLinha4);
      caixa.add (pnlLinhas,BorderLayout.CENTER);
      JPanel pnlSul = new JPanel(new FlowLayout());
      pnlSul.add(btnSoma);
      pnlSul.add(btnSubtracao);
      pnlSul.add(btnMultiplicacao);
      pnlSul.add(btnDivisao);
      caixa.add(pnlSul, BorderLayout.SOUTH);
     
      btnSoma.addActionListener(this); 
      btnSubtracao.addActionListener(this);
      btnMultiplicacao.addActionListener(this);
      btnDivisao.addActionListener(this); 
    
     
      setSize(468,203);
      setLocationRelativeTo(null);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
   }
   
   public void actionPerformed(ActionEvent ae){
      int valorA, valorB, resultado;
      if(ae.getSource() == btnSoma){
         valorA = Integer.parseInt(txtValorA.getText());
         valorB = Integer.parseInt(txtValorB.getText()); 
         resultado = valorA + valorB;
         txtResultado.setText(""+ resultado);
         txtOperacao.setText("Soma"); 
      }
   
   }
}