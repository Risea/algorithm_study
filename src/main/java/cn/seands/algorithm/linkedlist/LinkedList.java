package cn.seands.algorithm.linkedlist;


import sun.awt.image.ImageWatched;

public class LinkedList<E extends Comparable> {

    private final LinkedNode head;

    public LinkedList(){
        head = new LinkedNode();
    }

    /**
     * 链表头部添加节点
     * @param data
     */
    public void addFirst(E data){
        head.next = new LinkedNode(data, head.next);
    }

    /**
     * 获取尾部节点
     * @return
     */
    public LinkedNode getLastNode(){
        LinkedNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp;
    }

    public LinkedNode getByIdx(int idx){
        LinkedNode tmp = head;
        int _idx = 0;
        while (tmp.hasNext() && _idx < idx){
            tmp = tmp.next;
            _idx++;
        }
        if(_idx != idx){
            return null;
        }
        return tmp;
    }

    /**
     * 默认尾部添加一个节点
     * @param data
     */
    public void add(E data){
        LinkedNode node = new LinkedNode(data);
        LinkedNode lastNode = getLastNode();
        lastNode.next = node;
    }

    /**
     * 查看打印所有节点
     */
    public void list(){
        LinkedNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
            System.out.println(tmp.data.toString());
        }
    }

    /**
     * 插入一个节点,根据E类型的compare排序放入对应位置
     * @param data
     */
    public void insert(E data){
        LinkedNode tmp = head;
        while(tmp.next != null){
            if(tmp.next.data.compareTo(data) > 0){
                break;
            }
            tmp = tmp.next;
        }
        /*if(tmp.data.equals(data)) {           // 不允许插入重复数据
            throw new Exception("插入了相同数据...");
        }*/
        LinkedNode node = new LinkedNode(data);
        node.next = tmp.next;
        tmp.next = node;
    }

    /**
     * 根据下标插入到对应位置
     * @param idx   从0开始, 0: 插入到头部, 1:插入到第一个节点之后 ...
     * @param data
     */
    public void insert(int idx, E data){
        LinkedNode tmp = head;
        int _idx = 0;
        while(tmp.next != null && _idx < idx){
            tmp = tmp.next;
            _idx++;
        }
        if(_idx != idx) {           // 不允许插入重复数据
            System.out.println("链表长度小于插入点,插入至链表尾部...");
        }
        LinkedNode node = new LinkedNode(data);
        node.next = tmp.next;
        tmp.next = node;
    }

    public boolean isEmpty(){
        if(head.next == null){
            return true;
        }
        return false;
    }

    /**
     * 根据
     * @param data
     */
    public boolean remove(E data){
        if(isEmpty()){
            System.out.println("链表空de...");
            return false;
        }
        LinkedNode tmp = head;
        boolean f = false;
        while(tmp.next != null){
            if(tmp.next.data.equals(data)){
                tmp.next = tmp.next.next;
                f = true;
                break;
            }
            tmp = tmp.next;
        }
        if(!f){
            System.out.println("未找到该节点...");
        }
        return f;
    }

    /**
     * 根据下标删除节点
     * @param idx
     * @return
     */
    public boolean removeByIdx(int idx){
        if(isEmpty()){
            System.out.println("链表空de...");
            return false;
        }
        LinkedNode tmp = head;
        int _idx = 0;
        while (tmp.hasNext() && _idx < idx){
            tmp = tmp.next;
            _idx++;
        }
        if(_idx != idx){
            System.out.println("链表节点数量太少,未找到...");
            return false;
        }
        tmp.next = tmp.next.next;
        return true;
    }

    /**
     * 根据下标替换节点
     * @param idx
     * @param data
     * @return
     */
    public boolean replace(int idx, E data){
        if(isEmpty()){
            System.out.println("链表空de...");
            return false;
        }
        LinkedNode tmp = getByIdx(idx);
        if(tmp != null){
            tmp.next = new LinkedNode(data, tmp.next.next);
            return true;
        }
        return false;
    }

    /**
     * 根据old元素替换为新元素
     * @param oldData
     * @param newData
     * @return
     */
    public boolean replace(E oldData, E newData){
        if(isEmpty()){
            System.out.println("链表空de...");
            return false;
        }
        LinkedNode tmp = head;
        boolean f = false;
        while (tmp.hasNext()){
            if(tmp.next.data.equals(oldData)){
                f = true;
                break;
            }
            tmp = tmp.next;
        }
        if(f){
            tmp.next = new LinkedNode(newData, tmp.next.next);
            return true;
        }
        return false;
    }

    /**
     * 获取链表节点个数
     * @return
     */
    public int size(){
        LinkedNode tmp = head;
        int count = 0;
        while (tmp.next != null){
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    /**
     * 单向链表翻转
     */
    public void reversal(){
        if(head.next == null || head.next.next == null){
            return;
        }
        LinkedNode cur = head.next;
        LinkedNode newHead = new LinkedNode();
        while (cur != null){
            LinkedNode next = cur.next;     // 下一个节点
            // 将cur插入到newHead之后
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        head.next = newHead.next;
    }

    /**
     * 两两翻转
     */
    public void flipInTwos(){
        LinkedNode node = head;
        while (node.hasNext()){
            LinkedNode nn = node.next.next;
            // 交换下一个 与 下下个
            if(nn != null){
                LinkedNode nnNext = nn.next;   // 下下个 next
                LinkedNode n = node.next;      // 下个元素
                nn.next = n;                   // n 移动到 nn之后
                n.next = nnNext;               // 修改n之后为nnNext
                node.next = nn;                // 修改当前 到 nn
                node = n;                      // 当前循环节点跳到 n
            }else{
                break;
            }
        }
    }

    /**
     * 单向链表查找倒数第N个数据
     * 双指针, 快慢指针查找
     * @param n
     * @return
     */
    public E findDataByLast(int n){
        LinkedNode tmp1 = head;
        LinkedNode tmp2 = head;
        int idx = 0;
        // tmp1快指针先跑到 第N个位置
        while (tmp1.hasNext()){
            tmp1 = tmp1.next;
            idx++;
            if(idx >= n){
                break;
            }
        }
        if(idx < n){
            System.out.println("链表长度只有"+idx+",未找到...");
            return null;
        }
        // tmp1再跑到最后, 即再跑count - n次
        // tmp2需要跑到count-n+1位置
        tmp2 = tmp2.next;
        while (tmp1.hasNext()){
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        return tmp2.data;
    }

    /**
     * 单向链表查找倒数第N个数据
     * 两边循环 先取得链表长度,再查找
     * @param n
     * @return
     */
    public E findDataByLastTwo(int n){
        LinkedNode tmp = head;
        int count = 0;
        while (tmp.hasNext()){
            tmp = tmp.next;
            count++;
        }
        if(n > count || n <= 0){
            System.out.println("n必须在(0, "+count+"]之间,未找到...");
            return null;
        }
        // 倒数第N个, 即正数第 count-n+1 个(倒数第1个,即最后一个 --> 第count个)
        tmp = head;
        int idx = count - n + 1;
        while(tmp.hasNext() && --idx >= 0){
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public void merge(LinkedList<E> list2){
        LinkedNode tmp1 = head.next;
        LinkedNode tmp2 = list2.head.next;
        LinkedNode newHead = new LinkedNode();
        LinkedNode last = newHead;
        while(tmp1!=null && tmp2!=null){
            if(tmp1.data.compareTo(tmp2.data) <= 0){
                last.next = tmp1;
                last = tmp1;
                tmp1 = tmp1.next;
            }else {
                last.next = tmp2;
                last = tmp2;
                tmp2 = tmp2.next;
            }
        }
        last.next = tmp1 == null ? tmp2 : tmp1;
        head.next = newHead.next;
    }



    class LinkedNode {
        private E data;
        private LinkedNode next;

        public LinkedNode(){
        }

        public LinkedNode(E data){
            this.data = data;
            this.next = null;
        }

        public LinkedNode(E data, LinkedNode next){
            this.data = data;
            this.next = next;
        }

        public boolean hasNext(){
            return next != null;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public LinkedNode getNext() {
            return next;
        }

        public void setNext(LinkedNode next) {
            this.next = next;
        }
    }

}
