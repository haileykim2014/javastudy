## Enum

### 자바에서 제공하는 Enum에 대해 공부해보자 📖

- enum 정의하는 방법
- enum이 제공하는 메소드(values()와 valueOf())
- java.lang.Enum
- EnumSet


### 인터페이스 기반 상수의 정의 : 자바5 이전의 방식

인터페이스 내에 선언된 변수는 public, static, final이 선언된 것으로 간주

관련 있는 상수들을 묶어서 선언했었다.

```java
interface Scale{
	int DO = 0; int RE = 1; int MI = 2; int FA = 3;
	int SO = 4; int RA = 5; int TI = 6;
}
```

### 이전 방식의 문제점

Animal.DOG는 1이라는 정수를 갖는다. int형 값이니까 switch는 Person.MAN이 전달된것으로 알고 실행된다. 컴파일 및 실행과정에서 발견되지 않는 오류가 발생한다. 나중에 오류가 발생했는지 모르는 치명적인 약점이 생긴다.

안정장치가 필요하다. 최소한 컴파일 레벨에서 오류가 발견이 되도록 개선이 되었다.→Enum 등장

```java
interface Animal{
	int DOG = 1;
	int CAT = 2;
}

interface Person{
	int MAN =1;
	int WOMAN = 2;
}

class NonSafeConst{
	public static void main(String[] args){
		who(Person.MAN); //정상적인 메소드 호출
		who(Animal.DOG); //비정상적 메소드 호출
	}
}

public static void who(int man){
	switch(man){
	case Person.MAN;
		System.out.println("남성 손님입니다.");
		break;
	case Person.WOMAN;
		System.out.println("여성 손님입니다.");
			break;
	}
}
```

### Enum 📌

열거형(enumerated type)이라고 부르며 서로 연관된 상수들의 집합이다. 기존에 상수를 사용하면서 발생했던 문제(typesafe)를 개선하고자 jdk1.5 부터 추가 된 기능이다.

### Enum 정의 📌

- `enum` 키워드를 이용하여 정의한다.
- 열거형 필드의 이름은 상수이기 때문에 대문자로 표기한다.
- 기본적으로 0부터 시작하는 정숫값이 연속적으로 부여된다.

```
/*
enum 열거형이름 { 상수명1, 상수명2, ...}
*/
enum Day { // 0부터 연속적인 정수값 부여
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}
```

### Enum의 사용 💡

- Hamburger라는 enum을 정의한 후
- EnumTest 클래스에서 `init()` 메소드 호출 시 열거형 인스턴스 변수에 `Hamburger.BIGMAC` 대입

```
enum Hamburger {
    BIGMAC, SHANGHI, MACCHICKEN;
}

public class EnumTest {
    public static void main(String[] args) {
        Hamburger hamburger = Hamburger.BIGMAC;
        System.out.println(hamburger + "버거 입니다.");

    }
}
```

```
Output
BIGMAC버거 입니다.
```

### 중요점 ⭐️

- 모든 enum은 클래스를 사용해서 내부적으로 정의가 된다.
- 실제로 컴파일까지 한 후 바이트 코드를 분석해보면 아래와 같이 출력된다.

```
// 내부적으로 위에서 작성한 enum은 아래와 같이 바뀐다.
class Hamburger
{
     public static final Hamburger BIGMAC = new Hamburger();
     public static final Hamburger SHANGHI = new Hamburger();
     public static final Hamburger MACCHICKEN = new Hamburger();
}
```

