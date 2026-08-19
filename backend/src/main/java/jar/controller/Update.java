package jar.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jar.model.Student;
import jar.repo.StudentRepo;
import jar.service.Dservice;

@RestController
@RequestMapping("/api/v1")
public class Update {

    @Autowired
    Dservice db;

    @PutMapping("/{id}")
    public Map<Object, Object> update(@PathVariable Integer id, @RequestBody Student d) {

       return db.update(id, d);
    }
}
