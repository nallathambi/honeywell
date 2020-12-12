package com.honeywell.interview.clock.exercise.controller;

import com.honeywell.interview.clock.exercise.model.Time;
import com.honeywell.interview.clock.exercise.service.CloclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClockController {

    @Autowired
    private CloclService service;

    @GetMapping("/angle/{time}")
    public ResponseEntity<Time> getAngle(@PathVariable String time) {
        Time response = null;
        try {
            if(time.contains(":")) {
                String[] timeSplit = time.split(":");
               response =  service.getAngle(Integer.parseInt(timeSplit[0]),Integer.parseInt(timeSplit[1]));
            }else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if(null == response)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
