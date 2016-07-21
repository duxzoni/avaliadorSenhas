package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class LetrasEmSequencia extends RegraSequencia {

	@Override
	protected String getSequence() {
		return "abcdefghijklmnopqrstuvwxyz";
	}

}
