package com.study.profile_stack_api.domain.profile.controller;

import com.study.profile_stack_api.domain.profile.dto.request.ProfileCreateRequest;
import com.study.profile_stack_api.domain.profile.dto.response.ProfileResponse;
import com.study.profile_stack_api.domain.profile.service.ProfileService;
import com.study.profile_stack_api.global.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //REST API 컨트롤러로 등록
@RequestMapping("/api/v1/profiles") // 기본 URL 경로 설정
public class ProfileController {
    private final ProfileService profileService; //의존성 주입: Servie를 주입받음

    public ProfileController(ProfileService profileService) { //생성자 주입, spring이 ProfileService 찾아서 자동으로 주입해준다.
        this.profileService = profileService;
    }

    //프로필 생성
    //POST 요청 처리
    @PostMapping
    public ResponseEntity<ApiResponse<ProfileResponse>> createProfile(
            //HTTP body를 객체로 변환
            @RequestBody ProfileCreateRequest request) {

        ProfileResponse response = profileService.createProfile(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "성공"));
    }
}
