package tecnicatura.frc.utn.edu.ar.usuario_service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tecnicatura.frc.utn.edu.ar.usuario_service.entities.Usuario;
import tecnicatura.frc.utn.edu.ar.usuario_service.feignClients.AutoFeignClient;
import tecnicatura.frc.utn.edu.ar.usuario_service.feignClients.MotoFeignClient;
import tecnicatura.frc.utn.edu.ar.usuario_service.models.Auto;
import tecnicatura.frc.utn.edu.ar.usuario_service.models.Moto;
import tecnicatura.frc.utn.edu.ar.usuario_service.repositories.UsuarioRepository;

import java.util.*;

@Service
public class UsuarioService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AutoFeignClient autoFeignClient;
    @Autowired
    private MotoFeignClient motoFeignClient;

    public List<Auto> getAutos(Long idUsuario) {
        return restTemplate.getForObject("http://localhost:8082/auto/usuario/"+idUsuario, List.class);
    }
    public List<Moto> getMotos(Long idUsuario) {
        return restTemplate.getForObject("http://localhost:8083/moto/usuario/"+idUsuario , List.class);
    }

    public Auto saveAuto(Long idUsuario, Auto auto) {
        auto.setUsuarioId(idUsuario);
        return autoFeignClient.save(auto);
    }
    public Moto saveMoto(Long idUsuario, Moto moto) {
        moto.setUsuarioId(idUsuario);
        return motoFeignClient.save(moto);
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
    public Map<String, Object> getUsuarioVehiculos(Long idUsuario){
        Map<String, Object> usuarioVehiculos = new HashMap<>();
        Usuario usuario = getById(idUsuario);
        if(usuario == null){
            usuarioVehiculos.put("Mensaje", "El usuario no existe");
            return usuarioVehiculos;
        }
        usuarioVehiculos.put("Usuario", usuario);
        List<Auto> autos = autoFeignClient.findByUsuarioId(idUsuario);
        if( autos == null || autos.isEmpty() ){
            usuarioVehiculos.put("Autos", "El usuario no tiene autos");
        } else {
            usuarioVehiculos.put("Autos", autos);
        }
        List<Moto> motos = motoFeignClient.findByUsuarioId(idUsuario);
        if(motos == null || motos.isEmpty()){
            usuarioVehiculos.put("Motos", "El usuario no tiene motos");
        }else {
            usuarioVehiculos.put("Motos", motos);
        }
        return usuarioVehiculos;
    }
}
