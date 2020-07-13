package cn.seands.design_pattern.factory;

import cn.seands.design_pattern.entity.IPhone;
import cn.seands.design_pattern.entity.Phone;

public class IPhoneFactory implements PhoneFactory {
    public Phone create() {
        return new IPhone();
    }
}
