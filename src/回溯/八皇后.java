package 回溯;

import java.util.Arrays;

public class 八皇后 {
    int[] result=new int[8];//下标表示行，值对应皇后所在的列
    int count=0;//计数器

    {
        Arrays.fill(result,-1);
    }
    /*
     * 寻找所有八皇后的棋子摆放
     * 遍历每一种摆放情况，找到符合的摆放并打印
     * 对第row行的所有列进行摆放，如果某一列能够摆放，则继续往下一行尝试
     * */
    public void cal8queens(int row) {
        //如果row==8，说明当前棋盘每一行的摆放符合八皇后，打印棋盘
        if (row==8){
            count++;
            printQueens(result);
            return;
        }
        //从row行第一列开始摆放
        for (int colum=0;colum<8;colum++){
            //判断row行colum列是否能够摆放，如果可以，则摆放下一行
            if (isOK(row,colum)){
                //设置row行皇后的摆放列为colum
                result[row]=colum;
                cal8queens(row+1);
            }
            //状态回归，回溯，其实这里不需要这一行，为了方便理解回溯算法，特意加的
            result[row]=-1;
        }
    }
    /*
    * 判断row行colum列能否摆放皇后
    * 从后前面的行遍历，判断colum列的正上方、左上对角线以及右上对角线是否有皇后
    * 如果有皇后说明当前位置不能摆放，返回false
    * */
    private boolean isOK(int row, int colum) {
        // 左斜上方         右斜上方
        int leftup=colum-1,rightup=colum+1;
        //主键往上判断每一行
        for ( row=row-1;row>=0;row--){
            //判断row行的col um列是否有皇后
            if (result[row]==colum){
                return false;
            }
            //判断左上对角线，leftup列是否有皇后
            if (leftup>=0&&result[row]==leftup){
                return false;
            }
            //判断右上对角线，rightup列是否右皇后
            if (rightup<8&&result[row]==rightup){
                return false;
            }
            leftup--;
            rightup++;
        }
        //所有情况都没有皇后摆放，说明当前这个位置可以摆放皇后，返回true
        return true;
    }

    private void printQueens(int[] result) {
        //打印八皇后
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println(count);
        System.out.println("----------");
    }


}
