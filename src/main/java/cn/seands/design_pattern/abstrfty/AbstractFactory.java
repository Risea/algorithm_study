package cn.seands.design_pattern.abstrfty;

import cn.seands.design_pattern.entity.Pad;
import cn.seands.design_pattern.entity.Phone;

public abstract class AbstractFactory {
    public abstract Phone createPhone();
    public abstract Pad createPad();
    // 抽象类可以定义一些其他公共方法等
    void init(){}
}
