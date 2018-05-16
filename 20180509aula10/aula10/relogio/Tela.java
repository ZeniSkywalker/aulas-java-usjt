import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Tela extends JFrame implements ActionListener
{
   
   private JLabel mostrador;
   private JButton btTicTac, btHora, btMinuto;
   private Relogio relogio;
 
       
   public Tela()
   {
      super("Relogio");
      relogio = new Relogio();
        
      mostrador = new JLabel(relogio.mostra());
      mostrador.setHorizontalAlignment(SwingConstants.CENTER);
      mostrador.setFont( new Font( "Arial", Font.BOLD, 72 ) );
      
      btTicTac = new JButton("TicTac");
      btHora = new JButton("Alterar Hora");
      btMinuto = new JButton("Alterar Minuto");
      
      Container caixa = getContentPane();
      
      caixa.setLayout(new BorderLayout());
      
      caixa.add(mostrador, BorderLayout.CENTER);
      caixa.add(btTicTac, BorderLayout.SOUTH);
      caixa.add(btHora, BorderLayout.WEST);
      caixa.add(btMinuto, BorderLayout.EAST);
      
      btTicTac.addActionListener(this);
      btHora.addActionListener(this);
      btMinuto.addActionListener(this);
     
      setSize(450,200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);	 
   }
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == btTicTac)
      {
         relogio.ticTac();
         mostrador.setText(relogio.mostra());   
      }
      else if (e.getSource() == btHora)
      {
         String hora = JOptionPane.showInputDialog(this, "Nova hora:");
         relogio.setHora(Integer.parseInt(hora));
         mostrador.setText(relogio.mostra());   
      }
      else if (e.getSource() == btMinuto)
      {
         String minuto = JOptionPane.showInputDialog(this, "Novo minuto:");
         relogio.setMinuto(Integer.parseInt(minuto));
         mostrador.setText(relogio.mostra());   
      }
   }
   
}
