package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;
import jar.service.Dservice;


@RestController
@RequestMapping("/api/v1")
public class Create {

    @Autowired
    Dservice db;

    @PostMapping
    public Map<Object, Object> create(@RequestBody Student d) {
        
         return db.create(d);
    }
    
    
}
