package leetcodeHOT100;

import java.util.HashMap;
import java.util.Map;

//运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
//        实现 LRUCache 类：
//
//        LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
//        int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//        void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//         
//
//        进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/lru-cache
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class LRUCache {
    private Map<Integer,DLinkedNode> cache=new HashMap<>();
    private int size;
    private DLinkedNode head,tail;
    private int capacity;
    //LRU采用HashMap+双向链表实现
    //Hashmap存储缓存的k-v，记录节点在链表的位置，get等操作方便获取数据
    // 双向链表记录每个k-v的使用情况
    //链表头节点表示最近被使用的缓存，尾节点表示最久未使用的
    public LRUCache(int capacity) {
        size=0;
        this.capacity=capacity;
        head=new DLinkedNode();
        tail=new DLinkedNode();
        head.next=tail;
        tail.prev=head;
    }
//    对于 get 操作，首先判断 key 是否存在：
//
//    如果 key 不存在，则返回 -1−1；
//
//    如果 key 存在，则 key 对应的节点是最近被使用的节点。通过哈希表定位到该节点在双向链表中的位置，并将其移动到双向链表的头部，最后返回该节点的值。
    public int get(int key) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode==null){
            return -1;
        }
        moveToHead(dLinkedNode);
        return dLinkedNode.value;
    }

//    对于 put 操作，首先判断 key 是否存在：
//
//    如果 key 不存在，使用 key 和 value 创建一个新的节点，在双向链表的头部添加该节点，并将 key 和该节点添加进哈希表中。然后判断双向链表的节点数是否超出容量，如果超出容量，则删除双向链表的尾部节点，并删除哈希表中对应的项；
//
//    如果 key 存在，则与 get 操作类似，先通过哈希表定位，再将对应的节点的值更新为 value，并将该节点移到双向链表的头部。
    public void put(int key, int value) {
        DLinkedNode dLinkedNode = cache.get(key);
        if (dLinkedNode!=null){
            moveToHead(dLinkedNode);
            dLinkedNode.value=value;
            return;
        }
        else {
            if (size==capacity){
                DLinkedNode removeNode = removeTail();
                cache.remove(removeNode.key);
                size--;
            }
            DLinkedNode insertNode = new DLinkedNode(key, value);
            cache.put(key,insertNode);
            addToHead(insertNode);;
            size++;

        }

    }

    public void moveToHead(DLinkedNode dLinkedNode){
        //获取节点的前一个节点
        DLinkedNode pre=dLinkedNode.prev;
        //如果上一个节点是头节点，说明当前节点是第一个节点，无需移动
        if (pre==head){
            return;
        }
        //获取节点的后一个节点
        DLinkedNode after=dLinkedNode.next;
        //删除当前获取节点
        pre.next=after;
        after.prev=pre;
        //将当前获取节点插入到第一个节点
        //第一个节点
        DLinkedNode firstNode=head.next;
        head.next=dLinkedNode;
        dLinkedNode.prev=head;
        dLinkedNode.next=firstNode;
        firstNode.prev=dLinkedNode;
    }
    /*
    * 将尾部节点移除
    * */
    public DLinkedNode removeTail(){
        DLinkedNode last=tail.prev;
        last.prev.next=tail;
        tail.prev=last.prev;
        return last;

    }
    /*
    * 对于新增的数据，将其插入
    * */
    public void addToHead(DLinkedNode dLinkedNode){
        DLinkedNode first=head.next;
        head.next=dLinkedNode;
        dLinkedNode.prev=head;
        dLinkedNode.next=first;
        first.prev=dLinkedNode;
    }

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

}
