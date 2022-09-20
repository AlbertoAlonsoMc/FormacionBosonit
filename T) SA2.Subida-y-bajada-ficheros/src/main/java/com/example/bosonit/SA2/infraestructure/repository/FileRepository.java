package com.example.bosonit.SA2.infraestructure.repository;

import com.example.bosonit.SA2.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
