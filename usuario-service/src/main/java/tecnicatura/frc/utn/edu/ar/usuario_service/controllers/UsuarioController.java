package tecnicatura.frc.utn.edu.ar.usuario_service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tecnicatura.frc.utn.edu.ar.usuario_service.entities.Usuario;
import tecnicatura.frc.utn.edu.ar.usuario_service.models.Auto;
import tecnicatura.frc.utn.edu.ar.usuario_service.models.Moto;
import tecnicatura.frc.utn.edu.ar.usuario_service.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
       List<Usuario> usuarios = usuarioService.getAll();
       if(usuarios.isEmpty()){
           return ResponseEntity.noContent().build();
       }
       return ResponseEntity.ok(usuarios);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.getById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
        Usuario usuarioNuevo = usuarioService.save(usuario);
        return ResponseEntity.ok(usuarioNuevo);
    }
    @GetMapping("/autos/{id}")
    public ResponseEntity<List<Auto>> getAutos(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.getById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        List<Auto> autos = usuarioService.getAutos(id);
        if(autos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(autos);
    }
    @GetMapping("/motos/{id}")
    public ResponseEntity<List<Moto>> getMotos(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.getById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        List<Moto> motos = usuarioService.getAutos(id);
        if(motos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(motos);
    }
}
