package work1_2;

import java.util.Arrays;
import java.util.Scanner;

public class MServer {
    private static int n, s;
    private static int[] time;
    private static int[] sum, total;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            n = input.nextInt();
            s = input.nextInt();

            time = new int[n];
            sum = new int[s];
            total = new int[s];

            for (int i = 0; i < n; i++)
                time[i] = input.nextInt();

            Arrays.sort(time);

            double result = greedy();

            System.out.println(String.format("%.4f", result));
        }
    }

    private static double greedy() {
        int i = 0, j = 0;
        while (i < n) {
            sum[j] += time[i];
            total[j] += sum[j];
            i++;
            j++;
            if (j == s) j = 0;
        }
        double totalTime = 0;
        for (i = 0; i < s; i++)
            totalTime += total[i];
        totalTime /= n;

        return totalTime;
    }

}
