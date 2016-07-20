package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class RegraSymbols extends RegraPorCharacter {

	@Override
	public void validaCharacter(int index) {
		if (!Character.isLetterOrDigit(senha.charAt(index)))
			pontuacao++;
	}

	@Override
	public int score() {
		return pontuacao * 6;
	}


}