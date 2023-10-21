package com.example.bai01.enums;

import lombok.Getter;

@Getter
public enum SkillLevel {
    MASTER("m"),
    BEGINER("b"),
    ADVANCED("a"),
    PROFESSIONAL("p"),
    IMTERMEDIATE("i");

    private final String level;

    SkillLevel(String level) {
        this.level = level;
    }

}
