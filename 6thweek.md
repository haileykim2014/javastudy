## 목표

자바의 상속에 대해 학습하세요



## 학습할 것

- 자바 상속의 특징
- super 키워드
- 메서드 오버 라이딩
- 다이내믹 메서드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스



**상속**

상속이란? 한 클래스가 다른 클래스의 속성들을 획득하는 것. 상속을 통해 자식 클래스는 부모 클래스의 필드와 메서드를 재사용할 수 있다. OOP의 주요 개념이다. 아주 합리적이고 똑똑한 거 같다.

![https://blog.kakaocdn.net/dn/3Cy7K/btqQKvinOAY/hbRztMnr5DhSwIDdPXii81/img.png](https://blog.kakaocdn.net/dn/3Cy7K/btqQKvinOAY/hbRztMnr5DhSwIDdPXii81/img.png)

단일 상속(Single Inheritance)

단일 상속 : 한 클래스가 하나의 클래스만을 상속받는다.

![https://blog.kakaocdn.net/dn/HxiWq/btqQR6WatW8/2degWMzTZG0UedmTmh6H40/img.png](https://blog.kakaocdn.net/dn/HxiWq/btqQR6WatW8/2degWMzTZG0UedmTmh6H40/img.png)

다단계 상속(Multilevel Inheritance)

다단계 상속 : 클래스가 기본 클래스가 아닌 기본 클래스의 파생 클래스를 상속받는다.

![https://blog.kakaocdn.net/dn/c4b1jg/btqQR6WaxO0/KvOxPvzv2pTmKBkllOkjP1/img.png](https://blog.kakaocdn.net/dn/c4b1jg/btqQR6WaxO0/KvOxPvzv2pTmKBkllOkjP1/img.png)

계층적 상속(Hierarchical Inheritance)

계층적 상속 : 한 클래스가 여러 하위 클래스에 상속을 한다.

![https://blog.kakaocdn.net/dn/cb6FL3/btqQJEGEwsd/CUw7jVbWo08PBlSH3qfjN1/img.png](https://blog.kakaocdn.net/dn/cb6FL3/btqQJEGEwsd/CUw7jVbWo08PBlSH3qfjN1/img.png)

다중 상속(Multiple Inheritance)

다중 상속 : 한 클래스가 여러 개의 클래스를 상속받는다.

![https://blog.kakaocdn.net/dn/bzOfmY/btqQNqOorWO/RIqFk1KR1v86KSfXWupRnK/img.png](https://blog.kakaocdn.net/dn/bzOfmY/btqQNqOorWO/RIqFk1KR1v86KSfXWupRnK/img.png)

하이브리드 상속(Hybrid Inheritance)

**자바 상속의 특징**

- 상속을 해주는 상위 클래스를 부모 클래스(Parent Class, Super Class)라고 부른다.
- 상속을 받는 하위 클래스를 자식 클래스(Child Class, Sub Class)라고 부른다.
- 다단계 상속이 가능하고, 다중 상속을 지원하지 않는다.
- 모든 클래스는 Object 클래스의 자식 클래스이다.

```
class Parent {
    int a;
    String b;

    public void print() {
        System.out.println("a = "+a+" b = "+b);
    }
}

class Child extends Parent { // Parent 클래스를 상속 받아 Parent 클래스의 필드와 메서드를 가진다.
}
```

- 다중 상속의 문제점
- 상속받은 복수의 부모 클래스에 중복되는 필드나 메서드가 존재할 수도 있다.
- 같은 클래스를 두 번 이상 상속받을 수 있다.
- 부모 클래스에 접근할 방법이 애매해진다.

**super 키워드**

super 키워드는 자식 클래스에서 부모 클래스를 가리키는 키워드이다. super 키워드를 통해 자식 클래스는 부모 클래스의 필드나 메서드를 호출할 수 있다.

super 키워드와 헷갈릴 수도 있는 super() 메서드는 부모 클래스의 생성자 함수를 호출하는 메서드이다. 자식 클래스의 생성자 함수에는 기본적으로 super()를 호출해야 한다. 기입하지 않는 경우엔 컴파일러가 슬쩍 끼워 넣어 준다.

```
class Parent {
    String name;
    int age;

    public Parent() {
    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class Child extends Parent {
    boolean isMale;

    public Child() {
    }

    public Child(boolean isMale) {
        this.isMale = isMale;
    }

    public setName(String name) {
        super.name = name; // 부모 클래스의 필드
    }

    public setAge(int age) {
        super.age = age;  // 부모 클래스의 필드
    }

    @Override
    public String toString() {
    	return "name = "+name+", age = "+age+", isMale = "+isMale;
    }
}

class Main {
    public static void main(String[] args) {
        Child child = new Child(true);
        child.setName("bogeun");
        child.setAge(20);

        System.out.println(child);
    }
}

// result

name = bogeun, age = 20, isMale = true
```

super()는 부모 클래스의 기본 생성자이며, 인자가 추가되면 그에 맞는 생성자가 호출된다. 만약 부모 클래스에 기본 생성자가 없다면, 컴파일러가 자동으로 끼워 넣어주던 혜택은 받지 못하고, 정의된 생성자 함수를 자식 클래스의 생성자 함수마다 일일이 찾아가며 호출해줘야 한다.

```
class Parent {

    public Parent() {
    	System.out.println("나는 부모 클래스의 생성자다.");
    }

}

class Child extends Parent {

    public Child() {
    //  super();
    	System.out.println("나는 자식 클래스의 생성자다.");
    }
}

class Main {
    public static void main(String[] args) {
        Parent p = new Parent();

        System.out.println("------------------------------");

        Child c = new Child();
    }
}

// result

나는 부모 클래스의 생성자다.  // 얘도 알고보면 앞에 Object의 생성자가 호출 되겠지.
------------------------------
나는 부모 클래스의 생성자다.  // 부모 클래스의 기본 생성자가 호출 되고,
나는 자식 클래스의 생성자다.  // 그 다음 자식 클래스의 기본 생성자가 호출됨.
```

위처럼 자식 클래스의 생성자 함수에 super()가 기입되지 않아도 컴파일러가 스리슬쩍 넣어준다.

```
class Parent {  //  기본 생성자가 없는 부모 클래스

    String name;

    public Parent(String name) {
        this.name = name;
    }

}

class Child extends Parent {

    public Child() {    // 이 경우 부모 클래스에 기본 생성자가 없기 때문에
    // super();         // 컴파일 에러가 난다.
    }

    public Child() {
        super("bogeun"); // 부모 클래스의 생성자가 정확히 호출 되므로 에러가 없다.
    }

}
```

**메서드 오버 라이딩**

오버 라이딩(Overriding)은 부모 클래스로부터 상속받은 메서드를 자식 클래스에서 재정의하는 것이다.

```
class Parent {
    public void go() {
        System.out.println("I`m parent.");
    }
}

class Child extends Parent {

    @Override
    public void go() {
        System.out.println("I`m child.");
    }
}

class Main {
	public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        parent.go();
        child.go();
    }
}

// result

I`m parent.
I`m child.
```

위처럼 부모 클래스의 메소드를 자식 클래스가 새로 재정의하여 사용한다.

@Override 어노테이션은 개발자에게 '얘야 이거 오버 라이딩된 메서드란다.'라고 알려주는 역할과 부모 클래스에 없는 메서드를 착각하고 어노테이션을 붙인 경우 착각하고 있다고 알려주는 역할을 한다.

```
class Parent {
}

class Child extends Parent {

    @Override  //  컴파일 에러남. '수퍼 클래스엔 그런 거 없는데?'
    public void go() {
    }

}
```

**다이내믹 메서드 디스패치 (Dynamic Method Dispatch)**

메서드 디스패치란, 메소드를 어떻게 호출할 지를 정해서 호출하는 것이다. 여기에는 대표적으로 static과 dynamic이 있다.

먼저 정적 메소드 디스패치(static method dispatch)는 메서드가 어떻게 실행될지가 **컴파일 타임**에 결정된다. private, static, final의 메서드들은 static으로 결정되며, 컴파일 타임에 메서드가 결정된다.

```
class Parent {
    void run() {
        System.out.println("Parent.run()");
    }

    static void runStatic() {
        System.out.println("Parent.runStatic()");
    }
}

class Child extends Parent {
    @Override
    void run() {
        System.out.println("Child.run()");
    }

    static void runStatic() {
        System.out.println("Child.runStatic()");
    }
}

class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        parent.run();
        child.run();
        parent.runStatic();
        child.runStatic();
    }
}

