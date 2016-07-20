package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import org.junit.Assert;
import org.junit.Test;

import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraLowerCase;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraMiddleNumberOrSymbol;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraNumbers;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraRepeatCharacters;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSymbols;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraUpperCase;

public class AvaliadorSegurancaSenhaTest {

	@Test
	public void scoreSemSenha() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		Assert.assertEquals("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void numberOfCharactersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("12345678");
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 32, avaliadorSegurancaSenha.getPontuacao());
	}
		
	@Test
	public void upperCaseLettersScorePasswordJustWithNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("12345678", RegraUpperCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 32, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void upperCaseLettersScorePasswordWithLowerCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("123456aa", RegraUpperCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 32, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void upperCaseLettersScorePasswordJustWithUpperCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("123456AA", RegraUpperCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 44, avaliadorSegurancaSenha.getPontuacao());
	}

	@Test
	public void lowerCaseLettersScorePasswordJustWithNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("12345678", RegraLowerCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 32, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void lowerCaseLettersScorePasswordWithLowerCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("123456aa", RegraLowerCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 44, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void lowerCaseLettersScorePasswordJustWithUpperCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("123456AA", RegraLowerCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 32, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void numbersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("123456AA", RegraNumbers.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 56, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void symbolsScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("123456;/", RegraSymbols.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 44, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void middleNumberOrSymbolScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("1aa6aa;/", RegraMiddleNumberOrSymbol.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 36, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void repeatCharactersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha("1aa2364aa", RegraRepeatCharacters.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertEquals("Score", 33, avaliadorSegurancaSenha.getPontuacao());
	}
	
	
	@Test
	public void scoreComTodasAsRegras() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("12AAaa*%");
		Assert.assertEquals("Score", 90, avaliadorSegurancaSenha.getPontuacao());
	}
}
