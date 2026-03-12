package com.study.profile_stack_api.domain.techstack.dto.response;


import com.study.profile_stack_api.domain.techstack.entity.TechStack;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 클라이언트에게 보여줄 데이터 구조

@Getter
@NoArgsConstructor
public class TechStackResponse {
    private Long id;                    // 프로필 고유 ID
    private Long profileId;             // 프로필 ID (FK)
    private String name;                // 이름
    private String category;            // 기술 카테고리
    private String categoryIcon;    // 기술 카테고리 아이콘
    private String proficiency;         // 숙련도
    private String proficiencyIcon;     // 숙련도 아이콘
    private Integer yearsOfExp;         // 사용 경험 (년)
    private LocalDateTime createdAt;    // 생성 일시
    private LocalDateTime updatedAt;    // 수정 일시


    // Entity → Response 변환
    public static TechStackResponse from(TechStack techStack) {
        TechStackResponse techStackResponse = new TechStackResponse();

        techStackResponse.id = techStack.getId();
        techStackResponse.profileId = techStack.getProfileId();
        techStackResponse.name = techStack.getName();
        techStackResponse.category = techStack.getCategory().getDescription();
        techStackResponse.categoryIcon = techStack.getCategory().getIcon();
        techStackResponse.proficiency = techStack.getProficiency().getDescription();
        techStackResponse.proficiencyIcon = techStack.getProficiency().getIcon();
        techStackResponse.yearsOfExp = techStack.getYearsOfExp();
        techStackResponse.createdAt = techStack.getCreatedAt();
        techStackResponse.updatedAt = techStack.getUpdatedAt();

        return techStackResponse;
    }
}
