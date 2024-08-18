package com.sunho.kim.trace.threadlocal;

import com.sunho.kim.trace.threadlocal.code.FiledService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FiledServiceTest {

    private FiledService filedService = new FiledService();

    @Test
    void filed(){
        log.info("main start");
        Runnable userA = new Runnable() {
            @Override
            public void run() {
                filedService.logic("userA");
            }
        };
        Runnable userB = () -> {
            filedService.logic("userB");
        };
        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000); // 동시성 문제가 발생 X
        sleep(100); // 동시성 문제 발생
        threadB.start();
        sleep(3000); // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
