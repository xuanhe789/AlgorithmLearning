package leetcodeHOT100;

import java.util.ArrayList;
import java.util.List;

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
//        在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
//
//        例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
//        请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
//
//         
//
//        示例 1：
//
//        输入：numCourses = 2, prerequisites = [[1,0]]
//        输出：true
//        解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
//        示例 2：
//        输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//        输出：false
//        解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/course-schedule
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class _207_课程表 {
    //思路：i从0到numCourses开始执行DFS，用一个int[]数组表示某个节点的状态，
    //-1已被其他节点启动的 DFS 访问，表示无环，直接返回false
    // 1表示已被当前节点启动的 DFS 访问，表示有环，返回true
    //举个例子:[[1,3],[2,1],[0,3]]
    //i范围从0到3，有4个节点
    //0->空，无环
    //1->2>空，无环
    //2>空，无环
    //由于学习第三门课后，可以学习两门课程(0,1)所以
    //3->0->空，无环
    //3->1->2->空，无环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> listList=new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            listList.add(new ArrayList<Integer>());
        }
        int[] flag = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            listList.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i=0;i<numCourses;i++){
            if (dfs(listList,flag,i)){
                return false;
            }
        }
        return true;

    }
    /*
    * 返回true代表有环
    * */
    public boolean dfs(List<List<Integer>> listList,int[] flag,int num){
        //1表示已被当前节点启动的 DFS 访问，表示有环，返回true
        if (flag[num]==1){
            return true;
        }
        //-1已被其他节点启动的 DFS 访问，表示无环，直接返回false
        if (flag[num]==-1){
            return false;
        }
        //将状态设为，然后进行对当前节点进行dfs，如果后续无环，则修改状态为-1；
        flag[num]=1;
        for (Integer integer : listList.get(num)) {
            if (dfs(listList,flag,integer)){
                return true;
            }
        }
        //将状态修改为-1，代表这个节点形不成环
        flag[num]=-1;
        return false;
    }
}
