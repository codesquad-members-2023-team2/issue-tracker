package com.issuetracker.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Table("label")
public class Label {

    public Label(String labelName, String backgroundColor, String fontColor, String description) {
        this.labelName = labelName;
        this.backgroundColor = backgroundColor;
        this.fontColor = fontColor;
        this.description = description;
    }

    public Label(Integer labelId, String labelName, String backgroundColor, String fontColor, String description) {
        this.labelId = labelId;
        this.labelName = labelName;
        this.backgroundColor = backgroundColor;
        this.fontColor = fontColor;
        this.description = description;
    }

    @Id
    @Column("id")
    private Integer labelId;
    @Column("name")
    private String labelName;
    @Column("background_color")
    private String backgroundColor;
    @Column("font_color")
    private String fontColor;
    private String description;
    private Boolean deleted;
}
