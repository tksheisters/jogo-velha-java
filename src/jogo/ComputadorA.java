package jogo;

import java.util.Random;

public class ComputadorA extends Computador{
	public Random jogadaAleatoria = new Random();
	
	public ComputadorA(int computador) {
		super(computador);
		this.computador = computador;
		System.out.println();
		System.out.println("JOGADOR 'COMPUTADOR A' CRIADO!");
	}

	@Override
    public void jogadaComp(Tabuleiro tabuleiro){
		do {
			calculaJogada(tabuleiro);			
		}while(!checaPosicao(tentativa, tabuleiro));
        tabuleiro.setPosicao(tentativa, computador);
    }
    
    @Override
    public void calculaJogada(Tabuleiro tabuleiro) { // Jogada aleatória, define aleatóriamente uma linha e coluna
        do{
           tentativa[0] = jogadaAleatoria.nextInt(4);
                
        }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
        do{
           tentativa[1] = jogadaAleatoria.nextInt(4);
              
        }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
        tentativa[0]--; 
        tentativa[1]--;
    }
}