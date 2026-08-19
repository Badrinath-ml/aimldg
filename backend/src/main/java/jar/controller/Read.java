package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jar.service.Dservice;
import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api/v1")
public class Read {

    @Autowired
    Dservice db;

    @GetMapping 
    public Map<Object, Object> read() {

        return db.read();
    }
    
}
