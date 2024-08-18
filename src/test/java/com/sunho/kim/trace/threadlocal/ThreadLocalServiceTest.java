package com.sunho.kim.trace.threadlocal;

import com.sunho.kim.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void filed(){
        log.info("main start");
        Runnable userA = new Runnable() {
            @Override
            public void run() {
                service.logic("userA");
            }
        };
        Runnable userB = () -> {
            service.logic("userB");
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
