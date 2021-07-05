# IoC / DI

## IoC (Inversion of Control)
```
스프링에서는 일반적인 Java 객체를 new로 생성하여 개발자가 관리하는 것이 아니 Spring Container에 모두 맡김
즉, 개발자에서 프레임워크로 제어의 객체 관리의 권환이 넘어 갔음을 "제어의 역전"이라고 함
```   


## DI (Dependency Injection)
### 장점
```
- 의존성으로 부터 격리시켜 코드 테스트에 용이
- DI를 통하여, 불가능한 상황을 Mock와 같은 기술을 통하여, 안정적으로 테스트 가능
- 코드를 확장하거나 변경 할 때 영향을 최소화 (추상화)
- 순환참조를 막을 수 있음
  > 순환참조 : 내가 나를 참조하거나, 어떤 객체르 참조했는데 다시 나를 참조하는 것
  
- 재사용성을 높임
- 코드 단순화
- 왜 사용하는지 파악하기가 수월, 가독성이 높아짐
- 종속적이던 코드의 수도 줄여줌
- 종속성이 감소, 구성 요소의 종속성이 감소하면, 변경에 민감하지 않음
- 결합도(coupling)는 낮추면서 유연성과 확장성은 향상
- 객체간의 의존관계 설정가능
- 객체간의 의존관계를 없애거나 줄일 수 있음
```

```
Class Programmer{
  private Coffee coffee;
  
  public Programmer(){
    this.coffee = new Coffee();
  }
  
  public startProgramming(){
    this.coffee.drink();
    ....
  }
}
```
위 코드와 같이 Programmer Class에서 startProgramming 함수가 호출되기 위해서는 Coffee Class를 필요로 함.    
이것을 **Programmer Class는 Coffee Class의 의존성을 가진다.** 라고 함   
