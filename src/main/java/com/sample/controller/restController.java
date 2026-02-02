package com.sample.controller;

import com.sample.model.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/integration")
public class restController {

    Map<String,Data> map = new HashMap<String,Data>();

    @GetMapping("/testGetCall")
    public ResponseEntity<Map<String,Data>> testGetCall(){
        System.out.println("Consumer connect to get Call");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/testGetWithParam/{name}")
    public ResponseEntity<Data> testGetWithRequestBody(@PathVariable String name){
        System.out.println("Consumer connect to get testGetWithParam Call with id "+name);
        return ResponseEntity.ok(map.get(name.toLowerCase()));
    }

    @PostMapping("/testPostCallWithData")
    public void testPostCall(@RequestBody Data data){
        System.out.println("Consumer connect to get Call with data "+data.toString());
        map.put(data.getName().toLowerCase(), data);
    }

    @PostMapping("/testLogData")
    public void testLogData(){
        System.out.println("Consumer connect to Log Data "+ map.toString());
    }
}
