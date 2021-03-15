1. 使用Floyd算法求解有向图中各顶点间的最短距离，并输出顶点之间的最短距离矩阵。![image-20210315153545058](C:\Users\JoyeWang\AppData\Roaming\Typora\typora-user-images\image-20210315153545058.png)

   第一行输入有向图中的顶点数n、边数m；其后m行分别输入边的两个端点以及边的长度。

   ```
   INPUT:
   4 8
   0 1 2
   1 2 3
   0 2 6
   2 0 7
   0 3 4
   3 0 5
   2 3 1
   3 2 12
   
   OUTPUT:
   0 2 5 4 
   9 0 3 4 
   6 8 0 1 
   5 7 10 0 
   ```

   

2. 使用Dijkstra算法求解由起点到终点的最短路径。 ![image-20210315154823266](C:\Users\JoyeWang\AppData\Roaming\Typora\typora-user-images\image-20210315154823266.png)

   第一行输入有向图的顶点数n、边数m；其后m行分别输入边的两个端点以及边的长度。

   ```
   INPUT:
   8 11
   0 1 1
   1 3 2
   2 0 2
   3 2 1
   4 3 2
   3 5 8
   5 4 2
   4 6 2
   6 7 3
   7 5 2
   6 5 3
   
   OUTPUT:
   18
   ```

   