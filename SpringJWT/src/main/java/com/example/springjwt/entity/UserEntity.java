package com.example.springjwt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "user_entity")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // id가 생성되는 방식, id가 겹치지 않고 생성 됨.
    private int id;

    private String username;
    private String password;

    private String role; // 유저에 대한 권한을 줌.
}