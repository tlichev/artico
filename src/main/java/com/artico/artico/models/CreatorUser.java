package com.artico.artico.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreatorUser extends LocalUser {
    @Column(name = "about_creator")
    private String aboutCreator;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "recommendations")
    private Integer recommendations;

}