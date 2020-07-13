package cn.seands.design_pattern;

import cn.seands.design_pattern.entity.IPhone;
import cn.seands.design_pattern.entity.MiPhone;
import cn.seands.design_pattern.entity.Phone;

public class SimplePhoneFactory {
    public Phone create(String brand){
        if("apple".equals(brand)){
            return new IPhone();
        }else if("mi".equals(brand)){
            return new MiPhone();
        }else{
            return null;
        }
    }
}
