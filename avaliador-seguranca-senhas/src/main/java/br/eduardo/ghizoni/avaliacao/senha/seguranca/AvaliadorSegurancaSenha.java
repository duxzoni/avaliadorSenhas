package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import java.util.ArrayList;
import java.util.List;

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
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.Regra;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraPorCaractere;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.RegraPorString;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.Simbolos;
import br.eduardo.ghizoni.avaliacao.senha.seguranca.regras.SimbolosEmSequencia;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AvaliadorSegurancaSenha {

	private static final int MULTIPLICADOR_REQUERIMENTOS = 2;
	private Integer pontuacao = 0;
	private List<RegraPorCaractere> regrasPorCaractere = new ArrayList<RegraPorCaractere>();
	private List<RegraPorString> regrasPorString = new ArrayList<RegraPorString>();
	private List<RegraPorCaractere> requerimentos = new ArrayList<RegraPorCaractere>();
	private String senha = "";

	
	public AvaliadorSegurancaSenha() {
	}
	
	public Integer getPontuacao() {
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
				
				if(regra instanceof RegraPorCaractere)
					regrasPorCaractere.add((RegraPorCaractere) regra);
				else
					regrasPorString.add((RegraPorString) regra);
				
				if (requerimentosObrigatorios.contains(classe))
					requerimentos.add((RegraPorCaractere) regra);
				
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private List<Class> requerimentosObrigatorios(){
		ArrayList<Class> requerimentosObrigatorios = new ArrayList<Class>();
		requerimentosObrigatorios.add(LetrasMinusculas.class);
		requerimentosObrigatorios.add(LetrasMaiusculas.class);
		requerimentosObrigatorios.add(Numeros.class);
		requerimentosObrigatorios.add(Simbolos.class);
		
		return requerimentosObrigatorios;
		
	}
	
	public void calculaSegurancaDaSenha(String senha) {
		
		inicializaTodasAsRegrasPorChar(senha);
		inicializaTodasAsRegrasPorString(senha);
		calculaSegurancaDaSenha();
	}

	public void inicializaTodasAsRegrasPorChar(String senha) {
		inicializa(senha, 
				LetrasMinusculas.class, 
				LetrasMaiusculas.class, 
				Numeros.class, 
				Simbolos.class, 
				NumerosOuSimbolosNoMeio.class,
				CaracteresRepetidos.class, 
				LetrasMinusculosConsecutivos.class, 
				LetrasMaiusculasConsecutivas.class, 
				NumerosConsecutivos.class
				);
	}
	
	public void inicializaTodasAsRegrasPorString(String senha) {
		inicializa(senha, 
				LetrasApenas.class, 
				NumerosApenas.class, 
				NumeroDeCaracteres.class, 
				LetrasEmSequencia.class,
				NumerosEmSequencia.class,
				SimbolosEmSequencia.class
				);
	}
	
	
	public void calculaSegurancaDaSenha() {

		for (int index = 0; index < senha.length();  index++)
			for (RegraPorCaractere regraPorCharacter : regrasPorCaractere) 
				regraPorCharacter.validaCharacter(index);
		
		for (Regra regraPorCharacter : regrasPorCaractere) 
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

	public Response getResultadoAvaliacao() {
		Response retorno = new Response();
		retorno.setPontuacao(getPontuacao());
		
		Complexidade complexidade = Complexidade.porPontuacao(getPontuacao());;
		retorno.setComplexidade(complexidade.getMensagem());
		
		return retorno;
	}

}
