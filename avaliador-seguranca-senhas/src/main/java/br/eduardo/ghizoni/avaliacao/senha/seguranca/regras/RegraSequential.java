package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

import java.awt.datatransfer.StringSelection;

public abstract class RegraSequential extends RegraPorString{

	@Override
	public void validaSenha() {
		for (int index = 0; index < getSequence().length() - 3; index++) {
			String subSequence = getSequence().substring(index, index+3).toUpperCase();
			String reverseSubSequence = new StringBuilder(subSequence).reverse().toString();
			String senhaUpperCase = senha.toUpperCase();
			if(senhaUpperCase.contains(subSequence) || senhaUpperCase.contains(reverseSubSequence))
				pontuacao++;
		}
		
		pontuacao *= -3;
	}
	
	protected abstract String getSequence();


}
