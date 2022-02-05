# **목표**

자바의 패키지에 대해 학습하세요.

# **학습할 것 (필수)**

- package 키워드
- import 키워드
- 접근제어자
- 클래스패스
- CLASSPATH 환경변수
- classpath 옵션


# 패키지

`package c.javapackage`

- 클래스를 구분짓는 폴더 개념
- 자바는 패키지의 가장 상위 디렉토리(root) 에서 실행해야한다는 약속이 있기 때문에 해당 패키지로 가서 컴파일 하지 않는다.
- 소스에 가장 첫 줄에 있어야하고, 패키지 선언은 소스 하나에 하나만 있어야한다.
- 패키지 이름과 위치한 폴더의 이름이 같아야한다.
- 패키지이름을 java 로 시작하면 안된다.
- 모든 클래스에는 정의된 클래스 이름과 패키지 이름이 있다. 이 둘을 합쳐야 완전하게 한 클래스를 표현한다고 할 수 있으며 FQCN(Fully Qualified Class Name) 이라고 한다. ([출처: blog.baesangwoo.dev/posts/java-livestudy-7week/)](https://blog.baesangwoo.dev/posts/java-livestudy-7week/)

예를 들어 String 클래스의 패키지는 java.lang이며 FQCN은 java.lang.String이 된다.

![https://blog.kakaocdn.net/dn/bXu11o/btqRwaqG86L/uzdHgz2rdK7w93gZn79vkk/img.png](https://blog.kakaocdn.net/dn/bXu11o/btqRwaqG86L/uzdHgz2rdK7w93gZn79vkk/img.png)

)https://linuxhandbook.com/linux-directory-structure/ ( 리눅스에서 디렉토리 구조도가 있듯이 클래스의 역할을 구분짓기 위해  패키지라는 개념이 필요하다.)

### **(꼭 지키진 않지만) 패키지 이름 지정 규칙**

[제목 없음](https://www.notion.so/844410bbc0044a6283f09c8f59d6cdf3)

### **패키지 이름 명명 규칙**

- 패키지 이름은 모두 소문자여야한다.
- 자바의 예약어를 사용하면 안된다. (예, `int`, `static`)
- 개발 패키지 표준은 정하는 것에 따라 지정하면 된다.

### 빌트-인 패키지(Built-in Package)

(출처: [www.notion.so/ed8e346f88f54849a06ff968b1877ca5](https://www.notion.so/ed8e346f88f54849a06ff968b1877ca5) )

자바는 개발자들이 사용할 수 있도록 여러 많은 패키지 및 클래스를 제공한다.

가장 자주 쓰이는 패키지로는 **java.lang**과 **java.util**이 있다.

java.lang은 자주 사용하는 패키지이지만 한번도 **import**하여 사용한적이 없다.

**즉, 자바에서 java.lang 패키지는 아주 기본적인 것들이기 때문에 import로 불러오지 않아도 자바가 알아서 java.lang의 클래스를 불러온다.**

예) String, System

```
import java.lang.String;
import java.lang.System;
public class Main{
	public static void main(String[] args){
		String str = this is from java.lang.String";
        System.out.println(str);
        }
 }
```

# import 키워드

`import 패키지명.클래스명`

다른패키지명에 있는 클래스를 찾지 못할때 사용한다.

패키지에 다수의 클래스를 `import` 하는 경우 `import 패키지명.*` 처럼 import 할 수 있다.

[인텔리 제이 , 윈도우] `Alt` +`Enter` 을 이용해 바로 import 가능

`import static`의 경우, static 한 변수( 클래스 변수)와 static 한 메소드를 사용하고자 할때 용이하다. ( 이것이 없다면, 클래스.함수, 클래스.변수 형태로 이용해야함.)

사실 우리는 아주 똑똑한 intellyj 를 사용하고 있기 때문에, 그냥 빨간줄이 보이면, alt enter 을 누른다. 우리가 기억해야하는 것은 오히려 import 를 하지 않아도되는 패키지이다.

### **import 를 하지 않아도되는 패키지**

- java.lang 패키지 ( 예:: `System.out.println("--static case--");`, `String` )
- 같은 패키지

**:: 같은 패키지, 다른 패키지인지만 신경쓰면 된다**

### ****

- 코드 예시

![https://blog.kakaocdn.net/dn/b28vEt/btqRqQGBKoH/qiKGL5Tk39j7Id4zTlJ0w1/img.png](https://blog.kakaocdn.net/dn/b28vEt/btqRqQGBKoH/qiKGL5Tk39j7Id4zTlJ0w1/img.png)

패키지 계층

```
package me.whiteship.javapackage.sub;

public class Sub {
  public Sub() {}
  public void subClassMethod() {}
}

```

```
package me.whiteship.javapackage.sub;

public class SubStatic {

  public static final String CLASS_NAME = "SubStatic";

  public static void subStaticMethod() {
    System.out.println("subStaticMethod is called");
  }
}

```

```
package me.whiteship.javapackage;

import me.whiteship.javapackage.sub.Sub;

import static me.whiteship.javapackage.sub.SubStatic.CLASS_NAME;
import static me.whiteship.javapackage.sub.SubStatic.subStaticMethod;

public class Package {

  Package() {}

  public static void main(String[] args) {

    Sub sub = new Sub();
    sub.subClassMethod();
    System.out.println("--static case--");
    System.out.println(CLASS_NAME);
    subStaticMethod();
  }
}

```

---

### **접근 제어자(Access Modifier)**

접근제어자는 클래스, 메소드, 인스턴스 및 클래스 변수를 선언할 때, 사용된다. 자바에서 사용하는 접근지시자는 `public`, `protected`, `package-private(접근 제어자 없음)`, `private`로 총 네가지 이다.

- `public`
    - 누구나 접근 가능하다.
- `protected`
    - 같은 패키지에 있거나, 상속 받는 경우 사용할 수 있다.
- `package-private`
    - 아무 접근제어자를 적어주지 않은 경우이며, `package-private`라 불린다. 같은 패키지 내에서 접근 가능하다.
- `private`
    - 해당 클래스 내에서만 접근 가능하다.

![https://blog.kakaocdn.net/dn/Kb2tD/btqRrPm3DAn/9Q28T3eXG4n3kukPuMiup0/img.png](https://blog.kakaocdn.net/dn/Kb2tD/btqRrPm3DAn/9Q28T3eXG4n3kukPuMiup0/img.png)

접근 제어자 관계도

- 코드예시

```
package me.whiteship.javapackage.sub;

public class AccessModifier {
  public void publicMethod() {}

  protected void protectedMethod() {}

  void packagePrivateMethod() {}

  private void privateMethod() {}
}

```

```
package me.whiteship.javapackage;

import me.whiteship.javapackage.sub.AccessModifier;

public class AccessCall {

  public static void main(String[] args) {
    AccessModifier accessModifier = new AccessModifier();
    accessModifier.publicMethod();
    accessModifier.protectedMethod();
    accessModifier.packagePrivateMethod();
    accessModifier.privateMethod();
  }
}

```

![https://blog.kakaocdn.net/dn/cVTPg8/btqRqQGCb2C/mUors2hsMrr8koYkbvFuEK/img.png](https://blog.kakaocdn.net/dn/cVTPg8/btqRqQGCb2C/mUors2hsMrr8koYkbvFuEK/img.png)

각기 다른 에러 코드 확인

대표적인 예시로는, 변수의 경우, 변수를 변경 못하게 하고, 꼭 메소드를 통해 변경이나 조회할 수 있도록 할 때, 접근제어자를 많이 이용한다.

[제목 없음](https://www.notion.so/eeaf76db40d848df895e2f58ebd6e278)

또 다른 예시로

하나의 소스 파일 내에서 2개 이상의 클래스를 정의하는 경우 (권장 X), 파일 이름과 같은 클래스 명을 제외한 클래스는 package private이여서 같은 패키지 내에 있는 클래스들만, 이 클래스의 객체를 생성하고, 이용할 수 있다.

```
package me.whiteship.javapackage;

public class PublicClass {
  public static void main(String[] args) {
    System.out.println("public Class");
  }

}
class PublicSecondClass {
}
```

---

# 클래스패스

클래스를 찾기위한 경로.

**JVM이(누가) 프로그램을 실행할 때(언제), 클래스파일을 찾는 데(**왜**) 클래스 패스(기준이 되는 파일 경로)(무엇을)를 사용한다.**

즉,JVM은 CLASSPATH의 경로를 확인하여 라이브러리 클래스들의위치를 참조하게 된다. 그러나 J2JDK 버전부터는 \jre\lib\ext 폴더에 필요한 클래스 라이브러리들을 복사해 놓으면 사용가능하여 특별한 경우가 아니면 설정을 하지 않는다.

잠깐 자바프로그램 실행과정을 돌이켜 생각해보자.

![https://blog.kakaocdn.net/dn/c9SxVe/btqRt6IVNEY/qzfqkA4a6Da4Z2tVyD9d4k/img.png](https://blog.kakaocdn.net/dn/c9SxVe/btqRt6IVNEY/qzfqkA4a6Da4Z2tVyD9d4k/img.png)

자바 프로그램 실행과정    (https://asfirstalways.tistory.com/158)

소스 코드(.java로 끝나는 파일)를 컴파일하면 소스 코드가 “바이트 코드"로 변환된다. java runtime(java 또는 jre)으로 이 .class 파일에 포함된 명령을 실행하려면, 이 파일을 찾을 수 있어야 한다. .class 파일을 찾을 때, classpath에 지정된 경로를 사용한다.

classpath는 .class 파일이 포함된 디렉토리와 파일을 콜론(;)으로 구분한 목록이다.

이 classpath 를 지정하기 위한 두 가지 방법이 있다.

- CLASSPATH 환경변수 사용
- java runtime 에 -classpath 옵션 사용

### CLASSPATH 환경변수 사용

`CLASSPATH=.;C:\Program Files\Java\jdk-10.0.1\lib\tools.jar`

컴퓨터 시스템 변수 설정을 통해 지정할 수 있다.JVM이 시작될 때 JVM의 클래스 로더는 이 환경 변수를 호출한다. 그래서 환경 변수에 설정되어 있는 디렉토리가 호출되면 그 디렉토리에 있는 클래스들을 먼저 JVM에 로드한다. 그러므로 CLASSPATH 환경 변수에는 필스 클래스들이 위치한 디렉토리를 등록하도록 한다.

컴퓨터 시스템 변수 설정을 통해 지정할 수 있다.

![https://blog.kakaocdn.net/dn/cgTFrB/btqRqb5kigF/TIDMKzmCWECK2NDscHxQH0/img.png](https://blog.kakaocdn.net/dn/cgTFrB/btqRqb5kigF/TIDMKzmCWECK2NDscHxQH0/img.png)

https://blog.opid.kr/62    ( 컴퓨터 시스템 변수 설정을 통해 지정 )

### java runtime 에 -classpath 옵션 사용

`javac <options> <souce files>`

컴파일러가 컴파일 하기 위해서 필요로 하는 참조할 클래스 파일들을 찾기 위해서 컴파일시 파일 경로를 지정해주는옵션

`Hello.java`파일이 `C:\Java` 디렉터리에 존재하고,

필요한 클래스 파일들이 `C:\Java\Engclasses`에 위치한다면,`javac -classpath C:\Java\Engclasses C:\Java\Hello.java` 로 해주면 된다.

만약 참조할 클래스 파일들이 그 외의 다른 디렉터리, 그리고 현 디렉토리에도 존재한다면,`javac -classpath .;C:\Java\Engclasses;C;\Java\Korclasses C:\Java\Hello.java`

과 같이`;` 으로 구분해줄 수 있다. ( `.` 은 현 디렉토리, `..` 은 현 디렉토리에서 상위 디렉토리를 의미한다.)

또한 classpath 대신 단축어인 cp를 사용해도 된다.

`javac -cp .;C:\Java\Engclasses;C;\Java\Korclasses C:\Java\Hello.java`

# **참고 문헌**

자바의 신

[https://blog.opid.kr/62](https://blog.opid.kr/62)

[https://effectivesquid.tistory.com/entry/자바-클래스패스classpath란](https://effectivesquid.tistory.com/entry/%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4%ED%8C%A8%EC%8A%A4classpath%EB%9E%80)

[http://blog.naver.com/PostView.nhn?blogId=minsuk0123&logNo=44865799](http://blog.naver.com/PostView.nhn?blogId=minsuk0123&logNo=44865799)

[https://hyoje420.tistory.com/7](https://hyoje420.tistory.com/7)

[www.notion.so/ed8e346f88f54849a06ff968b1877ca5](https://www.notion.so/ed8e346f88f54849a06ff968b1877ca5)

[blog.baesangwoo.dev/posts/java-livestudy-7week/](https://blog.baesangwoo.dev/posts/java-livestudy-7week/)

# **유용한 크롬 확장 프로그램 추천 : 한글 url 복사**

한글 url 을 복사하는데 encoding 되어 알 수 없는 긴 문자열로 주소가 복사되는게 싫다면? 이 크롬 확장자를 이용해보자.

[chrome.google.com/webstore/detail/decode-url-by-click/mahkjonofhhakemoelnblidpijhjhabk](https://chrome.google.com/webstore/detail/decode-url-by-click/mahkjonofhhakemoelnblidpijhjhabk)

사용방법은 간단하다.

![https://blog.kakaocdn.net/dn/cbyT9p/btqRt5b7FQl/D9qEXAwNkNJPys8iOvvAl1/img.png](https://blog.kakaocdn.net/dn/cbyT9p/btqRt5b7FQl/D9qEXAwNkNJPys8iOvvAl1/img.png)

effectivesquid.tistory.com/entry/자바-클래스패스classpath란 주소창

여기서 url 을 복사( 윈도우의경우, ctrl +C ) 한후, 저 pin 한 크롬 확장 프로그램을 누른 뒤, ctrl + v 하면, 깔끔한 한글 url 을 만날 수 있다.

[effectivesquid.tistory.com/entry/자바-클래스패스classpath란](https://effectivesquid.tistory.com/entry/%EC%9E%90%EB%B0%94-%ED%81%B4%EB%9E%98%EC%8A%A4%ED%8C%A8%EC%8A%A4classpath%EB%9E%80)

![https://blog.kakaocdn.net/dn/o08r1/btqRwbb66fT/lLdgosNK63fq1nKeso5dj0/img.png](https://blog.kakaocdn.net/dn/o08r1/btqRwbb66fT/lLdgosNK63fq1nKeso5dj0/img.png)

성공적으로 decoding 이 되면 초록색 불로 바뀐다
