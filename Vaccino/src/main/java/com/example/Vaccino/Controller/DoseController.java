package com.example.Vaccino.Controller;

import com.example.Vaccino.Enum.VaccineBrand;
import com.example.Vaccino.Model.Dose;
import com.example.Vaccino.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/vaccinate")
    public Dose addDose(@RequestParam VaccineBrand vaccineBrand,
                          @RequestParam("id") int id){
       return doseService.addDose(vaccineBrand,id);

    }

}
