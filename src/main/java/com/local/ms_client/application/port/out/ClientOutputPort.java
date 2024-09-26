package com.local.ms_client.application.port.out;

import com.local.ms_client.domain.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientOutputPort {

    Client save(Client client);
    Client findById(Long id);
    Page<Client>findAll(Pageable pageable);
    Page<Client>findAllByStore(Long storeId, Pageable pageable);
}
