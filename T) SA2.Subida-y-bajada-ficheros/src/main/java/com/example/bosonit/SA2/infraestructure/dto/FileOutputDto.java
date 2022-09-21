package com.example.bosonit.SA2.infraestructure.dto;

import java.util.Date;

public record FileOutputDto(Long id, String originalName, String categoria, Date date, Long bytes) {
}
