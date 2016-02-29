import java.util.*;
import java.util.LinkedList;
import java.util.Array.List;

public class Jogo_Dos_Oito {
	
public class Matriz { 
	 int[] vazia = new int[2];  // x e y da posiçao vazia 
	 int matriz[][] = new int [3][3];
	 int profundidade = 0 ; 
	 ArrayList<Matriz> visitado = new ArrayList<Matriz>();
	 int heuristica = 100000;
	
	Matriz ( int[][] mat , int prof , ArrayList<Matriz> visit , Matriz pai ) { //--Formato ( matriz , profundidade , visitado , no pai ) 
		if ( visit != null ) {
			visitado = ( ArrayList<Matriz>)v.clone();
			visitado.add(parent);
		}
		profundidade = prof + 1 ;
		
		for ( int i = 0; i < matriz.length() ; i++){
			for ( int j = 0 ; j <matriz.length(); j++){
				matriz[i][j] = mat[i][j];
			}
		}
		
		boolean posiçao_vazia = false ; 
		for ( int i = 0; i < matriz.length() ; i++){
			for ( int j = 0 ; j <matriz.length(); j++){
				if ( matriz[i][j] == -1 ) {
					vazia[0] = i ; 
					vazia[1] = j ; 
					posiçao_vazia = true ; 
					break;
				}
			}
			if ( posiçao_vazia ) break;
		}
	}
	public boolean Cima() {
        int y = vazia[0];
        int x = vazia[1];
        if (x < 0 || x > 2 || y < 1 || y > 2) return false;
        int temp = matriz[y][x];
        matriz[y][x] = matriz[y-1][x];
        matriz[y-1][x] = temp;
        vazia[0] = y-1;
        return true;
    }
     
    public boolean Baixo() {
        int y = vazia[0];
        int x = vazia[1];
        if (x < 0 || x > 2 || y < 0 || y > 1) return false;
        int temp = matriz[y][x];
        matriz[y][x] = matriz[y+1][x];
        matriz[y+1][x] = temp;
        vazia[0] = y+1;
        return true;
    }
     
    public boolean Esquerda() {
        int y = vazia[0];
        int x = vazia[1];
        if (x < 1 || x > 2 || y < 0 || y > 2) return false;
        int temp = matriz[y][x];
        matriz[y][x] = matriz[y][x-1];
        matriz[y][x-1] = temp;
        vazia[1] = x-1;
        return true;
    }
     
    public boolean Direita() {
        int y = vazia[0];
        int x = vazia[1];
        if (x < 0 || x > 1 || y < 0 || y > 2) return false;
        int temp = matriz[y][x];
        matriz[y][x] = matriz[y][x+1];
        matriz[y][x+1] = temp;
        vazia[1] = x+1;
        return true;
    }
    
}
	
//---------------------------------------------------------------------- Main 
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
	long inicio = SystemcurrentTimeMillis();
	
	
	switch (opcao ) {
		case 1: // Profundidade 
		DFS pesq = new DFS();
		
		comparar(matriz,solucao);
		case 2: // Largura
		
		comparar(matriz,solucao);
		case 3: // Profundidade Iterativa 
		
		comparar(matriz,solucao);
		case 4: // Gulosa
		
		comparar(matriz,solucao);
		case 5: // A*
		
		comparar(matriz,solucao);
	
}
	long fim = System.currentTimeMillis();
	System.out.println("Tempo: " + (inicio-fim));

}
}
//----------------------------------------------------------------------
 public class comparar(int [][] mat , int [][] sol) {
	int c = 0; 
	for ( int i = 0 ;  i < 3 ; i++) {
		for ( int j = 0 ; j < 3 ; j++){
			if ( mat[i][j] == sol[i][j]){
			c++;
			}
		}
	}
	if ( c == 9 ) {
		System.out.println("Soluçao igual á origem");
	}
}
//----------------------------------------------------------------------
public void DFS() {
}
	


