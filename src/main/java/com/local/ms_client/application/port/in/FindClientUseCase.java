package com.local.ms_client.application.port.in;

import com.local.ms_client.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindClientUseCase {
    Client findClientById(Long id);
    Page<Client> findAllClients(Pageable pageable);
    Page<Client> findAllByStore(Long storeId,Pageable pageable);
}
