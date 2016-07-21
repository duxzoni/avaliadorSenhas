package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class NumerosConsecutivos extends RegraPorCaractere {
	
	private boolean lastCharIsDigit = false;
	
	@Override
	public void validaCharacter(int index) {
		boolean isDigit = Character.isDigit(senha.charAt(index));
		if(lastCharIsDigit && isDigit )
			pontuacao++;
		
		lastCharIsDigit = isDigit;
	}

	public int score() {
		return pontuacao * -2 ;
	}

}
