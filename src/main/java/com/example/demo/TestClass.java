package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class TestClass implements Runnable{
    public void run(){
        print();
    }

    public void print(){
        for (int i = 0; i < 5; i++) {
            String nm = Thread.currentThread().getName();
            System.out.println("Thread!! "+nm+ " "+i);
        }
    }
}
