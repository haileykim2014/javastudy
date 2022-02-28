## 프로세스와 쓰레드

**프로세스** : 실행 중인 프로그램, 자원과 쓰레드로 구성

**쓰레드** : 프로세스 내에서 실제 작업을 수행. 모든 프로세스는 최소한 하나의 쓰레드를 가지고 있다.

<aside>
💡 프로세스 : 쓰레드 = 공장 : 일꾼

</aside>

프로스세스 안에서 일하는 쓰레드

- 싱글 쓰레드 프로세스 : 자원 + 스레드
- 멀디 스레드 프로세스 : 자원 + 스레드 + 스레드 + ... + 스레드 (일꾼 여러명)

<aside>
💡 하나의 새로운 프로세스를 생성하는 것보다 하나의 새로운 쓰레드를 생성하는 것이 더 적은 비용이 든다.

</aside>

### 멀티쓰레드의 장단점

대부분의 프로그램이 멀티스레드로 작성되어 있다. 그러나 멀티쓰레드 프로그래밍이 장점만 있는 것은 아니다.

| 장점 | - 시스템 자원을 보다 효율적으로 사용할 수 있다.
- 사용자에 대한 응답성이 향상된다.
- 작업이 분리되어 코드가 간결해 진다.
” 여러모로 좋다” |
| --- | --- |
| 단점 | - 동기화(synchronization)에 주의해야한다.
- 교착상태(dead-lock)가 발생하지 않도록 주의해야 한다.
- 각 쓰레드가 효율적으로 고르게 실행될 수 있게 해야한다.
”프로그래밍 할떄 고려해야할 사항들이 많다” |

### 쓰레드의 구현과 실행

### Thread클래스를 상속 (자바는 단일 상속)

```java
class MyTread extends Thread{
		public void run() { //Thread클래스의 run()을 오버라이딩
			//작업 내용
	}
}
```

### Runnable 인터페이스를 구현

```java
class MyThread2 implements Runnable{
		public void run() {
				//작업 내용
	}
}
```

```java
package jungsuk;

public class Ex13_1 {
    public static void main(String args[]) {
        ThreadEx1_1 t1 = new ThreadEx1_1();

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();

    }
}

class ThreadEx1_1 extends Thread { //Thread클래스를 상속해서 쓰레드를 구현
    public void run() { //쓰레드가 수행할 작업
        for (int i = 0; i < 5; i++) {
            System.out.println(getName()); // 조상인 Thread의 getName()을 호출
        }
    }
}

class ThreadEx1_2 implements Runnable { // Runnable 인터페이스를 구현해서 쓰레드를 구현
    public void run() {
        for (int i = 0; i < 5; i++) {
            //Thread.currentThread() - 현재 실행 중인 Thread를 반환한다.
            System.out.println(Thread.currentThread().getName());
        }
    }
}
```

Thread-1
Thread-1
Thread-1
Thread-1
Thread-1
Thread-0
Thread-0
Thread-0
Thread-0
Thread-0
