# JAVA & SPRING
## Java & Spring
1. 디자인패턴
   - Singleton Pattern
   ```
   singleton 패턴은 어떠한 클래스(객체가) 유일하게 1개만 존재 할 때 사용
   이를 주로 사용하는 곳은 서로 자원을 공유 할 때 사용하는데, TCP Socket 통신에서 서버와 연결된
   connect 객체에 주로 사용
   ```
   - Adapter Pattern
   ```
   adapter는 실생활에서는 110V를 220V로 변경해주거나, 그 반대로 해주는 변환기를 예로 들 수 있음
   호환성이 없는 기존 클래스의 인터페이스를 변환하여 재사용 할 수 있도록 해줌
   SOLID 중에서 개방폐쇄 원칙(OCP)를 따름
   ```
   - Proxy Pattern
   ```
   proxy는 대리인이라는 뜻으로써, 뭔가를 대신해서 처리하는 것. 
   Proxy Class를 통해서 대신 전달하는 형태로 설계되며, 실제 client는 Proxy로 부터 결과를 받음.
   Cache의 기능으로도 활용이 가능함.
   SOLID 중에서 개방폐쇄 원칙 (OCP)과 의존 역전 원칙 (DIP) 를 따름.
   ```
   - Decorator Pattern
   ```
   Decorator pattern은 기본 뼈대(class)는 유지하되, 이후 필요한 형태로 꾸밀 때 사용.
   경우 상속의 대안으로도 활용. SOLID 중에서 개방폐쇄 원칙 (OCP)과 의존 역전 원칙 (DIP)를 따름
   ```
   - Observer Pattern
   ```
   Observer pattern은 변화과 일어났을 때, 미리 등록된 다른 class에 통보해주는 패턴을 구현한 것.
   많이 보이는 곳은 event listener 에서 해당 패턴을 사용
   ```
   - Facade Pattern
   ```
   Facade는 건물의 앞쪽 정면이라는 뜻. 여러 개의 객체와 실제 사용하는 서브 객체의 사이에 복잡한 의존관계가 있을 대,
   중간에 facade라는 객체를 두고, 여기서 제공하는 interface만을 활용하여 기능을 사용하는 방식.
   Facade는 자신이 가지고 있는 각 클래스의 기능을 명확히 알아야 함.
   ```
   - Strategy Pattern
   ```
   객체지향의 꽃. 유사한 행위들을 캡슐화하여, 객체의 행위를 바꾸고 싶은 경우 직접 변경하는 것이 아닌 전략만 변경하여,
   유연하게 확장하는 패턴 SOLID 중에서 개방폐쇄 원칙 (OCP)과 의존 역전 원칙 (DIP)를 따름.
   전략 메서드를 가진 전략 객체 (Normal Strategy, Base64 Strategy)
   전략 객체를 사용하는 컨텍스트 (Encoder)
   전략 객체를 생성해 컨텍스트에 주입하는 클라이언트 (예제에선 Main)
   ```
   
