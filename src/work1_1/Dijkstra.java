package work1_1;


public class Dijkstra {
    static int M = 10000000;               //��ʾ������֮��û��·

    public static void main(String[] args) {
        int weight[][] = {
                {0, M, 10, M, 30, 100},
                {M, 0, 5, M, M, M},
                {M, M, 0, 50, M, M},
                {M, 10, M, 0, M, 10},
                {M, M, M, 20, 0, 60},
                {M, M, M, M, M, 0}
        };
        int start = 0;                     //��ʾ��Դ�㿪ʼ
        int shortPath[] = Dijkstra(weight, start);      //�洢ÿһ�ε����·���ĳ���
        for (int i = 0; i < shortPath.length; i++) {
            //˵��start�㵽i��û�����·
            if (shortPath[i] == M) {
                continue;
            }
            System.out.println("��" + start + "������" + i + "��̾����ǣ�" + shortPath[i]);
        }
    }

    private static int[] Dijkstra(int[][] weight, int start) {
        // TODO Auto-generated method stub
        int n = weight.length;               //����ĸ���
        int shortPath[] = new int[n];         //����start��������������·��
        String path[] = new String[n];       //�洢ÿһ��������start������������ַ�����ʾ
        for (int i = 0; i < n; i++) {
            path[i] = start + "->" + i;
        }
        int visited[] = new int[n];           //��ǵ�ǰ�ö�������·���Ƿ��������1��ʾ���
        //���г�ʼ������һ�������Ѿ����
        shortPath[start] = 0;
        visited[start] = 1;
        for (int count = 1; count < n; count++) {     //����n-1�����
            int k = 0;                      //ѡ��һ�������ʼ���������δ����ǵĵ�
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                //��ʾ�õ�δȷ�����·��������start���õ���ֱ������
                if (visited[i] == 0 && weight[start][i] < min) {
                    min = weight[start][i];
                    k = i;
                }
            }
            //����ѡ���Ķ�����Ϊ��������·��������·������Ϊmin
            shortPath[k] = min;
            visited[k] = 1;
            //��ʱk��Ϊ�м�㣬����һ�������ж�start��δ���ʵ�������ľ���
            for (int i = 0; i < n; i++) {
                //��ʾ��start������i��һ��·�Ǿ�������k��Ҫ��startֱ�ӵ�����iҪ����̣�����
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
            System.out.println("��" + start + "������" + i + "�����·����" + path[i]);
        }
        return shortPath;
    }
}

