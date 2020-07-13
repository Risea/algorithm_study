package cn.seands.design_pattern;

import cn.seands.design_pattern.entity.Phone;

public class Test1 {
    public static void main(String[] args) {
        SimplePhoneFactory factory = new SimplePhoneFactory();
        Phone phone1 = factory.create("apple");
        System.out.println(String.format("phone1 brand --> %s", phone1.brand()));
        Phone phone2 = factory.create("mi");
        System.out.println(String.format("phone2 brand --> %s", phone2.brand()));
    }
}
