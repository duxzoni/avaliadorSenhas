package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public abstract class RegraPorCharacter {
	protected Integer pontuacao = 0;
	protected String senha;
	
	public RegraPorCharacter() {
	}
	
	public abstract void validaCharacter(int index);
	
	public abstract int score();

	public void setSenha(String senha) {
		this.senha = senha;
		
	}
	
}
