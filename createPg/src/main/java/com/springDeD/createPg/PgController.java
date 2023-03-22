package com.springDeD.createPg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("")
public class PgController extends AbsPgsInterface {

    @Autowired
    @Lazy

    public PgRepository PgRepository;
    @CrossOrigin(origins = "http://localhost:4200/")
    @GetMapping("/pg")
    public List<Pg> getAllPgs() {
        return PgRepository.findAll();
    }
    

}
