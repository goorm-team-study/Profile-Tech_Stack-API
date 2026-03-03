package com.study.profile_stack_api.domain.pofile.entity;

//직무
public enum Position {
    BACKEND("⚙️", "백엔드 개발자"),
    FRONTEND("🎨", "프론트엔드 개발자"),
    FULLSTACK("🔄", "풀스택 개발자"),
    MOBILE("📱", "모바일 개발자"),
    DEVOPS("🚀", "DevOps 엔지니어"),
    DATA("📊", "데이터 엔지니어"),
    AI("🤖", "AI/ML 엔지니어"),
    ETC("💻" ,"기타");

    private final String icon;
    private final String description;

    Position(String icon,String description) {
        this.icon = icon;
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }
    public String getDescription() {
        return description;
    }
}
