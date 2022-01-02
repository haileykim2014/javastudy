## 목표

자바가 제공하는 다양한 연산자를 학습

## 학습할 것

- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof
- assignment operator
- 화살표 연산자
- 3항 연산자
- 연산자 우선 순위
- Java 13.switch 연산자

## 산술 연산자

<aside>
💡 산술(arithmetic) 연산자는 수학적인 계산에 사용되는 연산자다.

</aside>

산술 연산자는 산술이라는 의미 그대로 수학적인 계산에 사용되는 연산자로 유치원 및 초등학생 때 배우는 덧셈,뺄셈,곱셈,나눗셈 등의 수학적 기호 연산자를 뜻한다. 다만, 수학에서 사용하는 연산자와 프로그래밍에서 사용하는 연산자는 의미가 조금 다르니 그에 대해 살펴본다.

### 사칙 연산자

덧셈,뺄셈,곱셈,나눗셈은 정말 자주 쓰이는 연산자로 모두가 잘 아는 사칙연산이다.

우선순위 역시 동일하게 적용되어 곱셈과 나눗셈은 덧셈이나 뺄셈보다 높기에 우선 적용된다.

- 사용 예제코드

```java
public static void main(String args[]) {
		int a = 10;
    int b = 4;
    System.out.printf("%d + %d = %d%n", a, b, a + b);
    System.out.printf("%d - %d = %d%n", a, b, a - b);
    System.out.printf("%d * %d = %d%n", a, b, a * b);
    System.out.printf("%d / %d = %d%n", a, b, a / b);//---(1)
    System.out.printf("%d / %f = %f%n", a, (float)b, a / (float)b); //---(2)
}
```

🔷 실행결과

(1) : 10 /4 이면 2.5가 맞지만 출력 결과를 보면 2가 나온다. 그 이유는 자료형에 있다. 연산에 사용된 두 피연산자는 모두 int형이다. 연산결과 역시 int형으로 반환을 하는데 결과값인 2.5는 실수형이기에 소숫점을 버리고 정수형인 2로 반환을 한다. 그리고 이 때, 소숫점은 버림을 하지 반올림을 하지 않는다.

그럼 어떻게 소숫점까지 표현한 정확한 결과를 얻을 수 있을까 ?

그럼 피연산자중 한 쪽을 실수형으로 변환해야 한다. 위 예제코드 중 (2)항목을 보면 b를 실수형(float)으로 변경해주었다.

위의 연산과정을 보면 두 피연산자의 타입이 각각 int형과 float형으로 일치하지 않기에 타입을 맞춰줘야하는데, 보통 범위가 넓은 쪽으로 매치가 되기에 int보다 범위가 넓은 float타입으로 일치시킨 뒤 연산을 수행한다.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8ecb6bba-8641-4821-bcfe-a027ff0923f9/Untitled.png)

### 피연산자가 정수형인 경우 나누는 수로 0을 사용하면 에러가 발생한다.

피연산자가 정수형인 경우 나누는 수로 0을 사용하게 되면 ArithmeticException이 발생한다.

0이 아닌 부동 소숫점값(0.0f, 0.0d)를 사용하는 것은 가능하지만 이 경우엔 무한대(Infinity)가 반환된다.

![피연산자가 유한수가 아닌 경우의 연산결과](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7d4eeead-1896-4da4-b149-5c37a85072ab/Untitled.png)

피연산자가 유한수가 아닌 경우의 연산결과

### 작은 범위로의 형변환도 가능하다.

int형 피연산자와 float형 피연산자간에 산술연산을 하면 범위가 더 큰 쪽으로 자동 캐스팅되어 연산을 수행한다. 그럼 int형으로 결과를 받고싶을 경우엔 어떻게 해야할까? 명시적 형변환을 해주면된다.

```java
int a = 10;;
float b = 4.0f;
int value = (int)(a / b);
System.out.println(value);

byte c = 10;
byte d = 30;
byte value2 = (byte)(c * d);
System.out.println(value2);
```

[실행 결과]

2

44

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c4bc81c7-a9e3-442f-b501-a8d2b09df692/Untitled.png)

⇒ int형을 byte형으로 변환하는경우 하위 8자리(1byte)만 보존하기에 그외에 값이 손실된다.

****연산전에 충분히 큰 자료형을 사용해서 오버플로우를 막아라.****

```java
public static void main(String[] args) {
    int a = 1_000_000;
    int b = 2_000_000;

    long value = a * b;

    System.out.println(value);
}
```

