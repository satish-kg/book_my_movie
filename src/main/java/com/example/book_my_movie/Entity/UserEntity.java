package com.example.book_my_movie.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private int age;
    @NonNull
    @Column(unique = true)
    private String mobileNo;
    private String address;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<TicketEntity> bookedTicketList = new ArrayList<>();

}
