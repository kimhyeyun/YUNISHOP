package com.example.yunishop.domain.member;

import com.example.yunishop.constant.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String memberId;
    private String password;
    private int postCode;
    private String address;
    private String addtionalAddress;
    private Role role;
}
