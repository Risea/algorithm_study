package cn.seands.algorithm.queue;

/**
 * 循环队列
 */
public class CircularQueue<E> {

    private int head;
    private int tail;
    private E[] data;
    private int maxSize;

    public CircularQueue(int maxSize) {
        /*if(maxSize <= 0){
            throw new Exception("maxSize 不能小于等于0");
        }*/
        this.maxSize = maxSize + 1;         // 用了一个空元素来判断满
        data = (E[])new Object[maxSize+1];
        head = tail = 0;
    }

    public boolean isEmpty(){
        return head == tail;
    }

    /**
     * 初始: head = tail = 0
     * 判空: head == tail
     * 此时判满，有多种实现
     * 1. 用变量flag标记,入队列(true) or 出队列(false)。 最后根据 head == tail && flag 队列满， head == tail && !flag 队列空
     * 2. 用变量计数当前队列中元素的数量size。最后根据 size == maxSize 队列满
     * 3. 因为head与tail指到同一个节点时为空,所以空出一个节点来标识,当tail到head前一个节点时就算满了(此时队列中元素只有maxSize-1),
     * 最后根据取模运算 (tail+1) % maxSize == head判断队列满。
     * @return
     */
    public boolean isFull(){
        return (tail + 1) % maxSize == head;
    }

    public int size(){
        return (tail + maxSize - head) % maxSize;
    }

    public void add(E e) throws Exception {
        if(isFull()){
            throw new Exception("队列已满, 无法添加新元素...");
        }
        /*
        data[tail] = e;
        tail = (tail + 1) % maxSize;
        */
        data[tail++] = e;
        if(tail == maxSize){        // 循环的
            tail = 0;
        }
    }

    public E peek() throws Exception {
        if(isEmpty()){
            throw new Exception("队列已空, 偷看不了啦...");
        }
        return data[head];
    }

    public E remove() throws Exception {
        if(isEmpty()){
            throw new Exception("队列已空, 无法出列...");
        }
        E tmp = data[head];
        data[head] = null;
        head = (head+1) % maxSize;
        return tmp;
    }

    /**
     * sout打印出所有元素 及当前head与tail的值
     */
    public void list(){
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("%s, ", data[i]);
        }
        System.out.printf(" head=%d, tail=%d \n", head, tail);
    }

}
