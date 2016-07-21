package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class RegraNumbers extends RegraPorCharacter {

	@Override
	public void validaCharacter(int index) {
		if (Character.isDigit(senha.charAt(index)))
			pontuacao++;
	}

	public int score() {
		if(pontuacao == senha.length())
			return 0;
		return pontuacao * 4;
	}


}
