package com.study.profile_stack_api.domain.techstack.controller;

import com.study.profile_stack_api.domain.techstack.dto.request.TechStackCreateRequest;
import com.study.profile_stack_api.domain.techstack.dto.request.TechStackUpdateRequest;
import com.study.profile_stack_api.domain.techstack.dto.response.TechStackResponse;
import com.study.profile_stack_api.domain.techstack.entity.TechStack;
import com.study.profile_stack_api.domain.techstack.service.TechStackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/profiles/{profileId}/tech-stacks") // {}는 정해진게 아니라 어떤 값이 들어갈 수 있음
// 위 두개 에러 시 gradle에 추가
// implementation 'org.springframework.boot:spring-boot-starter-web'
@RequiredArgsConstructor
@Validated
@Slf4j
public class TechStackController {
    private final TechStackService techstackService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TechStackResponse> create(@Valid @RequestBody TechStackCreateRequest request) {
        TechStack created = techstackService.create(request);
        return ResponseEntity.created(URI.create("/api/v1/profiles/{profileId}/tech-stacks" + created.getId())).body(TechStackResponse.from(created));
    }

    @GetMapping
    public List<TechStackResponse> getAll() {
        return techstackService.findAll().stream()
                .map(TechStackResponse::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TechStackResponse getById(@PathVariable Long id) {
        return TechStackResponse.from(techstackService.findById(id));
    }

    @PutMapping("/{id}")
    public TechStackResponse update(@PathVariable Long id, @Valid @RequestBody TechStackUpdateRequest request){
        TechStack updated = techstackService.update(id, request);
        return TechStackResponse.from(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        techstackService.delete(id);
    }
}
