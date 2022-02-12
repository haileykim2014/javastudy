# **9주차 : 예외 처리**

# **목표**

자바의 예외 처리에 대해 학습하세요.

# **학습할 것 (필수)**

- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이는?
- RuntimeException과 RE가 아닌 것의 차이는?
- 커스텀한 예외 만드는 방법

# **Exception과 Error의 차이는?**

- 먼저 알아보기 전에 Exception 과 Error에 대해 알아보자

# **예외의 종류**

- checked exception
- error
- runtime exception 혹은 unchecked exception

# **Error**

### **개념**

- **컴퓨터 하드웨어의 오동작** 또는 **고장**으로 인해 응용프로그램에 이상이 생겼거나 JVM 실행에 문제가 생겼을 경우 발생하는 것이다.
- **프로세스에 영향을 준다**
- **시스템 레벨에서 발생한다(자바 프로그램 외의 오류)**

### **종류**

VirtualMachineError

OutOfMemoryError

StackOverflowError

등등

# **Exception(예외)**

### **개념**

- 컴퓨터의 에러가 아닌 **사용자의 잘못된 조작** 또는 **개발자의 잘못된 코딩**으로 인해 발생하는 프로그램 오류이다.
- 예외가 발생하면 프로그램이 종료가 된다는 것은 에러와 동일하지만 예외는 **예외처리(Exception Handling)를** 통해 프로그램을 종료되지 않고 정상적으로 작동되게 만들어줄 수 있다. **자바에서 예외처리는 Try Catch문**을 통해 해줄 수 있다.
- **개발자가 구현한 로직에서 발생**
- **쓰레드에 영향을 준다**

### **종류**

### **Checked Exception**

**특징**

- 반드시 예외 처리 해야한다

**확인**

- 컴파일 단계

**대표 예외**

- RuntimeException를 제외한 모든 예외
- IOException
- SQLException 지금은 없다.

# **runtime exception(이하 런타임 예외)**

- 예외가 발생할 것을 미리 감지하지 못했을 때 발생.
- 런타임 예외에 해당하는 모든 예외들은 RuntimeException을 확장한 예외들이다.

# **모든 예외의 부모 클래스는 java.lang.Throwable클래스이다**

- Exception과 Error 클래스는 Throwable 클래스를 상속받아 처리하도록 되어있다.
- Exception이나 Error를 처리할 때 Throwable로 처리해도 무관하다
- Throwable 클래스에 선언되어있고, Exception클래스에서 Overring한 메소드는 10개가 넘으며 가장 많이 사용되는 메소드는 getMassage, toString, printStackTrace가 있다.
    - getMessage()
        - 예외 메시지를 String형태로 제공받는다.예외가 출력되었을 때 어떤 예외가 발생되었는지를 확인할 때 매우 유용하다.메시지를 활용하여 별도의 예외 메시지를 사용자에게 보여주려고 할 때 좋다.
    - toString()
        - 예외메시지를 String형태로 제공받는다.getMessage() 메소드보다는 약간 더 자세하게, 예외 클래스 이름도 같이 제공한다.
    - printStackTrace()
        - 가장 첫 줄에는 예외 메시지를 출력하고, 두 번째 줄부터는 예외가 발생하게 된 메소드들의 호출 관계(스택 트레이스를)출력해준다.
        - printStackTrace()는 서비스 운용시 사용하면 안된다

# **getMessage()**

```
public class ThrowableSample {
    public static void main(String[] args) {
        ThrowableSample sample = new ThrowableSample();
        sample.throwable();
    }

    private void throwable() {
        int[] intArray = new int[5];
        try {
            intArray =null;
            System.out.println(intArray[5]);
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }

    }
}
//출력
null
```

- 간단하게 출력된다

```
public class ThrowableSample {
    public static void main(String[] args) {
        ThrowableSample sample = new ThrowableSample();
        sample.throwable();
    }

    private void throwable() {
        int[] intArray = new int[5];
        try {
            intArray =null;
            System.out.println(intArray[5]);
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            System.out.println(t.toString());
        }

    }
}
//출력
null
java.lang.NullPointerException

```

