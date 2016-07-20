package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public abstract class RegraPorString implements Regra {
	protected Integer pontuacao = 0;
	protected String senha;
	
	public RegraPorString() {
	}
	
	public abstract void validaSenha();

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int score() {
		return pontuacao;
	}
	
}
