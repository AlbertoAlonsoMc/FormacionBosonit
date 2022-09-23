package com.example.bosonit.kafka.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    private String firstName, lastName;
}
