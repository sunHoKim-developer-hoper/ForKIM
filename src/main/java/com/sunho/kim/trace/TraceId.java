package com.sunho.kim.trace;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class TraceId {

    private String id;
    private int level;

    public TraceId(){
        this.id = createId();
        this.level = 0;
    }

    private String createId(){
        //UUID의 앞 8자리만 사용
        return UUID.randomUUID().toString().substring(0,8);
    }

    public TraceId createNextId(){
        return new TraceId(this.id, this.level + 1);
    }

    public TraceId createPreviousId(){
        return new TraceId(this.id, this.level - 1);
    }

    public boolean isFirstLevel(){
        return this.level == 0;
    }

    public int getLevel(){
        return this.level;
    }
}
