package com.example.Vaccino.controller;

import com.example.Vaccino.Dto.Response.AppointmentResponse;
import com.example.Vaccino.Model.Appointment;
import com.example.Vaccino.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity BookAppointment(@RequestParam("pId") int PatId,
                                               @RequestParam("dId") int DocId){
        try {
            AppointmentResponse savedAppointment = appointmentService.BookAppointment(PatId, DocId);
            return new ResponseEntity(savedAppointment,HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
