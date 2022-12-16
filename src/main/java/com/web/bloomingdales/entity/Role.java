package com.web.bloomingdales.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    private String roleName;
    private String roleDescription;
}
