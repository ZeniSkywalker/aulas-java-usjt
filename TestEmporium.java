public class TestEmporium{
   public static void main(String[] args){
      Carrinho carrinho = new Carrinho();
      carrinho.colocarProdutoNoCarrinho("carne", 40.50, 1.0);
      carrinho.colocarProdutoNoCarrinho("arroz", 1.43, 2.5);
      carrinho.colocarProdutoNoCarrinho("carne", 40.50, 2.0);
      carrinho.colocarProdutoNoCarrinho("feijão", 6.78, 50.0);
      carrinho.colocarProdutoNoCarrinho("carne", 40.50, 3.0);
      carrinho.colocarProdutoNoCarrinho("carne", 40.50, 4.0);
      carrinho.colocarProdutoNoCarrinho("carne", 40.50, 5.0);
      carrinho.colocarProdutoNoCarrinho("carne", 40.50, 6.0);
      carrinho.colocarProdutoNoCarrinho("laranja", 4.00, 2.0);
      carrinho.colocarProdutoNoCarrinho("carne", 40.50, 7.0);
            
      Caixa caixa = new Caixa("Kalr E. Furr", carrinho, "084.218.456-98");
      caixa.imprimirCompra();
      carrinho.removerProdutoDoCarrinho("carne");
      caixa.imprimirCompra();
      carrinho.removerVariosProdutosDoCarrinhoMaisEficiente("carne");
      caixa.imprimirCompra(); 
   }
}