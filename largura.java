import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class largura {
    public static void larg( ArrayList<No> L ,int [][] sol){
        int contador = 0;
        int iguais = 0, xi = 0;
        int prof;
        while (xi != 1) {
            int x0 = 0;
            int y0 = 0;

            No novo = L.get(0);
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
            if (x0 != 0 && !novo.operador.equals("Baixo")) {
                int x = matriz[x0 - 1][y0];
                matriz[x0 - 1][y0] = 0;
                matriz[x0][y0] = x;

                No noFilho = new No(novo, matriz, "Cima", prof + 1, 0);
                L.add(noFilho);
                contador++;
            }

            matriz = novo.getMatriz();

            //***Mover para baixo***
            if (x0 != 2 && !novo.operador.equals("Cima")) {
                int x = matriz[x0 + 1][y0];
                matriz[x0 + 1][y0] = 0;
                matriz[x0][y0] = x;

                No noFilho = new No(novo, matriz, "Baixo", prof + 1, 0);
                L.add(noFilho);
                contador++;
            }

            matriz = novo.getMatriz();

            //***Mover para Direita***
            if (y0 != 2 && !novo.operador.equals("Esquerda")) {
                int x = matriz[x0][y0 + 1];
                matriz[x0][y0 + 1] = 0;
                matriz[x0][y0] = x;

                No noFilho = new No(novo, matriz, "Direita", prof + 1, 0);
                L.add(noFilho);
                contador++;
            }

            matriz = novo.getMatriz();

            //***Mover para Esquerda***
            if (y0 != 0 && !novo.operador.equals("Direita")) {
                int x = matriz[x0][y0 - 1];
                matriz[x0][y0 - 1] = 0;
                matriz[x0][y0] = x;

                No noFilho = new No(novo, matriz, "Esquerda", prof + 1, 0);
                L.add(noFilho);
                contador++;
            }
            //System.out.println(L.size());
        }
    }
}