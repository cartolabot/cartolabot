package com.cb.cartolascraping.schedule;

import com.cb.cartolascraping.dto.ParciaisResponse;
import com.cb.cartolascraping.outbound.ParciaisCartolaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScrapingSchedule {

    @Autowired
    private ParciaisCartolaClient parciaisCartolaClient;

    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
    public void parciaisTask() {
        ParciaisResponse mData = parciaisCartolaClient.getParciais();
    }
}
