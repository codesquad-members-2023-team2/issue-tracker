package com.issuetracker.service;

import com.issuetracker.domain.Milestone;
import com.issuetracker.dto.milestone.MilestoneDto;
import com.issuetracker.repository.MilestoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MilestoneService {

    private final MilestoneRepository milestoneRepository;

    public List<MilestoneDto> findAllMilestones() {

        List<Milestone> milestoneList = milestoneRepository.findAllMilestones();
        List<MilestoneDto> milestoneDtoList = new ArrayList<>();

        for (Milestone milestone : milestoneList) {
            int milestoneId = milestone.getId();
            long countOpenedIssues = milestoneRepository.countOpenedIssuesByMilestoneId(milestoneId);
            long countClosedIssues = milestoneRepository.countClosedIssuesByMilestoneId(milestoneId);
            int progress = 0;
            if (countClosedIssues + countOpenedIssues != 0) {
                progress = (int) (100 * ((double) countClosedIssues / (countOpenedIssues + countClosedIssues)));
            }

            milestoneDtoList.add(new MilestoneDto(milestoneId,
                    milestone.getName(),
                    milestone.getDescription(),
                    milestone.getCompletedAt(),
                    countOpenedIssues, countClosedIssues, progress));
        }

        return milestoneDtoList;
    }
}
