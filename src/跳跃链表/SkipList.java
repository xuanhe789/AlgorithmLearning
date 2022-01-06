package 跳跃链表;
/*
* 跳表简单实现
* */
public class SkipList {
    //用于初始化节点的层数
    private static final float SKIPLIST_P = 0.5f;
    //跳跃链表的最大层数
    private static final int MAX_LEVEL = 16;
    private int levelCount = 1;
    private Node head=new Node();

    /*
    * 随机层数生成，规则：从第一层开始往上升，每次往上升的概率为50%
    * 第一层 -> 第二层 ：50%
    * 第二层 -> 第三层 ：50%
    * ...
    * */
    public int randomLevel(){
        int level=1;
        while (Math.random()<SKIPLIST_P&&level<MAX_LEVEL){
            level++;
        }
        return level;
    }

    /*
    * 跳跃链表节点插入
    * */
    public Node insert(int vaule){
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data=vaule;
        newNode.maxLevel=level;
        //新插入节点每层索引的前节点
        Node[] preNodes=new Node[level];
        /*
        * 1.初始化每层索引前置节点，这一步没必要
        * */
//        for (int i=level-1;i>=0;i--){
//            preNodes[i]=head;
//        }
        /*
         * 2.找到当前节点插入位置每层索引的前节点
         * */
        Node p=head;
        for (int i=level-1;i>=0;i--){
            while (p.nextNodes[i]!=null&&p.nextNodes[i].data<vaule){
                p=p.nextNodes[i];
            }
            //此时的p就是新增节点第i层索引的前置节点
            preNodes[i]=p;
        }

        /*
        * 3.将新增节点在所有level的索引下插入
        * */
        for (int i=level-1;i>=0;i--){
            newNode.nextNodes[i]=preNodes[i].nextNodes[i];
            preNodes[i].nextNodes[i]=newNode;
        }
        //更新链表的最大索引层数
        if (level>levelCount){
            levelCount=level;
        }
        return newNode;
    }

    /*
    *跳跃链表查询
    * */
    public Node find(int value){
        Node p=head;
        for (int i=levelCount-1;i>=0;i--){
            while (p.nextNodes[i]!=null&&p.nextNodes[i].data<value){
                p=p.nextNodes[i];
            }
        }
        if (p.nextNodes[0]!=null&&p.nextNodes[0].data==value){
            return p.nextNodes[0];
        }
        return null;
    }

    /*
    * 跳跃链表删除
    * */
    public void delete(int value){
        //删除前需要找到该节点的每层索引的前置节点
        Node[] preNodes = new Node[levelCount];
        Node p=head;
        for (int i=levelCount-1;i>=0;i--){
            while (p.nextNodes[i]!=null&&p.nextNodes[i].data<value){
                p=p.nextNodes[i];
            }
            preNodes[i]=p;
        }
        /*
        * 找到该节点，并删除该节点以及其每层索引的关联
        * */
        if (preNodes[0]!=null&&p.nextNodes[0].data==value){
            Node deleteNode=p.nextNodes[0];
            for (int i=p.nextNodes[0].maxLevel-1;i>=0;i--){
                preNodes[i].nextNodes[i]=deleteNode.nextNodes[i];
                deleteNode.nextNodes[i]=null;
            }
        }
        //更新最大层数
        while (levelCount>1&&head.nextNodes[levelCount]==null){
            levelCount--;
        }
    }


    public class Node {
        private int data = -1;
        private Node nextNodes[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;


        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");


            return builder.toString();
        }
    }
}
