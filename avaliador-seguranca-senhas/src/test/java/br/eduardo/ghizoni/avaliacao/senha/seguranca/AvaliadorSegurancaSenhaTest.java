package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import org.junit.Assert;
import org.junit.Test;

public class AvaliadorSegurancaSenhaTest {

	@Test
	public void numberOfCharactersScore() {
		AvaliadorSegurancaSenha avaliadorSegurancaSenha = new AvaliadorSegurancaSenha();
		avaliadorSegurancaSenha.numberOfCharacters("1234567");
		
		Assert.assertEquals("Score", 28, avaliadorSegurancaSenha.getPontuacao());
	}

}
