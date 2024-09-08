package tecnicatura.frc.utn.edu.ar.usuario_service.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import tecnicatura.frc.utn.edu.ar.usuario_service.models.Auto;

import java.util.List;

@FeignClient(name = "auto-service", url = "http://localhost:8082")
public interface AutoFeignClient {
    @PostMapping("/auto")
    public Auto save(@RequestBody Auto auto);

    @GetMapping("/auto/usuario/{usuarioId}")
    public List<Auto> findByUsuarioId(@PathVariable("usuarioId") Long usuarioId);
}
