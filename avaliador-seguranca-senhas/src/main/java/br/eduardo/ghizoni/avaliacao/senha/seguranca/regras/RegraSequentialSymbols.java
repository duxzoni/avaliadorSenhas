package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class RegraSequentialSymbols extends RegraSequential {

	@Override
	protected String getSequence() {
		return ")!@#$%^&*()";
	}

}
