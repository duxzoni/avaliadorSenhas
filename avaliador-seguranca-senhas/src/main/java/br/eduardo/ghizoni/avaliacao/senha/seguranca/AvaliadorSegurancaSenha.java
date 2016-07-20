package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import java.util.ArrayList;
import java.util.List;

import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.Regra;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraConsecutiveLowerCase;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraConsecutiveNumber;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraConsecutiveUpperCase;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraLettersOnly;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraLowerCase;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraMiddleNumberOrSymbol;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraNumberOfCharacters;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraNumbers;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraNumbersOnly;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraPorCharacter;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraPorString;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraRepeatCharacters;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSequentialLetters;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSequentialNumbers;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSequentialSymbols;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraSymbols;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraUpperCase;

public class AvaliadorSegurancaSenha {

	private static final int MULTIPLICADOR_REQUERIMENTOS = 2;
	private Integer pontuacao = 0;
	private List<RegraPorCharacter> regrasPorCharacter = new ArrayList<RegraPorCharacter>();
	private List<RegraPorString> regrasPorString = new ArrayList<RegraPorString>();
	private List<RegraPorCharacter> requerimentos = new ArrayList<RegraPorCharacter>();
	private String senha = "";

	
	public AvaliadorSegurancaSenha() {
	}
	
	public int getPontuacao() {
		return pontuacao > 100 ? 100: pontuacao;
	}
	
	protected void inicializa(String senha, Class ... regras) {
		this.senha = senha;
		
		List<Class> requerimentosObrigatorios = requerimentosObrigatorios();
		for (Class<Regra> classe : regras) {
			Regra regra;
			try {
				regra = classe.newInstance();
				regra.setSenha(senha);
				
				if(regra instanceof RegraPorCharacter)
					regrasPorCharacter.add((RegraPorCharacter) regra);
				else
					regrasPorString.add((RegraPorString) regra);
				
				if (requerimentosObrigatorios.contains(classe))
					requerimentos.add((RegraPorCharacter) regra);
				
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
		
		inicializaTodasAsRegrasPorChar(senha);
		inicializaTodasAsRegrasPorString(senha);
		calculaSegurancaDaSenha();
	}

	public void inicializaTodasAsRegrasPorChar(String senha) {
		inicializa(senha, 
				RegraLowerCase.class, 
				RegraUpperCase.class, 
				RegraNumbers.class, 
				RegraSymbols.class, 
				RegraMiddleNumberOrSymbol.class,
				RegraRepeatCharacters.class, 
				RegraConsecutiveLowerCase.class, 
				RegraConsecutiveUpperCase.class, 
				RegraConsecutiveNumber.class
				);
	}
	
	public void inicializaTodasAsRegrasPorString(String senha) {
		inicializa(senha, 
				RegraLettersOnly.class, 
				RegraNumbersOnly.class, 
				RegraNumberOfCharacters.class, 
				RegraSequentialLetters.class,
				RegraSequentialNumbers.class,
				RegraSequentialSymbols.class
				);
	}
	
	
	public void calculaSegurancaDaSenha() {

		for (int index = 0; index < senha.length();  index++)
			for (RegraPorCharacter regraPorCharacter : regrasPorCharacter) 
				regraPorCharacter.validaCharacter(index);
		
		for (Regra regraPorCharacter : regrasPorCharacter) 
			pontuacao += regraPorCharacter.score();

		for (RegraPorString regraPorString : regrasPorString) {
			regraPorString.validaSenha();
			pontuacao += regraPorString.score();
		}
		
		pontuacao += pontuacaoRequirements();
		
		
	}

	private int pontuacaoRequirements() {
		int count = 0;
		if (senha.length() > 0)
			count++;
			
		for (Regra regra: requerimentos) 
			if (regra.score() > 0)
				count++;
		
		return count >3 ? count * MULTIPLICADOR_REQUERIMENTOS : 0;
	}


}
