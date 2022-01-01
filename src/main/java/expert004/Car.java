package expert004;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
    @Autowired
    Tire tire;
    //Tire를 implement하는 객체를 주입한다.
    public String getTireBrand(){
        return "장착된 타이어: " + tire.getBrand();
    }
}
