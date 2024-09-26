package com.local.ms_client.infrastructure.adapter.in.rest.controller;

import com.local.ms_client.application.port.in.FindClientUseCase;
import com.local.ms_client.application.port.in.SaveClientUseCase;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.mapper.ClientRestMapper;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.port.ClientApiPort;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.request.ClientRequest;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.response.ClientResponse;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/clients")
public class ClientController implements ClientApiPort {
    private final FindClientUseCase findClientUseCase;
    private final SaveClientUseCase saveClientUseCase;
    private final ClientRestMapper clientRestMapper;

    @Override
    public ResponseEntity<GenericResponse> getClients(Pageable pageable) {
        Page<ClientResponse> page = findClientUseCase.findAllClients(pageable)
                .map(clientRestMapper::toResponse);
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(clientRestMapper.toPageResponse(page));
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> getClientsByStoreId(Long storeId, Pageable pageable) {
        Page<ClientResponse> page = findClientUseCase.findAllByStore(storeId, pageable)
                .map(clientRestMapper::toResponse);
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(clientRestMapper.toPageResponse(page));
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> getClientsById(Long id, Pageable pageable) {
        ClientResponse clientResponse = clientRestMapper.toResponse(
                findClientUseCase.findClientById(id));
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(clientResponse);
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> saveClient(ClientRequest clientRequest) {
        ClientResponse clientSaved=clientRestMapper.toResponse(
                saveClientUseCase.save(clientRestMapper.toModel(clientRequest))
        );
        GenericResponse genericResponse = GenericResponse.success();
        return ResponseEntity.ok(genericResponse);
    }

    @Override
    public ResponseEntity<GenericResponse> updateClient(ClientRequest clientRequest) {
        ClientResponse clientSaved=clientRestMapper.toResponse(
                saveClientUseCase.update(clientRestMapper.toModel(clientRequest))
        );
        GenericResponse genericResponse = GenericResponse.success();
        return ResponseEntity.ok(genericResponse);
    }
}
