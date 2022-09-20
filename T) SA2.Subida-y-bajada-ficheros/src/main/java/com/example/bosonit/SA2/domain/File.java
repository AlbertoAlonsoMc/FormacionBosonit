package com.example.bosonit.SA2.domain;

import com.example.bosonit.SA2.infraestructure.dto.FileOutputDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String categoria;

    private Date date;

    private Long size;

    private FileOutputDto toFileOutputDto() {
        return new FileOutputDto(id, categoria, date, size);
    }
}
