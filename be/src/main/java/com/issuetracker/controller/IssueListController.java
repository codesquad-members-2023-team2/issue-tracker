package com.issuetracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.issuetracker.domain.Label;
import com.issuetracker.dto.IssueDto;
import com.issuetracker.dto.FilterLabelDto;
import com.issuetracker.dto.IssueLabelDto;
import com.issuetracker.dto.IssueListDto;
import com.issuetracker.dto.FilterMilestoneDto;
import com.issuetracker.dto.FilterUserDto;
import com.issuetracker.repository.LabelRepository;
import com.issuetracker.service.LabelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class IssueListController {
    private final LabelService labelService;

    @GetMapping("api/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<IssueListDto> home() {
        List<IssueDto> issues = new ArrayList<>();
        List<FilterUserDto> userList = new ArrayList<>();
        List<FilterLabelDto> labelList = new ArrayList<>();
        List<FilterMilestoneDto> milestoneList = new ArrayList<>();

        List<IssueLabelDto> issueLabelList = new ArrayList();
        issueLabelList.add(new IssueLabelDto(1, "라벨이름", "x000000", "x111111"));

        labelList.add(new FilterLabelDto(1, "라벨이름", "x000000", "x111111", "백엔드 라벨"));
        userList.add(new FilterUserDto(1, "luke", "프사"));
        milestoneList.add(new FilterMilestoneDto(1, "마일스톤", "설명", 2, 1));
        issues.add(new IssueDto(1, "나는 이슈다", "내용", "루크", "프사", true, "now", "내일", "마이 마일스톤", issueLabelList));

        IssueListDto issueListDto = new IssueListDto(issues, userList, labelList, milestoneList, 1,2,3,4);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        // headers.add("status", "200");
        // headers.add("message", "example");
        return new ResponseEntity<IssueListDto>(issueListDto, headers ,HttpStatus.OK);
    }

    @GetMapping("api/labels")
    public void labelList() {
        //labelService.createLabel(new Label(null, "포로", "붉은 색", "푸른 색", "설명", false));
        labelService.deleteLabelById(3);
        //labelService.updateLabel(new Label(2, "루크", "붉은 색", "푸른 색", "설명", false));
        System.out.println(labelService.findAllLabels());
    }
}