- 좀 더 자세하게 출력된다

```
public class ThrowableSample {
    public static void main(String[] args) {
        ThrowableSample sample = new ThrowableSample();
        sample.throwable();
    }

    private void throwable() {
        int[] intArray = new int[5];
        try {
            intArray =null;
            System.out.println(intArray[5]);
        } catch (Throwable t) {
            System.out.println(t.getMessage());
            System.out.println(t.toString());
            t.printStackTrace();
        }

    }
}
//출력
null
java.lang.NullPointerException
java.lang.NullPointerException
    at me.thewing.liveStudy._9week.ThrowableSample.throwable(ThrowableSample.java:13)
    at me.thewing.liveStudy._9week.ThrowableSample.main(ThrowableSample.java:6)
```

- 매우 자세한 메시지를 볼 수 있다.
- **이 메소드는 개발할 때에만 사용해야한다.**
- 운영할 시스템에 적용시 엄청난 양의 로그가 쌓이게 된다. 꼭 필요한 곳에만 사용할 것

# **반복문 내에서는 Checked Exception에 대한 처리는 지양해야한다**

```
for (String item : items) {
    try {
        insert(item);
    }catch (SQLException e) {
        e.printStackTrace();
    }
}
```

- 반복문 내에서 Checked Exception에 대한 예외처리 구문이 들어가게 되면 성능은 2배 3배 떨어지게 된다. 이러한 경우에는 insert에서 예외 발생 시, RuntimeException으로 한번 Wrapping하여 Exception이 발생 되도록 하고 반복문 내에서는 최대한 예외처리에 대한 코드를 제거하는 것이 성능 상 유리하다.

# **자바에서 예외 처리 방법 (try, catch, throw, throws, finally)**

- java에서는 프로그램이 실행되는 도중 발생하는 예외를 처리하기 위해 try /catch/ finally 문을 사용할 수 있다

# **문법**

```
try {

    예외를 처리하길 원하는 실행 코드;

} catch (e1) {

    e1 예외가 발생할 경우에 실행될 코드;

} catch (e2) {

    e2 예외가 발생할 경우에 실행될 코드;

}

...

finally {

    예외 발생 여부와 상관없이 무조건 실행될 코드;

}
```

try 블록

- 기본적으로 맨 먼저 실행되는 코드로 여기에 발생한 예외는 catch블록에서 처리된다

catch 블록

- try 블록에서 발생한 예외 코드나 예외 객체를 인수로 전달 받아 그 처리를 담당한다

finally 블록

- 이 블록은 try 블록에서 예외가 발생하건 안하건 맨 마지막에 무조건 실행된다

catch 블록과 finally 블록은 선택적인 옵션으로 반드시 사용할 필요는 없다

따라서 사용할 수 있는 모든 try 구문은 아래와 같다

```
1. try / catch

2. try / finally

3. try / catch / ... / finally
```

# **예외 throws**

```
public class ThrowSample {
    public static void main(String[] args) {
        ThrowSample sample = new ThrowSample();
        sample.throwException(13);

    }

    private void throwException(int number) {
        try {
            if(number > 12){
                throw new Exception("Number is over than 12");
            }
            System.out.println("Number is "+number);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
//결과
java.lang.Exception: Number is over than 12 << 이 부분 출력
    me.thewing.liveStudy._9week.ThrowSample.throwException(ThrowSample.java:13)
    me.thewing.liveStudy._9week.ThrowSample.main(ThrowSample.java:6)
```

- 강제 예외 발생
    - `throw new Exception("Number is over than 12")`;

```
public void throwExceptions(int number) throws Exception {
    if(number > 12){
        throw new Exception("Number is over than 12");
    }
    System.out.println("Number is "+number);
}
```

- 예외가 발생 했을때 `try-catch`로 묶어주지 않아도 메소드를 호출한 메소드로 예외 처리를 위임하는 것이기 때문에 전혀 문제가 되지 않는다.
- `throwsException()` 이라는 메소드는 `Exception`을 던진다고 메소드 선언부에 throws 선언을 해놓았기 때문에, `throwsException()` 메소드를 호출한 메소드에서는 반드시 `try-catch` 블록으로 `throwsException()` 메소드를 감싸주어야만 한다. 그렇지 않을 경우에 컴파일 에러가 발생한다.

