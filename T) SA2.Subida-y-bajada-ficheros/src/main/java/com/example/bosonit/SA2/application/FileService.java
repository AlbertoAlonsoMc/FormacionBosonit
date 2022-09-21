package com.example.bosonit.SA2.application;

import com.example.bosonit.SA2.infraestructure.dto.FileOutputDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    FileOutputDto save(MultipartFile file, String categoria) throws IOException;

    Resource loadByName(String name);

    Resource loadById(Long id);
}
