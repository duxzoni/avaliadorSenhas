package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public abstract class RegraPorCharacter implements Regra {
	protected Integer pontuacao = 0;
	protected String senha;
	
	public RegraPorCharacter() {
	}
	
	public abstract void validaCharacter(int index);

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
