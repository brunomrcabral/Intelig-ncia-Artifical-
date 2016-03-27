import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

class No{
    No pai;
    int matriz[][];
    String operador;
    int profundidade,custo;

    No(No p , int m[][] , String op , int pr , int c){

        pai = p;
        operador = op;
        profundidade = pr;
        custo = c;

        matriz= new int[3][3];
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                matriz[i][j] = m[i][j];
            }
        }
    }

    public int[][] getMatriz(){
        int nova[][] = new int [3][3];
        for(int i=0 ; i<3 ; i++)
            for(int j=0 ; j<3 ;j++)
                nova[i][j]= matriz[i][j];

        return nova;
    }

    public int getProfundidade(){
        return profundidade;
    }

    public int getCusto(){
        return custo;
    }
}


//---------------------------------------------------------------------------------------------------------------------------------------------------
public class jogo_oito {

    public static void main(String args[]) {
		
        Scanner ler = new Scanner(System.in);

        System.out.println("Configuracao Inicial");
        int[][] inicio_mat = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inicio_mat[i][j] = ler.nextInt();
            }
        }

        System.out.println("Configuracao Final");
        int[][] solucao = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solucao[i][j] = ler.nextInt();
            }
        }


        ArrayList<No> Lista = new ArrayList<No>();
        ArrayList<No> Visitados = new ArrayList<No>();
        String operador = " ";
        No root = new No(null, inicio_mat, operador, 0, 0);

        //Adicionar o no inicial á lista
        Lista.add(root);

        System.out.println();
        System.out.println("----Escolha o tipo de Pesquisa----");
        System.out.println("Pesquisa em Largura                             -> 1");
        System.out.println("Pesquisa em Profundidade                        -> 2");
        System.out.println("Pesquisa em Profundidade Iterativa              -> 3");
        System.out.println("Pesquisa Gulosa (distancia da posiçao final)    -> 4");
        System.out.println("Pesquisa Gulosa (#nós fora do sitio)            -> 5");
        System.out.println("A*                                              -> 6");
        int f = ler.nextInt();
        System.out.println();

		long inicio = System.currentTimeMillis();	
        GeneralSearchAlgorithm(Lista, Visitados, solucao, f, root);
		long fim = System.currentTimeMillis();
		 //System.out.println("Demorou " + (fim - inicio) + " milisegundos");
        System.out.println("Demorou " + (fim - inicio) + " milisegundos" + " ou " + ((fim-inicio)/1000)%60 + " segundos" ) ;

    }

    public static void GeneralSearchAlgorithm(ArrayList<No> L, ArrayList<No> V, int sol[][], int flag, No inicial) {
        if ( flag == 1 ) {
			largura.larg(L,sol);
        }
        if ( flag == 2 ) {
            profundidade.profu(L,V,sol);
        }
        if ( flag == 3  ){
            iterativa.iter(L,sol);
        }
        if(flag == 4){
            greedy_distancia.gree_dist(L , V , sol);
        }
        if(flag == 5){
            greedy_fora.gree_fora(L,V,sol);
        }
        if(flag == 6){
            A.estrela(L,V,sol);
        }



}

 public static void Caminho(No f, int c) {

        ArrayList<No> k = new ArrayList<No>();
        k.add(f);
        while (f.pai != null) {
            k.add(f.pai);
            f = f.pai;
        }
        System.out.println("Profundidade= " + (k.size() - 1));
        System.out.println("Nós Armazenados= " + c);
        System.out.println("Caminho:");

        for (int i = k.size() - 1; i >= 0; i--) {
            No x = k.get(i);
            System.out.println(x.operador);
        }
    }

    public static boolean Verificar (int matriz[][] , int matriz_teste[][]) {
        int count=0;

        for (int x = 0; x < 3; x++) {
            for (int j = 0; j < 3; j++) {
                if( matriz[x][j] == matriz_teste[x][j] )
                    count++;
            }
        }
        if(count == 9)
            return true;
        else
            return false;
    }
}

