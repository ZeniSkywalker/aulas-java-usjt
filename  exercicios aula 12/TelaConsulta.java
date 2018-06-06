/*
 * Tela para consultar clientes e pedidos
 * Exemplo de uso de JComboBox e JTable
 *
 * Prof. Sergio Bonato
 
 * Comentarios propositalmente sem acentuacao
 * 
 */
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Dimension;
import javax.swing.JOptionPane;
//para tratar eventos de selecao na tabela
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TelaConsulta extends JFrame implements ActionListener, ItemListener, ListSelectionListener{
   //constantes criadas para configurar as dimensoes do JFrame e do JScrollPane
   final int LARGURA_TELA = 600;
   final int ALTURA_TELA = 300;
   final int LARGURA_SCROLL_PANE = LARGURA_TELA - 200;
   final int ALTURA_SCROLL_PANE = ALTURA_TELA - 110;
   
   private JTextField txtNome, txtFone;
   private JLabel lblNome, lblId, lblFone;
   private JButton btnVoltar;
   private Cliente cliente;
   private Connection conn;
   //clientela sera usado para criar o JComboBox
   private Integer[] clientela;
   //colunas e pedidos serao usados para criar a JTable
   private String[] colunas = {"Id", "Data", "Valor"};
   private Object[][] pedidos;
   private JComboBox<Integer> cbId;
   private JTable tabelaPedidos;
   private JPanel pnlCentro;
   private Container caixa;
   private JScrollPane rolagem;
   
   public TelaConsulta(Connection conn){
      super("Consulta de Clientes");
      txtNome = new JTextField(20);
      txtFone = new JTextField(10);
      
      //guarda a conexao do banco em uma variavel de instancia
      this.conn = conn;
      
      //carrega os id dos clientes no vetor e instancia o combobox
      clientela = carregaClientes(conn);
      cbId = new JComboBox(clientela);
      
      lblId = new JLabel("Id");
      lblNome = new JLabel("Nome");
      lblFone = new JLabel("Fone");
      
      //instancia a JTable e coloca em uma barra de rolagem
      //veja metodo no fim da classe, criado porque tem que fazer varias vezes
      instanciaJTableEScrollPane();
      
      btnVoltar = new JButton("Voltar");
      
      caixa = getContentPane();
      caixa.setLayout(new BorderLayout());
      
      JPanel pnlNorte = new JPanel(new FlowLayout());
      JPanel pnlSul = new JPanel(new FlowLayout());
      pnlCentro = new JPanel(new FlowLayout());
      
      pnlNorte.add(lblId);
      pnlNorte.add(cbId);
      pnlNorte.add(lblNome);
      pnlNorte.add(txtNome);
      pnlNorte.add(lblFone);
      pnlNorte.add(txtFone);
      pnlSul.add(btnVoltar);
            
      pnlCentro.add(rolagem);
   
      btnVoltar.addActionListener(this);
      
      cbId.addItemListener(this);
      
      caixa.add(pnlNorte, BorderLayout.NORTH);
      caixa.add(pnlSul, BorderLayout.SOUTH);
      caixa.add(pnlCentro, BorderLayout.CENTER);
      
      setSize(LARGURA_TELA, ALTURA_TELA);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
   }
   
   public void actionPerformed(ActionEvent e){
   
      if(e.getSource() == btnVoltar){
         new TelaCliente(conn);
         dispose();
      }  
   }
   
    /*
    * metodo invocado quando muda o item selecionado na combobox
    */ 
    public void itemStateChanged(ItemEvent e){
      //sempre que muda o id selecionado na combobox este evento e gerado
      if(e.getStateChange() == ItemEvent.SELECTED){
         /* 
          * para refazer a tela com novos objetos e preciso remover os anteriores;
          * entao tiramos o painel do JFrame e o scrollpane do painel; instancia
          * outro scrollpane, configura de novo o tamanho preferido para aparecer a
          * barra de rolagem, adiciona no painel e coloca o painel de novo no JFrame
          */
         caixa.remove(pnlCentro);
         pnlCentro.remove(rolagem);
         //instancia uma nova JTable e uma nova barra de rolagem, pois nao da para mudar o conteudo da antiga
         instanciaJTableEScrollPane(); 
         //coloca de volta
         pnlCentro.add(rolagem);
         caixa.add(pnlCentro, BorderLayout.CENTER);
         /* adicionar elementos torna o container invalido
          * por isso precisa revalidar
          */
         validate();
         //redesenha o container
         repaint();
      }
   }
   
    /*
    * metodo invocado quando um item da tabela e selecionado
    */
   public void valueChanged(ListSelectionEvent e){
      /* colocar dentro deste if porque o evento e disparado duas vezes e assim 
         filtra-se somente um deles */
      if(e.getValueIsAdjusting()){
         String resultado = 
            tabelaPedidos.getColumnName(0)+": "+
            tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(),0)+
            "\n"+tabelaPedidos.getColumnName(1)+": "+
            tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(),1)+
            "\n"+tabelaPedidos.getColumnName(2)+": "+
            tabelaPedidos.getValueAt(tabelaPedidos.getSelectedRow(),2);
         JOptionPane.showMessageDialog(this, resultado);
      }
   
   }
   
   public Integer[] carregaClientes(Connection conn){
      //carrega todos os clientes gravados no banco
      Vendedor vendedor = new Vendedor();
      ArrayList<Cliente> lista = vendedor.buscarClientes(conn);
      
      //instancia o vetor do tamanho do arraylist de clientes
      Integer[] saida = new Integer[lista.size()];
      Cliente cliente;
      //prenche o vetor com o id do cliente para criar a combobox
      for(int i = 0; i < lista.size(); i++){
         cliente = lista.get(i);
         saida[i] = cliente.getIdCliente();
      }
      
      return saida;
   }
     
   public String[][] carregaDados(Connection conn){
      /* 
       * getSelectedIndex retorna a posicao do vetor clientela em que esta
       * o id selecionado; getItemAt retorna o id selecionado; entao instanciamos
       * um cliente com este id, recuperamos os demais dados do banco e preenchemos
       * os campos da tela
       */
      Cliente cliente = new Cliente(cbId.getItemAt(cbId.getSelectedIndex()));
      cliente.carregar(conn);
      txtNome.setText(cliente.getNome());
      txtFone.setText(cliente.getFone());
      /* 
       * carregamos os pedidos do banco e preenchemos a matriz saida com os dados
       * de cada pedido; esta matriz sera retornada e usada para preencher a JTable
       */
      ArrayList<Pedido> lista = cliente.carregarPedidos(conn);
      //formata a data
      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      
      String[][] saida = new String[lista.size()][colunas.length];
      Pedido pedido;
      for(int i = 0; i < lista.size(); i++){
         pedido = lista.get(i);
         saida[i][0] = pedido.getId()+"";
         saida[i][1] = formatter.format(pedido.getData());
         //formata o numero com 2 casas decimais
         saida[i][2] = String.format("%.2f", pedido.getValor());
      }
      
      return saida;
   } 
   
   //metodo para centralizar a instanciacao da JTable e nao ficar repetindo codigo
   public void instanciaJTableEScrollPane(){
      //carrega a matriz de pedidos para instanciar a JTable
      pedidos = carregaDados(conn);
      tabelaPedidos = new JTable(pedidos, colunas);
      tabelaPedidos.getSelectionModel().addListSelectionListener(this);
      //coloca a JTable em um scroll pane para ter a barra de rolagem
      rolagem = new JScrollPane(tabelaPedidos);
      /*
       * fixa a dimensao do scroll pane, senao ele fica grande o bastante para
       * que a JTable sempre caiba nele e por isso a barra de rolagem nao aparece
       * nunca
      */
      rolagem.setPreferredSize(new Dimension(LARGURA_SCROLL_PANE, ALTURA_SCROLL_PANE));
   }
}