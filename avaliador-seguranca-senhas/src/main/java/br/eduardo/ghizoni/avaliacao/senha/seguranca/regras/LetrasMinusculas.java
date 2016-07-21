package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class LetrasMinusculas extends RegraPorCaractere {
	
	@Override
	public void validaCharacter(int index) {
		char charAt = senha.charAt(index);
		if (charAt != CEDILHA_MINUSCULO && Character.isLowerCase(charAt))
			pontuacao++;
	}

	public int score() {
		if (pontuacao > 0 && pontuacao < senha.length())
			return (senha.length() - pontuacao) * 2;
		return 0;
	}


}
