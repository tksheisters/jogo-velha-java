package jogo;

public class Tabuleiro {
	private int[][] tabuleiro = new int[3][3]; // cria uma matriz de 3x3 que será o tabuleiro

 
	public Tabuleiro(){ // construtor da classe invocando um método assim que instanciado para transformar cada inteiro da matriz em 0
	    zerarTabuleiro();
	}
	    
	public void zerarTabuleiro(){ // método que percorre cada linha e coluna da matriz,
	    for(int l = 0; l < tabuleiro.length ; l++) {		// <<-- percorre as linhas  	
	        for(int c = 0; c < tabuleiro.length ; c++) {		// <<-- percorre as colunas
	            tabuleiro[l][c] = 0; // define como 0 o inteiro na posição do indice atual
	        }
	    }
	}
	public void imprimeTabuleiro(){ // método parecido com o zerarTabuleiro(), só que agora percorre verificando
	    								// se em determinada posição tem o numero -1, 1 ou 0, e imprime no console
	    System.out.println();
	    for(int l = 0; l < tabuleiro.length  ; l++){
	        for(int c = 0; c < tabuleiro.length; c++){
	                
	            if(tabuleiro[l][c]== -1){ // se for -1 ele imprime X na determinada posição
	            	System.out.print("  X  ");
	            }
	                if(tabuleiro[l][c]== 1){ // se for 1 ele imprime O na determinada posição
	                    System.out.print("  O  ");
	                }
	                if(tabuleiro[l][c]== 0){ // se for 0 ele imprime uma string vazia na determinada posição
	                    System.out.print("     ");
	                }
	                
	                if(c == 0 || c == 1) // desenha uma separação entre as colunas
	                    System.out.print("|");
	            }
	            System.out.println(" ");
	        }
	                
	    }
	    
	    public int getPosicao(int[] tentativa){ // metodo para pegar a posicao da tentativada de jogar tanto do jogador 1 quanto do computador
	        return tabuleiro[tentativa[0]][tentativa[1]];
	    }

	    public void setPosicao(int[] tentativa, int jogador){ // este metodo marca a posicao no tabuleiro com o parametro passado
	        if(jogador == 1)
	            tabuleiro[tentativa[0]][tentativa[1]] = -1;
	        else
	            tabuleiro[tentativa[0]][tentativa[1]] = 1;
	        
	        imprimeTabuleiro();
	    }
		
	    public int verificaLinhas(){ // verifica se nas linhas os tres campos já foram marcados, soma os números nas determinadas posições
	        for(int l = 0 ; l < tabuleiro.length ; l++){// da matriz, lembrando que -1 é o jogador 1, 1 é o computador e 0 campo vazio.
	
	            if((tabuleiro[l][0] + tabuleiro[l][1] + tabuleiro[l][2]) == -3)
	                return -1; // jogador completou uma linha
	            if((tabuleiro[l][0] + tabuleiro[l][1] + tabuleiro[l][2]) == 3)
	                return 1; // computador completou uma linha
	        }
	        
	        return 0;
	                
	    }

		public int verificaColunas(){ // faz a mesma coisa que o verificaLinhas só que com as colunas
	        for(int c = 0 ; c < tabuleiro.length ; c++){
	
	            if((tabuleiro[0][c] + tabuleiro[1][c] + tabuleiro[2][c]) == -3)
	                return -1;
	            if((tabuleiro[0][c] + tabuleiro[1][c] + tabuleiro[2][c]) == 3)
	                return 1;
	        }
	        
	        return 0;
	                
	    }
	    
	    public int verificaDiagonais(){ // esse verifica as diagonais
	        if((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == -3)
	            return -1;
	        if((tabuleiro[0][0] + tabuleiro[1][1] + tabuleiro[2][2]) == 3)
	            return 1;
	        if((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == -3)
	            return -1;
	        if((tabuleiro[0][2] + tabuleiro[1][1] + tabuleiro[2][0]) == 3)
	            return 1;
	        
	        return 0;
	    }
	
	    public boolean empate(){ // metodo que percorre cada campo do tabuleiro 
	        for(int l = 0 ; l < tabuleiro.length ; l++) // pra verificar se o tabuleiro está completo, caso esteja completo e sem nenhum vencedor definido então   
	            for(int c = 0 ; c < tabuleiro.length ; c++) // o jogo se dá como empate
	                if(tabuleiro[l][c] == 0)
	                    return false;
	        return true;
	    }
}
	
