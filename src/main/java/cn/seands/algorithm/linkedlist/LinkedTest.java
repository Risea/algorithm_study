package cn.seands.algorithm.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedTest {

    public static void main(String[] args) {
        LinkedList<Person> list = new LinkedList<>();
        list.add(new Person(1, "aaa"));
        list.add(new Person(2, "bbb"));
        list.add(new Person(5, "eee"));
        System.out.println("初始: ");
        list.list();
        System.out.println("\n\n添加节点3:");
        list.insert(new Person(3, "ccc"));
        list.list();
        System.out.println("\n\n添加节点4:");
        Person d = new Person(4, "ddd");
        list.insert(3, d);
        list.list();
        System.out.println("\n\n头部添加:0");
        list.addFirst(new Person(0, "sss"));
        list.list();
        System.out.println("节点个数: "+list.size()+"\n\n两两翻转:");
        list.flipInTwos();
        list.list();
        System.out.println("\n\n再次两两翻转:");
        list.flipInTwos();
        list.list();

        System.out.println("\n\n删除节点:d");
        list.remove(d);
        list.list();
        System.out.println("\n\n删除节点1:");
        list.removeByIdx(1);
        list.list();

        System.out.println("\n\n替换元素0:");
        list.replace(0, new Person(0, "xxx"));
        list.list();
        System.out.println("\n\n替换元素5:");
        list.replace(new Person(5, "eee"), new Person(6, "FFF"));
        list.list();

        System.out.println("\n\n翻转链表:");
        list.reversal();
        list.list();
        list.reversal();

        System.out.println("\n\n查找倒第4个节点:");
        System.out.println(list.findDataByLast(4));
        System.out.println("查找倒第2个节点:");
        System.out.println(list.findDataByLast(2));
        System.out.println("查找倒第1个节点:");
        System.out.println(list.findDataByLastTwo(1));
        System.out.println("查找倒第3个节点:");
        System.out.println(list.findDataByLastTwo(3));

        System.out.println("\n\n合并链表:");
        LinkedList<Person> list2 = new LinkedList<>();
        list2.add(new Person(1, "AAA"));
        list2.add(new Person(2, "BBB"));
        list2.add(new Person(4, "CCC"));
        list.list();
        System.out.println("----");
        list2.list();
        list.merge(list2);
        System.out.println("----");
        list.list();
    }

}

class Person implements Comparable{
    Integer no;
    String name;

    public Person() {
    }

    public Person(Integer no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person)o;
        return no.compareTo(p.getNo());
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(no, person.no) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }
}