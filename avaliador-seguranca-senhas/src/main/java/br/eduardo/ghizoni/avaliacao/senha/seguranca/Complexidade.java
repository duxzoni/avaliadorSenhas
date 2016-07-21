package br.eduardo.ghizoni.avaliacao.senha.seguranca;

public enum Complexidade {
	MUITO_CURTA(0,0, "Muito curta","#D70000"),
	MUITO_FRACA(1, 19, "Muito fraca", "#D74F00" ), 
	FRACA(20, 39, "Fraca", "#D78800"), 
	BOA(40, 59, "Boa", "#E8DC00"),
	FORTE(60, 79, "Forte", "#3CC800"), 
	MUITO_FORTE(80, 100, "Muito forte", "#027E00");
    
	private final int inicio;
	private final int fim;
	private final String mensagem;
	private final String cor;

    Complexidade(int inicio, int fim, String mensagem, String cor) { 
    	this.inicio = inicio;
    	this.fim = fim;
    	this.mensagem = mensagem;
    	this.cor = cor;
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

	public String getCor() {
		return cor;
	}
}
