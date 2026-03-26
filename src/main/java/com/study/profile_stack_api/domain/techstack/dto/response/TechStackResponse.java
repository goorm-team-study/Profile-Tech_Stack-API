package com.study.profile_stack_api.domain.techstack.dto.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.study.profile_stack_api.domain.techstack.entity.TechStack;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 클라이언트에게 보여줄 데이터 구조

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TechStackResponse {
    private Long id;                    // 프로필 고유 ID
    private Long profileId;             // 프로필 ID (FK)
    private String name;                // 이름
    private String category;            // 기술 카테고리
    private String categoryIcon;    // 기술 카테고리 아이콘
    private String proficiency;         // 숙련도
    private String proficiencyIcon;     // 숙련도 아이콘
    private Integer yearsOfExp;         // 사용 경험 (년)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;    // 생성 일시
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;    // 수정 일시


    // Entity → Response 변환
    public static TechStackResponse from(TechStack entity) {
        return TechStackResponse.builder()
                .id(entity.getId())
                .profileId(entity.getProfileId())
                .name(entity.getName())
                .category(entity.getCategory().getDescription())
                .categoryIcon(entity.getCategory().getIcon())
                .proficiency(entity.getProficiency().getDescription())
                .proficiencyIcon(entity.getProficiency().getIcon())
                .yearsOfExp(entity.getYearsOfExp())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}