⇒ value로 무엇이 출력될까? 2 x 10¹² 값을 long(8 byte)에 저장하니 정상적으로 출력이 될 것 같지만, 실제로 출력 되는 값은-1454759936 로 엉뚱한 값이 출력된다.  그 이유는 long형으로 자동형변환을 하는 시점에서는 이미 오버플로우가 발생하여 값이 변조되었기 때문에 형변환이 된다한들 값이 변하지 않는 것이다.

[int형 연산으로 overflow 발생](https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Ff9f77dd2-98d4-4783-8510-5c667db72ec3%2FUntitled.png&blockId=bb6984c7-cca5-4c65-bacf-df73418a590d)

int형 연산으로 overflow 발생

그렇기에 해당 연산이 진행되기 전  하나의 피연산자를 충분한 크기의 자료형으로 형변환을 해서 타입일치를 시켜 충분한 범위를 확보해야 한다.

```java
public static void main(String[] args) {
    int a = 1_000_000;
    int b = 2_000_000;

    long value = (long)a * b;

    System.out.println(value);//2000000000000
}
```

1. a가 long으로 형변환되며 충분한 범위 확보
2. a와 b의 타입이 일치하지 않기때문에 더 넓은 범위인 long으로 b를 형변환하여 타입 일치
3. 연산 수행하여 value에 대입

****문자도 산술연산이 가능하다.****

[https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fff53f71a-ee92-4891-acfd-c2d5419f2bfa%2Fasciifull.gif&blockId=d4de2183-b0c1-4bdf-9b3b-a3d0974469af](https://oopy.lazyrockets.com/api/v2/notion/image?src=https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2Fff53f71a-ee92-4891-acfd-c2d5419f2bfa%2Fasciifull.gif&blockId=d4de2183-b0c1-4bdf-9b3b-a3d0974469af)

산술연산자를 숫자형의 자료형 뿐 아니라 문자도 가능하다.  가능한 이유는 문자도 실제로 해당 문자의 유니코드(부호없는 정수)로 바꾸어 저장되기 때문이다.

```java
System.out.println('c' - 'b'); // 1
```

Java

⇒ c의 유니코드는 99이고, b의 코드는 98이다. 그렇기에 'c' - 'b'는 99 - 98이 되며 결과값은 1이된다.

이를 응용하면 특정 문자의 다음 문자값을 가져오는것도 가능하다.

```java
char c = 'c';
System.out.println((char)(c + 1)); //d
```

⇒c의 코드는 99이며 여기에 1을 더한 값인 100을 다시 char로 형변환 해준다면 d가 출력된다.

### 화살표(->) 연산자

- 8 버전부터 람다 표현식(lambda expression) 이 공식적으로 적용되었음
- 함수형 프로그래밍(Functional programming) 표현
    - side-effect 발생을 최소화 하기 위함
    - 조건
        - Pure function
        - Anonymous function
        - Higher-order function
    - Java 에서는 하나의 메소드가 선언된 인터페이스
- 화살표 연산자는 Java 에서 람다 표현식의 syntax 일부
    
    ```java
    (argument, ...) -> {expression}
    ```
    

```java
interface Test{
    int func(int a);
}

class Test2 {
    public void func(Test test){
        int value = test.func(3);
        System.out.println(value);
    }
}

class Operator{
    public static void main(String[] args) {
        Test2 test2 = new Test2();
				// lambda expression 사용 X 버전
        test2.func(new Test() {
            public int func(int a){
                return a + 2;
            }
        });
				// lambda expression 사용 버전
        test2.func((a) ->{
            return a + 2;
        });
    }
}
```

## 3항 연산자

- Conditional Operator
    - `?:`
    - 구조
        
        ```java
        Conditional Expression ? Expression(true인 경우) : Expression(false 인 경우);
        ```
        
- 3항 연산자 사용 VS if-else 사용
    - 3항 연산자: expression
    - if-else: statement
    - 문법적인 의미로 보자면 3항 연산자는 expression 이므로 statement 내부 expression이 위치할 수 있는 모든 곳에서 사용 가능, expression 이므로 3항 연산자 자체를 중첩해서 사용 가능

```java
class Operator{
    public static void main(String[] args) {
        int a = 2;
				// if-else statement 사용
        if(a == 2){
            a += 1;
        }
        else{
            a += 2;
        }
        
				// 3항 연산 사용
        a == 2 ? a += 1 : a+=2 ;
    }
}
```

## 연산자 우선 순위

[제목 없음](https://www.notion.so/5a7b44aed1374284add8d48f20898f0f)

**Ref.** [https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html)

- 동일 선상에 있는 연산자들은 동일한 우선 순위를 가짐
- 할당 연산 제외한 Binary Operator 는 left ⇒ right 로 평가
- 할당 연산은 right⇒ left 로 평가
