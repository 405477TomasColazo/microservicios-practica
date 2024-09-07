package tecnicatura.frc.utn.edu.ar.usuario_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tecnicatura.frc.utn.edu.ar.usuario_service.entities.Usuario;
import tecnicatura.frc.utn.edu.ar.usuario_service.models.Auto;
import tecnicatura.frc.utn.edu.ar.usuario_service.models.Moto;
import tecnicatura.frc.utn.edu.ar.usuario_service.repositories.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Auto> getAutos(Long idUsuario) {
        return restTemplate.getForObject("http://localhost:8082/usuario/"+idUsuario, List.class);
    }
    public List<Moto> getMotos(Long idUsuario) {
        return restTemplate.getForObject("http://localhost:8083/usuario/"+idUsuario , List.class);
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getById(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
