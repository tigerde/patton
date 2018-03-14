package com.cenyol.example.service;

import com.alibaba.dubbo.demo.DemoService;

public class MyService {
    DemoService demoService;
    String abc;
    public void sayHello(String name){
        demoService.sayHello(name);
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public DemoService getDemoService() {
        return demoService;
    }

    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }
}
