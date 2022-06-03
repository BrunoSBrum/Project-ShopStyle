package com.ms.history.repository;

import com.ms.history.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    @Query("{ 'history_id' : ?0 }")
    User findByHistory_id(Long history_id);
}
