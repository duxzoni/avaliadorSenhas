package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class NumerosOuSimbolosNoMeio extends RegraPorCaractere {

	@Override
	public void validaCharacter(int index) {
		char charAt = senha.charAt(index);
		boolean isCedilha = charAt == CEDILHA_MAIUSCULO || charAt == CEDILHA_MINUSCULO;
		if (index > 0 && index < (senha.length() - 1) && (!Character.isLetter(charAt) || isCedilha))
			pontuacao++;
	}

	public int score() {
		return pontuacao * 2;
	}

}
