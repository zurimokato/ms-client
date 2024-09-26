package com.local.ms_client.infrastructure.adapter.out.database;

import com.local.ms_client.application.port.out.ClientOutputPort;
import com.local.ms_client.domain.model.Client;
import com.local.ms_client.infrastructure.adapter.out.database.mapper.ClientPersistenceMapper;
import com.local.ms_client.infrastructure.adapter.out.database.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientOutputPort {
    private final ClientRepository clientRepository;
    private final ClientPersistenceMapper clientPersistenceMapper;

    @Override
    public Client save(Client client) {
        return clientPersistenceMapper.toModel(
                clientRepository.save(clientPersistenceMapper.toEntity(client))
        );
    }

    @Override
    public Client findById(Long id) {
        return clientPersistenceMapper.toModel(
                clientRepository.findById(id).orElseThrow(
                        () -> new RuntimeException("")
                )
        );
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(clientPersistenceMapper::toModel);
    }

    @Override
    public Page<Client> findAllByStore(Long storeId, Pageable pageable) {
        return clientRepository.findAllByStoreId(storeId, pageable).map(clientPersistenceMapper::toModel);
    }
}
