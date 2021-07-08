# Spring Boot Validation

## Validation 이란?
> 프로그래밍에 있어서 가장 필요한 부분   
> 특히 Java에서는 null 값에 대해서 접근하려고 할 때 null pointer exception이 발생함으로,   
> 이러한 부분을 방지하기 위해서 미리 검증하느 과정을 **Validation** 이라고 함

```
public void run(String account, String pw, int age){
  if(account == null || pw == null){
    return;
  }
   
  if(age == 0){
      return;
  }
}
```
1. 검증해야 할 값이 많은 경우 코드의 길이가 길어짐
2. 구현에 따라서 달라 질 수 있지마 Service Logic과의 분리가 필요
3. 흩어져 있는 경우 어디에서 검증을 하는지 알기 어려우며, 재사용의 한계가 있음
4. 구현에 따라 달라 질 수 있지만, 검증 Logic이 변경되는 경우 테스트 코드 등 참조하는 클래스에서 Logic이 변경되어야하는 부분이 발생 가능

![무제](https://user-images.githubusercontent.com/50236501/124909935-fb551100-e025-11eb-9a17-802f33a60b42.jpg)

