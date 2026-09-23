package cl.duoc.pedidos360_backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:4200")
public class Pedidos360Controller {

    @GetMapping
    public List<Map<String, Object>> obtenerPedidos() {

        return List.of(
            Map.of(
                "id", 1,
                "producto", "Notebook",
                "estado", "EN_PREPARACION"
            ),
            Map.of(
                "id", 2,
                "producto", "Telefono",
                "estado", "DISPONIBLE"
            )
        );
    }
}