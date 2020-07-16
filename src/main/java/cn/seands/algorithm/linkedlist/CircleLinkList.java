package cn.seands.algorithm.linkedlist;

public class CircleLinkList<E> {

    private CircleNode<E> first;

    public CircleLinkList(){
        this.first = null;
    }

    public void list(){
        CircleNode<E> cur = first;
        if(cur == null){
            System.out.println("环形链表为空, 没有数据了...");
            return;
        }
        // 循环打印到最后一个节点
        while(cur.next != first){
            System.out.println(cur.data);
            cur = cur.next;
        }
        System.out.println(cur.data);
    }

    // 环形尾部添加一个节点
    private void add(E data){
        CircleNode<E> node = new CircleNode<>(data);
        CircleNode<E> cur = first;
        if(cur == null){
            first = node;
            first.next = first;
            return;
        }
        while(cur.next != first){
            cur = cur.next;
        }
        cur.next = node;
        node.next = first;
    }

    private boolean remove(E data){
        if(first == null){
            System.out.println("环形链表为空...无法删除");
            return false;
        }
        // 不带头结点、删除第一个元素  ----  最后一个节点next --> first.next
        CircleNode<E> cur = first;
        if(cur.data.equals(data)){
            cur.next = cur.next.next;
            return true;
        }
        cur = cur.next;
        while (cur != first){
            if(cur.data.equals(data)){
                cur.next = cur.next.next;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private E removeByIdx(int idx){
        if(first == null || idx <= 0){
            System.out.println("无法移除...");
            return null;
        }
        CircleNode<E> cur = first;
        if(cur.next == first){
            if(idx == 1){
                first = null;
                return cur.data;
            }
            return null;
        }
        cur = cur.next;
        int i = 1;
        while (cur != first){
            if(i == idx){
                cur.next = cur.next.next;
                return null;
            }
            i++;
            cur = cur.next;
        }
        return null;
    }
}

class CircleNode<E> {
    public E data;
    public CircleNode<E> next;

    public CircleNode(){
    }

    public CircleNode(E data){
        this.data = data;
        this.next = null;
    }

    public CircleNode(E data, CircleNode<E> next){
        this.data = data;
        this.next = next;
    }

    public boolean hasNext(){
        return next != null;
    }

}
