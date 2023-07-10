package com.user.Service.Entites;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="userId",length = 50)
    private String userId;
    private String name;
    private String email;
    private String about;
    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
