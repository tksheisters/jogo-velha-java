package jogo;
/*
 * Classe abstrata para os filhos herdarem os m�todos
 */
public abstract class Jogador {
	protected int[] tentativa = new int[2]; // cria dois vetores para serem utilizados para definir o campo em que vai ser feito a jogada 
    protected int jogador;
    
    public Jogador(int jogador){ //m�todo contrutor da classe
        this.jogador = jogador;
    }
    
    public abstract void jogadaHumana(Tabuleiro tabuleiro); // m�todo abstrato que vai definir o campo a ser jogado
    
    public abstract void Tentativa(Tabuleiro tabuleiro); // m�todo abstrato que vai ser feito uma checagem para ver se o campo est� vazio utilizando do
    													// metodo abaixo, e definir as coordenadas da jogada
    public boolean checaTentativa(int[] tentativa, Tabuleiro tabuleiro){ 
        if(tabuleiro.getPosicao(tentativa) == 0) //m�todo que verifica se o campo est� vazio
            return true;
        else
            return false;
    }
}
