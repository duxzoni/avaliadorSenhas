package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import org.junit.Assert;
import org.junit.Test;

import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.CaracteresRepetidos;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.LetrasApenas;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.LetrasEmSequencia;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.LetrasMaiusculas;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.LetrasMaiusculasConsecutivas;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.LetrasMinusculas;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.LetrasMinusculosConsecutivos;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.NumeroDeCaracteres;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.Numeros;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.NumerosApenas;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.NumerosConsecutivos;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.NumerosEmSequencia;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.NumerosOuSimbolosNoMeio;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.Simbolos;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.SimbolosEmSequencia;

public class AvaliadorSegurancaSenhaTest {

	@Test
	public void scoreSemSenha() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("");
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void numberOfCharactersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", NumeroDeCaracteres.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 32, avaliadorSegurancaSenha.pontuacao);
	}
		
	@Test
	public void upperCaseLettersScorePasswordJustWithNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", LetrasMaiusculas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void upperCaseLettersScorePasswordWithLowerCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456aa", LetrasMaiusculas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void upperCaseLettersScorePasswordJustWithUpperCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456AA", LetrasMaiusculas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 12, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void upperCaseScoreJustLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("ABCDEFGH", LetrasMaiusculas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}

	@Test
	public void lowerCaseLettersScorePasswordJustWithNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", LetrasMinusculas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void lowerCaseLettersScorePasswordWithLowerCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456aa", LetrasMinusculas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		
		Assert.assertSame("Score", 12, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void lowerCaseLettersScorePasswordJustWithUpperCaseLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456AA", LetrasMinusculas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void lowwerCaseScoreJustLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("abcdefgh", LetrasMinusculas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void numbersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456AA", Numeros.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 24, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void numbersScoreJustNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", Numeros.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void symbolsScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123456;/", Simbolos.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 12, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void middleNumberOrSymbolScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1aa6aa;/", NumerosOuSimbolosNoMeio.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 4, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void repeatCharactersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1aa2364aa", CaracteresRepetidos.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void repeatCharactersScoreDiferentCharsRepeated() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12AAaa*%", CaracteresRepetidos.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.pontuacao);
	}
	

	@Test
	public void consecutiveLowerCaseScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1aa2AA4aa", LetrasMinusculosConsecutivos.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -4, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void consecutiveUpperCaseScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1AA2aa4AA", LetrasMaiusculasConsecutivas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -4, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void consecutiveNumberScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("11AAaa43A", NumerosConsecutivos.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -4, avaliadorSegurancaSenha.pontuacao);
	}
	
	
	@Test
	public void lettersOnlyScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("abcdefg", LetrasApenas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -7, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void lettersOnlyScorePasswordWithNumbers() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("11AAaa43A", LetrasApenas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void numbersOnlyScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("12345678", NumerosApenas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -8, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void numbersOnlyScorePasswordWithLetters() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("11AAaa43A", NumerosApenas.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", 0, avaliadorSegurancaSenha.pontuacao);
	}

	@Test
	public void sequentialLettersScoreSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123abc4d", LetrasEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void sequentialLettersScoreReverseSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123cBa4d", LetrasEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void sequentialLettersScoreSequenceOfFour() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123abcd", LetrasEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -6, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void sequentialNumbersScoreSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123abc4d", NumerosEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void sequentialNumbersScoreReverseSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("321abc4d", NumerosEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void sequentialNumbersScoreSequenceOfFour() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1234bcd", NumerosEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -6, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void sequentialSymbolsScoreSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123&*(4d", SimbolosEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void sequentialSymbolsScoreReverseSequenceOfThree() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("123(*&4d", SimbolosEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -3, avaliadorSegurancaSenha.pontuacao);
	}

	@Test
	public void sequentialSymbolsScoreSequenceOfFour() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.inicializa("1^&*(cd", SimbolosEmSequencia.class);
		avaliadorSegurancaSenha.calculaSegurancaDaSenha();
		
		Assert.assertSame("Score", -6, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void scoreWithAllRolesActivated() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("12AAaa*%");
		Assert.assertSame("Score", 81, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void scoreUsingMaximumSimultaneousRules() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("123EA^&*cdE");
		Assert.assertSame("Score", 110, avaliadorSegurancaSenha.pontuacao);
	}
	
	@Test
	public void scoreNeverGratterThanAHundred() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("123EA^&*cdE");
		Assert.assertSame("Score", 110, avaliadorSegurancaSenha.pontuacao);
		Assert.assertSame("Limited Score", 100, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void scoreNeverNegative() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("abcdefghij");
		Assert.assertSame("Score", -12, avaliadorSegurancaSenha.pontuacao);
		Assert.assertSame("Limited Score", 0, avaliadorSegurancaSenha.getPontuacao());
	}
	
	@Test
	public void retorno() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("123EA^&*cdE");
		Response resultadoAvaliacao = avaliadorSegurancaSenha.getResultadoAvaliacao();
		Assert.assertSame("Score", 100, resultadoAvaliacao.getPontuacao());
		Assert.assertEquals("Complexidade", "Muito forte", resultadoAvaliacao.getComplexidade());
	}
	
	@Test
	public void senhaComCCedilhaMinusculo() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("çlkjhgf");
		Response resultadoAvaliacao = avaliadorSegurancaSenha.getResultadoAvaliacao();
		Assert.assertSame("Score", 20, resultadoAvaliacao.getPontuacao());
		Assert.assertEquals("Complexidade", "Fraca", resultadoAvaliacao.getComplexidade());
	}
	
	@Test
	public void senhaComCCedilhaMaiusculo() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("ÇLKJHGF");
		Response resultadoAvaliacao = avaliadorSegurancaSenha.getResultadoAvaliacao();
		Assert.assertSame("Score", 20, resultadoAvaliacao.getPontuacao());
		Assert.assertEquals("Complexidade", "Fraca", resultadoAvaliacao.getComplexidade());
	}
	
	@Test
	public void senhaComCCedilhaNoMeio() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("WYÇçXZ");
		Response resultadoAvaliacao = avaliadorSegurancaSenha.getResultadoAvaliacao();
		Assert.assertSame("Score", 40, resultadoAvaliacao.getPontuacao());
		Assert.assertEquals("Complexidade", "Boa", resultadoAvaliacao.getComplexidade());
	}
	
	@Test
	public void senhaComSimbolosENumerosEmSequencia() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.calculaSegurancaDaSenha("!@#$%67890");
		Response resultadoAvaliacao = avaliadorSegurancaSenha.getResultadoAvaliacao();
		Assert.assertSame("Score", 83, resultadoAvaliacao.getPontuacao());
		Assert.assertEquals("Complexidade", "Muito forte", resultadoAvaliacao.getComplexidade());
	}
	
	
}
