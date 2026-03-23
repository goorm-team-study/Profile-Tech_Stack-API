package com.study.profile_stack_api.domain.techstack.service;

import com.study.profile_stack_api.domain.techstack.dto.request.TechStackCreateRequest;
import com.study.profile_stack_api.domain.techstack.entity.Category;
import com.study.profile_stack_api.domain.techstack.entity.Proficiency;
import com.study.profile_stack_api.domain.techstack.entity.TechStack;
import com.study.profile_stack_api.domain.techstack.repository.TechStackRepository;

import com.study.profile_stack_api.global.exception.TechStackNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //import javax.transaction.Transactional가 아님
@RequiredArgsConstructor
@Slf4j
public class TechStackService {
    private final TechStackRepository techStackRepository;

    @Transactional // 데이터를 변경하는 작업에 필요(INSERT)
    public TechStack create(TechStackCreateRequest request) {
        TechStack techStack = TechStack.builder()
                .name(request.getName())
                .category(Category.valueOf(request.getCategory().toUpperCase())) // 소문자 대문자 방지
                .proficiency(Proficiency.valueOf(request.getProficiency().toUpperCase()))
                .build();
        return techStackRepository.save(techStack);
    }
    // SELECT
    public List<TechStack> findAll() {
        return techStackRepository.findAll();
    }

    // SELECT
    public TechStack findById(Long id) {
        return techStackRepository.findById(id)
                .orElseThrow(() -> new TechStackNotFoundException(id));
    }
    // *카테고리 조회
    public List<TechStack> findByCategory(Category category) {
        return techStackRepository.findByCategory(category);
    }
    // *숙련도 조회
    public List<TechStack> findByProficiency(Proficiency proficiency) {
        return techStackRepository.findByProficiency(proficiency);
    }

    @Transactional // UPDATE
    public TechStack update(Long id, TechStackCreateRequest request) {
        TechStack techStack = findById(id);
        // Dirty Checking
        if (request.getName() != null)
            techStack.setName(request.getName());

        if (request.getCategory() != null)
            techStack.setCategory(Category.valueOf(request.getCategory().toUpperCase()));

        if (request.getProficiency() != null)
            techStack.setProficiency(Proficiency.valueOf(request.getProficiency().toUpperCase()));

        return techStack;
    }

    @Transactional // DELETE
    public void delete(Long id) {
        if(!techStackRepository.existByName(String.valueOf(id))){
            throw new TechStackNotFoundException(id);
        }
        techStackRepository.deleteById(id);
    }
}
