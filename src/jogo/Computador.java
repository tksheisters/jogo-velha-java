package jogo;

public abstract class Computador {		// Praticamente a mesma coisa que a classe Jogador, serve só para diferenciar entre uma pessoa e um computador
	protected int[] tentativa = new int[2];
    protected int computador;
    
    public Computador(int computador){
        this.computador = computador;
    }
    
    public abstract void jogadaComp(Tabuleiro tabuleiro);
    
    public abstract void calculaJogada(Tabuleiro tabuleiro);

    public boolean checaPosicao(int[] tentativa, Tabuleiro tabuleiro){
        if(tabuleiro.getPosicao(tentativa) == 0)
            return true;
        else
            return false;
    }
}