package com.local.ms_client.infrastructure.adapter.in.rest.controller;

import com.local.ms_client.application.port.in.FindClientUseCase;
import com.local.ms_client.application.port.in.SaveClientUseCase;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.mapper.ClientRestMapper;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.port.ClientApiPort;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.request.ClientRequest;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.response.ClientResponse;
import com.local.ms_client.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/clients")
public class ClientController implements ClientApiPort {
    private final FindClientUseCase findClientUseCase;
    private final SaveClientUseCase saveClientUseCase;
    private final ClientRestMapper clientRestMapper;

    @Override
    @Cacheable(value = "clients")
    public GenericResponse getClients(Pageable pageable) {
        Page<ClientResponse> page = findClientUseCase.findAllClients(pageable)
                .map(clientRestMapper::toResponse);
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(clientRestMapper.toPageResponse(page));
        return genericResponse;
    }

    @Override
    @Cacheable(value = "clients", key = "#storeId")
    public GenericResponse getClientsByStoreId(Long storeId, Pageable pageable) {
        Page<ClientResponse> page = findClientUseCase.findAllByStore(storeId, pageable)
                .map(clientRestMapper::toResponse);
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(clientRestMapper.toPageResponse(page));
        return genericResponse;
    }

    @Override
    @Cacheable(value = "clients", key = "#id")
    public GenericResponse getClientsById(Long id, Pageable pageable) {
        ClientResponse clientResponse = clientRestMapper.toResponse(
                findClientUseCase.findClientById(id));
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(clientResponse);
        return genericResponse;
    }

    @Override
    public GenericResponse saveClient(ClientRequest clientRequest) {
        ClientResponse clientSaved=clientRestMapper.toResponse(
                saveClientUseCase.save(clientRestMapper.toModel(clientRequest))
        );
        log.info("cliente saved {}" ,clientSaved);
        return GenericResponse.success();
    }

    @Override
    public GenericResponse updateClient(ClientRequest clientRequest) {
        ClientResponse updated=clientRestMapper.toResponse(
                saveClientUseCase.update(clientRestMapper.toModel(clientRequest))
        );
        log.info("cliente updated {}" ,updated);
        return GenericResponse.success();
    }
}
