# 목표

자바의 인터페이스에 대해 학습하세요.

# 학습할 것 (필수)

- 인터페이스 정의하는 방법
- 인터페이스 구현하는 방법
- 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
- 인터페이스 상속
- 인터페이스의 기본 메서드 (Default Method), 자바 8
- 인터페이스의 static 메서드, 자바 8
- 인터페이스의 private 메서드, 자바 9

---

## 인터페이스(Interface) 정의하는 방법

인터페이스를 정의 하는 방법을 알아보기 전에 왜 인터페이스를 정의하여 사용할까?

일단 추상(abstract) 클래스와 인터페이스(interface) 공통점과 차이점을 알아보자.

**추상(abstract)의** 단어의 뜻은 무엇일까?

- 사물이 지니고 있는 여러 가지 측면 가운데서 특정한 측면만을 가려내어 포착하는 것이다.(위키백과)

세상에 존재하는 모든 객체를 구체적이고 상세하게 인간이 파악하기는 사실은 힘들다.

그래서 우리 인간은 객체들에 대해서 공통점을 찾고 그 공통점대로 객체를 묶는 행위를 추상화 즉 일반화한다.

다음 그림을 보면서 이해해보자.

![https://blog.kakaocdn.net/dn/wk2Qe/btqSASXx1GL/UoziqfaOTFbFH4o2XGt1Ck/img.png](https://blog.kakaocdn.net/dn/wk2Qe/btqSASXx1GL/UoziqfaOTFbFH4o2XGt1Ck/img.png)

여기 인간이라는 객체와  고래라는 객체가 있다. 이 둘은 누가 봐도 다르고 사는 서식지도 다르다.

하지만 이 둘을 그룹화하여 객체들을 조금 더 단순하게 바라보고 싶다.

이 둘의 공통점을 찾아보자면

인간의 정의한 포유류라는 그룹에 속할 수 있다.

참새와 닭도 마찬 같이로 조류라는 그룹에 속할 수 있다.

이렇게 객체의 개념을 이용하여 객체들을 여러 그룹으로 **분류**함으로써 얻는 장점이 무엇이 있을까?

1. **객체 간의 차이점은 무시하고 객체들 간의 공통점을 파악하기 쉬움**

2. **객체의 불필요한 세부사항을 제거함으로써 중요한 부분을 강조할 수 있음**

이러한 행위는 객체지향 프로그래밍에도 해당한다.

(조금 더 복잡한 프로그래밍을 단순화하고 분류함으로써 유연한 관계를 만들기 위해)

자 이제 추상(abstract)을 자세히 알아봤으니

다시 추상 클래스와 인터페이스의 공통점과 차이점을 알아보자

- 공통점
    - 자기 자신을 객체화할 수 없으며 다른 객체가 상속(extends) , 구현(implements)을 하여 객체를 생성할 수 있다.
    - 상속(extends) , 구현(implements)을 한 하위 클래스에서는 상위에서 정의한 추상 메서드(abstract method)를 반드시 구현하여야 한다.

그럼 추상클래스만 쓰지 왜 인터페이스가 존재할까?

**추상 클래스는 IS - A ~는 ~이다 -> Hailey 은 사람이다.**

**인터페이스는 HAS - A "~는 ~ 를 할 수 있다. Hailey는 수영을 할 수 있다.**

즉 Person은 수영을 할 수도 있고 할 수 없을 수도 있기 때문에 Person이라는 개념에 속하는 것이 어색하다.

**추상 클래스(abstract class)**

```
public abstract class Person {

    public final int FINGER_COUNT = 10; // 상수 가질수 있음

    public int age;  //변수를 가질수 있음

    public abstract void language(); //추상 메서드

    public void eat(){
        System.out.println("나는 음식을 입으로 먹는다.");
    }

    public void walk(){
        System.out.println("나는 두 다리로 걷는다.");
    }
}

```

**인터페이스(interface)**

```
public interface SwimAble {
    public abstract void swim(); // public abstract 생략가능합니다.
}

```

**Hailey 클래스 (Person을 상속받고 SwimAble을 구현하고 있다! )**

```
public class Hailey extends Person implements SwimAble{

    public Hailey(int age) {
        this.age = age;
    }

    @Override
    public void language() {
        System.out.println("저는 한국어를 사용합니다");
    }

    @Override
    public void swim() {
        System.out.println("개헤엄을 잘 합니다.");
    }
}

```

인터페이스의 특징(정의 방법)

1. 추상 메서드와 상수로 구성됨 (**자바 8 이후부터 default , static 메서드 추가 가능)**

2.  모든 메서드 접근 지정자는 public이며 생략이 가능

1. 상수는 public static fianl 속성이며 생략이 가능

인터페이스 구현 방법

1. public class classname implements 인터페이스
2. 인터페이스에서 정의한 추상 메서드를 인터페이스를 구현(implements)하고 있는 클래스에서 재정의 하여 구현하여 사용하면 된다.

---

## 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

위 코드와 이어집니다.

일단 Kevin(케빈)이라는 객체와  Fish(물고기)를 정의해보자.

Kevin Class

```
public class Kevin extends Person {
    public Kevin(int age) {
        this.age = age;
    }

    @Override
    public void language() {
        System.out.println("I Speak English");
    }
}

```

Fish Class

```
public class Fish implements SwimAble{

    @Override
    public void swim() {
        System.out.println("나는 헤엄을 엄청 잘한다.");
    }
}

```

그러면 다이어 그램으로 보면 다음과 같다.

![image](https://user-images.githubusercontent.com/74589038/152649687-0ad01a0a-6930-4cc3-80af-6474a3fe4f68.png)

자 그러면 Hailey 객체는 분류를 나눌 때

SwimAble 그룹에도 속할 수 있고 Person이라는 그룹에도 속할 수 있다.

따라서 다음과 같은 코드가 가능하다.

```
public class Solution {
    public static void main(String[] args) {

        Hailey hailey = new Hailey(25);
        Kevin kevin = new Kevin(25);
        Fish fish = new Fish();

//=======================사람 그룹========================
        List<Person> people = new ArrayList<>();
        people.add(hailey);
        people.add(kevin);
        for (Person person : people) {
            person.language();
            person.walk();
            person.eat();
        }

//=========================헤엄 칠수 있는 그룹==========================
        List<SwimAble> swimAbles = new ArrayList<>();
        swimAbles.add(fish);
        swimAbles.add(hailey);

        for (SwimAble swimAble : swimAbles) {
            swimAble.swim();
        }
    }
}

```

즉 이런 식으로 객체의 상세정보를 제외하고 분류(classification)의 정의에 중요한 부분을 강조를 할 수 있다.

---

## 인터페이스 상속

인터페이스의 가장 큰 장점은 다중 상속이 가능하다는 것이다.

예를 들어보자.

Hailey 객체는 사람이면서 수영이라는 부가기능을 가지고 있다.

하지만 수영이라는 인터페이스는 너무 광범위하여 세부 종목을  Hailey에게 하고 싶다.

접영을 하려면 자유형을 해야 한다고 가정하자. 또한  접영을 한다는 것은 수영을 할 수 있다는 것이다.

코드를 보자.

```
public interface Freestyle {
    void freestyle();
}

public interface SwimAble {
     abstract void swim(); // public abstract 생략가능합니다.

}

public interface ButterflyStroke extends SwimAble ,Freestyle{
    void butterflyStroke();
}

```

```
public class Hailey extends Person implements ButterflyStroke{

    public Hailey(int age) {
        this.age = age;
    }

    @Override
    public void language() {
        System.out.println("저는 한국어를 사용합니다");
    }

    @Override
    public void swim() {
        System.out.println("수영을 합니다");
    }

    @Override
    public void butterflyStroke() {
        System.out.println("접영을 합니다");
    }

    @Override
    public void freestyle() {
        System.out.println("자유형 합니다");
    }
}

```

또한 인터페이스는 **다중 구현이 가능**한데

예를 들면

Hailey 객체가 프로그래밍을 배워서  수영과 프로그래밍을 가능해졌을 때

다중 구현을 통해 해결할 수 있다.

```
public interface Programing {
    void programing();
}

```

```
public class Hailey extends Person implements ButterflyStroke ,Programing{

 	'''' 생략

    @Override
    public void programing() {
        System.out.println("코딩을 할줄 압니다.");
    }
}

```

---

### 인터페이스의 기본 메서드 (Default Method) - 자바 8

앞에 표에서 설명한 것처럼 자바 8 이전에는 Interface 에는 추상 메서드만 선언이 가능했었다.

하지만 자바 8 이후부터는 Interface에  default , static 메서드가 추가가 가능한데.

이게 나온 이유는?

인터페이스가 변경되고 추상 메서드가 추가될 때마다 해당 구현체에게 가서 추상 메서드를 일일이 구현한다는 것은 매우 복잡하고 귀찮은 일이 될 수 있다.

물론 구현체마다 메서드가 하는 역할이 달라질 수 있지만.

인터페이스에서 기본 메서드를 추가하고 마음에 안 드는 구현체에게만 가서 다시 기본 메서드를 재정의 만 해주면 되기 때문에 훨씬 편리하게 기능을 추가할 수 있다.

**Default Method**

```
public interface Programing {
    void programing();

    default void application(){
        System.out.println("애플리케이션을 만듭니다.");
    }
}

```

---

### 인터페이스의 스테틱 메서드 (Static Method) - 자바 8

앞서 말한 default 메서드 와 맥락은 비슷하고

다른점은 구현체에서 **재정의가 불가능** 하다.

```
public interface Programing {
    void programing();

    static void  study(){
        System.out.println("프로그래밍을 공부합니다.");
    }
}

```

---

### 인터페이스의 priavte 메서드 (private Method) - 자바 9

말 그대로 인터페이스 내부에서 private 메서드를 사용 할 수 있는 것이다.

자바 8에서 나온 default ,static method 는 기본적으로 접근 지정자가 public만 가능 했기 때문에

캡슐화를 하지 못하였다.
