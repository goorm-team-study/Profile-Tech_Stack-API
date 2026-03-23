package com.study.profile_stack_api.domain.techstack.repository;

import com.study.profile_stack_api.domain.techstack.entity.Category;
import com.study.profile_stack_api.domain.techstack.entity.Proficiency;
import com.study.profile_stack_api.domain.techstack.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Jpa: 어노테이션 필요 없음, Jdbc: 어노테이션 필요 @Repository
// JpaRepository문제 시 gradle reload.
public interface TechStackRepository extends JpaRepository<TechStack, Long>{

    // 이름 조회: 이름 같은 대명사는 List보단 Optional사용
    Optional<TechStack> findByName(String name);

    // 카테고리별 조회
    List<TechStack> findByCategory(Category category);

    // 숙련도별 조회
    List<TechStack> findByProficiency(Proficiency proficiency);

    // *존재 여부
    Boolean existByName(String name);
}
