package com.local.ms_client.infrastructure.adapter.out.database.repositories;

import com.local.ms_client.infrastructure.adapter.out.database.entity.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    Page<ClientEntity> findAllByStoreId(Long storeId, Pageable pageable);
}
