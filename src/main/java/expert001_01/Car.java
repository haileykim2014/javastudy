package expert001_01;

public class Car {
    Tire tire;
    //car가 구체적으로 KoreaTire를 생산할지, AmericaTire를 생산할지 결정
    public Car(){
        tire = new KoreaTire();
        //tire = new AmericaTire();
    }

    public String getTireBrand(){
        return "장착된 타이어: "+ tire.getBrand();
    }
}
