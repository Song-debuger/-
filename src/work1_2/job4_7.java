package work1_2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class job4_7 {
    private static int n, s;
    private static int[] time;
    private static int[] sum, total;

    public static void main(String[] args) throws IOException {
        BufferedReader filein = new BufferedReader(
                new FileReader("input.txt"));    //读入文件数据
        String line1 = filein.readLine();       //读入n，s
        String[] ns = line1.split(" ");
//        Scanner input = new Scanner();

            n = Integer.parseInt(ns[0]);//n个顾客
            s = Integer.parseInt(ns[1]);//s处可以提供服务

            time = new int[n];//存储每个顾客需要的服务时间
            sum = new int[s];
            total = new int[s];

        String line2 = filein.readLine();
        String[] tArray = line2.split(" ");

            for (int i = 0; i < n; i++) {
                time[i] = Integer.parseInt(tArray[i]);//第i个顾客需要等待的时间为time[i]
            }

            Arrays.sort(time);//对每个顾客需要的服务时间从小到大排序

            double result = greedy();//贪心算法计算结果

            PrintWriter fileout = new PrintWriter(new FileWriter("output.txt"));

            fileout.println(result);
            fileout.close();
            filein.close();

//            System.out.println(String.format("%.2f", result));

    }

    /**
     * 贪心算法
     *
     * @return
     */
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
