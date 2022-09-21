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
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String originalName;

    private String categoria;

    private Date date;

    private Long bytes;

    public FileOutputDto toFileOutputDto() {
        return new FileOutputDto(id, originalName, categoria, date, bytes);
    }
}
