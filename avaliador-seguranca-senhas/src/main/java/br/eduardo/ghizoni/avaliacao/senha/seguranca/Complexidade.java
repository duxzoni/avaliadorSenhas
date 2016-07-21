package br.eduardo.ghizoni.avaliacao.senha.seguranca;

public enum Complexidade {
	MUITO_CURTA(0,0, "Muito curta"),
	MUITO_FRACA(1, 19, "Muito fraca"), 
	FRACA(20, 39, "Fraca"), 
	BOA(40, 60, "Boa"),
	FORTE(61, 80, "Forte"), 
	MUITO_FORTE(81, 100, "Muito forte");
    
	private final int inicio;
	private final int fim;
	private final String mensagem;

    Complexidade(int inicio, int fim, String mensagem) { 
    	this.inicio = inicio;
    	this.fim = fim;
    	this.mensagem = mensagem;
    }

    public static Complexidade porPontuacao(int pontuacao) {
        for (Complexidade complexidade: Complexidade.values()) 
            if (complexidade.getInicio() <= pontuacao && pontuacao <= complexidade.getFim()) 
            	return complexidade;
        
        throw new IllegalArgumentException("Complexidade Inválida");
    }

	public int getInicio() {
		return inicio;
	}

	public int getFim() {
		return fim;
	}

	public String getMensagem() {
		return mensagem;
	}
}
