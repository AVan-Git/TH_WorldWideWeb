package vn.edu.iuh.fit.se.enums;

public enum SkillLevel {

    MASTER(1),
    BEGINER(2),
    ADVANCED(3),
    PROFESSIONAL(4),
    IMTERMEDIATE(5);
    private final  int level;
    SkillLevel(int level) {
        this.level = level;
    }

}
