package expert005;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

public class Car {

    @Resource//자바 표준 어노테이션 , id가 우선순위
    Tire tire;

    public String getTireBrand(){

        return "장착된 타이어: " + tire.getBrand();
    }
}
