package br.com.challenges.waterVolume;

import java.util.*;

/**
 * Created by pablo on 7/4/17.
 */
public class WaterVolume {


    static int waterVolumeCalc(int[][] array2D) {

        int count = 0;
        int volume = 0;

        //for each 1s saves their distance - left,right,top,bottom
        List<Integer> listDistanceDirections = new ArrayList<>();

        //for each 1s saves the smallest distance
        List<Integer> listDistance = new ArrayList<>();

        //move the array2d from left to right
        for (int linha = 0; linha < array2D.length; linha++) {
            for (int coluna = 0; coluna < array2D.length; coluna++) {

                //System.out.print(Arrays.toString(new int[]{linha, coluna}));
                if (array2D[linha][coluna] != 0) {

                    // Count the distance from the current position to the left
                    for (int posicaoColuna = coluna; posicaoColuna >= 0; posicaoColuna--) {
                        if (array2D[linha][posicaoColuna] == 0) {
                            listDistanceDirections.add(count);
                            break;
                        } else {
                            count++;
                        }

                    }

                    count = 0;
                    // Count the distance from the current position to the right
                    for (int posicaoColuna = coluna; posicaoColuna <= array2D.length - 1; posicaoColuna++) {
                        if (array2D[linha][posicaoColuna] == 0) {
                            listDistanceDirections.add(count);
                            break;
                        } else {
                            count++;
                        }
                    }

                    count = 0;
                    // Count the distance from the current position to the top
                    for (int posicaoLinha = linha; posicaoLinha >= 0; posicaoLinha--) {
                        if (array2D[posicaoLinha][coluna] == 0) {
                            listDistanceDirections.add(count);
                            break;
                        } else {
                            count++;
                        }


                    }

                    count = 0;
                    // Count the distance from the current position to the bottom
                    for (int posicaoLinha = linha; posicaoLinha <= array2D.length - 1; posicaoLinha++) {
                        if (array2D[posicaoLinha][coluna] == 0) {
                            listDistanceDirections.add(count);
                            break;
                        } else {
                            count++;
                        }
                    }


                    //An exception if array not having a distance close to 0
                    if (listDistanceDirections.isEmpty()) {
                        count = 0;
                        // contar a distancia da posicao atual para a esquerda
                        for (int posicaoColuna = coluna; posicaoColuna >= 0; posicaoColuna--) {
                            if (array2D[linha][posicaoColuna] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections.add(count);
                        count = 0;
                        // contar a distancia da posicao atual para a direita
                        for (int posicaoColuna = coluna; posicaoColuna <= array2D.length - 1; posicaoColuna++) {
                            if (array2D[linha][posicaoColuna] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections.add(count);
                        count = 0;
                        // contar a distancia da posicao atual para a cima
                        for (int posicaoLinha = linha; posicaoLinha >= 0; posicaoLinha--) {
                            if (array2D[posicaoLinha][coluna] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections.add(count);
                        count = 0;
                        // contar a distancia da posicao atual para a baixo
                        for (int posicaoLinha = linha; posicaoLinha <= array2D.length - 1; posicaoLinha++) {
                            if (array2D[posicaoLinha][coluna] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections.add(count);
                    }


                    listDistance.add(Collections.min(listDistanceDirections));
                    count = 0;
                    listDistanceDirections = new ArrayList<>();

                }

            }

        }

        //converting List<> to Integer[]
        Integer[] finalResult = new Integer[listDistance.size()];
        finalResult = listDistance.toArray(finalResult);
        HashSet<Integer> uniquesNumbers = new HashSet<>(Arrays.asList(finalResult));

        // Here I calculate the frequency of a number by their equal distance
        for (int a : uniquesNumbers) {

            volume += a * Collections.frequency(listDistance, a);

        }

        return volume;

    }

}
