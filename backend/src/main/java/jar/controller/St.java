package jar.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.model.Student;
import jar.repo.StudentRepo;

@RestController
@RequestMapping("/api/v1")
public class St {

    @Autowired
    StudentRepo db;

    @GetMapping()
    Map<Object, Object> m1() {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "welcome to get api");
        res.put("status", 200);
        res.put("data", m3());

        return res;
    }

    @PostMapping()
    Map<Object, Object> m2(@RequestBody Student d) {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "welcome to Post api");
        res.put("status", 201);
        String name = d.getName();
        String email = d.getEmail();
        String ip = d.getIp();
        Student s = new Student();
        s.setName(name);
        s.setEmail(email);
        s.setIp(ip);

        System.out.println("\n\t check 1 : " + d.getName());
        System.out.println("\n\t check 1 : " + d.getEmail());
        System.out.println("\n\t check 1 : " + d.getIp());

        db.save(s);

        return res;
    }
     @PutMapping("/update/{id}")
    Map<Object, Object> m4(@RequestBody Student d, @PathVariable("id") long id) {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "welcome to Put api");
        res.put("status", 200);
        Student s = db.findById(id).orElse(null);
        if (s != null) {
            if (d.getName() != null) {
                s.setName(d.getName());
            }
            if (d.getEmail() != null) {
                s.setEmail(d.getEmail());
            }
            if (d.getIp() != null) {
                s.setIp(d.getIp());
            }
            db.save(s);
        } else {
            res.put("msg", "Student not found");
            res.put("status", 404);
        }
        return res;
    }

    @DeleteMapping("/delete/{id}")
    Map<Object, Object> m5(@PathVariable("id") long id) {
        Map<Object, Object> res = new HashMap<>();
        res.put("msg", "welcome to Delete api");
        res.put("status", 200);
        Student s = db.findById(id).orElse(null);
        if (s != null) {
            db.delete(s);
        } else {
            res.put("msg", "Student not found");
            res.put("status", 404);
        }
        return res;
    }

    List<Student> m3() {
        return db.findAll();
    }

}