// result

Parent.run()
Child.run()
Parent.runStatic()
Child.runStatic()
```

위의 예에서 parent나 child 두 경우 모두 컴파일 시점에 어떤 메서드를 실행할 지가 결정이 끝나고 그대로 실행을 한다.

동적 메서드 디스패치(dynamic method dispatch)는 어떤 메소드가 사용될 지 **런 타임**에 결정된다. 동적 메소드 디스패치는 객체 지향 프로그래밍의 **다형성**을 지원하기 위한 핵심 메커니즘이다. 동적 메소드 디스패치에 의해 같은 타입의 서로 다른 구현을 가진 객체들이 각각 자신이 어떤 메서드를 어떻게 동작시켜야 하는지 알게 된다.

```
class Parent {
    void run() {
        System.out.println("Parent.run()");
    }
}

class Child1 extends Parent {
    @Override
    void run() {
        System.out.println("Child1.run()");
    }
}

class Child2 extends Parent {
    @Override
    void run() {
        System.out.println("Child2.run()");
    }
}

class Main {
    public void main(String[] args) {
        Parent child1 = new Child1();
        Parent child2 = new Child2();

        child1.run();
        child2.run();
    }
}

// result

Child1.run()
Child2.run()
```

child1과 child2 모두 컴파일 시점엔 그냥 대충 Parent 클래스의 run()을 호출하면 되겠거니 하고 있다. 그러나, 런 타임에 컴파일러가 가지고 있는 타입의 정보를 가지고 자기가 어떤 메서드를 실행해야 하는 지가 결정된다.

부가적인 내용으로, 자바에서는 멤버 변수의 다형성을 허용하지 않는다. 이것은 멤버 변수는 컴파일 시점에 정해져서 런 타임에는 변화가 없다는 뜻이다.

```
class Parent {
    int x = 1;
}

