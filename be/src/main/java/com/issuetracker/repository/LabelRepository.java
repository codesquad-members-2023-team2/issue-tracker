package com.issuetracker.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import com.issuetracker.domain.Label;

public interface LabelRepository extends CrudRepository<Label, Integer> {

    @Query("select label_id, label_name, background_color, font_color, description, deleted from labelList where deleted = 0")
    List<Label> findAllLabels();

    @Query("update label_id, label_name, background_color, font_color, description, deleted from labelList where deleted = 0")
    List<Label> findAllLabels();
}
