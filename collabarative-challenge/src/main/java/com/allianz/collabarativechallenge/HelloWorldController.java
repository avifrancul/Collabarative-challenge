package com.allianz.collabarativechallenge;


import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET,path="/hello-world")
    public String helloWorld(){
        return "This is just the begining!!";
    }

    @RequestMapping(method = RequestMethod.GET,path="/hello-world-bean")
    public HelloWorldbean helloWorldbean(){
        return new HelloWorldbean("Hello World");
    }

    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldbean helloWorldbean(@PathVariable String name){
        return new HelloWorldbean(String.format("This is a new begining for you,%s",name));
    }


}
