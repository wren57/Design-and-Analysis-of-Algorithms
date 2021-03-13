package ex01;

import java.util.Scanner;

/**
 * @author WangJiayi
 * @since 2021-03-10
 */
public class Kruskal {
    //记录每个顶点在并查集中的父亲
    private static int father[];

    public static void main(String[] args) {
        //Kruskal算法求最小生成树
        Kruskal();
    }

    public static void Kruskal(){
        TreeK tree = new TreeK();
        //初始化树的顶点数、边数、权值
        Scanner scanner = new Scanner(System.in);
        tree.nodeNum=scanner.nextInt();
        tree.edgeNum=scanner.nextInt();
        tree.edge=new Edge[tree.edgeNum];
        for (int i = 0; i < tree.edgeNum; i++) {
            tree.edge[i]=new Edge(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        }
        //记录顶点是否被访问过
        boolean[] visited=new boolean[tree.nodeNum];
        //初始化每个节点的父亲
        father=new int[tree.nodeNum];
        for (int i = 0; i < tree.nodeNum; i++)  father[i]=i;
        //记录形成的最小生成树的权值
        int result=0;
        //将树的边按照权值大小进行升序排序；
        for(int i=0;i<tree.edgeNum;++i){
            for(int j=i+1;j<tree.edgeNum;++j){
                if(tree.edge[j].w<tree.edge[i].w){
                    Edge temp=tree.edge[i];
                    tree.edge[i]=tree.edge[j];
                    tree.edge[j]=temp;
                }
            }
        }
        //n个顶点仅需n-1条边构成最小生成树
        int count=tree.nodeNum-1;
        for(int j=0;j<tree.edgeNum;++j){
            if(count==0)    break;
            //通过并查集判断当前两个端点是否在同一个集合中
            if(find(tree.edge[j].u)!=find(tree.edge[j].v)){
                union(tree.edge[j].u,tree.edge[j].v);
                result+=tree.edge[j].w;
                count--;
            }
        }
        System.out.println(result);
    }

    //并查集判断是否会成环
    public static int find(int x){
        if(x!=father[x])    return find(father[x]);
        return x;
    }

    public static void union(int x, int y){
        father[find(y)]=find(x);
    }

}

class TreeK {
    int nodeNum,edgeNum;
    Edge edge[];
}

class Edge{
    int u,v,w;
    public Edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}