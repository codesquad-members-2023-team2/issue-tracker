package com.issuetracker.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.issuetracker.domain.Label;
import com.issuetracker.mapper.LabelMapper;

public interface LabelRepository extends CrudRepository<Label, Integer> {

    @Query(value = "SELECT label_id, label_name, background_color, font_color, description, deleted FROM labelList WHERE deleted = 0")
    List<Label> findAllLabels();

    @Query("UPDATE labelList SET deleted = 1 WHERE label_id = :labelId")
    Label deleteByLabelId(@Param("labelId") Integer labelId);
}
