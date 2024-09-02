public class Vendedor extends Usuario {
	
	private Produto[] produtos;
	
	public Vendedor(String login, String senha, String nome) {
		super(login, senha, nome);
	}

	public Produto[] getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto[] produtos) {
		this.produtos = produtos;
	}

}