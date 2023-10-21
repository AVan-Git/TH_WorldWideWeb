package com.example.bai01.ids;

import com.example.bai01.models.Job;
import com.example.bai01.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobId implements Serializable {
    private Job job;
    private Skill skill;
}
