package com.example.Vaccino.Controller;

import com.example.Vaccino.Enum.Specialization;
import com.example.Vaccino.Model.Doctor;
import com.example.Vaccino.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        try {
            doctorService.addDoctor(doctor);
           return "Doctor registered successfully!";
        }
        catch (Exception e){
           return "Invalid Doctor request!";
        }
    }

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam int id){
       return doctorService.getDoctor(id);
    }

    @GetMapping("/getBySpecialization")
    public List<Doctor> getDoctor(@RequestParam("specialization") Specialization specialization){
        return doctorService.getDoctor(specialization);
    }

    @DeleteMapping("/delete")
    public String DeleteDoctor(@RequestParam int id){
        doctorService.DeleteDoctor(id);
        return "Doctor has been deleted";
    }
}
