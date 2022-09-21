package com.example.bosonit.SA2.application;

import com.example.bosonit.SA2.infraestructure.dto.FileOutputDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

public interface FileService {

    FileOutputDto save(MultipartFile file, String categoria) throws IOException;

    ResponseEntity<String> downloadByName(String name, Path targetFolder) throws IOException;

    ResponseEntity<String> downloadById(Long id, Path targetFolder) throws IOException;
}
