# Spring Boot
> Spring Boot는 단순히 실행되며, 프로덕션 제품 수준의 스프링 기반 어플리케이션을 쉽게 만들 수 있음
> Spring Boot 어플리케이션에는 Spring 구성이 거의 필요하지 않음
> Spring Boot java -jar로 실행하는 Java 어플리케이션을 만들 수 있음

### 💡주요 목표
> Spring 개발에 대해 빠르고, 광범위하게 적용할 수 있는 환경
> 기본값 설정이 있지만 설정을 바꿀 수 있음
> 대규모프로젝트에 공통적인 비 기능 제공(보안, 모니터링 등등)
> XML 구성 요구사항이 전혀 없음

### ‼️장점
> 어플리케이션 개발에 필수 요소들만 모아둠
> 간단한 설정으로 개발 및 커스텀이 가능
> 간단하고, 빠르게 어플리케이션 실행 및 배포가 가능
> 대규모프로젝트(운영환경)에 필요한 비 기능적 기능도 제공
> 오랜 경험에서 나오는 안정적인 운영이 가능
> Spring에서 불편한 설정이 없음 (XML 설정 등등)

***
### REST API Client 
![무제](https://user-images.githubusercontent.com/50236501/124254994-a49e9180-db64-11eb-9b2a-63bf14296b8a.jpg)

***
## API
![무제](https://user-images.githubusercontent.com/50236501/124251750-399f8b80-db61-11eb-9125-40f3b8c58a60.jpg)

- Get API   

|이름|설명|
|:------|:---|
|@GetMapping|Get Resource 설정|
|@RequestParam|URL Query Param Parsing|
|@PathVariable|URL Path Variable Parsing|
|Object|Query Param Object로 Parsing|
|@RestController|RestAPI 설정|
|@RequestMapping|리소스를 설정 (method로 구분가능)|


- Post API

|이름|설명|
|:------|:---|
|@RestController|RestAPI 설정|
|@RequestMapping|리소스를 설정 (method로 구분가능)|
|@PostMapping|Post Resource 설정|
|@RequestBody|Request Body 부분 Parsing|
|@PathVariable|URL Path Variable Parsing|
|@JsonProperty|json naming|
|@JsonNaming|class json naming|


- Put API

|이름|설명|
|:------|:---|
|@RestController|RestAPI 설정|
|@RequestMapping|리소스를 설정 (Method로 구분가능)|
|@PutMapping|Put Resource 설정|
|@ReuqestBody|Request Body 부분 Parsing|
|@PathVariable|URL Path Variable Parsing|


- Delete API

|이름|설명|
|:------|:---|
|@RestController|RestAPI 설정|
|@RequestMapping|리소스를 설정 (Method로 구분가능)|
|@DeleteMapping|Delete Resource 설정|
|@RequestParam|URL Query Param Parsing|
|@PathVariable|URL Path Variable Parsing|
|Object|Query Param Object로 Parsing|


- Response 내려주기

|이름|설명|
|:------|:---|
|String|일반 Text Type 응답|
|Object|자동으로 Json 변환되어 응답 상태값은 항상 200 ok|
|ResponseEntity|Body의 내용을 Object로 설정상황에 따라서 Http Status Code 설정|
|@ResponseBody|RestController가 아닌 곳 (Controller)에서 Json 응답을 내릴 때|
