package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class LetrasApenas extends RegraPorString{

	@Override
	public void validaSenha() {
		if (senha.matches("[a-zA-Z]+"))
			pontuacao = senha.length() * (-1);
	}


}
