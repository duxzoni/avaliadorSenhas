package br.eduardo.ghizoni.avaliacao.senha.seguranca;

public class Response {
	private String complexidade;
	private int pontuacao;
	
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
}
