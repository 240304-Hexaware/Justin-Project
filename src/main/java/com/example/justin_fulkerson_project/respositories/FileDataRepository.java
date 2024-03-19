package com.example.justin_fulkerson_project.respositories;

import com.example.justin_fulkerson_project.entities.FileDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDataRepository extends MongoRepository<FileDataEntity, Object> {
    // Define custom methods for querying or managing FileDataEntity objects if needed
}
