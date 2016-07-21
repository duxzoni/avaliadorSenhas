package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class NumerosOuSimbolosNoMeio extends RegraPorCaractere {

	@Override
	public void validaCharacter(int index) {
		if (index > 0 && index < (senha.length() - 1) && !Character.isLetter(senha.charAt(index)))
			pontuacao++;
	}

	public int score() {
		return pontuacao * 2;
	}

}
