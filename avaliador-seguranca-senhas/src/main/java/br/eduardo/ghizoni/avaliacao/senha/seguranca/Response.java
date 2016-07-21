package br.eduardo.ghizoni.avaliacao.senha.seguranca;

public class Response {
	private String complexidade;
	private int pontuacao;
	private String cor;
	
	public String getComplexidade() {
		return complexidade;
	}
	
	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}

	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