![https://images.velog.io/images/ljs0429777/post/563a0e93-8eef-461d-bd79-c8a447a87791/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-01-27%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.25.12.png](https://images.velog.io/images/ljs0429777/post/563a0e93-8eef-461d-bd79-c8a447a87791/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-01-27%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.25.12.png)

### 주의사항 ⭐️

- 열거형 상수의 비교에는 ==와 compartTo() 사용가능 (등가비교연산자 가능)
- =, >, >=, <, <=, <> 같은 비교연산자는 사용할 수 없음(컴파일 에러)

```
if (NORMAR.BIGMAC > MACALL.BIGMAC) { // 열거형 상수에는 비교연산자 사용불가
    System.out.println("이렇게 사용하면 컴파일에러가 납니다.");
}
```

### 비교연산자를 왜 쓸 수 없을까? 🤔

바이트코드를 분석해보면 알겠지만 enum은 클래스이다. 클래스에서 비교연산자를 쓸 수 있었나? 다시 생각해보면 객체와 객체는 서로 비교연산자를 쓸 수 없기 때문에 enum에서 지원하지 않는 것이다.

### java.lang.Enum 💡

모든 enum은 내부적으로 java.lang.Enum 클래스를 부모 클래스로 가진다.

[제목 없음](https://www.notion.so/98586f80731d495c8ac63c0306d6db6e)

그 밖에 clone(), equals(), finalize(), toString(), hashCode() 메소드들도 있는데 이는 Object 클래스로부터 상속받은 메소드이기 때문에 따로 언급하지 않는다.

### values(), valueOf() 💡

위에서 본 java.lang.Enum 즉 열거형의 조상 클래스에선 values(), valueOf() 메소드에 대한 내용을 자세히 찾아볼 수 없다. 그 이유는 **컴파일러가 자동으로 추가**해 주는 메소드이기 때문이다.

예제를 통해 각 메소드별 결과값과 실제로 **컴파일러가 자동으로 어떻게 추가해** 주는지 내부적으로 확인해보자

컴파일까지 실행한 후 바이트코드를 분석해보면 static으로 선언되어 있는 메소드 2개를 발견할 수 있다. 이로써 values(), valueOf() 메소드는 컴파일러가 자동으로 추가해 주는다는 사실을 직접 확인할 수 있다.

- **enum 테스트를 위해 EnumByte 따로 생성해서 테스트했습니다.**

[제목 없음](https://www.notion.so/ab5c81515bd4478ebef1d0655de87f8d)

```
enum Hamburger {
    BIGMAC, SHANGHI, MACCHICKEN;
}

public class EnumTest {
    public static void main(String[] args) {
        Hamburger hamburger = Hamburger.valueOf("MACCHICKEN");
        System.out.println(hamburger + " 버거 입니다.");
    }
}
```

```
MACCHICKEN 버거 입니다.
```

```
enum Hamburger {
    BIGMAC, SHANGHI, MACCHICKEN;
}

public class EnumTest {

    public static void main(String[] args) {
        Hamburger[] hamburger = Hamburger.values();
        System.out.println("현재 저희 매장에 있는 버거는");
        for (Hamburger burgers : hamburger) {
            System.out.println(burgers + " 버거가 있습니다.");
        }
    }
}
```

```
현재 저희 매장에 있는 버거는
BIGMAC 버거가 있습니다.
SHANGHI 버거가 있습니다.
MACCHICKEN 버거가 있습니다.
```

![https://images.velog.io/images/ljs0429777/post/ae738309-7b2f-4cf7-9676-f2f2ccdfeaf8/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-01-27%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.27.56.png](https://images.velog.io/images/ljs0429777/post/ae738309-7b2f-4cf7-9676-f2f2ccdfeaf8/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-01-27%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012.27.56.png)

### 열거형에 멤버 추가하기 💡

- 위에서 연속적인 값을 자동으로 대입한다고 했었다. 만약 개발자가 불연속적인 열거형 상수의 경우, 원하는 값을 () 안에 대입하면 된다.
- 이때 단순히 () 안에 대입하는 것이 아니라 추가적으로 해야 하는 작업이 있다.

```
// () 안에 원하는 값을 적으면 된다.
// 하지만 이렇게 작성하기 위해선 추가적인 작업이 소요된다.
enum Day {
    SUNDAY(1), MONDAY(5), TUESDAY(0), WEDNESDAY(2), THURSDAY(6), FRIDAY(3), SATURDAY(4);
}
```

```
// 내부적으로 불연속적인 값을 주기 위하여 생성자를 만들어 값을 받아온 후, 인스턴스 변수에 저장하는 방식이다.
enum Day {
    SUNDAY(1), MONDAY(5), TUESDAY(0), WEDNESDAY(2), THURSDAY(6), FRIDAY(3), SATURDAY(4);
    Day(int value) { this.value = value; } // 항상 접근제어자는 private 이다.

    private final int value; // 정수를 저장할 인스턴스 변수를 추가해준다.
    public int value() { return value; }
}
```

### 주의사항

- 열거형의 생성자는 묵시적으로 private 이므로, 외부에서 객체생성이 불가능하다.
    
    ```
    Day day = new Day(1); // 열거형의 생성자는 외부에서 호출 불가능하다.
    ```
    

![https://images.velog.io/images/ljs0429777/post/c2792e1d-d7c0-4fd4-9166-300a20af011b/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-01-28%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%202.35.30.png](https://images.velog.io/images/ljs0429777/post/c2792e1d-d7c0-4fd4-9166-300a20af011b/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202021-01-28%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%202.35.30.png)

### EnumSet 💡

### Set

Set은 **객체(데이터)를 중복해서 저장할 수 없다**. 또한 저장된 객체(데이터)를 인덱스로 관리하지 않기 때문에 **저장 순서가 보장되지 않는다** Set 컬렉션을 구현하는 대표적인 클래스들은 **HashSet, TreeSet, LinkedHashSet** 등이 있다. 주로 공통적으로 사용하는 메소드들은 add, iterator, size, remove, clear 들이 있다.

### EnumSet

Set 인터페이스를 기반으로 하면서 Enumeration type을 사용하는 방법이다.

[제목 없음](https://www.notion.so/b1e882e09ea64a3fa961aa25e279866e)

```
import java.util.EnumSet;

enum Gfg { CODE, LEARN, CONTRIBUTE, QUIZ, MCQ };

public class EnumSetExample {
    public static void main(String[] args) {
        // Creating a set
        EnumSet<Gfg> set1, set2, set3, set4;

        // Adding elements
        set1 = EnumSet.of(Gfg.QUIZ, Gfg.CONTRIBUTE, Gfg.LEARN, Gfg.CODE); // 일일이 입력하는거 같음
        set2 = EnumSet.complementOf(set1); // 인자로 들어온 enumset에서 누락된값만 집어넣나???
        set3 = EnumSet.allOf(Gfg.class); // 전체를 다 집어넣음
        set4 = EnumSet.range(Gfg.CODE, Gfg.CONTRIBUTE); //시작범위, 끝범위 입력하면 그 사이에 값 대입

        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        System.out.println("Set 3: " + set3);
        System.out.println("Set 4: " + set4);
    }
}
```

```
Set 1: [CODE, LEARN, CONTRIBUTE, QUIZ]
Set 2: [MCQ]
Set 3: [CODE, LEARN, CONTRIBUTE, QUIZ, MCQ]
Set 4: [CODE, LEARN, CONTRIBUTE]
```

### 이펙티브 자바 ✍️

### switch의 대안으로 상수별로 다르게 동작하는 코드 구현

- switch 문을 이용해 상수의 값에 따라 분기처리하는 방법

```
public enum Operation {
    PLUS, MINUS, TIMES, DIVIDE;

    // 상수가 뜻하는 연산을 수행한다
    // 새로운 상수가 추가되면 case 문도 추가해야한다.
    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }

        throw new AssertionError("Unknown op: " + this);
    }
}
```

### 상수별 메소드 구현

- 열거 타입은 상수별로 다르게 동작하는 코드를 구현하는 코드를 제공해준다.

```
public enum Operation {
    PLUS {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIED {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    public abstract double apply(double x, double y);
}
```

### 데이터와 메소드가 있는 형태

- 열거 타입 상수 각각을 특정 데이터와 연결지으려면 생성자에서 데이터를 받아 인스턴스 필드에 저장하면 된다.

```
// 어떤 객체의 지구에서의 무게를 입력받아 여덞 행성에서의 무게를 출력하는 예제이다.
enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS  (4.869e+24, 6.052e6),
    EARTH  (5.975e+24, 6.378e6),
    MARS   (6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN (5.685e+26, 6.027e7),
    URANUS (8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26, 2.477e7);

    private final double mass;           // 질량(단위: 킬로그램)
    private final double radius;         // 반지름(단위: 미터)
    private final double surfaceGravity; // 표면중력(단위: m / s^2)

    // 중력상수(단위: m^3 / kg s^2)
    private static final double G = 6.67300E-11;

    // 생성자
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass()           { return mass; }
    public double radius()         { return radius; }
    public double surfaceGravity() { return surfaceGravity; }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;  // F = ma
    }
}

public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("200");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("%s에서의 무게는 %f이다.%n",
                    p, p.surfaceWeight(mass));
    }
}
```

### Anti Pattern

### ordinal()

대부분의 enum 상수는 자연스럽게 하나의 정숫값과 대응된다. 그리고 해당 상수가 그 열거 타입에서 몇 번째 위치인지를 반환하는 ordinal() 메소드를 제공해준다. 이러한 기능으로 인해 열거 타입과 대응되는 상수를 추출하고 싶을 때 사용하고 싶을 것이다.

```
enum Ensemble {
    SOLO, DUET, TRIO, QUARTET, QUINTET, SEXTET, SEPTET, OCTET, NONET, DECTET;

    public int numberOfMusicians() {
        return ordinal()+1;
    }
}

public class Test {
    public static void main(String[] args) {
        Ensemble ensemble = Ensemble.valueOf("NONET");
        System.out.println(ensemble.numberOfMusicians());;
    }
}
```

```
Output
9
```

상수 선언 순서를 바꾸는 순간 numberOfMusicians() 메소드는 우리가 생각했던 방식으로 동작하지 않을 것이다. 또한 값을 중간에 비울 수도 없다. 더 이상 값을 추가하지 않을려면 일종의 더미 상수를 집어넣어야 한다. 이렇게 되면 코드가 깔끔하지 못하기 때문에 자바 Enum API 문서 상에도 ordinal() 메소드 사용을 권장하진 않는다.

> Most programmers will have no use for this method. It is designed for use by sophisticated enum-based data structures, such as EnumSet and EnumMap.
> 
> 
> 대부분 개발자들은 이 메소드를 사용할 일이 없다. 이 메소드는 EnumSet과 EnumMap 같이 열거 타입 기반의 범용 자료구조에 쓸 목적으로 설계되었다.
>
