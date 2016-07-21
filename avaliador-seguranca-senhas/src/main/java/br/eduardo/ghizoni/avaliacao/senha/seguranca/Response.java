package br.eduardo.ghizoni.avaliacao.senha.seguranca;

import org.apache.commons.lang.StringUtils;

public class Response {
	private String complexidade;
	private int pontuacao;
	private String cor;
	
	public String getComplexidade() {
		return complexidade;
	}
	
	public void setComplexidade(String complexidade) {
		this.complexidade = complexidade;
	}

	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
		calculaCor(pontuacao);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public void calculaCor(int pontuacao){
		Integer vermelhoHexa = 0xFF;
		Integer verdeHexa = 0xA2;
		String azul = "00"; 
		
		if(pontuacao <= 50)
			verdeHexa = pontuacao * verdeHexa / 50;
		else
			vermelhoHexa = (pontuacao-100) *-1 * vermelhoHexa / 50;
		
		String vermelho = StringUtils.leftPad(Integer.toHexString(vermelhoHexa), 2, '0');		
		String verde = StringUtils.leftPad(Integer.toHexString(verdeHexa), 2, '0');
		setCor("#"+vermelho+verde+azul);
	}
	
}
