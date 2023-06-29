# Java Concurrency

## 1. Overview
java.util.concurrent 패키지는 동시성 응용 프로그램을 만들기 위한 도구를 제공

## 2. 주요 구성
- Executor
- ExecutorService
- ScheduledExecutorService
- Future
- CountDownLatch
- CyclicBarrier
- Semaphore
- ThreadFactory
- BlockingQueue
- DelayQueue
- Locks
- Phaser

### 2.1. [Executor](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/Executor.html)

Executor 는 제공된 작업을 실행하는 개체를 나타내는 인터페이스 이다.

- Runnable 객체를 비동기적으로 실행하는 객체
- 작업을 실행하는 데 사용할 스레드를 관리

### 2.2. [ExecutorService](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/ExecutorService.html)

ExecutorService 는 비동기 처리를 위한 인터페이스 이다. 
메모리 내 대기열을 관리하고 스레드 가용성에 따라 제출된 작업을 예약한다.

- Executor 인터페이스를 확장



