package com.issuetracker.mapper;

import com.issuetracker.domain.Label;
import com.issuetracker.dto.label.LabelDto;

public class LabelMapper {
    public static LabelDto mapLabelEntityToDto(Label label) {
        return new LabelDto(label.getLabelId(), label.getLabelName(), label.getBackgroundColor(),
                label.getFontColor(), label.getDescription());
    }
}
