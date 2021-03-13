package ex01;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-03-10
 */
public class Prim {
    public static void main(String[] args) {
        TreeP tree = new TreeP();
        //记录形成的最小生成树的权值
        int result=0;
        //初始化树的顶点数、边数、权值
        Scanner scanner = new Scanner(System.in);
        tree.nodeNum=scanner.nextInt();
        tree.edgeNum=scanner.nextInt();
        tree.edge=new int[tree.nodeNum][tree.nodeNum];
        for(int i=0;i< tree.nodeNum;++i){
            for(int j=0;j< tree.nodeNum;++j){
                tree.edge[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < tree.edgeNum; i++) {
            int u=scanner.nextInt();
            int v=scanner.nextInt();
            tree.edge[u][v]=tree.edge[v][u]=scanner.nextInt();
        }
        //存放有效边的权值
        int[] lowCost=new int[tree.nodeNum];
        for(int i=1;i<tree.nodeNum;++i){
            lowCost[i]= tree.edge[0][i];
        }
        //形成最小生成树，并迭代有效边的权值
        for(int i=0;i<tree.nodeNum-1;++i){
            int index=0;
            int minn=Integer.MAX_VALUE;
            for(int j=0;j<tree.nodeNum;++j){
                if(lowCost[j]!=0 && lowCost[j]<minn){
                    minn=lowCost[j];
                    index=j;
                }
            }
            if(index==0)    break;
            lowCost[index]=0;
            result+=minn;
            for(int j=0;j<tree.nodeNum;++j){
                if(tree.edge[index][j]!=Integer.MAX_VALUE && tree.edge[index][j]<lowCost[j]){
                    lowCost[j]=tree.edge[index][j];
                }
            }
        }
        System.out.println(result);
    }
}

class TreeP{
    int nodeNum,edgeNum;
    int[][] edge;
}