## 목표

자바가 제공하는 제어문을 학습하세요.

## 학습할 것

선택문

반복문

## 제어문

제어문 : 코드의 실행 흐름(순서)를 제어하는 구문

(cf. 순차문 : 코드가 작성된 순서대로 실행되는 구문)

## 조건문

### if문

간단한 의사 결정 문

명령문 또는 명령문 블록의 실행 여부를 결정하는데 사용.

주어진 조건이 참이면 명령문 블록이 실행되고 그렇지 않으면 블록을 건너뛴다.

조건을 실행하는 동안 조건이 참이면 해당 명령문이 실행되고 나머지 코드는 건너뛴다.

어떤 조건도 참이 아니면 마지막 else문이 실행

```java
if(condition)
{
   // If condition is true then this block of statements will be executed
}
else if(condition)
{
   // If condition is true then this block of statements will be executed
}
else 
{
   // If none of condition is true, then this block of statements will be executed
}
```

# 선택문 ( switch/case 문 )

다중 if문 대신 사용, 조건문의 일종.

if문을 여러 개 사용하면 실행 속도가 느려지기 때문에 사용.

switch함수의 매개변수에 들어오는 값에 따라 코드를 실행합니다. 즉, **스위치 문은** 조건에 기초한 다수의 블록 중 한 블록의 명령문을 실행한다. switch 문에는 많은 선택 항목이 있으며 각 선택 항목에 대해 다른 작업을 수행 할 수 있다.

1. switch 문 표현식은 byte, short, int, long, enum 유형, String 및 Byte, Short, Int 및 Long과 같은 **일부 래퍼 유형**일 수 있다..(단, switch 표현식에서만 wrapper 허용하고, case 에는 wrapper 를 허용하지 않는다.) **switch ()** 대괄호 사이에 변수 또는 표현식을 넣는다. 
2. 케이스 값은 리터럴 또는 상수 여야합니다.
3. 각 케이스는 고유해야한다. 중복 케이스 값을 생성하면 컴파일 타임 오류가 발생
4. 각 케이스에는 선택적인 **break 문** 이있다. 스위치 내부에서 명령문 시퀀스를 종료하고 스위치 표현식 다음에 컨트롤을 점프하는 데 사용된다.
5. 어떤 경우에도 **break 문을** 사용하지 않으면 break 문에 도달 할 때까지 다음 case로 실행이 계속된다.
6. **스위치 문 케이스에** 해당하는 경우가 **없으면** 이 default 가 실행된다. 기본 케이스에는 **break 문이** 필요하지 않는다

```java
switch(조건식){
     case 값1:
     실행 코드
     break;
     case 값2:
     실행 코드
     break;
     case 값3:
     실행 코드
     break;
     default: case에 해당하는 값이 없을 때 실행할 코드 
      break;        
}
/*
case 값의 개수는 임의로 설정 가능
break : 코드가 실행되다가 break를 만나면,
바로 실행을 중지하고 해당 loop에서 빠져나옴 
*/
```

# for 문

사용자가 코드 블록을 여러 번 실행하려는 경우 사용한다. **반복 횟수가 고정되어 있는 것이 특징징이다.** (  for ( ;; ) 의경우는 무제한 반복횟. )For 루프는 초기화, 조건, for 루프 본문, 증가 / 감소의 네 부분으로 구성.

**1. 초기화**

**2. 조건**

**3. for 루프 본문**

**4. 증가 / 감소**

```
for(initialization; condition; increment/decrement)
{
   // Body of for loop
}
```

**1. 초기화 :** 초기화는 루프의 첫 번째 부분이며 한 번만 발생. 루프의 시작점을 표시 여기에서 변수를 선언 및 초기화하거나 이미 초기화 된 변수를 사용한다.

**2. 조건 :** 조건은 루프의 두 번째 부분이며 부울 값을 true 또는 false로 반환해야하는 조건을 제공 / 작성한다. 루프의 상태를 테스트하기 위해 매번 실행된다. 조건이 거짓이 될 때까지 실행을 계속한다.

**3. for 루프의 본문 :** 조건 참을 평가 한 후 매번 실행되는 코드 블록을 포함한다.

**4. 증가 / 감소 :** 변수의 인덱스 값을 업데이트하는데 사용된다.

# while 문

