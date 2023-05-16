package com.issuetracker.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.issuetracker.domain.Label;
import com.issuetracker.mapper.LabelMapper;

public interface LabelRepository extends CrudRepository<Label, Integer> {

    @Query(value = "SELECT id, name, background_color, font_color, description, deleted FROM label WHERE deleted = 0")
    List<Label> findAllLabels();

    @Query("UPDATE label SET deleted = 1 WHERE id = :id")
    Label deleteByid(@Param("id") Integer id);

    @Query("INSERT INTO label (name, background_color, font_color, description) VALUES (:name, :backgroundColor, :fontColor, :description)")
    Label createLabel(@Param("name") String name, @Param("backgroundColor") String backgroundColor,
            @Param("fontColor") String fontColor, @Param("description") String description);
}
