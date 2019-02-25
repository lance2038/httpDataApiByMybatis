package com.lance.business.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务类
 *
 * @author lance
 */
@Component("autoJob")
public class AutoJobExec
{

    @Scheduled(cron = "0/5 * * * * *")
    public void doJob() throws Exception
    {

    }

}
