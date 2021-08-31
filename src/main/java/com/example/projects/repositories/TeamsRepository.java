package com.example.projects.repositories;

import com.example.projects.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<Teams, Long> {
}
