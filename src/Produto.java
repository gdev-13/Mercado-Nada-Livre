import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

public class Produto {
	
	private float preco;
	private String nome;
	private String descricao;
	private int quantidade;
	
	public Produto(String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
	}
		
	public String getNome() {
		return nome;
    }
	
	public String getPreco() {
		DecimalFormat deci = new DecimalFormat("0.00");
		return deci.format(preco);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public float getPrecoF() {
		return preco;
	}
	
	public String toString() {
		return this.getNome() + " " + this.getPreco();
	}
}
