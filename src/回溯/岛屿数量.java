package 回溯;

//    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
//    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
//    此外，你可以假设该网格的四条边均被水包围。
//
//             
//
//    示例 1：
//
//    输入：grid = [
//            ["1","1","1","1","0"],
//            ["1","1","0","1","0"],
//            ["1","1","0","0","0"],
//            ["0","0","0","0","0"]
//            ]
//    输出：1
//    示例 2：
//
//    输入：grid = [
//            ["1","1","0","0","0"],
//            ["1","1","0","0","0"],
//            ["0","0","1","0","0"],
//            ["0","0","0","1","1"]
//            ]
//    输出：3
//             
//
//    提示：
//
//    m == grid.length
//    n == grid[i].length
//1 <= m, n <= 300
//    grid[i][j] 的值为 '0' 或 '1'
//
//    来源：力扣（LeetCode）
//    链接：https://leetcode-cn.com/problems/number-of-islands
//    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 岛屿数量 {
    //回溯法
    //dfs方法： 设目前指针指向一个岛屿中的某一点 (i, j)，寻找包括此点的岛屿边界。
    //从 (i, j) 向此点的上下左右 (i+1,j),(i-1,j),(i,j+1),(i,j-1) 做深度搜索。
    //终止条件：
    //(i, j) 越过矩阵边界;
    //grid[i][j] == 0，代表此分支已越过岛屿边界。
    //搜索岛屿的同时，执行 grid[i][j] = '0'，即将岛屿所有节点删除，以免之后重复搜索相同岛屿。
    //主循环：
    //遍历整个矩阵，当遇到 grid[i][j] == '1' 时，从此点开始做深度优先搜索 dfs，岛屿数 count + 1 且在深度优先搜索中删除此岛屿。
    //
    //作者：jyd
    //链接：https://leetcode-cn.com/problems/number-of-islands/solution/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int numIslands(char[][] grid) {
        if (grid.length==1&&grid[0].length==1){
            return grid[0][0]=='1'?1:0;
        }
        int sum=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    dfs(grid,i,j);
                    sum++;
                }
            }
        }
        return sum;
    }

    public void dfs(char[][] grid, int i,int j){
        if (i<0||i==grid.length||j<0||j==grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}
