## 2주차 : 자바 데이터 타입, 변수 그리고 배열

## 목표

자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다.

학습할것

- 프리미티브 타입 종류와 값의 범위 그리고 기본값
- 프리미티브 타입과 레퍼런스 타입
- 리터럴
- 변수 선언 및 초기화 하는 방법
- 변수의 스코프와 라이프타임
- 타입변환, 캐스팅 그리고 타입 프로모션
- 1차 및 2차 배열 선언하기
- 타입추론, var

## 프리미티브 타입의 종류

기본 자료형 혹은 원시자료형 이라고 불리는 프리미티브 타입은 값을 할당 할때 변수의 주소값에 값이 그 자체로 저장되는 데이터 타입이다.

해당 데이터 타입은 값이 할당되면 앞서 살펴본 JVM Runtime Data Area 영역 중 stack 영역에 값이 저장된다.

## 프리미티브 타입의 종류

Java에서 프리미티브 타입의 종류는 총 8가지이다.

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/88c514fb-196c-4937-ae11-a85e3765477a/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20211216%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211216T151321Z&X-Amz-Expires=86400&X-Amz-Signature=b160ee2b5b8f611373770ababc3bd3732531b7b8fcd3bc15844fb5c9cc219258&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

## 프리미티브 타입과 레퍼런스 타입

### 레퍼런스 타입이란?

참조자로형이라 불리는 레퍼런스 타입의 종류는 무한하다. 프리미티브 타입과 달리 JVM Runtime Data Area 영역 중 heap 영역에 할당되는데 레퍼런스 타입의 변수 주소 값에는 값이 아닌 heap영역에 할당된 주소가 저장된다. 

## 리터럴

리터럴은 변수나 상수에 저장되는 값 그 자체를 의미한다.

```java
int a = 10;
```

에서 바로 10이 리터럴이다.

고정된 값을 표현하는 리터럴은 정수를 표현하는 리터럴, 실수를 표현하는 리터럴,문자를 표현하는 리터럴, boolean 을 표현하는 리터럴, 문자열을 표현하는 리터럴 등이 있다.

### 정수 리터럴

정수를 표현하는 방법은 여러가지 있다. 일반적으로 사용하는 10진법부터 2진법,8진법과 같은 방법이 있고 자바에서는 다양한 진법을 지원한다.

```java
int decimal = 26; //일반적인 형태 10진법
int octal = 032; //제일 앞에 0이 붙으면 8 진법
int hexadecimal = 0x1a;//0x가 붙으면 16진법
int binary = 0b11010; //0b가 붙으면 2진법
```

정수 리터럴은 기본적으로 int형이고 long타입을 표현하려면 I,L을 마지막에 붙여야 한다.

### 실수 리터럴

실수 타입의 리터럴은 기본적으로 DOUBLE타입이고, FLOAT 타입으로 표현하려면 F를 명시적으로 붙여야한다.

```java
double a = 0.1; //0.1
double b = 1E-1; //0.1
float c = 0.1f;//0.1
```

### 문자 리터럴

