package com.clone.twitter.user_service.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserProfilePic {
    private String fileId;
    private String smallFileId;
}