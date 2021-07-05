# AOP
## AOP (Aspect Oriented Programming)

> 관점지향 프로그래밍   
> 스프링 어플리케이션은 대부부 특별한 경우를 제외하고는 MVC 웹 어플리케이션에서는 Web Layer, Business Layer, Data Layer로 정의   
> 어떤 로직을 기준으로 핵심적인 관점, 부가적인 관점으로 나누어서 보고 그 관점을 기준으로 각각 모듈화하겠다는 것
>> 여기서 모듈화란 어떤 공통된 로직인 기능을 하나의 단위로 묶는 것   
>> AOP에서 각 관점으 기준으로 로직을 모듈화한다는 것은 코드들을 부분적으로 나누어서 모듈화하겠다는 의미   
>> 이때, 소스 코드상에서 다른 부분에 계속 반복해서 사용하는 코드들이 있는데 이것을 **흩어진 관심사(Crosscutting Concerns)** 라고 함

```
- Web Layer : REST API르 제공하며, Client 중심으로 로직 적용
- Business Layer : 내부 정책에 따른 logic을 개발하며, 주로 해당 부분을 개발
- Data Layer : 데이터 베이스 및 외부와의 연동을 처리
```

![무제](https://user-images.githubusercontent.com/50236501/124429706-27179300-dda9-11eb-8e25-70f18083edbb.jpg)   
   
### 위와 같이 흩어진 관심사를 Aspect로 모듈화하고 핵심적이 비즈니스 로직에서 분리하여 재사용하겠다는 것이 AOP의 취지

***

## AOP 주요 개념
- Aspect : 흩어진 관심사를 모듈화 한것. 주로 부가기능을 모듈화
- Target : Aspect를 적용하는 곳
- Advice : 실질적으로 어떤 일을 해야할 지에 대한 것, 실질적인 부가기능을 담은 구현체
- JointPoint : Advice가 적용될 위치. 끼어들 수 있는 지점. 메서드 진입 지점, 생성자 호출 지점. 필드에서 값으 꺼내올 때 등 다양한 시점에 적용가능
- PointCut : JointPoint의 상세한 스펙을 정의한 것. 'A란 메서드으 진입 시점에 호출할 것' 과 같이 더욱 구체적을 Advice가 실행될 지점을 정할 수 있음


## 스프링 AOP 특징
- 프록시 패턴 기반의 AOP 구현체, 프록시 객체를 쓰는 이유는 접근 제어 및 부가기능을 추가하기 위해서임
- 스프링 빈에만 AOP를 적용 가능
- 모든 AOP 기능을 제공하는 것이 아닌 스프링 IoC와 연동하여 엔터프라이즈 애플리케이션에서 가장 흔한 문제(중복코드, 프록시 클래스 작성의 번거로움, 객체들 간 관계 복잡도 증가...)에 대한 해결책을 지원하는 것이 목적

> 스프링 @AOP를 사용하기 위해서는 다음과 같이 dependency를 추가해야함
```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-aop'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```
***

### 주요 Annotation   

| Annotation |의미|
|------------|----|
|@Aspect|자바에서 널리 사용하는 AOP 프레임워크에 포함되며, AOP를 정의하는 Class에 할당|
|@Pointcut|기능을 어디에 적용시킬지, 메소드? Annotation? 등 AOP를 적용시키 지점을 설정|
|@Before|Advice Target 메소드가 호출되기 전에 Advice 기능을 수행|
|@After|메소드가 성공적으로 실행 후,예외가 발생 되더라도 실행(Taget 메소드의 결과에 관계없이 Target메소드가 완료되면 Advice 기능을 수행)|
|@AfterReturning|메소드 호출 성공 실행 시 (Not Throws)|
|@AfterThrowing|메소드 호출 실패 예외 발생 (Throws)|
|@Around|Before / after 모두 제어|


### 횡단 관심
![무제](https://user-images.githubusercontent.com/50236501/124380687-042da600-dcf9-11eb-9ee0-7008f2408798.jpg)
