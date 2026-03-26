package com.study.profile_stack_api.domain.techstack.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechStackCreateRequest {

    @NotBlank(message = "기술명은 필수입니다.")
    private String name;

    @NotNull(message = "카테고리는 필수입니다.")
    private String category;

    @NotNull(message = "숙련도는 필수입니다.")
    private String proficiency;

    @NotNull(message = "경험 연수는 필수입니다.")
    private Integer yearsOfExp;
}
