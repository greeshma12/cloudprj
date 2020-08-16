package com.fs.cloudfirestoredemo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fs.cloudfirestoredemo.model.Cafe;
import com.fs.cloudfirestoredemo.service.FirebaseService;

@RestController
public class CafeController {
	@Autowired
	FirebaseService firebaseservice;
	
	
	@GetMapping(value = "/get/{name}")
	public Cafe getCafe(@PathVariable("name") String name) throws InterruptedException, ExecutionException {
		return firebaseservice.getCafeDetails(name);
		
	}
	@PostMapping("/createCafe")
    public String createCafe(@RequestBody Cafe cafe ) throws InterruptedException, ExecutionException {
        return firebaseservice.savecafe(cafe);
    }

    @PutMapping("/updatecafe")
    public String updateCafe(@RequestBody Cafe cafe  ) throws InterruptedException, ExecutionException {
        return firebaseservice.updatecafe(cafe);
    }

    @DeleteMapping("/deleteCafe/{name}")
    public String deleteCafe(@PathVariable("name") String name){
        return firebaseservice.deletecafe(name);
    }

}
