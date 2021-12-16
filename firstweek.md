목표

- JVM이란 무엇인가
- 컴파일 하는 방법
- 실행하는 방법
- 바이트 코드란 ?
- JIT 컴파일러란 ? 어떻게 동작하나 ?
- JVM 구성요소
- JDK와 JRE차이

## JVM이란 무엇인가 ?

- Java Virtual Machine 의 약자로 Java Byte Code를 OS에 맞게 해석해주는 역할을 하는 가상머신
- JVM 버전이 OS마다 있다 ex, 윈도우용 가상 머신, 맥용 가상머신
- 한번 작성해서 어디서든 실행할 수 있다.
- 자바 코드로 작성한 프로그램은 실행할 환경에 독립적으로 실행할 수 있게 만들어준다.

## 컴파일 하는 방법

- .java 파일 → .class파일(바이트코드)로 만드는 것
- JDK를 설치하면 bin directory안에 javac.exe라는 java compiler가 포함되어 있다
- 이 javac를 사용해서 .class파일을 만든다
- 컴파일 : 미리 해두는 번역 작업
- JIT 가 그때그때 번역해준다.

## 실행하는 방법
<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/fb837012-e7f3-468a-90df-fe9cc228f4ee/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20211216%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211216T151852Z&X-Amz-Expires=86400&X-Amz-Signature=5b55f935212d819188f5c353e383e34464dcf30a64f1df465c0c5453e44c155d&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject">

- 메모장에 자바코드 작성→[Hello.java](http://Hello.java)로 저장→javac Hello.java →.class 파일 생성→ java Hello(실행) →메모장 내용출력
- .java → .class → class loader → execution engine → runtime data area
- JVM에서 실행과정
    - class loader를 통해 .class파일들을 JVM에 올린다.
    - Execution Engine의 interpreter와 JIT compiler를 통해 해석된다.
    - runtime data area에 비채되어 수행

## 바이트코드란 무엇인가

- JVM이 이해할 수 있는 언어로 변환된 자바 소스코드를 의미
- 자바 컴파일러에 의해 변환되는 코드의 명령어의 크기가 1byte라서 자바 바이트 코드라고 불림
- 자바 바이트 코드는 자바 가상 머신만 설치되어 있다면 어느 운영체제에서도 실행 가능

## JVM 구성 요소
<img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/cc01cbca-24f9-4447-b6f5-78123b9da3d4/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20211201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211201T151200Z&X-Amz-Expires=86400&X-Amz-Signature=68f5ed13fa2e64f1d44cfb925684ff22e27314b28bc4ed74c940a8876c9626a8&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject"/>

- Class Loader
    
    runtime 시점에 클래스를 JVM내부로 로딩하게 해주며 클래스 파일을 분석한 뒤에 Runtime data area에 배치한다.
    
- Runtime data areas
    
    Class Loader에서 분석된 클래스 파일의 데이터를 저장하고 실행중에 필요한 데이터를 저장한다.
    
    5개의 영역으로 구분
    
    - static : 가장 먼저 데이터가 저장되는 공간, 클래스 로더에 의해 로딩된 클래스,메서드,클래스변수,전역변수 저장
    - Heap : new 연산자 통해 생성된 객체 저장
    - Stack : 기본형 데이터 타입 저장, 지역변수, 매개변수, 리턴값, 참조변수 저장
    - PC Register :JVM이 수행할 명령어의 주소를 저장
    - Native method stack : 기계어로 작성된 코드 실행하는 공간, 다른 언어로 작성된 코드 수행
- Execution Engine
    
    Runtime Data Area에 배치된 바이트코드를 해석하고 실행한다. 이때 Interpreter 방식과 JIT 컴파일 방식을 혼합하여 해석한다.
    
    인터프리터 방식을 사용하다가 일정한 기준이 넘어가면 JIT 컴파일 방식으로 실행한다.
    
    - Interpreter : 바이트코드를 한 줄씩 읽고 해석
    - JIT 컴파일 (Just In Time Complie) : 바이트 코드를 런타임 시점에 바로 기계어로 변환한다.
- Garbage Collector//
    
    Garbage Collector 는 Heap 메모리 영역에 생성된 객체들 중에 참조되지 않은 객체들을 제거하는 역할을 한다. GC의 동작시간은 일정하게 정해져 있지 않기 때문에 언제 객체를 정리할 지는 알 수 없다. 즉 바로 참조가 없어지자 마자 작동하는 것이 아니다.
    
    GC를 수행하는 동안 GC Thread를 제외한 다른 모든 Thread는 일시정지 상태가 된다.
    
    최조 JVM이 나왔을때 Interpreter(한 줄씩 해석하고 실행)이었기 때문에 속도가 느리다는 단점이 있었지만 JIT compiler (Just In Time) 방식을 통해 이점을 보완했다.
    

## JIT 컴파일러란 무엇이며 어떻게 동작하는지 ?

- JVM의 Execution Engine에 속해있다.
- JIT컴파일러는 Just In Time 컴파일러로 바이트코드를 기계어로 번역하여 실행하는 것을 뜻한다.
- JIT는 bytecode를 어셈블러 같은 nativecode로 바꿔서 실행이 빠르지만 역시 변환하는데 비용이 발생한다.  이 같은 이유 때문에 JVM은 모든 코드를 JIT compiler 방식으로 실행하지 않고 interpreter 방식을 사용하다 일정 기준이 넘어가면 JIT compiler 방식으로 실행한다.
- 인터프리터 방식은 바이트코드를 한 줄씩 읽으면서(번역하면서) 코드를 실행하기 때문에 동일한 메소드를 실행하는 경우 중복해서 번역하는 비효율이 있다. 이를 방지해서 보다 좋은 성능을 낼 수 있게 하기 위해 JIT 컴파일러는 번역한 내용을 캐싱해 두었다가 동일한 메소드를 실행할 경우 다시 번역하지 않고 캐싱된 내용을 실행한다.

## JDK와 JRE의 차이
<img width="" src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/edd1e504-8027-4778-b7f6-e022063206cd/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20211201%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20211201T151011Z&X-Amz-Expires=86400&X-Amz-Signature=fa09c5460f05ea50433c4d73080a5c4364f04c0d835ec0a52333b7ba9239000d&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject"/>

- JDK : Java Development Kit, 자바 개발 도구
    
    JVM, Java API, Java Tool, java Compiler
    
    JRE에서 제공하는 실행 환경 뿐만 아니라 자바 개발에 필요한 여러가지 명령어 그리고 컴파일러를 포함 
    
- JRE : Java Runtime Environment, 자바 실행 환경
    
    JVM, JAVA API
    
    자바 애플리케이션을 실행하기 위한 최소의 실행 환경 제공
    
    바이트 코드들이 돌아갈 수있게 도와준다.
    
    [자바의 구동 원리와 JVM(Java Virtual Machine)](https://gbsb.tistory.com/2)

## 마치며
주임님의 추천으로 백기선님의 지난 스터디 커리큘럼을 참고해서 자바 공부를 시작했다.
학원 다닐때 쌤이 말씀해주셨던 부분인데 막상 다른사람에게 설명하려 하니 다시 들여다 봐야할 부분들이 생겼다.
JVM의 구성요소 중 데이터 영역 및 GC의 역할에 대해서도 고민하면서 작업하는 때가 왔음좋겠다... 
