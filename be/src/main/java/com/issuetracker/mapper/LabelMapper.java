package com.issuetracker.mapper;

import com.issuetracker.domain.Label;
import com.issuetracker.dto.label.LabelDto;

public class LabelMapper {
    public static LabelDto mapLabelEntityToDto(Label label) {
        return new LabelDto(label.getId(), label.getName(), label.getBackgroundColor(),
                label.getFontColor(), label.getDescription());
    }
}
