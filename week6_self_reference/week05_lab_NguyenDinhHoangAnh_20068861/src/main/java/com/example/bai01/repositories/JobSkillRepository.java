package com.example.bai01.repositories;

import com.example.bai01.ids.JobId;
import com.example.bai01.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSkillRepository extends JpaRepository<JobSkill, JobId> {
}