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

### 📌 Filter Class에 Componet Annotation을 적용하면 Global Filter로 적용됨
### 📌 @WebFilter(urlPatterns = "/api/user/*") 을 적용하면 /api/user의 하위에만 적용됨 ➡️ 이런식으로 특정 Class나 Controller에 적용가능
> 이럴때는 Main Class에 @ServletComponentScan Annotation을 추가해줘야함
