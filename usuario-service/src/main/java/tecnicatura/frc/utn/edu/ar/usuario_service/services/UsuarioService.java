package tecnicatura.frc.utn.edu.ar.usuario_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicatura.frc.utn.edu.ar.usuario_service.entities.Usuario;
import tecnicatura.frc.utn.edu.ar.usuario_service.repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

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
