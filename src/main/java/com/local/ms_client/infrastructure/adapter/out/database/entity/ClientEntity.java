package com.local.ms_client.infrastructure.adapter.out.database.entity;


import com.local.ms_client.domain.enums.StateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clients")
public class ClientEntity {
    @Id
    private Long id;
    private String name;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "second_last_name")
    private String secondLastName;
    private String email;
    private String phone;
    private String address;
    @Column(name = "storeId")
    private Long storeId;
    private StateEnum status;
}
