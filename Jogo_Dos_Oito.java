import java.util.*;
public class Jogo_Dos_Oito {
public static void main(String[] args) {
	Scanner ler = new Scanner(System.in);
	int matriz[][] = new int [3][3];
	int solucao[][] = new int[3][3];
	System.out.println("Introduza uma matriz: ");

	for ( int i = 0 ; i < 3; i++){
		for ( int j = 0; j < 3 ; j++) {
			matriz[i][j] = ler.nextInt();
		}
	}

	System.out.println("Introduza uma soluçao: ");
	for ( int i = 0 ; i < 3; i++){
		for ( int j = 0; j < 3 ; j++) {
			solucao[i][j] = ler.nextInt();
		}
	}
	
	System.out.println("Escolha o tipo de Busca: ");
	System.out.println("1: Procura em Profundidade.");
	System.out.println("2: Procura em Largura.");
	System.out.println("3: Procura em Profundidade Iterativa.");
	System.out.println("4: Procura Gulosa.");
	System.out.println("5: Procura em Estrela");

	int opcao = ler.nextInt();
	int c = 0; 
	for ( int i = 0 ;  i < 3 ; i++) {
		for ( int j = 0 ; j < 3 ; j++){
			c++;
		}
	}
	if ( c == 9 ) {
		System.out.println("Soluçao igual á origem");
	}


}
}