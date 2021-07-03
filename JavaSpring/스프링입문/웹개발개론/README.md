

# 💡웹 개발 개론 정리

1. WEB
   - HTTP
   > Hypertext Transfer Protocol
   >> 어플리케이션 컨트롤

   - URI
   > Uniform Resource Identifier
   >> 리소스 식별자<br>
   >> 모든 정보에 접근할 수 있는 정보

   - HTML
   > Hyper Text Markup Language
   >> 하이퍼미디어 포맷<br> 
   >> XML을 바탕으로한 범용 문저 포맷<br>
   >> 사용자가 알아보기 쉬운 형태로 표현

***
2. REST (Representational State Transfer : 자원의 상태 전달) - 네트워크 아키텍쳐
   - Client, Server
   > 서로 독립적으로 분리되어 있어야함
   - Stateless
   > 요청에 대해서 클라이언트의 상태를 서버에 저장하지 않음
   - Cache
   > 클라이언트는 서버의 응답을 Cache(임시저장) 할 수 있어야함 <br> 클라이언트가 Cache를 통해서 응답을 재사용할 수 있어야 하며, 이를 통해서 서버의 부하를 낮춤
   - 계층화 (Layered System)
   > 서버와 클라이언트 사이에, 방화벽, 게이트웨이, Proxy등 다양한 계층 형태로 구성이 가능해야 하며, 이를 확장 할 수 있어야함
   - 인터페이스 일관성
   > 인터페이스의 일관성을 지키고, 아키텍처를 단순화시켜 작은 단위로 분리하여, 클라이언트, 서버가 독립적으로 개선될 수 있어야함
   - Code on Demand (Optional)
   > 자바 애플릿, 자바스크립트, 플래시 등 특정한 기능을 서버로부터 클라이언트가 전달받아 코드를 실행 할 수 있어야함
   
   ### 다음의 인터페이스 일관성이 잘 지켜졌는지에 따라, REST를 잘 사용했는지 판단 가능
   - 자원의 식별
   > 웹 기반의 REST 에서는 리소스 접근시, URI 사용
   - 메세지를 통한 리소스 조작
   > Web에서는 다양한 방식으로 데이터 전달가능<br>그 중에서 가장 많이 사용하는 방식은 HTML, XML, JSON, TEXT<br>이 중에서 어떠한 타입의 데이터인지를 알려주기 위해서 HTTP Header 부분에 
   > content-type을 통해서 데이터 타입을 지정가능<br> 또한 리소스 조작을 위해서 데이터 전체를 전달 하지 않고, 이를 메세지로 전달
   - 자기서술적 메세지
   > 요청하는 데이터가 어떻게 처리 되어져야 하는지 충분한 데이터를 포함 할 수 있어야함<br>HTTP 기반의 REST에서는 HTTP Method와 Header 정보, 그리고 URI의 포함되는 정보로 표현 할 수 있음<br>
   > 그 외에 담지 못한 정보들은 URI의 메세지를 통하여 표현
   - Application 상태에 대한 엔진으로써 하이퍼미디어
   > REST API를 개발할 때 단순히 Client 요청에 대한 데이터만 응답해주는 것이 아닌 관련된 리소스에 대한 Link 정보까지 같이 포함되어야함   
   
   **📌이러한 조건들을 잘 갖춘 경우 REST FUL 하다고 표현하고, 이를 REST API 라고 부름‼️**

***
3. URI 설계 패턴
   - URI (Uniform Resource Identifier)
   > 인터넷에서 특정 자원을 나타내는 주소 값   
   > 해당 값은 유일 (응답은 달라질 수 있음)
   - URL (Uniform Resource Locator)
   > 인터넷 상에서의 자원, 특정 파일이 어디에 위치하는지 식별하는 주소   
   
   **📍URL은 URI의 하위 개념‼️**
   
   ### URI 설계 원칙 (RFC-3986)
   - 슬래쉬 구분자(/)는 계층 관계를 나타내는 데 사용
   - URI 마지막 문자로 (/)는 포함하지 않음
   - 하이픈(-)은 URI 가독성을 높이는데 사용
   - 밑줄(_)은 사용하지 않음
   - URI 경로에는 소문자가가 적합
   - 파일 확장자는 URI에 포함하지 않음
   - 프로그래밍 언어에 의존적인 확장자를 사용하지 않음
   - 구현에 의존적인 경로를 사용하지 않음
   - 세션 ID를 포함하지 않음
   - 프로그래밍 언어의 Method명을 이용하지 않음
   - 명사에 단수형보다는 복수형을 사용해야함. 컬렉션에 대한 표현은 복수로 사용
   - 컨트롤러 이름으로는 동사나 동사구를 사용
   - 경로 부분 중 변하는 부분은 유일한 값으로 대체
   - CRUD 기능을 나타내는 것은 URI에 사용하지 않음
   - URI Query Parameter 디자인
   > URI 쿼리 부분으로 컬렉션 결과에 대해서 필터링 할 수 있음
   - URI 쿼리는 컬렉션의 결과를 페이지로 구분하여 나타내는데 사용
   - API에 있어서 서브 도메인은 일관성 있게 사용해야함
   - 클라이언트 개발자 포탈 서브 도메인은 일관성 있게 만듬

***
4. HTML Protocol
   - HTTP (Hyper Text Transfer Protocol)로 RFC 2616에서 규정된 WEB에서 데이터를 주고 받는 프로토콜
   - 이름에는 하이퍼텍스트 전송용 프로토콜로 정의되어 있지만 실제로는 HTML, XML, JSON, Image, Voice, Video, Javascript, PDF 등 다양한 컴퓨터에서 다룰 수 있는 것은 모두 전송 가능
   - HTTP는 TCP를 기반으로 한 REST의 특징을 모두 구현하고 있는 Web 기반의 프로토콜
   - HTTP는 메세지를 주고 (Request) 받는 (Response) 형태의 통신 방법
   ![무제](https://user-images.githubusercontent.com/50236501/124126113-4797d280-dab5-11eb-933d-8df8cabf37ac.jpg)  
   
   - HTTP의 요청을 특정하는 Method는 8가지가 있음
   ![무제](https://user-images.githubusercontent.com/50236501/124126314-8594f680-dab5-11eb-8a50-0894ca1fbcc0.jpg)   
   
   - HTTP Status Code
   ![무제](https://user-images.githubusercontent.com/50236501/124126442-a3625b80-dab5-11eb-9c37-a4ff0a0bb03b.jpg)   
   
   - 자주 사용되는 코드
   ![d](https://user-images.githubusercontent.com/50236501/124126510-b1b07780-dab5-11eb-9b78-8763a1594365.jpg)   
