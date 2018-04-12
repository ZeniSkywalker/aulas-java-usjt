 // Esta classe modela um produto a ser comprado no "emporium".

public class Produto
{
    // atributos: variáveis que armazenam os dados de um objeto, após este
    // ser instanciado.
    private String nome;
    private double precoUnitario; // em reais
    private double quantidade; // em quilogramas
    
    // método construtor: usado para inicializar os atributos,
    // quando um objeto produto é criado (instanciado). Notar que o construtor
    // faz chamada interna de dois métodos modificadores.
    public Produto(String nome, double precoUnitario, double quantidade)
    {
        this.nome = nome;
        setPrecoUnitario(precoUnitario);
        setQuantidade(quantidade);
    }
    
    // métodos de acesso: usados para retornar o valor de um atributo.
    public String getNome()
    {
        return nome;
    }
    
    public double getPrecoUnitario()
    {
        return precoUnitario;
    }
    
    public double getQuantidade()
    {
        return quantidade;
    }
    
    // métodos modificadores: usados para alterar o valor de um atributo,
    // depois que o objeto foi criado (instanciado).
    public void setNome(String novoNome)
    {
        nome = novoNome;
    }
    
    public void setPrecoUnitario(double novoPreco)
    {
        if(novoPreco <= 0)
        {
            precoUnitario = 1.0;
        }
        else 
        {
            precoUnitario = novoPreco;
        }
            
    }
    
    public void setQuantidade(double novaQuantidade)
    {
        if(quantidade < 0)
        {
            quantidade = 1.0;        
        }
        else
        {
            quantidade = novaQuantidade;
        }
    }
    
    // outros métodos
    
    // O método abaixo retorna uma String, que contém os valores dos
    // atributos do objeto, mais a quantidade vezes o preço unitário.
    public String gastoComProduto()
    {
        return String.format("%16s R$%14.2f %10.2f R$%14.2f\n",
         nome, precoUnitario, quantidade, quantidade*precoUnitario);
             /*    "Produto: " + nome + "   " + 
                "Preco Unitario: R$ " + precoUnitario + " / kg   " +
                "Quantidade: " + quantidade + " kg   " +
                "Total: R$ " + quantidade*precoUnitario + "\n";*/
    }
    
    
}
