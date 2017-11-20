package com.anakinliu.demo.config;

import com.anakinliu.demo.BraveKnight;
import com.anakinliu.demo.Knight;
import com.anakinliu.demo.Quest;
import com.anakinliu.demo.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Anakinliu on 17.10.13.
 * If you only do what you can do,
 * you'll never be more than you are now.
 */
@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
