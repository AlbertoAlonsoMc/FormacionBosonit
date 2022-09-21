package com.example.bosonit.SA2.application;

import com.example.bosonit.SA2.domain.FileEntity;
import com.example.bosonit.SA2.infraestructure.dto.FileOutputDto;
import com.example.bosonit.SA2.infraestructure.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;

    private final Path rootFolder = Paths.get("uploaded_files");

    @Override
    public FileOutputDto save(MultipartFile file, String categoria) throws IOException {
        FileEntity fileEntity = new FileEntity(null, file.getOriginalFilename(), categoria, new Date(), file.getSize());
        fileRepository.save(fileEntity);
        Files.copy(file.getInputStream(), rootFolder.resolve(Objects.requireNonNull(file.getOriginalFilename())));
        return fileEntity.toFileOutputDto();
    }

    @Override
    public ResponseEntity<String> downloadByName(String name, Path targetFolder) throws IOException {
        if (targetFolder != null) {
            Files.copy(rootFolder.resolve(name), targetFolder.resolve(name));
            return ResponseEntity.status(HttpStatus.OK).body("Archivo descargado correctamente en " + targetFolder.toAbsolutePath());
        } else {
            Path rootFolderPath = Paths.get("");
            Files.copy(rootFolder.resolve(name), rootFolderPath.resolve(name));
            return ResponseEntity.status(HttpStatus.OK).body("Archivo descargado correctamente en " + rootFolderPath.toAbsolutePath());
        }

    }

    @Override
    public void downloadById(Long id) {

    }
}
