package tecnicatura.frc.utn.edu.ar.autoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicatura.frc.utn.edu.ar.autoservice.entities.Auto;
import tecnicatura.frc.utn.edu.ar.autoservice.repositories.AutoRepository;

import java.util.List;

@Service
public class AutoService {
    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> getAll(){
        return autoRepository.findAll();
    }

    public Auto getById(Long id){
        return autoRepository.findById(id).orElse(null);
    }
    public Auto save(Auto auto){
        return autoRepository.save(auto);
    }
    public List<Auto> byUsuarioId(Long id){
        return autoRepository.findByUsuario_id(id);
    }
}
