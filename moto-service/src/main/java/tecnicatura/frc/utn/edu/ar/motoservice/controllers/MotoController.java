package tecnicatura.frc.utn.edu.ar.motoservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tecnicatura.frc.utn.edu.ar.motoservice.entities.Moto;
import tecnicatura.frc.utn.edu.ar.motoservice.services.MotoService;

import java.util.List;

@RestController
@RequestMapping("/moto")
public class MotoController {
    @Autowired
    private MotoService motoService;

    @GetMapping
    public ResponseEntity<List<Moto>> getMotos(){
        List<Moto> motos = motoService.getAll();
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Moto> getMotoById(@PathVariable Long id){
        Moto moto = motoService.getById(id);
        if(moto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(moto);
    }
    @PostMapping
    public ResponseEntity<Moto> postAuto(@RequestBody Moto moto){
        return ResponseEntity.ok(motoService.save(moto));
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Moto>> getMotosByUsuario(@PathVariable Long id){
        List<Moto> motos = motoService.byUsuarioId(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
}
