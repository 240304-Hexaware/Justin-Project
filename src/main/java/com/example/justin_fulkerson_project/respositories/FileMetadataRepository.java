package com.example.justin_fulkerson_project.respositories;// FileMetadataRepository.java
import com.example.justin_fulkerson_project.entities.FileMetadataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileMetadataRepository extends MongoRepository<FileMetadataEntity, String> {
    // No need to define methods here; use default CRUD methods
}
