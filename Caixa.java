// Esta classe modela o caixa do "emporium". Ela deve receber o nome do
// cliente e a lista de produtos (conteúdo do "carrinho").

public class Caixa
{
   // atributos: variáveis que armazenam os dados de um objeto, após este
   // ser instanciado.
   private Cliente cliente;
   private Carrinho carrinho;
   
   // método construtor: usado para inicializar os atributos,
   // quando um objeto cliente é criado (instanciado). Notar que o construtor
   // faz chamada interna de dois métodos modificadores.
   public Caixa(String nomeCliente, Carrinho novoCarrinho, String cpf)
   {
      cliente = new Cliente(nomeCliente, cpf);
      carrinho = novoCarrinho;
   }

   // outros métodos
   
   /*
    * O método abaixo imprime os dados do cliente e a lista de 
    * compras (conteúdo do "carrinho"). O nome do cliente (retornado pelo
    * método getNome() ) e a lista de produtos comprados pelo cliente 
    * (retornados pelo método listaDeProdutos() ) são concatenados em uma 
    * String. Em seguida, o conteúdo da String é impresso.
    */
   
   public void imprimirCompra()
   {
      String saida = "";
      saida += "Cliente: " + cliente.getNome() + "\tCpf: " + cliente.getCpf() + "\n\n" +
         String.format("%22s %16s %21s\n\n",
         "**********************", "Lista de Compras",
         "*********************") + carrinho.listaDeProdutos();
      
      System.out.println(saida);
   }
}
