package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class LetrasMaiusculas extends RegraPorCaractere {

	@Override
	public void validaCharacter(int index) {
		if (Character.isUpperCase(senha.charAt(index)))
			pontuacao++;
	}

	public int score() {
		if (pontuacao > 0 && pontuacao < senha.length())
			return (senha.length() - pontuacao) * 2;
		return 0;
	}


}
