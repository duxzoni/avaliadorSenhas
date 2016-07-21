package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public abstract class RegraPorCaractere implements Regra {
	
	protected  static final char CEDILHA_MINUSCULO = 'ç';
	protected static final char CEDILHA_MAIUSCULO = 'Ç';
	
	protected Integer pontuacao = 0;
	protected String senha;
	
	public RegraPorCaractere() {
	}
	
	public abstract void validaCharacter(int index);

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
