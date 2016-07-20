package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class RegraLowerCase extends RegraPorCharacter {

	@Override
	public void validaCharacter(int index) {
		if (Character.isLowerCase(senha.charAt(index)))
			pontuacao++;
	}

	public int score() {
		if (pontuacao > 0)
			return (senha.length() - pontuacao) * 2;
		return 0;
	}


}
