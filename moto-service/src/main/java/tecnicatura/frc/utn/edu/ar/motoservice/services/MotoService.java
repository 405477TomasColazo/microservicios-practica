package tecnicatura.frc.utn.edu.ar.motoservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tecnicatura.frc.utn.edu.ar.motoservice.entities.Moto;
import tecnicatura.frc.utn.edu.ar.motoservice.repositories.MotoRepository;

import java.util.List;

@Service
public class MotoService {
    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> getAll(){
        return motoRepository.findAll();
    }

    public Moto getById(Long id){
        return motoRepository.findById(id).orElse(null);
    }
    public Moto save(Moto moto){
        return motoRepository.save(moto);
    }
    public List<Moto> byUsuarioId(Long id){
        return motoRepository.findByUsuarioId(id);
    }
}
