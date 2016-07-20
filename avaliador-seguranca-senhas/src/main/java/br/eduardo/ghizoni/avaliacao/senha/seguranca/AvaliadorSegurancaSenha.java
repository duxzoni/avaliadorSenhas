package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import java.util.ArrayList;
import java.util.List;

import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraLowerCase;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraMiddleNumberOrSymbol;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraNumbers;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraPorCharacter;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSymbols;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraUpperCase;

public class AvaliadorSegurancaSenha {

	private static final int MULTIPLICADOR_REQUERIMENTOS = 2;
	private static final int MULTIPLICADOR_LENGTH = 4;
	private Integer pontuacao = 0;
	private List<RegraPorCharacter> regrasPorCharacter = new ArrayList<RegraPorCharacter>();
	private List<RegraPorCharacter> requerimentos = new ArrayList<RegraPorCharacter>();
	private String senha = "";
	
	public AvaliadorSegurancaSenha() {
	}
	
	public AvaliadorSegurancaSenha(String senha, Class ... regras ) {
		this.senha = senha;
		inicializaRegras(regras);
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	private void inicializaRegras(Class ... regras) {
		List<Class> requerimentosObrigatorios = requerimentosObrigatorios();
		for (Class<RegraPorCharacter> classe : regras) {
			RegraPorCharacter regra;
			try {
				regra = classe.newInstance();
				regra.setSenha(senha);
				regrasPorCharacter.add(regra);
				
				if (requerimentosObrigatorios.contains(classe))
					requerimentos.add(regra);
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private List<Class> requerimentosObrigatorios(){
		ArrayList<Class> requerimentosObrigatorios = new ArrayList<Class>();
		requerimentosObrigatorios.add(RegraLowerCase.class);
		requerimentosObrigatorios.add(RegraUpperCase.class);
		requerimentosObrigatorios.add(RegraNumbers.class);
		requerimentosObrigatorios.add(RegraSymbols.class);
		
		return requerimentosObrigatorios;
		
	}
	
	public void calculaSegurancaDaSenha(String senha) {
		this.senha = senha;
		inicializaRegras(
				RegraLowerCase.class, 
				RegraUpperCase.class, 
				RegraNumbers.class, 
				RegraSymbols.class, 
				RegraMiddleNumberOrSymbol.class);
		calculaSegurancaDaSenha();
	}
	
	
	public void calculaSegurancaDaSenha() {

		pontuacao += pontuacaoNumberOfCharacters(); // +(n*4)

		for (int index = 0; index < senha.length();  index++)
			for (RegraPorCharacter regraPorCharacter : regrasPorCharacter) 
				regraPorCharacter.validaCharacter(index);
		
		for (RegraPorCharacter regraPorCharacter : regrasPorCharacter) 
			pontuacao += regraPorCharacter.score();
		
		pontuacao += pontuacaoRequirements();
	}

	private int pontuacaoRequirements() {
		int count = 0;
		if (pontuacaoNumberOfCharacters() > 0)
			count++;
			
		for (RegraPorCharacter regra: requerimentos) 
			if (regra.score() > 0)
				count++;
		
		return count >3 ? count * MULTIPLICADOR_REQUERIMENTOS : 0;
	}


	private int pontuacaoNumberOfCharacters() {
		return senha.length() * MULTIPLICADOR_LENGTH;
	}


}
