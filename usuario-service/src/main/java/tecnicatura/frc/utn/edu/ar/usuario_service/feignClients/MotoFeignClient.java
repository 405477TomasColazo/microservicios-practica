package tecnicatura.frc.utn.edu.ar.usuario_service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tecnicatura.frc.utn.edu.ar.usuario_service.models.Moto;

import java.util.List;

@FeignClient(name = "moto-service",url = "localhost:8083")
public interface MotoFeignClient {
    @PostMapping("/moto")
    public Moto save(@RequestBody Moto moto);

    @GetMapping("/moto/usuario/{usuarioId}")
    public List<Moto> findByUsuarioId(@PathVariable("usuarioId") Long usuarioId);
}
