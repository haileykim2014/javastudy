# ✔ **목표**

자바의 Class에 대해 학습하세요.

# ✔ **학습할 것 (필수)**

- 클래스 정의하는 방법
- 객체 만드는 방법 (new 키워드 이해하기)
- 메소드 정의하는 방법
- 생성자 정의하는 방법
- this 키워드 이해하기

## 💡 클래스 정의하는 방법

**객체지향 프로그래밍(OOP)**은 **현실 세계의 사물을 객체로 보고, 객체의 속성과 기능을 기반으로 프로그래밍하는 기법**이다. 

**클래스**는 객체지향 프로그래밍에서 **객체를 정의해주는 틀**이라고 생각하면 된다. 즉, **객체의 속성과 기능을 하나로 묶어놓은 틀**이다. 

자바에서 클래스는 **필드, 생성자, 메소**드로 구성된다.

- **필드(멤버 변수)** : 객체지향에서 **속성**에 해당하며 멤버 변수라고도 한다.
- **생성자** : 변수에 초기값을 대입하여 사용하듯 클래스에도 동일한 형식으로 생성해 **초기화를 해주는 역할**을 한다.
- **메소드** : 객체지향에서 **기능(행위)**에 해당하며, 클래스를 사용하여 메소드내에 정의된 행위를 실행하는 역할을 한다.

```
//접근지정자 class(키워드) 클래스이름 { }
public class Person {
	//필드, 멤버변수
	private String name;
	private String age;
	
	//default 생성자, 생략이 가능하지만 파라미터를 가진 생성자가 있을시 반드시 명시해야한다.
	public Person(){
		
	} 
	//파라미터를 가진 생성자, 파라미터를 가지고 변수를 초기화한다.
	public Person(String name, String age){
		this.name = name;
		this.age = age;
	}
	
	//메소드, 이름을 가져오는 행위를 한다.
	public String getName(){
		//메소드 내부 기능
		return name;
	}
}
```

자바에서는 클래스를 정의하기 class 키워드를 사용하며, 외부 클래스가 해당 클래스에 접근하는 범위를 **접근 지정자**를 통해 제한할 수 있다.

접근 지정자는 **public, protected, default, private** 네 가지가 있다. 

