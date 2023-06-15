package kea.dat22v2.mdd.eksamen3sem.app.api;


import kea.dat22v2.mdd.eksamen3sem.app.dto.ReserveRequest;
import kea.dat22v2.mdd.eksamen3sem.app.dto.ReserveResponse;
import kea.dat22v2.mdd.eksamen3sem.app.service.ReserveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reserve")
@CrossOrigin
public class ReserveController {

    ReserveService service;

    public ReserveController(ReserveService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<ReserveResponse>> findAllReserve() {
        return ResponseEntity.ok().body(service.findAllReserves());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReserveResponse> findReserve(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(service.findReserve(id));
    }

    @PostMapping
    public ResponseEntity<ReserveResponse> addReserve(@RequestBody ReserveRequest request) {
        return ResponseEntity.ok().body(service.addReserve(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteReserve(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(service.deleteReserve(id));
    }
}