```
public static void main(String[] args) {
    ThrowSample sample = new ThrowSample();
    sample.throwException(13);
    sample.throwExceptions(13); <<여기 오류
}
```

- 해결방안 1
    
    ```
      public static void main(String[] args) {
          ThrowSample sample = new ThrowSample();
          sample.throwException(13);
          try {
              sample.throwExceptions(13);
          } catch (Exception e){
    
          }
      }
    ```
    
    - `try-catch`로 묶는 것이다.
- 해결방안 2
    
    ```
      public static void main(String[] args) throws Exception {
            ThrowSample sample = new ThrowSample();
            sample.throwException(13);
            sample.throwExceptions(13);
      }
    ```
    
    - 호출한 메소드( 여기서는 `main()` 메소드)에서도 다시 throws 해버리면 된다.
- **이미 throws 한것을 다시 throws 하지말아야한다**
- 가장 좋은 방법은 `throws` 하는 메소드를 호출하는 메소드에서 `try-catch` 로 처리하는 것이다

# **예외의 throws와 throw**

- 메소드를 선언할 때 매개 변수 소괄호 뒤에 `throws`라는 예약어를 적어 준 뒤 예외를 선언하면, 해당 메소드에서 선언한 예외가 발생했을 때 호출한 메소드로 예외가 전달된다.만약 메소드에서 두 가지 이상의 예외를 던질 수 있다면, `implements`처럼 콤마로 구분하여 예외 클래스 이름을 적어주면 된다.
- `try` 블록 내에서 예외를 발생시킬 경우에는 `throw`라는 예약어를 적어 준 뒤 예외 객체를 생성하거나, 생성되어있는 객체를 명시해준다.`throw`한 예외 클래스가 `catch` 블록에 선언되어 있지 않거나, `throws` 선언에 포함되어 있지 않으면 컴파일 에러가 발생한다.
- `catch` 블록에서 예외를 throw 할 경우에도 메소드 선언의 throws 구문에 해당 예외가 정의되어 있어야만한다.

# **try - with - resources**

- exception시 resources를 자동으로 close() 해준다
- 사용 로직을 작성할 때 **객체는 AutoCloseable 인터페이스를 구현한 객체**여야한다
- 자바 7부터 추가

### **AutoCloseable 인터페이스**

```
public interface AutoCloseable {
    void close() throws Exception;
}

```

- 자동으로 리소스를 close()해주는 인터페이스

### **try - catch - finally 예제**

```
FileOutputStream out = null;
try {
    out = new FileOutputStream("thewing.txt");
    // 생략
} catch (FileNotFoundException e) {
    e.printStackTrace();
} finally {
    if (out != null) {
        try {
            out.close(); //close 예외가 발생할 수 있다.
        } catch(IOException e) {
                e.printStackTrace();
        }
}
```

### **try - with - resources 예제**

```
try(FileOutputStream out = new FileOutputStream("thewing.txt")) {
        //생략
} catch(IOException e){
    e.printStackTrace();
}

```

# **Multi Catch**

- 하나의 try 블록에서 여러개의 예외가 발생할 때 많은 catch문을 사용한다. 이렇게 사용했을 때 중복되는 코드들이 발생하는데 그것을 줄여주기 위함이다.
- 자바 7부터 추가

### **주의사항**

- Multi Catch문에 사용된 예외들은 예외의 상속관계에서 부모와 자식관계에 있으면 안된다

### **예제**

```
try {
    //생략
} catch ( NoSuchElementException | RuntimeException e) {

}
```

```
Exception in thread "main" java.lang.Error: Unresolved compilation problem:
    The exception NoSuchElementException is already caught by the alternative RuntimeException
```

- `NoSuchElementException` 은 `RuntimeException` 의 자식 클래스 이기 때문에 `RuntimeException` 하나만 처리가 가능하다