[자바 접근지정자](https://www.notion.so/98da105ce45246b9a85e27d9613f5a0c)

클래스를 정의할 때 지켜야하는 **명명규칙이 존재**한다.

1. 첫 문자가 문자나 '_', '$'의 특수문자로 시작되어야 하며 숫자로 시작할 수 없다.
2. 자바의 키워드는 사용할 수 없다.
3. 자바의 식별자는 대소문자를 구분한다.
4. 식별자 길이는 제한이 없고 공백은 포함할 수 없다.

```
//가능한 클래스 명
class Person {}
class _Person {}

//불가능한 클래스 명
class @Person {}
class 1Person {}
class new {}
class One Person {}
```

## 💡 객체 만드는 방법 (new 키워드 이해하기)

클래스를 정의했다면 클래스로부터 객체를 만들어 사용해야한다. 이러한 과정을 **클래스의 인스턴스화**라 정의한다. 

객체는 **new 키워드**를 이용해 생성이 가능하다. new 키워드를 이용하면 **[메모리 힙 영역](https://velog.io/@zayson/%EB%B0%B1%EA%B8%B0%EC%84%A0%EB%8B%98%EA%B3%BC-%ED%95%A8%EA%BB%98%ED%95%98%EB%8A%94-live-study-1%EC%A3%BC%EC%B0%A8-JVM%EC%9D%80-%EB%AC%B4%EC%97%87%EC%9D%B4%EB%A9%B0-%EC%9E%90%EB%B0%94-%EC%BD%94%EB%93%9C%EB%8A%94-%EC%96%B4%EB%96%BB%EA%B2%8C-%EC%8B%A4%ED%96%89%ED%95%98%EB%8A%94-%EA%B2%83%EC%9D%B8%EA%B0%80#runtime-data-area)에 데이터를 저장할 영역을 할당 받은 후 해당 영역의 주소를 객체에게 반환**하여 객체를 사용할수 있도록 만들어준다. 

객체를 생성하기 위해 사용하는 것이 클래스의 구조 중 하나였던 생성자이다.

```
//클래스이름 변수명 = new(키워드) 클래스이름(생성자 호출)

Person person = new Person();  // 기본 생성자
Person person1 = new Person("로베르토 레반도프스키",32); 
person1.getName();  //로베르토 레반도프스키

Map<String, Integer> map = new HashMap<>();
```

## 💡 메소드 정의하는 방법

클래스 내부의 메소드는 **접근지정자, 리턴타입, 메소드명, 파라미터(선택)로 구성된 정의부**와 **메소드의 기능을 호출하는 호출부**로 구성된다.

```
//접근지정자 리턴타입 메소드명(파라미터)
public String getName() {... 호출부 ...}
public void setName(String name) {..}
```

메소드를 정의할 때 중요한 기법이 있는데 바로 메소드 오버로딩과 메소드 오버라이딩이다.

자바의 객체지향의 특징인 다형성을 이용한 방법으로 코드의 변경과 확장을 용이하게 해주는 자바의 대표적인 특징이다.

### 📌 메소드 오버로딩(Method Overloading)

메소드 오버로딩은 파라미터의 갯수나 타입이 다르다면 동일한 이름의 메소드명을 사용해 메소드를 정의할 수 있는 기법이다. 

매개변수는 동일하고 리턴타입이 다른 경우에는 메소드 오버로딩이 성립하지 않는다. 

예를 들면, System.out.println()이 대표적인 메소드 오버로딩 기법 중 하나이다.

```
//메소드 오버로딩
public String getName() {...}
public String getName(int age) {...}

//대표적인 메소드 오버로딩
System.out.println("바이에른 뮌헨");
System.out.println("1900);
```

메소드 오버로딩의 장점은 하나의 이름으로 다양한 기능을 사용할 수 있으므로 동일한 기능에 대해 다른 이름을 정의하는 것이므로 사용하는데 편의성을 더해준다. 

### 📌 메소드 오버라이딩(Method Overriding)

메소드 오버라이딩은 상위 클래스가 정의한 메소드를 하위 클래스가 가져와 변경하거나 확장하는 기법, 즉 하위 클래스에서 메소드를 재정의하는 기법이다.

```
class Person {
	public void info() {
		System.out.println("사람입니다");
	}
}

class Adult extends Person {
	@Override
	public void info() {
		System.out.println("어른입니다.");
	}
}

class Child extends Person {
	@Override
	public void info() {
		System.out.println("어린이입니다.");
	}
}

Person person = new Person();
Adult adult = new Adult();
Child child = new Child();

person.info();     //사람입니다.
adult.info();      //어른입니다.
child.info();      //어린이입니다.
```

메소드 오버라이딩은 상위 클래스의 메소드를 하위 클래스에서 메소드를 재정의하기 때문에 확장과 변경에 용이하다는 장점이 있다.

## 💡 생성자 정의하는 방법

변수를 선언하고 초기화하는 것과 마찬가지로 **클래스를 생성하고 객체를 호출할 때 객체를 초기화** 하기 위해 사용되는 것이 **생성자**이다.

생성자는 **기본 생성자, 묵시적 생성자, 명시적 생성자**로 구분된다.

1. **기본 생성자** : 클래스 내부에 선언된 생성자가 없는 경우 객체 생성 시에 컴파일러가 자동으로 추가해주는 생성자이다.
2. **묵시적 생성자** : 파라미터 값을 가지지 않는 생성자이다.
3. **명시적 생성자** : 파라미터 값을 가지는 생성자이다.

```
class Person() {...} -> 기본 생성자 호출 
class Person() {
	//묵시적 생성자
	public Person() {
		System.out.println("생성되었습니다.");
	}
	
	//명시적 생성자 
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}
} 
```

생성자는 몇가지 특징을 가지고 있다. 

- 생성자는 **리턴 타입을 가지지 않는다**.
- 생성자는 **클래스 이름과 동일**하다.
- 모든 클래스는 **생성자가 반드시 존재**하고, **한개 이상**의 생성자를 가진다.
- 클래스 내부에 생성자를 선언하지 않으면 컴파일러가 기본 생성자를 선언해 사용한다.
- **명시적 생성자만 선언되있는 경우** **파라미터가 없는 생성자를 사용하고 싶다면 묵시적 생성자를 선언**해주어야한다. (생성자가 클래스 내부에 선언되어 있기 때문에 **기본 생성자가 생성되지 않는다**.)

## 💡 this키워드 이해하기

**this 키워드**는 **클래스가 인스턴스화 되었을때 자기 자신의 메모리 주소**를 가지고 있다. 

즉, **자기자신을 나타내는 키워드**라 생각하면 된다. 또한, 클래스 내부의 필드 이름과 메소드를 통해 넘어온 파라미터의 변수명이 동일한 경우 this키워드를 이용해 **클래스 내부의 필드이름과 파라미터를 구분**해준다. 

```
class Person {
	private String name;
	public Person(String name) {
		this.name = name;   // 클래스 필드 name = 파라미터 name
	}
}
```

**this()**는 **클래스 내부에서 생성자를 호출**한다. 

this()의 경우 **호출하는 곳의 첫 번째 문장**에서 호출되어야 한다. 생성자가 파라미터가 있는 경우 this()안에 생성자 파라미터 타입에 맞게 직접 입력하여 사용할 수 있다.

```
class Person {
	private String name;
	public Person(String name) {
		this.name = name;   // 클래스 필드 name = 파라미터 name
	}
	
	public Person(String name)
		this(name+"입니다");
	}
}
```

# ✔ **과제 (Optional)**

- int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
- int value, Node left, right를 가지고 있어야 합니다.
- BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
- DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.

**이진트리는 각각의 노드의 자식 노드의 개수가 2개 이하인 트리**를 말한다. 이진트리의 종류로는 **완전이진트리(Complete Binary Tree), 포화이진트리(Perfect Binary Tree) ,정 이진트리(Full Binary Tree)**가 있다.

- **완전 이진 트리** : 노드가 루트, 왼쪽, 오른쪽 순으로 차례때로 채워지는 트리를 말하고 반드시 왼쪽부터 채워져 있어야한다.
- **포화 이진 트리** : 리프 노드의 레벨이 모두 동일하고 트리가 가득 채워져 있는 트리를 말한다. 즉, 노드의 갯수가 $2^N-1$개를 가진다.
- **정 이진 트리** :  노드가 두 개의 자식노드를 갖는다. 홀수 개의 자식 노드를 가질 수 없다.
    
    ![[출처] [https://sean-ma.tistory.com/24](https://sean-ma.tistory.com/24)](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/787a6992-c525-45bc-976f-aae2ff50f4a5/Untitled.png)
    
    [출처] [https://sean-ma.tistory.com/24](https://sean-ma.tistory.com/24)
    

Node.java

```
public class Node {
    private Node left;
    private Node right;
    private int value;

    public Node(Node left, Node right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
```

BinaryTree.java

```
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    //Level-order 방식 순회와 동일
    public void BFS(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            Node node = que.poll();
            System.out.print(node.getValue()+" ");
            if(node.getLeft() != null)
                que.offer(node.getLeft());
            if(node.getRight() != null)
                que.offer(node.getRight());
        }
        System.out.println();
    }

    //왼쪽, 루트, 오른쪽 순으로 순회 (Inorder 방식 순회)
    public void DFS(Node root) {
        if(root == null)
            return;
        DFS(root.getLeft());
        System.out.print(root.getValue()+" ");
        DFS(root.getRight());
    }
}
```

BinaryTreeTest.java

```
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {
    private static Node root;
    private static BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        Node node10 = new Node(null,null,10);
        Node node9 = new Node(null,null,9);
        Node node8 = new Node(node10,null,8);
        Node node7 = new Node(null,node9,7);
        Node node6 = new Node(node8,null,6);
        Node node5 = new Node(null,null,5);
        Node node4= new Node(node7,null,4);
        Node node3 = new Node(node5,node6,3);
        Node node2 = new Node(node4,null,2);
        Node node1 = new Node(node2,node3,1);

        binaryTree = new BinaryTree(node1);
        root = binaryTree.getRoot();
    }

    @Test
    @DisplayName("root 값 가져오기")
    void getRoot() {
        Assertions.assertEquals(1,binaryTree.getRoot().getValue());
    }

    @Test
    @DisplayName("BFS 테스트, 레벨오더")
    void BFS() {
        System.out.println(1+" "+2+" "+3+" "+4+" "+5+" "+6+" "+7+" "+8+" "+9+" "+10);
        binaryTree.BFS(root);
    }

    @Test
    @DisplayName("DFS 테스트, Inorder")
    void DFS() {
        System.out.println(7+" "+9+" "+4+" "+2+" "+1+" "+5+" "+3+" "+10+" "+8+" "+6);
        binaryTree.DFS(root);
    }

}
```
