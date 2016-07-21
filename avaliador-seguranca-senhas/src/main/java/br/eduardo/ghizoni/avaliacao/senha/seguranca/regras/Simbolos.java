package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class Simbolos extends RegraPorCaractere {

	@Override
	public void validaCharacter(int index) {
		char charAt = senha.charAt(index);
		if (!Character.isLetterOrDigit(charAt) || charAt == CEDILHA_MINUSCULO || charAt == CEDILHA_MAIUSCULO  )
			pontuacao++;
	}

	public int score() {
		return pontuacao * 6;
	}


}
