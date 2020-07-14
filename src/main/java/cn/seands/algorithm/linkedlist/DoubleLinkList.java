package cn.seands.algorithm.linkedlist;

/**
 * 带头尾节点的双向链表
 * 头尾两个都是 标识作用的 空节点
 * @param <T>
 */
public class DoubleLinkList<T> {

    private DLinkNode<T> head;
    private DLinkNode<T> tail;

    public DoubleLinkList(){
        head = new DLinkNode<T>();
        tail = new DLinkNode<T>();
        head.next = tail;
        tail.pre = head;
    }

    public void list(){
        DLinkNode<T> cur = head;
        while(cur.next != tail){
            cur = cur.next;
            System.out.println(cur.data);
        }
    }

    public T findByIdx(int idx){
        DLinkNode<T> cur = head;
        int i = 0;
        while(cur.next != tail && i < idx){
            cur = cur.next;
            i++;
        }
        if(i > idx){
            System.out.println("链表长度少于"+idx+"...");
            return null;
        }
        return cur.data;
    }

    public DoubleLinkList<T> add(T data){
        DLinkNode<T> node = new DLinkNode<>(data);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        return this;
    }

    public boolean del(T data){
        DLinkNode<T> cur = head;
        while(cur.next != tail){
            cur = cur.next;
            if(cur.data.equals(data)){
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        DoubleLinkList<Integer> dll = new DoubleLinkList<Integer>();
        Integer data1 = 1;
        Integer data2 = 2;
        Integer data3 = 3;
        dll.add(data1).add(data2).add(data3);
        dll.list();
        System.out.println("find idx3 --> "+dll.findByIdx(3));
        boolean f = dll.del(2);
        System.out.println("del 2 --> "+f);
        dll.list();
        System.out.println("add 5, 7...");
        dll.add(5).add(7);
        dll.list();
        f = dll.del(1);
        System.out.println("del 1 --> "+f);
        dll.list();
        f = dll.del(7);
        System.out.println("del 7 --> "+f);
        dll.list();
    }

}

/**
 * 双向链表的节点
 * @param <T>
 */
class DLinkNode<T>{
    T data;
    DLinkNode<T> pre;
    DLinkNode<T> next;

    public DLinkNode() {
    }

    public DLinkNode(T data) {
        this.data = data;
    }

    public DLinkNode(T data, DLinkNode<T> pre, DLinkNode<T> next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }
}
