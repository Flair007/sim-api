package com.sim.demo.controller;

import com.sim.demo.entity.Sim;
import com.sim.demo.repository.SimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class SimController {
    @Autowired
    SimRepository simRepository;
    @GetMapping("/")
    public ResponseEntity getStatus(){
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity addRecord(@RequestBody Sim sim){
              simRepository.save(sim);
            return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/listall")
    public ResponseEntity listSims(){
       List<Sim> list= simRepository.findAll();
        return new ResponseEntity(list,HttpStatus.CREATED);
    }
    @GetMapping("/list/{id}")
    public ResponseEntity getSim(@PathVariable int id ){
        Optional<Sim> record= simRepository.findById(id);
        Sim sim=null;
        if(record.isPresent()){
            sim=record.get();
         }
        return new ResponseEntity(sim,HttpStatus.FOUND);
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity deleteSim(@PathVariable int id ){
        simRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.GONE);
    }
    @GetMapping("/to-renew")
    public ResponseEntity listRenewSims(){
     List<Sim> list= simRepository.findAll();
     List<Sim> renewList=new ArrayList<>();
     list.stream().forEach((i)->{
         if(i.getExpiry_date().before(new Date(new Date().getTime()+ 30L *24*60*60*1000))) {
             renewList.add(i);
         }
     });
     return new ResponseEntity(renewList,HttpStatus.OK);
    }
    @PostMapping("/renew/{id}")
    public ResponseEntity RenewSim(@PathVariable int id){
        Optional<Sim> record= simRepository.findById(id);
        Sim sim=null;
        if(record.isPresent()){
            sim=record.get();
        }
        sim.setExpiry_date(new Date(new Date().getTime()+ 90L *24*60*60*1000));
        simRepository.save(sim);
        return new ResponseEntity(HttpStatus.OK);
    }
}
