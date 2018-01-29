package br.com.challenges.waterVolume;

/**
 * Created by pablo on 7/2/17.
 */
public class WaterVolumeMain {

    public static void main(String[] args) {

        int[][] sample1 =
                {
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0},
                        {1, 1, 1, 1, 1},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 0, 0}
                };

        int[][] sample2 =
                {
                        {1, 1, 1},
                        {1, 0, 0},
                        {1, 0, 0}
                };

        int[][] sample3 =
                {
                        {0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 0},
                        {0, 1, 1, 1, 1, 1, 0},
                        {0, 0, 0, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0}
                };


        System.out.println("Volume: " + WaterVolume2.solution(sample1));
        System.out.println("Volume: " + WaterVolume2.solution(sample2));
        System.out.println("Volume: " + WaterVolume2.solution(sample3));


    }


}