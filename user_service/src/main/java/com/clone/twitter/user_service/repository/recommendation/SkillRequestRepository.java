package com.clone.twitter.user_service.repository.recommendation;

import com.clone.twitter.user_service.entity.recommendation.SkillRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRequestRepository extends CrudRepository<SkillRequest, Long> {

    @Query(nativeQuery = true, value = """
            INSERT INTO skill_request (request_id, skill_id)
            VALUES (:requestId, :skillId)
            """)
    @Modifying
    SkillRequest create(long requestId, long skillId);
}