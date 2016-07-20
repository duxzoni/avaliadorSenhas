package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class RegraSequentialLetters extends RegraSequential {

	@Override
	protected String getSequence() {
		return "abcdefghijklmnopqrstuvwxyz";
	}

}
