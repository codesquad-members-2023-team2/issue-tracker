package com.issuetracker.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.issuetracker.domain.Label;

public interface LabelRepository extends CrudRepository<Label, Integer> {

    @Query("select label_id, label_name, background_color, font_color, description, deleted from labelList where deleted = 0")
    List<Label> findAllLabels();

    @Query("update labelList set deleted = 1 where label_id = :labelId")
    Label deleteByLabelId(@Param("labelId") Integer labelId);
}
