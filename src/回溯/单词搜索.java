package 回溯;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//        单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//         
//
//        示例:
//
//        board =
//        [
//        ['A','B','C','E'],
//        ['S','F','C','S'],
//        ['A','D','E','E']
//        ]
//
//        给定 word = "ABCCED", 返回 true
//        给定 word = "SEE", 返回 true
//        给定 word = "ABCB", 返回 false
//         
//
//        提示：
//
//        board 和 word 中只包含大写和小写英文字母。
//        1 <= board.length <= 200
//        1 <= board[i].length <= 200
//        1 <= word.length <= 10^3
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/word-search
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (dfs(board,visited,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,boolean[][]visited ,String word,int i,int j,int index){
        if (i<0||i==board.length||j<0||j==board[0].length||board[i][j]!=word.charAt(index)||visited[i][j]){
            return false;
        }
        if (index==word.length()-1) {
            return true;
        }
        //设置状态，表示已被访问过
        visited[i][j]=true;
        boolean flag=dfs(board,visited,word,i+1,j,index+1)
                ||dfs(board,visited,word,i-1,j,index+1)
                ||dfs(board,visited,word,i,j+1,index+1)
                ||dfs(board,visited,word,i,j-1,index+1);
        if (!flag){
            visited[i][j]=false;
        }
        return flag;
    }
}
