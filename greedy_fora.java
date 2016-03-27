import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;


public class greedy_fora {
    public static void gree_fora(ArrayList<No> L, ArrayList<No> V, int[][] sol) {
        int custo = 0;
        int iguais = 0, xi = 0, contador = 0;
        int prof;

        while(xi != 1){
            int x0 = 0 ;
            int y0 = 0 ;

            No novo = L.get(0);
            V.add(novo);
            L.remove(0);
            prof = novo.getProfundidade();

            int matriz[][];
            matriz = novo.getMatriz();

            //Verificar se encontrou a solucao
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matriz[i][j] == sol[i][j])
                        iguais++;
                }
            }
            if (iguais == 9) {
                xi = 1;
                System.out.println("ENCONTRADA");
                jogo_oito.Caminho(novo, contador);
            } else
                iguais = 0;


            //Encontrar a posicao em branco
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matriz[i][j] == 0) {
                        x0 = i;
                        y0 = j;
                    }
                }
            }


            //***Mover para cima***
            if (x0 != 0) {
                matriz[x0][y0] = matriz[x0 - 1][y0];
                matriz[x0 - 1][y0] = 0;

                //Calcular o custo
                custo = 0;
                for (int i = 0; i < 3; i++) {
                    for(int j=0 ; j< 3 ; j++){
                        if(matriz[i][j] != sol[i][j])
                            custo++;
                    }
                }

                //No eventualmente criado
                No noFilho = new No(novo, matriz, "Cima", prof + 1, custo);

                //Onde adicionar
                int k = 0;
                for (int i = 0; i < V.size(); i++) {
                    int matriz_teste[][] = V.get(i).getMatriz();

                    if (jogo_oito.Verificar(matriz, matriz_teste) != true)
                        k++;
                }

                //Nao esta presente nos visitados
                if (k == V.size()) {
                    if (L.isEmpty()) {
                        L.add(noFilho);
                        contador++;
                    }
                    else {
                        int custo_teste=0;

                        for (int m = 0; m < L.size(); m++) {
                            custo_teste = L.get(m).getCusto();
                            if (custo < custo_teste) {
                                L.add(m, noFilho);
                                contador++;
                                break;
                            }
                        }
                    }
                }
            }

            matriz = novo.getMatriz();

            //***Mover para baixo***
            if (x0 != 2) {
                matriz[x0][y0] = matriz[x0 + 1][y0];
                matriz[x0 + 1][y0] = 0;

                //Calcular o custo
                custo = 0;
                for (int i = 0; i < 3; i++) {
                    for(int j=0 ; j< 3 ; j++){
                        if(matriz[i][j] != sol[i][j])
                            custo++;
                    }
                }

                //No eventualmente criado
                No noFilho = new No(novo, matriz, "Baixo", prof + 1, custo);

                //Nao esta presente nos visitados
                int k = 0;
                for (int i = 0; i < V.size(); i++) {
                    int matriz_teste[][] = V.get(i).getMatriz();

                    if (jogo_oito.Verificar(matriz, matriz_teste) != true)
                        k++;
                }

                //Nao esta presente nos visitados
                if (k == V.size()) {
                    if (L.isEmpty()) {
                        L.add(noFilho);
                        contador++;
                    }
                    else {
                        int custo_teste=0;

                        for (int m = 0; m < L.size(); m++) {
                            custo_teste = L.get(m).getCusto();
                            if (custo < custo_teste) {
                                L.add(m, noFilho);

                                contador++;
                                break;
                            }
                        }
                    }
                }
            }

            matriz = novo.getMatriz();

            //***Mover para Direita***
            if (y0 != 2) {
                matriz[x0][y0] = matriz[x0][y0 + 1];
                matriz[x0][y0 + 1] = 0;

                //Calcular o custo
                custo = 0;
                for (int i = 0; i < 3; i++) {
                    for(int j=0 ; j< 3 ; j++){
                        if(matriz[i][j] != sol[i][j])
                            custo++;
                    }
                }

                //No eventualmente criado
                No noFilho = new No(novo, matriz, "Direita", prof + 1, custo);

                //Onde adicionar
                int k = 0;
                for (int i = 0; i < V.size(); i++) {
                    int matriz_teste[][] = V.get(i).getMatriz();

                    if (jogo_oito.Verificar(matriz, matriz_teste) != true)
                        k++;
                }

                //Nao esta presente nos visitados
                if (k == V.size()) {
                    if (L.isEmpty()) {
                        L.add(noFilho);
                        contador++;
                    }
                    else {
                        int custo_teste=0;

                        for (int m = 0; m < L.size(); m++) {
                            custo_teste = L.get(m).getCusto();
                            if (custo < custo_teste) {
                                L.add(m, noFilho);

                                contador++;
                                break;
                            }
                        }
                    }
                }
            }

            matriz = novo.getMatriz();


            //***Mover para Esquerda***
            if (y0 != 0) {
                matriz[x0][y0] = matriz[x0][y0 - 1];
                matriz[x0][y0 - 1] = 0;

                //Calcular o custo
                custo = 0;
                for (int i = 0; i < 3; i++) {
                    for(int j=0 ; j< 3 ; j++){
                        if(matriz[i][j] != sol[i][j])
                            custo++;
                    }
                }

                //No eventualmente criado
                No noFilho = new No(novo, matriz, "Esquerda", prof + 1, custo);

                //Onde adicionar
                int k = 0;
                for (int i = 0; i < V.size(); i++) {
                    int matriz_teste[][] = V.get(i).getMatriz();

                    if (jogo_oito.Verificar(matriz, matriz_teste) != true)
                        k++;
                }

                //Nao esta presente nos visitados
                if (k == V.size()) {
                    if (L.isEmpty()) {
                        L.add(noFilho);
                        contador++;
                    }
                    else {
                        int custo_teste=0;

                        for (int m = 0; m < L.size(); m++) {
                            custo_teste = L.get(m).getCusto();
                            if (custo < custo_teste) {
                                L.add(m, noFilho);

                                contador++;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}

