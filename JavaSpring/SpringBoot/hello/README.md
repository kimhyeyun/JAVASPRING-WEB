# Get API  

|이름|설명|
|:------|:---|
|@GetMapping|Get Resource 설정|
|@RequestParam|URL Query Param Parsing|
|@PathVariable|URL Path Variable Parsing|
|Object|Query Param Object로 Parsing|
|@RestController|RestAPI 설정|
|@RequestMapping|리소스를 설정 (method로 구분가능)|

## REST API Client 
![무제](https://user-images.githubusercontent.com/50236501/124254994-a49e9180-db64-11eb-9b2a-63bf14296b8a.jpg)

***
## API
![무제](https://user-images.githubusercontent.com/50236501/124251750-399f8b80-db61-11eb-9125-40f3b8c58a60.jpg)


- [Post API][postlink]

[postlink]:https://github.com/kimhyeyun/FastCampus/tree/main/JavaSpring/post


- [Put API][putlink]

[putlink]:

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
