package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class RegraNumberOfCharacters extends RegraPorString{

	private static final int MULTIPLICADOR_LENGTH = 4;

	@Override
	public void validaSenha() {
		pontuacao = senha.length() * MULTIPLICADOR_LENGTH ;
	}
}
