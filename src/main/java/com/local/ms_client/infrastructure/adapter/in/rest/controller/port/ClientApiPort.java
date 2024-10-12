package com.local.ms_client.infrastructure.adapter.in.rest.controller.port;

import com.local.ms_client.infrastructure.adapter.in.rest.controller.request.ClientRequest;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

public interface ClientApiPort {
    @GetMapping
    GenericResponse getClients(Pageable pageable);

    @GetMapping("/find")
    GenericResponse getClientsByStoreId(@RequestParam Long storeId, Pageable pageable);

    @GetMapping("/{id}")
    GenericResponse getClientsById(@PathVariable(name = "id") Long id, Pageable pageable);

    @PostMapping()
    GenericResponse saveClient(@RequestBody @Valid ClientRequest clientRequest);

    @PutMapping
    GenericResponse updateClient(@RequestBody @Valid ClientRequest clientRequest);

}
