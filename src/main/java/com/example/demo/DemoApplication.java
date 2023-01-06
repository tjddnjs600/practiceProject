package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.*;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    TestClass testClass;

    @Bean
    ApplicationRunner applicationRunner(){
        return args -> {
            Runnable runnable = new TestClass();

            BlockingQueue<Runnable> blockingDeque = new ArrayBlockingQueue<>(5);
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 5, TimeUnit.MILLISECONDS, blockingDeque);


            for (int i = 0; i < 15; i++) {
                threadPoolExecutor.execute(runnable);
                System.out.println("mainThread "+i);
            }
        };
    }

}
