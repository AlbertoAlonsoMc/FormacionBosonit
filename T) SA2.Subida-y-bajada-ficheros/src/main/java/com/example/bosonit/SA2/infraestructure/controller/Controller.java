package com.example.bosonit.SA2.infraestructure.controller;

import com.example.bosonit.SA2.application.FileService;
import com.example.bosonit.SA2.infraestructure.dto.FileOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private FileService fileService;

    @PostMapping("upload/{categoria}")
    public FileOutputDto uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String categoria) throws IOException {
        return fileService.save(file, categoria);
    }

    @GetMapping("download/id/{id}/setpath")
    public FileOutputDto downloadFileId(@PathVariable Long id, @RequestParam(required = false) Path path) {
        return null;
    }

    @GetMapping("download/name/{name}")
    public ResponseEntity<String> downloadFileName(@PathVariable String name, @RequestParam(required = false) Path path) throws IOException {
        return fileService.downloadByName(name, path);
    }
}
