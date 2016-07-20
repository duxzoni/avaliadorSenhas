package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class RegraConsecutiveLowerCase extends RegraPorCharacter {
	
	private boolean lastCharIsLowerCase = false;
	
	@Override
	public void validaCharacter(int index) {
		boolean isLowerCase = Character.isLowerCase(senha.charAt(index));
		if(lastCharIsLowerCase && isLowerCase )
			pontuacao++;
		
		lastCharIsLowerCase = isLowerCase;
	}

	public int score() {
		return pontuacao * -2 ;
	}




}
