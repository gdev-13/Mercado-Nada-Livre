
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class Carrinho {
	
	private List<Produto> produtos;
	
	public Carrinho() {
		this.produtos = new LinkedList<Produto>();
	}
	
    public List<Produto> getProdutos() {
    	return this.produtos;
    }
    
    public String toString() {
    	String carrinho = "";
    	float total = 0;
    	for (Produto produto : this.produtos) {    		
    		total += produto.getPrecoF();
    		carrinho += produto.getNome() + " " + produto.getPreco() + "\n";
    	}
		DecimalFormat deci = new DecimalFormat("0.00");
    	carrinho += "Total: " + deci.format(total);
    	return carrinho;
    }
    
    public boolean adicionaProduto(Produto produto) {
    	return this.produtos.add(produto); 
	}

}
