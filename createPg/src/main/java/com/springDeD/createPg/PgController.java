package com.springDeD.createPg;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PgController {
    Pg pg1 = new Pg("Eraon");
    Pg pg2 = new Pg("Gon");
    Pg pg3 = new Pg("Kilua");
    private Map<String,Pg>dbPg= new HashMap<>(){{
        put(pg1.getId(),pg1);
        put(pg2.getId(),pg2);
        put(pg3.getId(),pg3);
    }};
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/pg")
    public Collection<Pg> getPg(){
        return dbPg.values();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/pg/{id}")
    public Pg getSinglePg(@PathVariable String id){
        Pg pgTmp = dbPg.get(id);
        if (pgTmp==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return pgTmp;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/pg/{id}")
    public void deleteSinglePg(@PathVariable String id){
        Pg pgTmp = dbPg.remove(id);
        if (pgTmp==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/pg")
    public Pg create(@RequestBody String name){
        Pg pgTmp = new Pg(name);
        dbPg.put(pgTmp.getId(),pgTmp);
        return pgTmp;
    }


}