# **자바가 제공하는 예외 계층 구조**

1. RuntimeException 클래스
2. RuntimeException 를 제외한 Exception 클래스의 자식 클래스

![https://blog.kakaocdn.net/dn/cuV0JO/btqS4Nn0U9E/3uUYkcvjsRrcicVxaqEWJk/img.png](https://blog.kakaocdn.net/dn/cuV0JO/btqS4Nn0U9E/3uUYkcvjsRrcicVxaqEWJk/img.png)

출처 - [http://www.tcpschool.com/java/java_exception_class](http://www.tcpschool.com/java/java_exception_class)

# **RuntimeException과 RE가 아닌 것의 차이는?**

- 위 그림에서 파란색 점선 영역이 CheckedException이고 주황색 영역 부분이 UnCheckedException 이다
- 런타임(JVM 구동)시 예외가 발생하는 것이 UnCheckedException(RuntimeException)이고 실행하지 않고 예외가 검출되는 것이 CheckedException 이다

### **RuntimeException**

- RuntimeException 클래스를 상속받는 자식 클래스들은 주로 치명적인 예외 상황을 발생시키지 않는 예외들로 구성되어있다.
- try / catch문을 사용하기 보다는 프로그램을 작성하면서 예외가 발생하지 않도록 주의 하는 것이 좋다
- 예외 발생 시 트랜잭션 rollback한다

### **CheckedException**

- CheckedException 클래스인 Exception 클래스에 속하는 자식 클래스들은 치명적인 예외 상황을 발생시키기 때문에 반드시 try / catch 문을 사용하여 예외처리를 해야만한다
- 자바 컴파일러는 RuntimeException 클래스 이외의 Exception 클래스의 자식 클래스에 속하는 예외가 발생할 가능성이 있는 구문에는 반드시 예외를 처리하도록 강제하고 있다
- 만약 이러한 예외가 발생할 가능성이 있는 구문을 예외처리하지 않았을 때는 컴파일 시 오류를 발생시킨다.
- 컴파일 단계에서 확인가능
- 예외 발생 시 트랜잭션 rollback 하지 않는다

# **커스텀한 예외 만드는 방법**

### **예외를 만들 수 있다?**

- `Throwable`을 직접 상속 받는 클래스는 `Exception`과 `Error`가 있다
- *`Error`와 관련된 클래스는 개발자가 손대서는 절대 안된다**
- 직접 만들땐 `Exception` 을 처리하는 클래스라면 `java.lang.Exception` 클래스의 상속을 받는 것이 좋다.

```
public class MyException extends Exception{
    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
    }
}
```

- super() 메소드

`this()` 메소드가 같은 클래스의 다른 생성자를 호출할 때 사용된다면, `super()` 메소드는 부모 클래스의 생성자를 호출할 때 사용됩니다.

자식 클래스의 인스턴스를 생성하면, 해당 인스턴스에는 자식 클래스의 고유 멤버뿐만 아니라 부모 클래스의 모든 멤버까지도 포함되어 있습니다.

따라서 부모 클래스의 멤버를 초기화하기 위해서는 자식 클래스의 생성자에서 부모 클래스의 생성자까지 호출해야만 합니다.

이러한 부모 클래스의 생성자 호출은 모든 클래스의 부모 클래스인 Object 클래스의 생성자까지 계속 거슬러 올라가며 수행됩니다.

```
public class MyException extends Exception{
    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
    }
}

```

```
public class CustomException {
    public static void main(String[] args) {
        CustomException sample = new CustomException();
        try {
            sample.throwMyException(13);
        } catch (MyException mye) {
            mye.printStackTrace();
        }
    }

    private void throwMyException(int number) throws MyException{
        try {
            if(number > 12) {
                throw new MyException("Number is over than 12");
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

//출력
me.thewing.liveStudy._9week.MyException: Number is over than 12
    me.thewing.liveStudy._9week.CustomException.throwMyException(CustomException.java:16)
    me.thewing.liveStudy._9week.CustomException.main(CustomException.java:7)
```

- `MyException`을 던진다고 명시해 놓았지만, 이 메소드를 호출하는 메소드(`main()`메소드)에서는 반드시 `MyException`으로 `catch` 할 필요는 없다.`MyException`의 부모 클래스인 `Exception` 클래스로 `catch`해도 무방하다.그런데 , 앞에서 `MyException`이 예외 클래스가 되려면 `Throwable` 클래스의 자식 클래스가 되어야 한다고 이야기했다. 만약 `MyException` 을 선언할 때 관련된 클래스를 확장하지 않았을 때에는 이 부분에서 제대로 컴파일이 되지 않는다. 다시 말해서, 다음과 같이 `MyException` 이 아무런 상속을 받지 않고 선언되어있다면,

```
public class MyException { // extends Exception{
    public MyException(){
        super();
    }

    public MyException(String message){
//        super(message);
    }
}
```

- `CustomException` 클래스를 컴파일할 때 에러메시지들을 내뿜게된다

```
public class CustomException {
    public static void main(String[] args) {
        CustomException sample = new CustomException();
        try {
            sample.throwMyException(13);
        } catch (MyException mye) {  <<error
            mye.printStackTrace();
        }
    }

    private void throwMyException(int number) throws MyException{
        try {
            if(number > 12) {
                throw new MyException("Number is over than 12");  <<error
            }
        } catch (MyException e) { <<error
            e.printStackTrace();
        }
    }
}
```

### **자바 예외 처리 전략**

- 예외를 어떻게 처리할지를 알아두는 것이 좋다
- 실행시에 발생할 확률이 매우 높은 경우에는 런타임 예외로 만드는것이 나을 수도 있다. 즉, 클래스 선언시 `extends Exception` 대신에 `extends RuntimeException` 으로 선언하는 것이다. 이렇게 되면 해당 예외를 던지는(throw하는) 메소드를 사용하더라도 `try-catch` 로 묶지 않아도 컴파일시에 예외가 발생하지 않는다. 하지만, 이 경우에는 예외가 발생할 경우 해당 클래스를 호출하는 다른 클래스에서 예외를 처리하도록 구조적인 안전장치가 되어있어야만 한다. 여기서 안전 장치라고 하는 것은 `try-catch` 로 묶지 않은 메소드를 호출하는 메소드에서 예외를 처리하는 `try-catch` 가 되어 있는 것을 이야기한다

```
public void methodCaller() {
    try {
        methodCaller();
    } catch (Exception e) {
        // 예외처리
    }
}

public void methodCallee() {
    // RuntimeException 예외 발생 가능성 있는 부분분
}
```

- 이와 같이 `unchecked exception`인 `RuntimeException`이 발생하는 메소드가 있다면, 그 메소드를 호출하는 메소드는 `try-catch` 로 묶어주지 않더라도 컴파일할 때 문제가 생기지 않는다.하지만, 예외가 발생할 확률은 높으므로, 위의 예에서 `methodCaller()` 처럼 `try-catch` 로 묶어주는 것이 좋다

```
try {
    //예외발생 가능한코드
} catch (SomeException e) {
    // 여기 아무 코드없음
}
```

- 이렇게 `catch`문장을 처리해주는건 피해야한다.
- 여기서 `SomeException` 이라는 것은 그냥 어떤 예외를 잡는다는 것을 의미할뿐 실제 존재한다는게 아니다
- catch에 아무런 작업을 하지않으면 어디서 발생했는지 전혀 문제를 찾을 수 없다.

### **정리**

- 임의의 예외 클래스를 만들때에는, 반드시 `try-catch` 로 묶어줄 필요가 있을 경우에만 `Exception` 클래스를 확장한다.일반적으로 실행시 예외를 처리할 수 있는 경우에는 `RuntimeException` 클래스를 확장하는 것을 권장한다
- `catch` 문 내에 아무런 작업 없이 공백을 놔두면 예외 분석이 어려워지므로 꼭 로그처리와 같은 예외 처리를 해줘야만한다

# **Reference**

- 자바의신
- [http://www.tcpschool.com/java](http://www.tcpschool.com/java)
