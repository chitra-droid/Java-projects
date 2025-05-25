package com.example.Vaccino.Controller;

import com.example.Vaccino.Dto.Response.AppointmentResponse;
import com.example.Vaccino.Dto.Response.AppointmentUpdateResponse;
import com.example.Vaccino.Model.Appointment;
import com.example.Vaccino.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity BookAppointment(@RequestParam("pId") int PatId,
                                          @RequestParam("dId") int DocId) {
        try {
            AppointmentResponse savedAppointment = appointmentService.BookAppointment(PatId, DocId);
            return new ResponseEntity(savedAppointment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("update/{id}")
    public ResponseEntity CancelAppointmentByPatientId(@PathVariable("id") int Patientid) {
        try {
            AppointmentUpdateResponse savedAppointment = appointmentService.CancelAppointment(Patientid);
            return new ResponseEntity(savedAppointment, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


