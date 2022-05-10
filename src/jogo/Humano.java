package jogo;

import java.util.Scanner;

public class Humano extends Jogador {
	public Scanner teclado = new Scanner(System.in); // variavel para pegar a entrada de dados do teclado
    
    public Humano(int jogador){ // construtor da classe, herda a classe pai (Jogador)
        super(jogador);
        this.jogador = jogador;
        System.out.println("JOGADOR 1 CRIADO!");
    }
    
    @Override
    public void jogadaHumana(Tabuleiro tabuleiro){ // define a jogada em determinado campo do tabuleiro
        Tentativa(tabuleiro); // verifica se o campo está em branco ou se já possui uma jogada, também define as coordenadas
        tabuleiro.setPosicao(tentativa, jogador);
    }
    
    @Override
    public void Tentativa(Tabuleiro tabuleiro){
        do{ // loop até ser definida uma posição disponível
            do{
            	System.out.println("DIGITE AS COORDENADAS DA SUA JOGADA");
                System.out.print("LINHA: ");
                tentativa[0] = teclado.nextInt(); // define em qual linha 
                
                if( tentativa[0] > 3 ||tentativa[0] < 1)
                    System.out.println("LINHA INVÁLIDA. DIGITE UM NÚMERO ENTRE 1 E 3");
                
            }while( tentativa[0] > 3 ||tentativa[0] < 1);
            
            do{
                System.out.print("COLUNA: ");
                tentativa[1] = teclado.nextInt(); // define em qual coluna
                
                if(tentativa[1] > 3 ||tentativa[1] < 1)
                    System.out.println("COLUNA INVÁLIDA. DIGITE UM NÚMERO ENTRE 1 E 3");
                
            }while(tentativa[1] > 3 ||tentativa[1] < 1);
            
            tentativa[0]--; // como os indices vão de 0 a 2, subtrai 1 para corresponder
            tentativa[1]--;
            
            if(!checaTentativa(tentativa, tabuleiro)) // mensagem de erro caso o campo já esteja marcado
                System.out.println("ESSE LOCAL JÁ FOI MARCADO. TENTE OUTRO.");
        }while( !checaTentativa(tentativa, tabuleiro) );
    }
}
