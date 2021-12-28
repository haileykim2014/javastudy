package expert001_02;

public class Driver {
    public static void main(String[] args){
        Tire tire = new KoreaTire();
        //Tire tire = new AmericaTire();

        Car car = new Car(tire);
        //car가 구체적으로 KoreaTire를 생산할지, AmericaTire를 생산할지 결정
        System.out.println(car.getTireBrand());
    }
}
