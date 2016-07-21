package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class Numeros extends RegraPorCaractere {

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
