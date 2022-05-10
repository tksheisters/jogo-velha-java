package jogo;
/*
 * Classe abstrata para os filhos herdarem os métodos
 */
public abstract class Jogador {
	protected int[] tentativa = new int[2]; // cria dois vetores para serem utilizados para definir o campo em que vai ser feito a jogada 
    protected int jogador;
    
    public Jogador(int jogador){ //método contrutor da classe
        this.jogador = jogador;
    }
    
    public abstract void jogadaHumana(Tabuleiro tabuleiro); // método abstrato que vai definir o campo a ser jogado
    
    public abstract void Tentativa(Tabuleiro tabuleiro); // método abstrato que vai ser feito uma checagem para ver se o campo está vazio utilizando do
    													// metodo abaixo, e definir as coordenadas da jogada
    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){ 
        if(tabuleiro.getPosicao(tentativa) == 0) //método que verifica se o campo está vazio
            return true;
        else
            return false;
    }
}
