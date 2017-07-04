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
        for (int row = 0; row < array2D.length; row++) {
            for (int column = 0; column < array2D.length; column++) {

                //System.out.print(Arrays.toString(new int[]{row, column}));
                if (array2D[row][column] != 0) {

                    // Count the distance from the current position to the left
                    for (int positionColumn = column; positionColumn >= 0; positionColumn--) {
                        if (array2D[row][positionColumn] == 0) {
                            listDistanceDirections.add(count);
                            break;
                        } else {
                            count++;
                        }

                    }

                    count = 0;
                    // Count the distance from the current position to the right
                    for (int positionColumn = column; positionColumn <= array2D.length - 1; positionColumn++) {
                        if (array2D[row][positionColumn] == 0) {
                            listDistanceDirections.add(count);
                            break;
                        } else {
                            count++;
                        }
                    }

                    count = 0;
                    // Count the distance from the current position to the top
                    for (int positionRow = row; positionRow >= 0; positionRow--) {
                        if (array2D[positionRow][column] == 0) {
                            listDistanceDirections.add(count);
                            break;
                        } else {
                            count++;
                        }


                    }

                    count = 0;
                    // Count the distance from the current position to the bottom
                    for (int positionRow = row; positionRow <= array2D.length - 1; positionRow++) {
                        if (array2D[positionRow][column] == 0) {
                            listDistanceDirections.add(count);
                            break;
                        } else {
                            count++;
                        }
                    }


                    //An exception if array not having a distance close to 0
                    if (listDistanceDirections.isEmpty()) {
                        count = 0;
                        // Count the distance from the current position to the left
                        for (int positionColumn = column; positionColumn >= 0; positionColumn--) {
                            if (array2D[row][positionColumn] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections.add(count);
                        count = 0;
                        // Count the distance from the current position to the right
                        for (int positionColumn = column; positionColumn <= array2D.length - 1; positionColumn++) {
                            if (array2D[row][positionColumn] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections.add(count);
                        count = 0;
                        // Count the distance from the current position to the top
                        for (int positionRow = row; positionRow >= 0; positionRow--) {
                            if (array2D[positionRow][column] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections.add(count);
                        count = 0;
                        // Count the distance from the current position to the bottom
                        for (int positionRow = row; positionRow <= array2D.length - 1; positionRow++) {
                            if (array2D[positionRow][column] == 1) {
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
