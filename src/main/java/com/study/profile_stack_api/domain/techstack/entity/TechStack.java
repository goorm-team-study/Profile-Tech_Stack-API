package com.study.profile_stack_api.domain.techstack.entity;

import jakarta.persistence.*;
import lombok.*;
//import org.hibernate.annotations.*; --> 필요 없는 것도 같이 import됨, 충돌의 원인
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

//DB 데이터 구조

@Entity // JPA가 관리하는 엔티티 클래스임을 선언, 기본 생성자 필요
@Table(name = "techstacks")
//위 어노테이션으로 JPA가 DB테이블과 매핑한다
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechStack {

    @Id //엔티티의 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                    // 프로필 고유 ID

    @Column(nullable = false)
    private Long profileId;             // 프로필 ID (FK)

    @Column(nullable = false, length = 50)
    private String name;                // 이름

    @Enumerated(EnumType.STRING) //이름을 문자열로 저장
    @Column(length = 20)
    private Category category;          // 기술 카테고리 ->enum으로 만들어서

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Proficiency proficiency;    // 숙련도 ->enum으로 만들어서

    @Column(name = "years_of_exp")
    private Integer yearsOfExp;         // 사용 경험 (년)

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp //Hibernate 전용 어노테이션, 엔티티 생성/수정 시 자동으로 시간 설정
    private LocalDateTime createdAt;    // 생성 일시

    @Column(name = "updated_at")
    @UpdateTimestamp  //Hibernate 전용 어노테이션, 엔티티 생성/수정 시 자동으로 시간 설정
    private LocalDateTime updatedAt;    // 수정 일시
}
