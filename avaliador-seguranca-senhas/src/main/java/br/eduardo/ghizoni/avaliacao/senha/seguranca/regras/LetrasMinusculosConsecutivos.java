package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class LetrasMinusculosConsecutivos extends RegraPorCaractere {
	
	private boolean lastCharIsLowerCase = false;
	
	@Override
	public void validaCharacter(int index) {
		char charAt = senha.charAt(index);
		boolean isLowerCase = charAt != CEDILHA_MINUSCULO && Character.isLowerCase(charAt);
		if( lastCharIsLowerCase && isLowerCase )
			pontuacao++;
		
		lastCharIsLowerCase = isLowerCase;
	}

	public int score() {
		return pontuacao * -2 ;
	}




}
