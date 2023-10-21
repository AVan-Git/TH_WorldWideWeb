package com.example.bai01.repositories;

import com.example.bai01.ids.CandidateId;
import com.example.bai01.models.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateId> {
}