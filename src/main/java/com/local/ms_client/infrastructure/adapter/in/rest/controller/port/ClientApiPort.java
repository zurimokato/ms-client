package com.local.ms_client.infrastructure.adapter.in.rest.controller.port;

import com.local.ms_client.infrastructure.adapter.in.rest.controller.request.ClientRequest;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ClientApiPort {
    @GetMapping
    ResponseEntity<GenericResponse> getClients(Pageable pageable);
    @GetMapping("/{storeId}")
    ResponseEntity<GenericResponse> getClientsByStoreId(@PathVariable Long storeId, Pageable pageable);
    @GetMapping("/")
    ResponseEntity<GenericResponse> getClientsById(@RequestParam Long id, Pageable pageable);

    @PostMapping()
    ResponseEntity<GenericResponse> saveClient(@RequestBody @Valid ClientRequest clientRequest);
    @PutMapping
    ResponseEntity<GenericResponse> updateClient(@RequestBody @Valid ClientRequest clientRequest);

}
