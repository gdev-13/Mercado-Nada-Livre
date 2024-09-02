import java.util.LinkedList;
import java.util.List;

public class Categoria {

	public String nome;
	private List<Produto> produtos;
	public int posicao;

	public Categoria(String nome) {
		this.nome = nome;
		this.produtos = new LinkedList<Produto>();
		this.posicao = 0;
    }

    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
    	this.nome = nome;
    }
    
    public void setPos(int pos) {
    	this.posicao = pos;
    }
    
    public int getPos() {
    	return this.posicao;
    }

    public boolean adicionaProduto(Produto produto) {
    	return this.produtos.add(produto); 
    }
    
    public Produto buscaProdutoPos (int posicao) {
    	return this.produtos.get(posicao-1);
    }
    
	public Produto buscaProduto (String nome) {
		for (Produto produtoBuscado : this.produtos) {
			if (produtoBuscado.equals(nome)) {
				return produtoBuscado;
			}
		} 
		return null;
	} 

    public String toString() {
  
        String saida = this.nome.toUpperCase() + "\n";
        for (int i = 0; i < this.produtos.size(); i++) {
        	saida += (i+1) + ". " + this.produtos.get(i).getNome() + " " + this.produtos.get(i).getPreco() + "\n";	
        }
        return saida;
  
    }

    public List<Produto> getProdutos() {
    	return this.produtos;
    }

	public void reduzPosicao() {
		this.posicao--;
		
	}
}
