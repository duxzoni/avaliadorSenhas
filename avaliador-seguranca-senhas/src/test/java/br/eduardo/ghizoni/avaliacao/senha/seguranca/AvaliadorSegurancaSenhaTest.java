package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraConsecutiveLowerCase;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraConsecutiveNumber;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraConsecutiveUpperCase;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraLettersOnly;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraLowerCase;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraMiddleNumberOrSymbol;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraNumberOfCharacters;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraNumbers;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraNumbersOnly;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraRepeatCharacters;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSequentialLetters;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSequentialNumbers;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSequentialSymbols;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSymbols;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraUpperCase;

public class AvaliadorSegurancaSenhaTest {

	@Test
	public void scoreSemSenha() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("");
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void numberOfCharactersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", RegraNumberOfCharacters.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 32, avaliadorSegurancaSenha.getPontuacao());
	}
		
	@Test
	public void upperCaseLettersScorePasswordJustWithNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", RegraUpperCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void upperCaseLettersScorePasswordWithLowerCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456aa", RegraUpperCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void upperCaseLettersScorePasswordJustWithUpperCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456AA", RegraUpperCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 12, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void upperCaseScoreJustLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("ABCDEFGH", RegraUpperCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}

	@Test
	public void lowerCaseLettersScorePasswordJustWithNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", RegraLowerCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void lowerCaseLettersScorePasswordWithLowerCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456aa", RegraLowerCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		
		Assert.assertSame("Score", 12, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void lowerCaseLettersScorePasswordJustWithUpperCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456AA", RegraLowerCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void lowwerCaseScoreJustLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("abcdefgh", RegraLowerCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void numbersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456AA", RegraNumbers.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 24, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void numbersScoreJustNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", RegraNumbers.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void symbolsScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456;/", RegraSymbols.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 12, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void middleNumberOrSymbolScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1aa6aa;/", RegraMiddleNumberOrSymbol.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 4, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void repeatCharactersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1aa2364aa", RegraRepeatCharacters.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void repeatCharactersScoreDiferentCharsRepeated() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12AAaa*%", RegraRepeatCharacters.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.getPontuacao());
	}
	

	@Test
	public void consecutiveLowerCaseScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1aa2AA4aa", RegraConsecutiveLowerCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -4, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void consecutiveUpperCaseScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1AA2aa4AA", RegraConsecutiveUpperCase.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -4, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void consecutiveNumberScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("11AAaa43A", RegraConsecutiveNumber.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -4, avaliadorSegurancaSenha.getPontuacao());
	}
	
	
	@Test
	public void lettersOnlyScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("abcdefg", RegraLettersOnly.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -7, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void lettersOnlyScorePasswordWithNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("11AAaa43A", RegraLettersOnly.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void numbersOnlyScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", RegraNumbersOnly.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -8, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void numbersOnlyScorePasswordWithLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("11AAaa43A", RegraNumbersOnly.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}

	@Test
	public void sequentialLettersScoreSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123abc4d", RegraSequentialLetters.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void sequentialLettersScoreReverseSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123cBa4d", RegraSequentialLetters.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void sequentialLettersScoreSequenceOfFour() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123abcd", RegraSequentialLetters.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -6, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void sequentialNumbersScoreSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123abc4d", RegraSequentialNumbers.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void sequentialNumbersScoreReverseSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("321abc4d", RegraSequentialNumbers.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void sequentialNumbersScoreSequenceOfFour() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1234bcd", RegraSequentialNumbers.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -6, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void sequentialSymbolsScoreSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123&*(4d", RegraSequentialSymbols.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void sequentialSymbolsScoreReverseSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123(*&4d", RegraSequentialSymbols.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.getPontuacao());
	}

	@Test
	public void sequentialSymbolsScoreSequenceOfFour() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1^&*(cd", RegraSequentialSymbols.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -6, avaliadorSegurancaSenha.getPontuacao());
	}
	@Test
	public void scoreWithAllRolesActivated() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("12AAaa*%");
		Assert.assertSame("Score", 81, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void scoreUsingMaximumSimultaneousRules() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("123EA^&*cdE");
		Assert.assertSame("Score", 100, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void retorno() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("123EA^&*cdE");
		Response resultadoAvaliacao = avaliadorSegurancaSenha.getResultadoAvaliacao();
		Assert.assertSame("Score", 100, resultadoAvaliacao.getPontuacao());
		Assert.assertEquals("Complexidade", "Muito forte", resultadoAvaliacao.getComplexidade());
	}
}
