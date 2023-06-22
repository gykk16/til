# SOLID

SOLID 원칙은 로버트 C. 마틴(Robert C. Martin)이 2000년 논문 "Design Principles and Design Patterns"에서 제시한 개념이다.
이후에 마이클 페더스(Michael Feathers)가 SOLID 약어를 소개하면서 이러한 개념이 발전되었다.


## 단일 책임 원칙 (Single Responsibility)

한 클래스는 단 하나의 책임을 가져야 한다.
클래스는 변경되는 이유가 하나여야 한다.

- 장점:
  - 테스트 - 단일 책임을 가진 클래스는 테스트 케이스가 적다.
  - 결합도 감소 - 단일 클래스에 적은 기능이 있다면 의존성도 적다.
  - 구조화 - 작고 잘 구성된 클래스는 단일 덩어리의 클래스보다 검색하기 쉽다.

## 개방 폐쇄 원칙 (Open/Closed)

기존의 코드를 수정하지 않으면서 기능을 추가할 수 있도록 설계 되어야 한다.
확장에는 열려 있고, 수정에는 닫혀 있어야 한다.
- 기존 코드는 안정적인 상태를 유지하고 새로운 코드 개발로 버그가 발생 하는 것을 방지 할 수 있다.

## 리스코프 치환 원칙 (Liskov Substitution)

자식 클래스는 언제나 부모 클래스로 대체될 수 있어야 한다.
상속 관계에서는 자식 클래스가 부모 클래스의 역할을 완전히 대체할 수 있어야 한다.

* a blatant violation of Liskov substitution and is a bit harder to fix than our previous two principles.

## 인터페이스 분리 원칙 (Interface Segregation)

클라이언트는 자신이 사용하지 않는 인터페이스에 의존하도록 강요받지 않아야 한다.
인터페이스는 클라이언트에 필요한 기능만 제공해야 한다.

## 의존 역전 원칙 (Dependency Inversion)

추상화에 의존해야 하며, 구체화에는 의존하면 안 한다. 
상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안 되며, 양쪽은 추상화에 의존해야 한다.

