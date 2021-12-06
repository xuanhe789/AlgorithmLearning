package 字符串匹配;


import java.util.LinkedList;

public class AC{
    ACNode root=new ACNode('/');

    /*
    * 构造所有节点的失败指针
    * 每个节点的失败指针的构造依赖其父节点的失败指针
    * */
    public void buildFailurePointer() {
        //从root节点开始构造
        LinkedList<ACNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //从队列中弹出父节点
            ACNode parent = queue.removeFirst();
            //根据父节点构造其所有子节点的失败指针
            for (int i=0;i<26;i++){
                ACNode pc=parent.childrens[i];
                if (pc==null){
                    continue;
                }
                //当父节点为root时，所有子节点的失败指针都指向root
                if (parent==root){
                    pc.fail=root;
                    continue;
                }
                //当父节点不为root时，则需要通过父节点的fail指针去寻找子节点的fail指针
                ACNode parentFail=parent.fail;
                while (parentFail!=null){
                    if (parentFail.childrens[i]!=null){
                        pc.fail=parentFail.childrens[i];
                        break;
                    }
                    parentFail=parentFail.fail;
                }
                //如果parentFail==null，说明了根节点下面也没有与之匹配的子节点
                // 说明这串字符在Trie树中没有可以匹配的后缀子串，因此让其指向root
                if (parentFail==null){
                    pc.fail=root;
                }
                //将该节点加入队列，后续为其子节点构造失败指针
                queue.add(pc);
            }
        }
    }

}

class ACNode {
    ACNode[] childrens=new ACNode[26];
    boolean isEnd;
    char data;
    //当isEnd为true时，记录单词的长度
    int length;
    //失败指针
    ACNode fail;

    public ACNode(char data) {
        this.data=data;
    }

}
