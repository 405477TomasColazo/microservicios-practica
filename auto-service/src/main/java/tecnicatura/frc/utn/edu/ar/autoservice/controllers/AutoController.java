package tecnicatura.frc.utn.edu.ar.autoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tecnicatura.frc.utn.edu.ar.autoservice.entities.Auto;
import tecnicatura.frc.utn.edu.ar.autoservice.services.AutoService;

import java.util.List;

@RestController
@RequestMapping("/auto")
public class AutoController {
    @Autowired
    private AutoService autoService;

    @GetMapping
    public ResponseEntity<List<Auto>> getAutos(){
        List<Auto> autos = autoService.getAll();
        if(autos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Auto> getAutoById(@PathVariable Long id){
        Auto auto = autoService.getById(id);
        if(auto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(auto);
    }
    @PostMapping
    public ResponseEntity<Auto> postAuto(@RequestBody Auto auto){
        return ResponseEntity.ok(autoService.save(auto));
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Auto>> getAutosByUsuario(@PathVariable Long id){
        List<Auto> autos = autoService.byUsuarioId(id);
        if(autos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autos);
    }
}
