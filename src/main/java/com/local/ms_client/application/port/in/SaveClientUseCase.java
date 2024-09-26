package com.local.ms_client.application.port.in;

import com.local.ms_client.domain.model.Client;

public interface SaveClientUseCase {

    Client save(Client client);
    Client update(Client client);
}
