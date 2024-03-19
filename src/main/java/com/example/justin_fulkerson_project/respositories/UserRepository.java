package com.example.justin_fulkerson_project.respositories;

import com.example.justin_fulkerson_project.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
