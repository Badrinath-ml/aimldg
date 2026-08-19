package jar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jar.repo.StudentRepo;
import jar.service.Dservice;

@RestController
@RequestMapping("/api/v1")
public class Delete {

    @Autowired
    Dservice obj;

    @DeleteMapping("/{id}")
    public Map<Object, Object> delete(@PathVariable Integer id) {

       
        return obj.ds(id);
    }
}
