package com.company.design;

import com.company.design.adapter.*;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

public class Main {

    public static void main(String[] args) {
        // Singleton
     /*   AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));*/

        // Adapter
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        // 220V -> 110V 로 변환 (adapter)
        // Main 내의 connect 함수는 110V 이므로 220V로 변환해주는 adapter가 필요
        Cleaner cleaner = new Cleaner();

        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airadapter = new SocketAdapter(airConditioner);
        connect(airadapter);
    }


    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }

}

