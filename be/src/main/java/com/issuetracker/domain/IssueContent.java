package com.issuetracker.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import com.issuetracker.dto.issue.IssuePostDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Table("subissue_content")
public class IssueContent {
    @Id
    private Long id;
    private String content;
}
