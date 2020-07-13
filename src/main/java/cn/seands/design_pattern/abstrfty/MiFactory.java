package cn.seands.design_pattern.abstrfty;

import cn.seands.design_pattern.entity.MiPad;
import cn.seands.design_pattern.entity.MiPhone;
import cn.seands.design_pattern.entity.Pad;
import cn.seands.design_pattern.entity.Phone;

public class MiFactory extends AbstractFactory {
    public Phone createPhone() {
        return new MiPhone();
    }

    public Pad createPad() {
        return new MiPad();
    }
}