class Child extends Parent {
    int x = 10;
}

class Main {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();
        Parent paild = new Child();

        System.out.println(parent.x);
        System.out.println(child.x);
        System.out.println(paild.x);
    }
}

// result

1
10
1
```

**추상 클래스**

추상 클래스는 클래스인데 추상적인 클래스이다. 추상 메서드를 가질 수 있고, 온전한 메소드도 가질 수 있는 클래스이다.

제일 많이 쓰는 예시로 Shape이라는 추상 클래스를 정의 해본다고 하면, Shape은 calArea(), printName() 등의 추상 메서드를 가진다. Shape은 String color의 멤버 변수를 가지고, getColor(), setColor()의 메서드를 가진다.

Shape의 하위 클래스로는 Triangle, Circle, Rectangle들을 정의하면, 추상 메서드에 해당하는 각각의 클래스에 맞는 메서드를 정의해줘야 한다. 온전한 형태의 메서드는 그대로 상속받아 똑같이 사용할 수도, 오버 라이딩해서 재정의할 수도 있다.

```
abstract class Shape {
    String color;

    abstract double calArea();
    abstract void printName();

    String getColor() {
        return color;
    }

    void setColor(String color) {
        this.color = color;
    }
}

class Circle {
	double radius;

    double calArea() {
        double area = 0;

        area = 3.14 * radius * radius;

        return area;
    }

    void printName() {
        System.out.println("I`m Circle.");
    }
}

class Rectangle {
    double width;
    double height;

    double calArea() {
        double area = 0;

        area = width * height;

        return area;
    }

    void printName() {
        System.out.println("I`m Rectangle.");
    }
}
```

**final 키워드**

final 키워드는 변수나 메소드 등을 immutable 하게 만들어 준다. final이 붙을 수 있는 곳은 클래스, 변수, 메서드가 있다.

변수의 경우

```
class Main {

//  멤버 변수에 붙는 경우.
    final int age = 10;

    public static void main(String[] args) {

    //  참조 변수에 final이 붙는 경우.
        final MyClass myClass = new MyClass();

        myClass = new MyClass(); // 컴파일 에러.

    //  프리미티브 타입 변수에 final이 붙는 경우.
    	final int MAX_SIZE = 100; // 상수가 되어버림.

    }

    // 메소드의 파라미터에 붙는 경우.
    void run(final int number) {
        number++;  // 컴파일 에러.
    }
}
```

메서드에 붙는 경우

```
class Parent {

    final void run() { // 메소드에 final이 붙는 경우.
        System.out.println("run");
    }

}

class Child extends Parent {

    @Override  //  오버라이딩을 못함, 컴파일 에러.
    void run() {
    }

}
```

final이 붙는 메서드는 static method dispatch로 컴파일 타임에 결정이 나버림.

클래스에 붙는 경우

```
final class Parent { // 클래스에 final이 붙는 경우.
}

class Child extends Parent { // 상속받을 수 없음, 컴파일 에러.
}
```

**Object 클래스**

자바에서 모든 클래스들의 상위 클래스이다. 내가 임의로 만든 클래스도 Object 클래스를 상속받고 있다. extends Object를 써넣지 않았는데도 어떻게 이게 되는 걸까? 이것은 컴파일러가 컴파일 타임에 쓱 끼워 넣어 준다.

내가 만든 클래스는 다른 클래스를 상속받고 있는데, 다중 상속이 되지 않는 자바인데 어떻게 Object 상속 부분을 끼워 넣어줄까? 이것은 컴파일러가 똑똑하게 가상 상위 클래스를 찾아 거기에 Object 상속을 슥 끼워넣어 준다.

이렇게 해서 직접적으로나 간접적으로나 모든 클래스는 Object 클래스를 상속받는다.
