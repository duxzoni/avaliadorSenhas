package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class RegraNumbers extends RegraPorCharacter {

	@Override
	public void validaCharacter(int index) {
		if (Character.isDigit(senha.charAt(index)))
			pontuacao++;
	}

	@Override
	public int score() {
		return pontuacao * 4;
	}


}
