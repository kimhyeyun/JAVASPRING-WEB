# Spring Filter와 Interceptor

## Filter

```
Filter란 Web Application에서 관리되는 영역으로써 Spring Boot Framework에서 Client로부터 오는 요청/응답에 대해서 최초/최종 단계의 위치에 존재하며,   
이를 통해서 요청/응답의 정보를 변경하거나, Spring에 의해서 데이터가 변환되기 전의 순수한 Client의 요청/응닶 값을 확인할 수 있음   
<br>
**유일하게 ServletRequest, ServletResponse의 객체를 변환** 할 수 있음   
<br>
주로 Spring Framework에서는 request / response의 Logging 용도로 활용하거나,   
인증과 관련된 Logic들을 해당 Filter에서 처리함   
<br>
이를 선/후 처리 함으로써, Service businewss logic과 분리시킴
```

![무제](https://user-images.githubusercontent.com/50236501/124911465-bc27bf80-e027-11eb-87b0-31dc9a82ad55.jpg)   

***

## Interceptor

```
Interceptor란 Filter와 매우 유사한 형태로 존재하지만, 차이점은 Spring Context에 등록됨   
AOP와 유사한 기능을 제공 할 수 있으며,   
주로 **인증 단계** 를 처리하거나, Logging를 하는데 사용함   
이를 선/후 처리 함으로써, Service business logic과 분리 시킴
```

![무제](https://user-images.githubusercontent.com/50236501/124911719-0ad55980-e028-11eb-8ecf-4699224704be.jpg)

