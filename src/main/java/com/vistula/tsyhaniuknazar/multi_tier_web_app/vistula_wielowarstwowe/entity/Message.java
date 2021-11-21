package com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name_of_user")
    private String nameOfUser;

    @Column(name = "message")
    private String messageOfUser;

    @Column(name = "date_of_creation")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfCreation;

    @Column(name = "date_of_update")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfUpdate;
}
