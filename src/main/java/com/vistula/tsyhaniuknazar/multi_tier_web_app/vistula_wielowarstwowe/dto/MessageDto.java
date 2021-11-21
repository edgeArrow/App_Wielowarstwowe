package com.vistula.tsyhaniuknazar.multi_tier_web_app.vistula_wielowarstwowe.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MessageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    //@NotBlank(message = "Please provide your name")
    private String nameOfUser;

    //@NotBlank(message = "please provide your message")
    private String messageOfUser;
}
