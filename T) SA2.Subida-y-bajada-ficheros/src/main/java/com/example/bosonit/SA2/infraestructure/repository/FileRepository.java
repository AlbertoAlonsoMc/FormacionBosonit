package com.example.bosonit.SA2.infraestructure.repository;

import com.example.bosonit.SA2.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {
}
