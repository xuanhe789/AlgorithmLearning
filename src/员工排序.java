//员工排序，给出公司的职员编号,身高和性别的信息，根据特定的规则对进行排序并输出。
//        女生在男生前面，如果性别相同，较矮的排前面。如果，身高也相同，编号较小的排前面。
//        输入是一个二维数组a[n] [3]第二维度的3个数字分别代表员工编号，身高和性别。其中性别0为女生，1位男生。 输出，按照排序顺序输出员工编号
public class 员工排序 {
    public static int[][] solution(int[][] arrs){
        //先对性别排序
        for (int i=0;i<arrs.length-1;i++){
            for (int j=0;j<arrs.length-i-1;j++){
                if (arrs[j][2]>arrs[j+1][2]){
                    int[] temp=arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=temp;
                }
            }
        }
        //计算女性的人数
        int women=0;
        for (int i=0;i<arrs.length;i++){
            if (arrs[i][2]==0){
                women++;
            }
        }
        //对女生的身高和编号排序
        for (int i=0;i<women-1;i++){
            for (int j=0;j<women-1-i;j++){
                if (arrs[j][1]>arrs[j+1][1]){
                    int[] temp=arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=temp;
                    continue;
                }
                if (arrs[j][1]==arrs[j+1][1]&&arrs[j][0]>arrs[j+1][0]){
                    int[] temp=arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=temp;
                }
            }
        }

        //对男生的身高和编号排序
        for (int i=0;i<arrs.length-1;i++){
            for (int j=women;j<arrs.length-1-i;j++){
                if (arrs[j][1]>arrs[j+1][1]){
                    int[] temp=arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=temp;
                    continue;
                }
                if (arrs[j][1]==arrs[j+1][1]&&arrs[j][0]>arrs[j+1][0]){
                    int[] temp=arrs[j];
                    arrs[j]=arrs[j+1];
                    arrs[j+1]=temp;
                }
            }
        }
        return arrs;
    }

    public static void main(String[] args) {
        int[][] a = {{1,171,0},{2,171,0},{3,172,1},{4,173,1},{5,174,0},{6,171,1},{7,168,0}};
        int[][] solution = solution(a);
        for (int[] arr:solution){
            System.out.println(arr[0]);
        }
    }
}
