package work1_1;


public class Dijkstra {
    static int M = 10000000;               //表示两顶点之间没有路

    public static void main(String[] args) {
        int weight[][] = {
                {0, M, 10, M, 30, 100},
                {M, 0, 5, M, M, M},
                {M, M, 0, 50, M, M},
                {M, 10, M, 0, M, 10},
                {M, M, M, 20, 0, 60},
                {M, M, M, M, M, 0}
        };
        int start = 0;                     //表示从源点开始
        int shortPath[] = Dijkstra(weight, start);      //存储每一次的最短路径的长度
        for (int i = 0; i < shortPath.length; i++) {
            //说明start点到i点没有最短路
            if (shortPath[i] == M) {
                continue;
            }
            System.out.println("从" + start + "出发到" + i + "最短距离是：" + shortPath[i]);
        }
    }

    private static int[] Dijkstra(int[][] weight, int start) {
        // TODO Auto-generated method stub
        int n = weight.length;               //顶点的个数
        int shortPath[] = new int[n];         //保存start到其他各点的最短路径
        String path[] = new String[n];       //存储每一步，保存start到其他各点的字符串表示
        for (int i = 0; i < n; i++) {
            path[i] = start + "->" + i;
        }
        int visited[] = new int[n];           //标记当前该顶点的最短路径是否已求出，1表示求出
        //进行初始化，第一个顶点已经求出
        shortPath[start] = 0;
        visited[start] = 1;
        for (int count = 1; count < n; count++) {     //加入n-1个结点
            int k = 0;                      //选出一个距离初始顶点最近的未被标记的点
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                //表示该点未确定最短路径，并且start到该点有直接连接
                if (visited[i] == 0 && weight[start][i] < min) {
                    min = weight[start][i];
                    k = i;
                }
            }
            //将新选出的顶点标记为已求出最短路径，并且路径长度为min
            shortPath[k] = min;
            visited[k] = 1;
            //此时k作为中间点，来进一步进行判断start到未访问的其他点的距离
            for (int i = 0; i < n; i++) {
                //表示有start到顶点i有一条路是经过顶点k，要比start直接到顶点i要距离短，更新
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                    path[i] = path[k] + "->" + i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (shortPath[i] == M) {
                continue;
            }
            System.out.println("从" + start + "出发到" + i + "的最短路径：" + path[i]);
        }
        return shortPath;
    }
}

