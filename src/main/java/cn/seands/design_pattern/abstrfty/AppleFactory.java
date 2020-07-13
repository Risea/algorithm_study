package cn.seands.design_pattern.abstrfty;

import cn.seands.design_pattern.entity.IPad;
import cn.seands.design_pattern.entity.IPhone;
import cn.seands.design_pattern.entity.Pad;
import cn.seands.design_pattern.entity.Phone;

public class AppleFactory extends AbstractFactory {
    public Phone createPhone() {
        return new IPhone();
    }

    public Pad createPad() {
        return new IPad();
    }
}
