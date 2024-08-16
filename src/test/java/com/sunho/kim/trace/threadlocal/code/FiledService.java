package com.sunho.kim.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FiledService {

    private String nameStore;

    public String logic(String name){
        log.info("저장 name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("조회 nameStore={}", nameStore);
        return nameStore;
    }

    private void sleep(int i){
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
