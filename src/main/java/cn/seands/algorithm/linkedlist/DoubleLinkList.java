package cn.seands.algorithm.linkedlist;

public class DoubleLinkList<T> {

    private DLinkNode<T> head;

    public void list(){
        DLinkNode<T> cur = head;
        while(cur.next != null){
            System.out.println(head.data);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {

    }

    class DLinkNode<T>{
        T data;
        DLinkNode<T> pre;
        DLinkNode<T> next;

        public DLinkNode() {
        }

        public DLinkNode(T data, DLinkNode<T> pre, DLinkNode<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

}
