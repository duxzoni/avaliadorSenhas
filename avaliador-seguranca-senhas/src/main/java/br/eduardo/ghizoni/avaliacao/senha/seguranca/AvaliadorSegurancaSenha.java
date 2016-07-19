package br.eduardo.ghizoni.avaliacao.senha.seguranca;

public class AvaliadorSegurancaSenha {

	private static final int _4 = 4;
	private Integer pontuacao = 0;
	
	public void calculaSegurancaDaSenha(String senha){
		
		numberOfCharacters(senha); //+(n*4)
//		uppercaseLetters(senha);	//+((len-n)*2)
//		lowercaseLetters(senha); //+((len-n)*2)	
//		numbers(senha); //+(n*4)	
//		symbols(senha); //+(n*6)	
//		middleNumbersOrSymbols(senha); //+(n*2)	
//		requirements(senha); //+(n*2)
		
	}

	protected AvaliadorSegurancaSenha numberOfCharacters(String senha) {
		pontuacao = senha.length() * _4;
		return this;
	}

	public int getPontuacao() {
		// TODO Auto-generated method stub
		return pontuacao;
	}
	
}
