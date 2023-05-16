package com.issuetracker.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LabelVo {
    private String name;
    private String backgroundColor;
    private String fontColor;
    private String description;
}
