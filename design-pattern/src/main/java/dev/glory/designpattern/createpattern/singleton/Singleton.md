# Singleton Pattern

인스턴스르 **오직 한개만** 제공하는 클래스

- 생성자가 여러 차례 호출되더라도 실제로 생성되는 객체는 하나이고, 최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴한다.

### Singleton Pattern 을 사용하는 이유

- 실무에서는 공통된 객체를 여러개 생성해서 사용하는 경우가 많다.
- 예를 들어, DB Connection Pool, Thread Pool, Cache, Loggin, Configuration 등이 있다.
- 이런 경우에 객체를 여러개 생성하면 자원을 낭비하게 되고, 이런 자원들은 전역적으로 접근이 가능해야 하기 때문에 싱글톤 패턴을 사용한다.
- 싱글톤 패턴은 전역적인 접근을 보장한다.

### Singleton Pattern 의 단점
- 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
- 멀티스레드 환경에서 동기화 처리를 해줘야 한다.
- 싱글톤 인스턴스가 너무 많은 일을 하거나 많은 데이터를 공유시킬 경우, 다른 클래스의 인스턴스들 간에 결합도가 높아져 "개방-폐쇄 원칙" 을 위배하게 된다.


## Singleton Pattern 구현 방법

기본적으로 아래와 같이 싱글톤 구현 가능하다
```java
public class Settings {

    private static Settings instance;

    private Settings() {
    }

    public static Settings getInstance() {
        // 인스턴스가 없을 경우에만 인스턴스 생성
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }
}
```
다만, 위의 코드는 멀티스레드 환경에서 동작할 경우, 동시에 getInstance() 메소드를 호출하면서 두개의 인스턴스가 생성될 수 있다. 
이를 방지하기 위해 가장 간단한 방법으로 동기화 처리를 해줘야 한다.

```java
public class Settings {

    private static Settings instance;

    private Settings() {
    }

    // 동기화 처리
    public static synchronized Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }
}
```
위의 코드는 동기화 처리를 했지만, 매번 동기화 처리를 하기 때문에 성능이 떨어진다. 
이를 해결하기 위해 DCL(Double-Checking Locking)을 사용한다.

```java
public class Settings {

    // volatile 키워드를 사용하여 컴파일러의 최적화를 방지한다.
    private static volatile Settings instance;

    private Settings() {
    }

    public static Settings getInstance() {
        if (instance == null) {
            // 동기화 블록 Double-Checking Locking
            synchronized (Settings.class) {
                if (instance == null) {
                    instance = new Settings();
                }
            }
        }
        return instance;
    }
}
```
위의 코드는 동기화 처리를 하지만, 동기화 처리를 한번만 하기 때문에 성능이 향상된다.

이른 초기화 방법을 사용하면, 클래스 로딩 시점에 인스턴스를 생성하기 때문에 동기화 처리를 하지 않아도 된다.

```java
public class Settings {

    // 이른 초기화 방법 -> 클래스 로딩 시점에 인스턴스 생성
    private static final Settings INSTANCE = new Settings();

    private Settings() {
    }

    public static Settings getInstance() {
        return INSTANCE;
    }
}
```

static inner class 를 사용하여 클래스 로딩 시점에 인스턴스를 생성할 수 있다.
```java
public class Settings {

    private Settings() {
    }
    
    // 내부 클래스를 사용하여 클래스 로딩 시점에 인스턴스 생성
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }
    
    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
```

---
## Singleton Pattern 깨는 방법
reflection 을 사용하여 private 생성자를 호출하고, 인스턴스를 생성할 수 있다.
```java
@Test
void broke_singleton() throws Exception {
    // given
    Settings instance1 = Settings.getInstance();

    // when
    Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    Settings instance2 = constructor.newInstance();

    // then
    assertThat(instance1).isNotEqualTo(instance2);
}
```

---