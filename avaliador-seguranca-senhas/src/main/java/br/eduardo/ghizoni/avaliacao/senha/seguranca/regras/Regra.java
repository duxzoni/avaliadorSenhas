package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public interface Regra {

	int score();

	void setSenha(String senha);

}