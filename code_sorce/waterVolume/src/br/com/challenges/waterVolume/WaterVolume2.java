package br.com.challenges.waterVolume;

/**
 * Created by pablo on 1/28/18.
 * pure way
 */
public class WaterVolume2 {
    static int solution(int[][] array2D) {

        int count = 0;
        int volume = 0;

        //for each 1s saves their distance - left,right,top,bottom
        int[] listDistanceDirections = new int[0];

        //for each 1s saves the smallest distance
        int[] listDistance = new int[0];

        //move the array2d from left to right
        for (int row = 0; row < array2D.length; row++) {
            for (int column = 0; column < array2D.length; column++) {

                //System.out.print(Arrays.toString(new int[]{row, column}));
                if (array2D[row][column] != 0) {

                    // Count the distance from the current position to the left
                    for (int positionColumn = column; positionColumn >= 0; positionColumn--) {
                        if (array2D[row][positionColumn] == 0) {

                            listDistanceDirections = addInt(listDistanceDirections, count);

                            break;
                        } else {
                            count++;
                        }

                    }

                    count = 0;
                    // Count the distance from the current position to the right
                    for (int positionColumn = column; positionColumn <= array2D.length - 1; positionColumn++) {
                        if (array2D[row][positionColumn] == 0) {

                            listDistanceDirections = addInt(listDistanceDirections, count);
                            break;
                        } else {
                            count++;
                        }
                    }

                    count = 0;
                    // Count the distance from the current position to the top
                    for (int positionRow = row; positionRow >= 0; positionRow--) {
                        if (array2D[positionRow][column] == 0) {

                            listDistanceDirections = addInt(listDistanceDirections, count);
                            break;
                        } else {
                            count++;
                        }


                    }

                    count = 0;
                    // Count the distance from the current position to the bottom
                    for (int positionRow = row; positionRow <= array2D.length - 1; positionRow++) {
                        if (array2D[positionRow][column] == 0) {

                            listDistanceDirections = addInt(listDistanceDirections, count);
                            break;
                        } else {
                            count++;
                        }
                    }


                    //An exception if array not having a distance close to 0
                    if (listDistanceDirections.length == 0) {
                        count = 0;
                        // Count the distance from the current position to the left
                        for (int positionColumn = column; positionColumn >= 0; positionColumn--) {
                            if (array2D[row][positionColumn] == 1) {
                                count++;
                            }

                        }
                        //listDistanceDirections.add(count);
                        listDistanceDirections = addInt(listDistanceDirections, count);
                        count = 0;
                        // Count the distance from the current position to the right
                        for (int positionColumn = column; positionColumn <= array2D.length - 1; positionColumn++) {
                            if (array2D[row][positionColumn] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections = addInt(listDistanceDirections, count);
                        count = 0;
                        // Count the distance from the current position to the top
                        for (int positionRow = row; positionRow >= 0; positionRow--) {
                            if (array2D[positionRow][column] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections = addInt(listDistanceDirections, count);
                        count = 0;
                        // Count the distance from the current position to the bottom
                        for (int positionRow = row; positionRow <= array2D.length - 1; positionRow++) {
                            if (array2D[positionRow][column] == 1) {
                                count++;
                            }

                        }
                        listDistanceDirections = addInt(listDistanceDirections, count);
                    }

                    listDistance = addInt(listDistance, minNumber(listDistanceDirections));

                    count = 0;
                    listDistanceDirections = new int[0];

                }

            }

        }

        int[] aux = findUniqueNumbers(listDistance);
        // Here I calculate the frequency of a number by their equal distance
        for (int a : aux) {

            volume += a * frequencyArray(listDistance, a);

        }

        return volume;

    }

    //get unique numbers in array
    private static int[] findUniqueNumbers(int[] input) {
        int[] newArray = new int[0];

        for (int anInput : input) {
            if (!contains(newArray, anInput)) {
                newArray = addInt(newArray, anInput);
            }
        }

        return newArray;
    }

    // if some number contein in array
    private static boolean contains(final int[] array, final int key) {
        for (final int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }


    //the shorter number of list
    private static int minNumber(int[] distancia) {
        int result = distancia[0];
        int next;

        for (int i = 1; i < distancia.length; i++) {

            next = distancia[i];

            if (result > next) {
                result = next;
            }

        }

        return result;
    }

    // frequency number in array
    private static int frequencyArray(int[] array, int number) {
        int result = 0;

        if (array.length != 0) {

            for (int frequency : array) {

                if (frequency == number) {
                    result++;
                }

            }

        }

        return result;
    }

    //add number in array[]
    private static int[] addInt(int[] array, int newInt) {
        //create a new array with extra index
        int[] newArray = new int[array.length + 1];

        //copy the integers from array to newArray
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        //add the new integer to the last index
        newArray[newArray.length - 1] = newInt;


        return newArray;

    }
}
