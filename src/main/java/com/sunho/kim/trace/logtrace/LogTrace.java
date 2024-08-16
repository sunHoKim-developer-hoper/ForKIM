package com.sunho.kim.trace.logtrace;

import com.sunho.kim.trace.TraceStatus;

public interface LogTrace {
    //로그 추적기를 위한 최소한의 기능만 정의
    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
