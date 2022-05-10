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
        
        while(jogar()); // loop para o jogo ficar rodando, ele para até ser definido um vencedor ou dar empate
    }

	public void selecionaOponente(){ // metodo para selecionar qual computador vai ser o oponente, é complementado com outro metodo adiante
    	System.out.println("=========BEM VINDO AO JOGO DA VELHA=========\n");
        System.out.println("VOCÊ VAI SER O JOGADOR 1! \n"); // você sempre vai ser o jogador 1
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
        	System.out.println("DIGITE UM NÚMERO ENTRE 1 e !");
        }
    }
    
    public int escolherOponente(){ // metodo que complementa o anterior, aqui a pessoa escolhe de fato qual oponente será o jogador 2
        int opcao = 0;
        
        do{
            System.out.println("1 = COMPUTADOR A");
            System.out.println("2 = COMPUTADOR B");
            System.out.println("3 = COMPUTADOR C\n");
            System.out.print("ESCOLHA UMA OPÇÃO: ");
            opcao = entrada.nextInt();
            
            if(opcao != 1 && opcao != 2 && opcao != 3)
                System.out.println("OPÇÃO INVÁLIDA. TENTE NOVAMENTE!"); // fica em loop até ser definido o segundo jogador, caso não digite um número
        }while(opcao < 1 || opcao > 3);									// de 1 a 3 fica aparecendo uma mensagem de erro
        
        return opcao;
    }
    
    public boolean jogar(){ // método que faz o jogo continuar até ser defiinido um vencedor ou empate
        if(ganhou() == 0 ){ // enquanto for 0 nenhum vencedor foi definido
            System.out.println("----------------------");
            System.out.println("\nRODADA: "+rodada);
            System.out.println("VEZ DO JOGADOR " + vez() + ":" );
            
            if(vez() == 1) // verifica de quem é a vez de jogar, o método completo está um pouco mais adiante
                player1.jogadaHumana(tabuleiro);
            else		  
            	player2.jogadaComp(tabuleiro);
            
            
            if(tabuleiro.empate() && ganhou() == 0){ // se empatar ou alguem ganhar retorna falso e acaba o loop do jogo
                System.out.println("SEM CAMPOS VAZIOS! JOGO EMPATADO!");
                return false;
            }
            vez++; // define quem é a vez de jogar
            rodada++; // a cada turno a rodada aumenta em 1

            return true; // enquanto não for definido o vencedor ou se o tabuleiro não estiver completo o jogo continua
        }
        else{
            if(ganhou() == -1 ) // verifica se quem ganhou foi o jogador 1 ou o jogador 2, o metodo ganhou() esta um pouco mais adiante
                System.out.println("VENCEDOR JOGADOR 1!");
            else
                System.out.println("VENCEDOR JOGADOR 2!");
            
            return false;
        }
            
    }
    
    public int vez(){ // verifica de quem é a vez, calcula com o modulo de 2, exemplo: está na vez 4... 4/2 = 1, o módulo verifica qual o resto da 
        if(vez %2 == 1)// divisão de um número por outro, se o resto for 1 então vez() == 1, ou seja vez do jogador 1, se der outro número então
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
