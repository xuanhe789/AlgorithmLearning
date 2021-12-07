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

    /*
    * 匹配逻辑
    * */
    public void match(char[] text){
        int length=text.length;
        //从根节点开始查找
        ACNode p=root;
        for (int i=0;i<length;i++){
            char c=text[i];
            int index=c-'a';
            //1.失败指针起作用的地方，如果当前节点的子节点不匹配当前字符，则指向其fail
            //2.然后再判断fail是否有匹配当前字符的子节点，如果不符合，则重复1
            //如果退出了while循环，说明有两种情况：
            // 1.p==null:搜了所有fail节点，包括root，没有与其匹配的子节点，说明没有以匹配该字符的单词存在，因此将p指向root，开启下一轮循环
            // 2.p.childrens[index]!=null:说明存在匹配，然后p指向其对应的子节点，判断p是否是单词的结尾节点，如果不是，则q则指向指向其fail
            //然后继续判断p.isEnd，重点：这样做是为了防止漏掉了某个以当前字符结尾的单词
            while (p!=null&&p.childrens[index]==null){
                p=p.fail;
            }
            if (p==null){
                p=root;
                continue;
            }
            p=p.childrens[index];
            //如果p==root的话，说明已经没有以当前字符结尾的单词了，开启下一轮循环
            while (p!=root){
                //如果找到当前以当前字符结尾的单词，则打印起始位置和长度，然后将p指向root，开启下一轮循环
                if (p.isEnd){
                    int pos = i-p.length+1;
                    System.out.println("匹配起始下标" + pos + "; 长度" + p.length);
                    p=root;
                    break;
                }
                p=p.fail;
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
