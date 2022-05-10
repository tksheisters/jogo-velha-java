package jogo;

import java.util.Random;

public class ComputadorC extends Computador{
	private int cont = 0;
	private Random jogadaAleatoria = new Random();

	public ComputadorC(int computador) {
		super(computador);
		this.computador = computador;
		System.out.println();
		System.out.println("JOGADOR 'COMPUTADOR C' CRIADO!");
	}

	@Override
	public void jogadaComp(Tabuleiro tabuleiro) {
		cont++;
		calculaJogada(tabuleiro);
        tabuleiro.setPosicao(tentativa, computador);
	}

	public void calculaJogada(Tabuleiro tabuleiro) { // Jogada com campos já definidos, joga em determinados campos de acordo com o contador, se o campo 
		do{											// já estiver marcado então faz uma jogada aleatória.
			if(cont == 1) {
				tentativa[0] = 0;
				tentativa[1] = 2;
			}
			if(cont == 2) {
				tentativa[0] = 1;
				tentativa[1] = 2;
			}
			if(cont == 3) {
				tentativa[0] = 0;
				tentativa[1] = 0;
			}
			if(cont == 4) {
				tentativa[0] = 2;
				tentativa[1] = 0;
			}
			if(cont == 5) {
				tentativa[0] = 0;
				tentativa[1] = 1;
			}
			if(cont == 6) {
				tentativa[0] = 1;
				tentativa[1] = 0;
			}
			if(cont == 7) {
				tentativa[0] = 2;
				tentativa[1] = 2;
			}
			if(cont == 8) {
				tentativa[0] = 1;
				tentativa[1] = 1;
			}
			if(cont == 9) {
				tentativa[0] = 2;
				tentativa[1] = 1;
			}

			else
				tentativa[0] = jogadaAleatoria.nextInt(3);
				tentativa[1] = jogadaAleatoria.nextInt(3);
		}while(!checaPosicao(tentativa, tabuleiro)) ;
	}
		
}