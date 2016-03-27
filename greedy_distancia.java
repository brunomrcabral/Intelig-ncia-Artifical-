import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class greedy_distancia {
    public static void gree_dist ( ArrayList<No> L, ArrayList<No> V, int[][] sol) {

        int custo = 0;
        int n = 0;
        int iguais = 0, xi = 0, contador = 0;
        int prof;

        //Array com a posicao desejada
        int f[] = new int[9];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                f[n] = sol[i][j];
                n++;
            }
        }
        n = 0;

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

                //Array posicao
                int cima[] = new int[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        cima[n] = matriz[i][j];
                        n++;
                    }
                }
                n = 0;

                //Calcular o custo
                custo = 0;
                for (int i = 0; i < 9; i++) {
                    if (cima[i] != f[i]) {
                        for (int j = 0; j < 9; j++) {
                            if (f[j] == cima[i]) {
                                if (j > i)
                                    custo += (cima[j] - f[i]);
                                else
                                    custo += f[i] - cima[j];
                            }
                        }
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

                //Array posicao
                int baixo[] = new int[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        baixo[n] = matriz[i][j];
                        n++;
                    }
                }
                n = 0;

                //Calcular o custo
                custo = 0;
                for (int i = 0; i < 9; i++) {
                    if (baixo[i] != f[i]) {
                        for (int j = 0; j < 9; j++) {
                            if (f[j] == baixo[i]) {
                                if (j > i)
                                    custo += (baixo[j] - f[i]);
                                else
                                    custo += f[i] - baixo[j];
                            }
                        }
                    }
                }

                //No eventualmente criado
                No noFilho = new No(novo, matriz, "Baixo", prof + 1, custo);

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

            //***Mover para Direita***
            if (y0 != 2) {
                matriz[x0][y0] = matriz[x0][y0 + 1];
                matriz[x0][y0 + 1] = 0;

                //Array posicao
                int direita[] = new int[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        direita[n] = matriz[i][j];
                        n++;
                    }
                }
                n = 0;

                //Calcular o custo
                custo = 0;
                for (int i = 0; i < 9; i++) {
                    if (direita[i] != f[i]) {
                        for (int j = 0; j < 9; j++) {
                            if (f[j] == direita[i]) {
                                if (j > i)
                                    custo += (direita[j] - f[i]);
                                else
                                    custo += f[i] - direita[j];
                            }
                        }
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

                //Array posicao
                int esquerda[] = new int[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        esquerda[n] = matriz[i][j];
                        n++;
                    }
                }
                n = 0;

                //Calcular o custo
                custo = 0;
                for (int i = 0; i < 9; i++) {
                    if (esquerda[i] != f[i]) {
                        for (int j = 0; j < 9; j++) {
                            if (f[j] == esquerda[i]) {
                                if (j > i)
                                    custo += (esquerda[j] - f[i]);
                                else
                                    custo += f[i] - esquerda[j];
                            }
                        }
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
