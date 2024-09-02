
public class Ecommerce {

	private static final boolean Produto = false;

	private String nome;

	private Categoria[] categorias;

	private Usuario[] usuarios;

	private int posicao;

	private int posicaoUsuario;

	private String separador = System.getProperty("line.separator");

	public Ecommerce(String nome) {
		this.nome = nome;
		this.categorias = new Categoria[10];
		this.usuarios = new Usuario[100];
		this.posicao = 0;
		this.posicaoUsuario = 0;
	}

	public boolean usuarioExiste(Usuario usuario) {
		for (Usuario usuarioDaVez : this.usuarios) {
			if (usuarioDaVez != null && usuarioDaVez.equals(usuario)) {
				return true;
			}
		}
		return false;
	}

	public boolean adicionaUsuario(Usuario usuario) {
		if (!usuarioExiste(usuario)) {
			this.usuarios[this.posicaoUsuario++] = usuario;
			return true;
		}
		return false;
	}

	public boolean adicionaCategoria(Categoria cat) {
		cat.setPos(this.posicao + 1);
		if (posicao < categorias.length) {
			this.categorias[this.posicao++] = cat;
			return true;
		} else {
			return false;
		}
	}

	public Categoria buscaCategoria(int posicao) {
		for (Categoria cat : this.categorias) {
			if (cat != null && cat.getPos() == posicao) {
				return cat;
			}
		}
		return null;
	}
	
	public boolean removeCategoria(int posicao) {
		for (int i = posicao + 1; i < this.categorias.length; i++) {
			this.categorias[i-1] = this.categorias[i];
			if (this.categorias[i] != null) {
				this.categorias[i].reduzPosicao();
			}
		}
		return true;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		String retorno = this.nome + this.separador;
		for (int i = 0; i < this.posicao; i++) {
			Categoria cat = this.categorias[i];
			retorno += (i + 1) + ". " + cat.getNome() + this.separador;
		}
		return retorno;
	}

	public Produto buscaProduto(String nome) {
		for (Categoria cat : this.categorias) {
			if (cat != null) {
				for (Produto produtoBuscado : cat.getProdutos()) {
					if (produtoBuscado.getNome().equals(nome)) {
						return produtoBuscado;
					}
				}
			}
		}
		return null;
	}

	public Usuario usuarioLogin(String login, String senha) {
		for (Usuario usuarioDaVez : this.usuarios) {
			if (usuarioDaVez != null) {
				if (usuarioDaVez.getLogin().equals(login) && usuarioDaVez.getSenha().equals(senha)) {
					return usuarioDaVez;
				}
			}

		}
		return null;
	}

	public void exibeCategorias() {
		for (Categoria categoriaCada : this.categorias) {
			if (categoriaCada != null) {
				System.out.println(categoriaCada.getPos() + ". " + categoriaCada);
			}
		}
	}
}