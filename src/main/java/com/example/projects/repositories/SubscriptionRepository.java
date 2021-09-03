package com.example.projects.repositories;

import com.example.projects.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("SELECT sub FROM Subscription sub " +
            "JOIN FETCH sub.items sui " +
            "WHERE " +
            "sub.legalEntityId = :legalEntityId " +
            "AND (sui.deskId IN :deskIds OR sui.productGradeId = :productGradeId)")
    List<Subscription> findUsersSubscribedByLegalEntityAndDeskOrProductGrade(
            @Param("legalEntityId") String legalEntityId,
            @Param("deskIds") List<String> deskIds,
            @Param("productGradeId") String productGradeId
    );
}
