package com.akarpov.forum.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "topic")
public class Topic {

    @Id
    private Long id;
    private String name;

}
