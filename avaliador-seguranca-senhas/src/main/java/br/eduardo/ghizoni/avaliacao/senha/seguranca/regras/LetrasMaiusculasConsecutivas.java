package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class LetrasMaiusculasConsecutivas extends RegraPorCaractere {
	
	private boolean lastCharIsUpperCase = false;
	
	@Override
	public void validaCharacter(int index) {
		char charAt = senha.charAt(index);
		boolean isUpperCase = charAt != CEDILHA_MAIUSCULO && Character.isUpperCase(charAt);
		if( lastCharIsUpperCase && isUpperCase )
			pontuacao++;
		
		lastCharIsUpperCase = isUpperCase;
	}

	public int score() {
		return pontuacao * -2 ;
	}


}
