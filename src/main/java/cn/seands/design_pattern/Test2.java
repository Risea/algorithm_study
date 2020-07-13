package cn.seands.design_pattern;

import cn.seands.design_pattern.entity.Phone;
import cn.seands.design_pattern.factory.IPhoneFactory;
import cn.seands.design_pattern.factory.MiPhoneFactory;
import cn.seands.design_pattern.factory.PhoneFactory;

public class Test2 {
    public static void main(String[] args) {
        PhoneFactory appleFactory = new IPhoneFactory();
        Phone phone1 = appleFactory.create();
        System.out.println(String.format("phone1 brand --> %s", phone1.brand()));
        PhoneFactory miFactory = new MiPhoneFactory();
        Phone phone2 = miFactory.create();
        System.out.println(String.format("phone2 brand --> %s", phone2.brand()));
    }
}
