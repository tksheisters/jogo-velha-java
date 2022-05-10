package jogo;

import java.util.Random;

public class ComputadorB extends Computador{
	public Random aleatorio = new Random();
	public int cont = 0;

	public ComputadorB(int computador) {
		super(computador);
		this.computador = computador;
		System.out.println();
		System.out.println("JOGADOR 'COMPUTADOR B' CRIADO!");
	}

	@Override
    public void jogadaComp(Tabuleiro tabuleiro){
		cont = cont + 2;
		do {
			calculaJogada(tabuleiro);			
		}while(!checaPosicao(tentativa, tabuleiro));
        tabuleiro.setPosicao(tentativa, computador);
    }
    
    @Override
    public void calculaJogada(Tabuleiro tabuleiro) { // Jogada Aleatória de acordo com um contador
    	do {
    			if(cont == 2) { // se contador for 2: jogada aleatória entre a linha 1 e 2 ( indice 0 e 1)
    	        	tentativa[0] = aleatorio.nextInt(2);
    	        }
    	    	if(cont == 4) { // se contador for 4: jogada aleatória entre a linha 1 e 2 ( indice 0 e 1)
    	        	tentativa[0] = aleatorio.nextInt(2);
    	        }
    	    	if(cont == 6){ // se contador for 6: jogada aleatória em qualquer linha
    	         	tentativa[0] = aleatorio.nextInt(3);
    	        }
    	        if(cont > 6) { // se contador for  maior que 6: jogada aleatória em qualquer linha
    	         	tentativa[0] = aleatorio.nextInt(3);
    	        }
    	        // ===================================================
    	        if(cont == 2) { // se contador for 2: jogada aleatória em qualquer coluna
    	        	tentativa[1] = aleatorio.nextInt(3);
    	        }
    	        if(cont == 4) { // se contador for 4: jogada aleatória entre a coluna 1 e 2 ( indice 0 e 1)
    	        	tentativa[1] = aleatorio.nextInt(2);
    	        }
    	        if(cont == 6) { // se contador for 6: jogada aleatória entre a coluna 1 e 2 ( indice 0 e 1)
    	        	tentativa[1] = aleatorio.nextInt(2);
    	        }
    	        if(cont > 6) { // se contador for  maior que 6: jogada aleatória em qualquer coluna
    	        	tentativa[1] = aleatorio.nextInt(3);
    	        }
    	        
    	}while(!checaPosicao(tentativa, tabuleiro));
    }
}