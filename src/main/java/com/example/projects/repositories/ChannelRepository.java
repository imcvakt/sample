package com.example.projects.repositories;

import com.example.projects.entities.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * channels would be a dictionary dont create that repo
 * seed all basic channels
 */
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
