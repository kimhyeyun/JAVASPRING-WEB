# AOP
## AOP (Aspect Oriented Programming)

> 관점지향 프로그래밍   
> 스프링 어플리케이션은 대부부 특별하 경우를 제외하고는 MVC 웹 어플리케이션에서는 Web Layer, Business Layer, Data Layer로 정의

```
- Web Layer : REST API르 제공하며, Client 중심으 로직 적용
- Business Layer : 내부 정책에 따른 logic을 개발하며, 주로 해당 부분을 개말
- Data Layer : 데이터 베이스 및 외부와의 연동을 처리
```

***

### 주요 Annotation   

| Annotation |의미|
|------------|----|
|@Aspect|자바에서 널리 사용하는 AOP 프레임워크에 포함되며, AOP를 정의하는 Class에 할당|
|@Pointcut|기능을 어디에 적용시킬지, 메소드? Annotation? 등 AOP를 적용시키 지점을 설정|
|@Before|메소드 실행하기 이전|
|@After|메소드가 성공적으로 실행 후,예외가 발생 되더라도 실행|
|@AfterReturning|메소드 호출 성공 실행 시 (Not Throws)|
|@AfterThrowing|메소드 호출 실패 예외 발생 (Throws)|
|@Around|Before / after 모두 제어|


### 횡단 관심
![무제](https://user-images.githubusercontent.com/50236501/124380687-042da600-dcf9-11eb-9ee0-7008f2408798.jpg)
