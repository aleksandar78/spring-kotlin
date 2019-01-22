package org.aroundbit.springkotlin;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DateService {

    public LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

}
