package com.example.projects.repositories;

import com.example.projects.entities.WebPush;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebPushRepository extends JpaRepository<WebPush, Long> {
}
