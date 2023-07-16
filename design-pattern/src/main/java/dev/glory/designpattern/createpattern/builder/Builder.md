# Builder Pattern

- 동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 패턴이다.
- 복잡한 객체를 생성하는 방법과 표현하는 방법을 정의하는 클래스를 별도로 분리하여, 서로 다른 표현이라도 이를 생성할 수 있는 동일한 절차를 제공하는 패턴이다.

### Builder Pattern 을 사용하는 이유

- 복잡한 객체를 만드는 프로세스를 독립적으로 분리할 수 있다.
- 구체적인 생성과정을 숨길 수 있다.

### Builder Pattern 의 단점

- 생성할 객체의 종류가 너무 많을 경우, 클래스의 수가 증가한다.

### Builder Pattern 구현 방법

- Builder Pattern 은 아래와 같이 구현할 수 있다.

```java
public class TourPlan {

    private String title;
    private String description;
    private String region;
    private String duration;
    private String price;

    // constructor

    // getter, setter
}
```

```java
public interface TourPlanBuilder {

    TourPlanBuilder setTitle(String title);

    TourPlanBuilder setDescription(String description);

    TourPlanBuilder setRegion(String region);

    TourPlanBuilder setDuration(String duration);

    TourPlanBuilder setPrice(String price);

    TourPlan build();
}
```

```java
public class TourPlanBuilderImpl implements TourPlanBuilder {

    private String title;
    private String description;
    private String region;
    private String duration;
    private String price;

    @Override
    public TourPlanBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public TourPlanBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public TourPlanBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    @Override
    public TourPlanBuilder setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public TourPlanBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    @Override
    public TourPlan build() {
        return new TourPlan(title, description, region, duration, price);
    }
}
```

```java
public class TourPlanDirector {

    private TourPlanBuilder tourPlanBuilder;

    public TourPlanDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan createTourPlan(String title, String description, String region, String duration, String price) {
        return tourPlanBuilder
                .setTitle(title)
                .setDescription(description)
                .setRegion(region)
                .setDuration(duration)
                .setPrice(price)
                .build();
    }
}
```

### lombok 을 사용한 Builder Pattern 구현 방법

- lombok 을 사용하면 아래와 같이 구현할 수 있다.

```java
@Builder
@Getter
@Setter
public class TourPlan {

    private String title;
    private String description;
    private String region;
    private String duration;
    private String price;
}
```


