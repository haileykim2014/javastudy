package expert001_02;

public class Car {
    Tire tire;

    public Car(Tire tire){
        //new가 사라지고 생성자에 인자추가
        this.tire = tire;
    }
    //의존성 주입을 할 경우 Car는 Tire인터페이스를 구현한 어떤객체가 들어오기만 하면 작동한다.
    // 곧 확장성도 좋아진다. 다른 타이어 브랜드들이 Tire인터페이스를 구현한다면 Car.java코드 변경없이 사용가능.
    public String getTireBrand(){
        return "장착된 타이어: "+ tire.getBrand();
    }
}
