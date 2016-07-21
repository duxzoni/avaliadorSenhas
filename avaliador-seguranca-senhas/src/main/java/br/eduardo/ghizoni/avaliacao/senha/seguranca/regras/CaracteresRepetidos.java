package br.eduardo.ghizoni.avaliacao.senha.seguranca.regras;

public class CaracteresRepetidos extends RegraPorCaractere {

	private double charRepetidos = 0; 
	
	@Override
	public void validaCharacter(int index) {
		Character letra = senha.charAt(index);
		boolean possuiCharRepetido = false;
		for (int i = 0; i < senha.length(); i++) 
			if (letra.equals(senha.charAt(i)) && i != index){
				possuiCharRepetido = true;
				pontuacao += Math.abs(senha.length() / (i-index));
			}

		if (possuiCharRepetido) { 
			charRepetidos++; 
			Double charUnicos = (Double) (senha.length()-charRepetidos);
			Double i =  ((pontuacao * 1.0)/charUnicos);
			pontuacao = (int) (charUnicos > 0 ? Math.ceil(i) : Math.ceil(pontuacao)); 
		}
			
		
	}

	public int score() {
		if (charRepetidos > 0)
			return  pontuacao * -1;
		return 0;
	}


}