문자는 작은 따옴표(')안에 표현 할 수 있다.

```java
char a = 'a';
```

![Untitled](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/71aa3faa-7d23-48bb-be52-1fd3ab12cd17/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20211216%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211216T151803Z&X-Amz-Expires=86400&X-Amz-Signature=d32b0b0ef0280e77164ef97f8de63f14d0307e036056da4c88a4081f61ecafe2&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

### 문자열 리터럴

문자열은 큰따옴표(")안에 표현할 수 있다.

```java
String a = "abc";
```

문자열 리터럴에는 조금 특이한 점이 있다. 다른 리터럴들은 프리미티브 타입의 값을 표현하기 위해 존재한다. 그런데  문자열(String)은 레퍼런스 타입이지, 프리미티브 타입이 아니다. String은 literal을 지원하는데 literal 방식으로 String에 값을 주면 heap영역에서 String constant pool 이라는 특수한 영역에 값이 저장된다. 그리고 동일한 값을 쓰는 경우에 다른 일반적인 레퍼런스타입 처럼 heap에 또 올라가지 않고 String constant pool에 존재하는 값을 참조하는 방식으로 작동한다.

### boolean 리터럴

true, false로 표현할 수 있다.

```java
boolean a = true;
boolean b = false;
```

## 변수 선언 및 초기화하는 방법

### Declaration ?

변수선언의 의미 : 저장공간을 확보하겠다.

```java
int a;
```

int 타입의 값을 저장 할 수 있는 공간을 확보했고 (int타입은 4byte) 그 공간을 지칭할 이름은 a이다.

### Initialization ?

변수를 초기화  한다는 것은 저장공간에 원하는 값을 저장하는 것을 의미한다. 변수를 선언하고 나면 해당 공간에는 아무런 의미 없는 쓰레기값이 들어간다. 그리고 그 상태에서 컴파일을 시도하면 

variable might not have been initialized 와 같은 컴파일 에러코드가 발생한다.

변수는 선언 후에 초기화를 해야하며 위에 선언한 변수에 대한 초기화는 다음과 같이 할 수 있다.

```java
a = 10;
```

### 선언과 초기화

변수의 선언과 초기화를  한 줄에 하는 것도 가능하다.

```java
int a = 10;
```

## 변수의 스코프와 라이프타임

### scope ? Life time ?

변수의 스코프란 해당 변수를 사용할 수 있는 영역범위를 뜻하고 라이프타임은 해당 변수가 메모리에 언제까지 살아있는지를 의미한다. 변수의 경우 scope에 따라 Instance variables,Class Variables,Local Variables 로 나눌 수 있다.

### Instance Variables

클래스 안에서 선언되어 있고, 어떠한 method나 block안에서 선언되지 않은 변수

scope - static method 를 제외한 클래스 전체

lifetime - 클래스를 인스턴스화한 객체가 메모리에서 사라질 때 까지

### Class Variables

클래스 안에서 선언되어있고, 어떠한 메서드나 블럭안에서 선언되지 않았으며 static 키워드가 포함되어 선언된 변수

scope - 클래스 전체

lifetime - 프로그램 종료시까지

### Local Variables

인스턴스 변수,클래스 변수가 아닌 모든 변수

scope - 변수가 선언된 block 내부

lifetime - control 이 변수가 선언된 block 내부에 있는 동안

```java
public class scope_and_lifetime {
    int num1, num2;   		//Instance Variables
    static int result;  	//Class Variable
    int add(int a, int b){  	//Local Variables
        num1 = a;
        num2 = b;
        return a+b;
    }
}
```

## 타입 변환, 캐스팅 그리고 타입 프로모션

## Type casting ?

타입캐스팅이란 크기가 더 큰 자료형을 크기가 더 작은 자료형에 대입하는 것

예를 들어 int (4byte)타입의 데이터를 byte(1byte)타입에 대입하는 경우가 있을 수 있다.

변환과정에서 데이터의 손실이나 변형이 올 수도 있다.

```java
int a = 10;     
byte b = (byte)a;
System.out.println(b); //  -> 10
(byte 는 -256~255까지 표현할 수 있음으로 타입캐스팅을 했음에도 데이터 변형이나 
손실은 오지 않았다)

int a = 10000;     
byte b = (byte)a;
System.out.println(b); //  -> 16
(표현범위를 벗어나는 값을 강제로 타입캐스팅해 데이터에 변형이 생겼다)
```

## Type promotion ?

타입캐스팅과 반대로 크기가 더 작은 자료형을 더 큰 자료형에 대입하는 것

예를 들어 byte(1byte)타입의 데이터를 int(4byte)타입에 대입하는 경우이다.

이 경우 데이터 손실이나 변형이 오지 않음으로 캐스팅 할 때 처럼 명시적으로 적지않아도 자동으로 변환이 가능하다.

```java
byte a = 10;
int b = a;
System.out.println(b); //  -> 10
```

위와 같은 타입변환은 프리미티브 타입뿐만 아니라 레퍼런스 타입에서도 가능하다. 

부모클래스로의 타입변환은 자동적으로 가능하지만 자식클래스로의 타입변환은 타입캐스팅이 필요하다. 자식클래스는 부모클래스의 필드나 메소드를 물려받음으로 자식클래스타입의 객체를 부모클래스 타입으로 바꾼다고해서 데이터의 손실이나 변형이 일어나진 않는다.

## 1차 및 2차 배열 선언하기

### Array ?

배열이란 동일한 타입의 데이터를 연속된 공간에 저장하기 위한 자료구조

### 1차 배열의 선언

배열을 선언하기 위해선 [ ]를 사용해야한다.

```java
int [] arr = new int[10];
```

int 타입의 연속된 10개의 데이터를 저장하는 공간을 arr이라는 이름으로 명칭하겠다.

배열에 값을 할당하는 예시

```java
arr[0] = 10;
arr[1] = 20;

//또는

int arr [] = {1,2,3}
```

### 2차 배열의 선언

2차 배열도 1차배열과 유사하며 다음과 같이 사용

```java
int [][] arr = new int [2][2];
arr[0][0] = 1;
arr[0][1] = 2;
arr[1][0] = 3;
arr[1][1] = 4;

위 코드는 다음 코드와 동일하다 

int arr[][] = {{1,2},{3,4}}
```

## 타입 추론, var

타입 추론이란 데이터 타입을 소스코드에 명시하지 않아도 컴파일 단계에서 컴파일러가 타입을 유추해 정해주는 것을 뜻한다. 1.5버전부터 추가된 Generic 이나 자바8버전에서 추가된 lamb에서 타입추론이 사용된다. 그리고 자바 10에서는 이러한 타입추론을 사용하는 var라는 Local Variable Type-reference가 추가되었다.
