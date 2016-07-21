package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class LetrasMaiusculasConsecutivas extends RegraPorCaractere {
	
	private boolean lastCharIsUpperCase = false;
	
	@Override
	public void validaCharacter(int index) {
		boolean isUpperCase = Character.isUpperCase(senha.charAt(index));
		if(lastCharIsUpperCase && isUpperCase )
			pontuacao++;
		
		lastCharIsUpperCase = isUpperCase;
	}

	public int score() {
		return pontuacao * -2 ;
	}


}
