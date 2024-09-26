package com.local.ms_client.domain.services;


import com.local.ms_client.application.port.in.FindClientUseCase;
import com.local.ms_client.application.port.in.SaveClientUseCase;
import com.local.ms_client.application.port.out.ClientOutputPort;
import com.local.ms_client.domain.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientServices implements FindClientUseCase, SaveClientUseCase {
    private final ClientOutputPort clientOutputPort;

    @Override
    public Client findClientById(Long id) {
        return clientOutputPort.findById(id);
    }

    @Override
    public Page<Client> findAllClients(Pageable pageable) {
        return clientOutputPort.findAll(pageable);
    }

    @Override
    public Page<Client> findAllByStore(Long storeId, Pageable pageable) {
        return clientOutputPort.findAllByStore(storeId, pageable);
    }

    @Override
    public Client save(Client client) {
        return clientOutputPort.save(client);
    }

    @Override
    public Client update(Client client) {
        Client clientToSave = clientOutputPort.findById(client.getId());
        return clientOutputPort.save(client);
    }
}
