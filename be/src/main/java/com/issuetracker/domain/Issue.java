package com.issuetracker.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.issuetracker.dto.issue.IssuePostDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Table("subissue")
public class Issue {
    @Id
    private Long id;
    private Long userId;
    private Integer milestoneId;
    private String title;
    private boolean opened;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;
    private LocalDateTime deletedAt;

    public static Issue ofCreated(IssuePostDto issuePostDto) {
        return new IssueBuilder()
                .userId(issuePostDto.getUserId())
                .milestoneId(issuePostDto.getMilestoneId())
                .title(issuePostDto.getTitle())
                .opened(true)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Issue ofUpdated(IssuePostDto issuePostDto, Issue issueUnmodified, long id) {
        return new IssueBuilder()
                .id(id)
                .userId(issueUnmodified.getUserId())
                .milestoneId(issuePostDto.getMilestoneId())
                .title(issuePostDto.getTitle())
                .opened(issueUnmodified.isOpened())
                .createdAt(issueUnmodified.getCreatedAt())
                .closedAt(issueUnmodified.getClosedAt())
                .deletedAt(issueUnmodified.getDeletedAt())
                .build();
    }

    public static Issue ofDeleted(Issue issue) {
        return new Issue(issue.getId(), issue.getUserId(), issue.getMilestoneId(), issue.getTitle(), issue.isOpened(),
                issue.getCreatedAt(), issue.getClosedAt(), LocalDateTime.now());
    }
}
