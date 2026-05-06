package com.mysite.sbb;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    private String hello;
    private int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setHello("안녕하세요");
        helloLombok.setLombok(123);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