**루프 상태**  조건이 만족 될 때까지 허용 코드가 반복하여 실행된다. **반복 횟수가 고정되지 않은 경우** **while 루프** 를 사용하는 것이 좋다  . **입력 제어 루프** 라고도 한다.

```
while(condition)
{
   // Body of while loop
}
```

- **true를** 반환 하면 **while 루프** 의 본문 이 실행된다. **while 루프** 의 본문 에서 명령문은 다음 반복을 위해 처리되는 변수에 대한 업데이트 값을 포함한다
- false를 반환하면 루프가 종료되어 수명주기의 끝을 표시한다
- ( while 루프 조건에서 true를 전달하면. 그러면 무한 루프가된다. )

# do-while 문

while 루프와 거의 유사하다. 루프 본문을 실행 한 후 조건을 확인하는 유일한 차이점이있다.  따라서, 조건에 관계 없이 적어도 한번 이상 반복문을 돈다는 특징을 가진다. **Exit Control Loop** 라고도한다.

```
do
{
   // Body of loop
} While(condition);
```

# for each 문

for each는 J2SE 5.0 부터 추가되었다. for each 라는 키워드가 따로 있는 것은 아니고 동일한 for를 이용한다. 하지만 조건식 부분이 조금 다르다. 보통 다른 언어에서 for each 라고 많이 하므로 자바에서도 보통 for each문이라고 말한다.

단, foreach문은 따로 반복회수를 명시적으로 주는 것이 불가능하고, 1스탭씩 순차적으로 반복될때만 사용가능하다는 제약이 있다.

```
for (변수타입 변수명 : 루프를 돌릴 객체) {
    // 실행 코드
}
```

루프를 돌릴 객체로는 루프를 돌릴수 있는 형태인 Array나 Collections가 가능하고  Iterable<E>를 상속받은 객체또한 가능하다.

예시

```
String[] temp = { "귤", "감", "토마토" };
for (String e : temp) {
    System.out.println(e);
}

// 기존 for 문
for (int i = 0; i < temp .length; i++) {
    System.out.println(temp[i]);
}
```

### JUnit 5.x.0 설정

pom.xml에 다음 종속성을 추가해야합니다 .

```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.1.0</version>
    <scope>test</scope>
</dependency>
```

이 버전 **이 작동하려면 Java 8** 이 **필요** .

또한 IntelliJ뿐만 아니라 Eclipse의 JUnit 플랫폼에서 단위 테스트를 실행하는 직접 지원. 물론 Maven Test 목표를 사용하여 테스트를 실행할 수도 있다.

반면 IntelliJ는 기본적으로 JUnit 5를 지원한다. 따라서 IntelliJ에서 JUnit 5를 실행하는 것은 매우 간단. 오른쪽 클릭 –> 실행 또는 Ctrl-Shift-F10.

---

**과제 1. live-study 대시 보드를 만드는 코드를 작성.**

```java
import org.kohsuke.github.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class GitHubIssue {
    //personal token need to secret
    private static final String MY_PERSONAL_TOKEN = "MY_SECRET_TOKEN";

    public static void main(String[] args) throws IOException {
        GitHub github = new GitHubBuilder().withOAuthToken(MY_PERSONAL_TOKEN).build();

        //Repository 연결
        GHRepository repo = github.getRepository("whiteship/live-study");

        //IssueState ALL, OPEN, CLOSED
        List<GHIssue> issues = repo.getIssues(GHIssueState.ALL);
        Map<String, Integer> participant = new HashMap<>();

        //1-18개 이슈
        for (GHIssue issue : issues) {
            Set<String> onlyOneParticipant = new HashSet<>();

            //댓글 한개 이상 단 경우 유저이름 중복 제거
            for (GHIssueComment comment : issue.getComments()) {
                onlyOneParticipant.add(comment.getUser().getName());
            }

            //카운트 증가해주기
            for (String name : onlyOneParticipant) {
                if(participant.containsKey(name)){
                    participant.replace(name,participant.get(name)+1);
                    continue;
                }
                participant.put(name,1);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //참여율 출력
        for(String name : participant.keySet()){
            double rate = (double)(participant.get(name) * 100) / issues.size();
            bw.write("name : " + name);
            bw.write(", Participation Rate : "+String.format("%.2f",rate)+"%");
            bw.newLine();
        }
        bw.close();
    }

}
```
