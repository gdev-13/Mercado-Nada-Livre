
public class Endereco {
	
	private String numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	public int posicao;
	
	public Endereco(String numero, String cep, String bairro, String cidade, String estado, String pais) {
		this.setNumero(numero);
		this.setCep(cep);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setPais(pais);
		this.posicao = 0;
	}
	
	public int getPosi() {
		return this.posicao;
	}
	
	public void setPosi(int posi) {
		this.posicao = posi;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String toString() {
		return this.getCep() + ", " + this.getNumero() + ", " + this.getBairro() + "\n" + this.getCidade() + "-" + this.getEstado() + ", " + this.getPais() + "\n";
	}
}
