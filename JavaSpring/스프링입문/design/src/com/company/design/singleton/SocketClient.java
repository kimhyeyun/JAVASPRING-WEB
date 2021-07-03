package com.company.design.singleton;

public class SocketClient {
    private static SocketClient socketClient = null;

    // AClass 와 Bclass가 다르게 나옴
    public SocketClient(){

    }

    // 생성자 대신 사용
    // 최초에 한번만 생성되도록
    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public  void connect(){
        System.out.println("connect");
    }

}
