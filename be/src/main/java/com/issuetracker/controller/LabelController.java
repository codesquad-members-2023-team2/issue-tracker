package com.issuetracker.controller;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.issuetracker.domain.Label;
import com.issuetracker.dto.label.LabelListDto;
import com.issuetracker.service.LabelService;
import com.issuetracker.vo.LabelVo;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LabelController {
    private final LabelService labelService;

    @GetMapping("/api/labels")
    public LabelListDto labelList() throws SQLException {
        return labelService.findAllLabels();
    }

    /**
     * 라벨 등록 기능
     * 예외처리 필요
     * @param labelName
     * @param backgroundColor
     * @param fontColor
     * @param description
     */
    @PostMapping("/api/labels")
    public void post(@RequestBody LabelVo labelVo) throws SQLException {
        labelService.createLabel(new Label(null, labelVo.getName(), labelVo.getBackgroundColor(), labelVo.getFontColor(),
                labelVo.getDescription(), false));
    }

    @DeleteMapping("/api/labels/{labelId}")
    public void delete(@PathVariable int labelId) {
        labelService.deleteLabelById(labelId);
    }

    @PatchMapping("/api/labels/{labelId}")
    public void update(@PathVariable int labelId, @RequestBody LabelVo labelVo) {
        labelService.updateLabel(new Label(labelId, labelVo.getName(), labelVo.getBackgroundColor(), labelVo.getFontColor(),
                labelVo.getDescription()));
    }

    // @ExceptionHandler(SQLException.class)
    // public void sqlException() {
    //     System.out.println("SQL 예외 발생(예외처리 수정 예정)");
    // }
    //
    // @ExceptionHandler(IllegalArgumentException.class)
    // public void labelException() {
    //     System.out.println("존재하지 않는 Issue입니다.");
    // }
}
