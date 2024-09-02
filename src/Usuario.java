import java.util.LinkedList;
import java.util.List;

public class Usuario {
	
	private Carrinho carrinho;
	
	private String login;
	
	private String senha;
	
	private String nome;
	
	private List<Endereco> endereco;
	
	public Usuario(String login, String senha, String nome) {
		this.setLogin(login);
		this.setSenha(senha);
		this.setNome(nome);
		this.endereco = new LinkedList<Endereco>();
		this.carrinho = new Carrinho();
	}

	public String getLogin() {
		return login;
	}
	
    public String toString() {
    	  
        String saida = "";
        for (int i = 0; i < this.endereco.size(); i++) {
        	saida += (i+1) + ". " + this.endereco.get(i).getNumero() + " " + this.endereco.get(i).getCep() + "\n";	
        }
        return saida;
  
    }


	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public boolean equals(Usuario outroUsuario) {
		return this.login.equalsIgnoreCase(outroUsuario.getLogin());
	}
	
	public boolean adicionaEndereco(Endereco endereco) {
		return this.endereco.add((Endereco) endereco);
	}
	
	public List<Endereco> getEndereco() {
		return endereco;
	}
	
	public Carrinho getCarrinho() {
		return carrinho;
	}
	
	public String exibeEnderecos() {
		System.out.println("\n-=-=-=-=-=-=-=- Endereços -=-=-=-=-=-=-=-");
	    String saida = "";
	    for (int i = 0; i < this.endereco.size(); i++) {
	    	saida += "\n" + (i+1) + ". " + this.endereco.get(i).getCep() + ", " + this.endereco.get(i).getNumero() + ", " + this.endereco.get(i).getBairro() + "\n" + this.endereco.get(i).getCidade() + "-" + this.endereco.get(i).getEstado()+ ", " + this.endereco.get(i).getPais() + "\n";	
	    }
	    return saida;
	  
	}
	
	public Endereco buscaEndereco (int posicao) {
		return this.endereco.get(posicao-1);
	}
}
