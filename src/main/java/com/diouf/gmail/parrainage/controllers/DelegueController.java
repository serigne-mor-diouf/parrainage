package com.diouf.gmail.parrainage.controllers;

import java.util.List;

import com.diouf.gmail.parrainage.dto.DelegueDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diouf.gmail.parrainage.entites.DelegueRegional;
import com.diouf.gmail.parrainage.services.DelegueRegionalService;

@RestController
@RequestMapping("/api/delegues")
public class DelegueController {
    @Autowired
    private DelegueRegionalService delegueRegionalService ;
    
    
    @GetMapping
    public List<DelegueRegional> getDelegueRegionals() {
        return delegueRegionalService.getDelegueRegional();
    }

    @DeleteMapping("/{id}")
    public void deleteDelegue(@PathVariable Long id) {
        delegueRegionalService.deleteDelegue(id);
    }



    @GetMapping("/{id}")
    public DelegueRegional findParrainage(@PathVariable Long id) {
        return delegueRegionalService.findParrainage(id);
    }

    @PutMapping("/{id}")
    public void modifierParrainage(@PathVariable Long id , @PathVariable DelegueDTO delegueRegional){
        delegueRegionalService.modifierDelegue(id ,delegueRegional);
    }
}
