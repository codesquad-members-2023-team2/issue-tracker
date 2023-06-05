package com.issuetracker.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.issuetracker.domain.Issue;
import com.issuetracker.domain.IssueContent;
import com.issuetracker.domain.User;

public interface IssueContentRepository extends CrudRepository<IssueContent, Long> {

}
