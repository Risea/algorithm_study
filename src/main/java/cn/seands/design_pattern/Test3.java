package cn.seands.design_pattern;

import cn.seands.design_pattern.abstrfty.AbstractFactory;
import cn.seands.design_pattern.abstrfty.AppleFactory;
import cn.seands.design_pattern.abstrfty.MiFactory;

public class Test3 {
    public static void main(String[] args) {
        AbstractFactory iFactory = new AppleFactory();
        AbstractFactory mFactory = new MiFactory();
        System.out.println(String.format("iPhone --> %s", iFactory.createPhone().brand()));
        System.out.println(String.format("iPad --> %s", iFactory.createPad().brand()));
        System.out.println(String.format("mPhone --> %s", mFactory.createPhone().brand()));
        System.out.println(String.format("mPhone --> %s", mFactory.createPad().brand()));
    }
}
