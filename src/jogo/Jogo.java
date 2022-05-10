package jogo;

import java.util.Scanner;

public class Jogo { // variaveis da classe
	public Scanner entrada = new Scanner(System.in);
	private Tabuleiro tabuleiro; 
    private Jogador player1;
    private Computador player2;
    public int rodada = 1, vez = 1;

    
    public Jogo(){ // construtor da classe, inicia criando o tabuleiro e chamando o metodo para escolher oponente
        tabuleiro = new Tabuleiro();
        selecionaOponente();
        
        while(jogar()); // loop para o jogo ficar rodando, ele para at� ser definido um vencedor ou dar empate
    }

	public void selecionaOponente(){ // metodo para selecionar qual computador vai ser o oponente, � complementado com outro metodo adiante
    	System.out.println("=========BEM VINDO AO JOGO DA VELHA=========\n");
        System.out.println("VOC� VAI SER O JOGADOR 1! \n"); // voc� sempre vai ser o jogador 1
        this.player1 = new Humano(1); // instancia o jogador como humano

        System.out.println("----------------------------------------\n");
        System.out.println("ESCOLHA QUEM VAI SER O JOGADOR 2: ");
        switch(escolherOponente()) { // dependendo da escolha de 1 a 3 instancia o jogador 2 como uma dessas classes
        case 1:
        	this.player2 = new ComputadorA(2);
        	break;
        case 2:
        	this.player2 = new ComputadorB(2);
        	break;
        case 3:
        	this.player2 = new ComputadorC(2);
        	break;
        default:
        	System.out.println("DIGITE UM N�MERO ENTRE 1 e !");
        }
    }
    
    public int escolherOponente(){ // metodo que complementa o anterior, aqui a pessoa escolhe de fato qual oponente ser� o jogador 2
        int opcao = 0;
        
        do{
            System.out.println("1 = COMPUTADOR A");
            System.out.println("2 = COMPUTADOR B");
            System.out.println("3 = COMPUTADOR C\n");
            System.out.print("ESCOLHA UMA OP��O: ");
            opcao = entrada.nextInt();
            
            if(opcao != 1 && opcao != 2 && opcao != 3)
                System.out.println("OP��O INV�LIDA. TENTE NOVAMENTE!"); // fica em loop at� ser definido o segundo jogador, caso n�o digite um n�mero
        }while(opcao < 1 || opcao > 3);									// de 1 a 3 fica aparecendo uma mensagem de erro
        
        return opcao;
    }
    
    public boolean jogar(){ // m�todo que faz o jogo continuar at� ser defiinido um vencedor ou empate
        if(ganhou() == 0 ){ // enquanto for 0 nenhum vencedor foi definido
            System.out.println("----------------------");
            System.out.println("\nRODADA: "+rodada);
            System.out.println("VEZ DO JOGADOR " + vez() + ":" );
            
            if(vez() == 1) // verifica de quem � a vez de jogar, o m�todo completo est� um pouco mais adiante
                player1.jogadaHumana(tabuleiro);
            else		  
            	player2.jogadaComp(tabuleiro);
            
            
            if(tabuleiro.empate() && ganhou() == 0){ // se empatar ou alguem ganhar retorna falso e acaba o loop do jogo
                System.out.println("SEM CAMPOS VAZIOS! JOGO EMPATADO!");
                return false;
            }
            vez++; // define quem � a vez de jogar
            rodada++; // a cada turno a rodada aumenta em 1

            return true; // enquanto n�o for definido o vencedor ou se o tabuleiro n�o estiver completo o jogo continua
        }
        else{
            if(ganhou() == -1 ) // verifica se quem ganhou foi o jogador 1 ou o jogador 2, o metodo ganhou() esta um pouco mais adiante
                System.out.println("VENCEDOR JOGADOR 1!");
            else
                System.out.println("VENCEDOR JOGADOR 2!");
            
            return false;
        }
            
    }
    
    public int vez(){ // verifica de quem � a vez, calcula com o modulo de 2, exemplo: est� na vez 4... 4/2 = 1, o m�dulo verifica qual o resto da 
        if(vez %2 == 1)// divis�o de um n�mero por outro, se o resto for 1 ent�o vez() == 1, ou seja vez do jogador 1, se der outro n�mero ent�o
            return 1; // vez do computador
        else
            return 2;
    }
    
    public int ganhou(){    // metodo que verifica se alguem completou alguma linha, coluna ou diagonal, utiliza-se dos metodos da classe tabuleiro
        if(tabuleiro.verificaLinhas() == 1)
            return 1;
        if(tabuleiro.verificaColunas() == 1)
            return 1;
        if(tabuleiro.verificaDiagonais() == 1)
            return 1;
        
        if(tabuleiro.verificaLinhas() == -1)
            return -1;
        if(tabuleiro.verificaColunas() == -1)
            return -1;
        if(tabuleiro.verificaDiagonais() == -1)
            return -1;
        
        return 0;
    }
}
