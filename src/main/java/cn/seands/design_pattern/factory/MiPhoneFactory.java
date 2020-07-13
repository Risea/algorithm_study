package cn.seands.design_pattern.factory;

import cn.seands.design_pattern.entity.MiPhone;
import cn.seands.design_pattern.entity.Phone;

public class MiPhoneFactory implements PhoneFactory {
    public Phone create() {
        return new MiPhone();
    }
}
