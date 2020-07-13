package cn.seands.algorithm.queue;

/**
 * 顺序队列
 * @param <E>
 */
public class ArrayQueue<E> {

    private int head;   // 队列头
    private int tail;   // 队列尾
    private E[] data;
    private int maxSize;    // 队列最大容量

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        data = (E[]) new Object[maxSize];
        head = 0;
        tail = 0;
    }

    /**
     * 队列中是否为空
     * @return
     */
    public boolean isEmpty(){
        if(head == tail){
            return true;
        }
        return false;
    }

    /**
     * 队列中是否满了
     * @return
     */
    public boolean isFull(){
        if(tail - head == maxSize){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 队列中有效元素个数
     * @return
     */
    public int size(){
        return tail - head;
    }

    /**
     * 查看当前队列头部元素
     * @return
     */
    public E peek() throws Exception {
        if(isEmpty()){
            throw new Exception("队列是空的,无法偷看...");
        }
        return data[head];
    }

    /**
     * 队列中添加元素
     * @param data
     * @throws Exception
     */
    public void add(E data) throws Exception {
        if(isFull()){
            throw new Exception("队列已满, 无法入列...");
        }
        if(tail == maxSize){        // tail到达队尾 且队列前面元素其实已经出列了,都是些无效元素,将数据前移
            refresh();
        }
        this.data[tail++] = data;
    }

    /**
     * 队列假满,队列中有一些已经出列的元素, 刷新元素前移
     */
    public void refresh(){
        int size = tail - head;
        for(int i = 0; i < size; i++){
            data[i] = data[head+i];
        }
        head = 0;
        tail = size;
    }

    /**
     * 头部元素出列
     * @return
     */
    public E remove() throws Exception {
        if(isEmpty()){
            throw new Exception("队列是空的,无法出列...");
        }
        /* 如果觉得出列的无效元素在队列中不好看的话,可以置为null。
        E tmp = data[head];
        data[head++] = null;
        return tmp;
        */
        return data[head++];
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
