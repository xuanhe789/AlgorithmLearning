package 剑指;

public class 矩阵中的路劲 {
    //回溯法模板
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        boolean[][] visited=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                boolean flag=dfs(board,words,visited,i,j,0);
                if (flag){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,char[] words,boolean[][] visited,int i,int j,int index){
        if (i<0 || i==board.length || j<0 || j==board[0].length || board[i][j]!=words[index] || visited[i][j]==true){
            return false;
        }
        if (index==words.length-1){
            return true;
        }
//        设置当前位置的状态，为true表示被访问过
        visited[i][j]=true;
        boolean flag=(dfs(board,words,visited,i,j-1,index+1)
                ||  dfs(board,words,visited,i,j+1,index+1)
                ||  dfs(board,words,visited,i-1,j,index+1)
                ||  dfs(board,words,visited,i+1,j,index+1));
        if (flag){
            return true;
        }
        //此路不通，还原状态，设置为未被访问过
        visited[i][j]=false;
        return false;
    }
}
