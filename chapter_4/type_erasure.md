
## Type Erasure

---
## 1. Type Erasure 가 무엇인가?

---
### 1.1 Type Eraser? Type Erasure?

- eraser: 지우는 것 (물건, 어떤 것)
- erasure: 삭제, 말소 (과정)
> Type Erasure은 \<T\>, \<String\> 같은 모든 제네릭 타입 정보를 컴파일중 제네릭 타입이 아닌 난제네릭 코드로 바꾸는 **과정**을 말한다.

**컴파일전:**
```java
public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```
**컴파일후:**
```java
public class Box {
    private Object value;

    public void set(Object value) {
        this.value = value;
    }

    public Object get() {
        return value;
    }
}
// T가 Object로 바뀌었다.
```

### 1.2 왜 이렇게 동작하는가?
- 제네릭은 자바 5에서 처음 도입되었다. 
- 이전 버전 자바와 하위 호환성을 유지하기 위해, 제네릭코드는 난제네릭코드로 바뀌는 방식을 사용해 동작한다.

## 2. Type Erasure의 제한점

---

### 2.1 `instanceof` 를 제네릭과 같이 사용할수 없다.

```java
List<String> list = new ArrayList<>();
if (list instanceof List<String>) { ... } // 컴파일 에러
```
- 컴파일중 제네릭타입이 모두 사라진다
- 제네릭 타입이 사라지면 `instanceof` 로 타입을 확인할 방법이 없으니 컴파일 에러가 생긴다.

### 2.2 제네릭 배열을 만들수 없다.
```java
T[] arr = new T[10]; // 컴파일 에러
```

- 컴파일중 제네릭타입 T가 지워져서 JVM이 어느 크기의 배열을 할당해야하는지 모른다.
### 2.3 제네릭 타입은 스태틱 필드에 사용할수 없다.

```java
class Box<T> {
    static T value; // 컴파일 에러
}
```
- 스테틱 필드는 객채가 아닌 클레스 그 자체에 속해있기에 각 객체에 속하는 타입 파라미터로 스태틱 필드를 정의할수 없다.