package 剑指;
//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
//
//         
//
//        示例 1：
//
//        输入：m = 2, n = 3, k = 1
//        输出：3
//        示例 2：
//
//        输入：m = 3, n = 1, k = 0
//        输出：1
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 机器人的运动范围 {
    int row;
    int col;
    int sum;
    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        row=m;
        col=n;
        sum=0;
        //从（0，0）节点出发
        dfs(visited,0,0,k);
        return sum;

    }

    public void dfs(boolean[][] visited, int m,int n,int k){
        if (m<0||m==row||n<0||n==col||visited[m][n]==true||sum(m, n)>k){
            return ;
        }
        visited[m][n]=true;
        sum++;
        dfs(visited,m,n+1,k);
        dfs(visited,m+1,n,k);
    }

    public int sum(int row,int col){
        int res=0;
        while (row!=0){
            res+=row%10;
            row=row/10;
        }
        while(col!=0){
            res+=col%10;
            col=col/10;
        }
        return res;
    }
}
