package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import org.junit.Assert;
import org.junit.Test;

public class ComplexidadeTest {

	@Test
	public void muitoCurta() {
		Complexidade porPontuacao = Complexidade.porPontuacao(0);
		Assert.assertEquals("Complexidade", "Muito curta", porPontuacao.getMensagem());
	}
	
	@Test
	public void muitoFraca() {
		Complexidade porPontuacao = Complexidade.porPontuacao(1);
		Assert.assertEquals("Complexidade", "Muito fraca", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(19);
		Assert.assertEquals("Complexidade", "Muito fraca", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(10);
		Assert.assertEquals("Complexidade", "Muito fraca", porPontuacao.getMensagem());
	}
	
	@Test
	public void fraca() {
		Complexidade porPontuacao = Complexidade.porPontuacao(20);
		Assert.assertEquals("Complexidade", "Fraca", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(39);
		Assert.assertEquals("Complexidade", "Fraca", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(30);
		Assert.assertEquals("Complexidade", "Fraca", porPontuacao.getMensagem());
	}
	
	@Test
	public void boa() {
		Complexidade porPontuacao = Complexidade.porPontuacao(40);
		Assert.assertEquals("Complexidade", "Boa", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(60);
		Assert.assertEquals("Complexidade", "Boa", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(50);
		Assert.assertEquals("Complexidade", "Boa", porPontuacao.getMensagem());
	}
	
	@Test
	public void forte() {
		Complexidade porPontuacao = Complexidade.porPontuacao(61);
		Assert.assertEquals("Complexidade", "Forte", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(80);
		Assert.assertEquals("Complexidade", "Forte", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(70);
		Assert.assertEquals("Complexidade", "Forte", porPontuacao.getMensagem());
	}
	
	@Test
	public void muitoForte() {
		Complexidade porPontuacao = Complexidade.porPontuacao(81);
		Assert.assertEquals("Complexidade", "Muito forte", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(100);
		Assert.assertEquals("Complexidade", "Muito forte", porPontuacao.getMensagem());
		
		porPontuacao = Complexidade.porPontuacao(90);
		Assert.assertEquals("Complexidade", "Muito forte", porPontuacao.getMensagem());
	}

}

