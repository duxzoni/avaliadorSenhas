package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class NumerosApenas extends RegraPorString{

	@Override
	public void validaSenha() {
		if (senha.matches("[0-9]+"))
			pontuacao = senha.length() * (-1);
	}

}
