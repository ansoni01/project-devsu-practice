package com.devsu.cuentamovimientos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "tbl_client")
@Where(clause = "status <> 0")
@SQLDelete(sql = "UPDATE tbl_client SET status = 0 WHERE client_id = ?", callable = true)
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private boolean status;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Person person;
}