package com.issuetracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.issuetracker.domain.Label;
import com.issuetracker.dto.label.LabelListDto;
import com.issuetracker.repository.LabelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LabelService {
    private final LabelRepository labelRepository;

    public Optional<Label> createLabel(Label label) {
        return Optional.ofNullable(labelRepository.save(label));
    }

    public Optional<Label> findLabelById(int labelId) {
        return Optional.ofNullable(labelRepository.findById(labelId).orElseThrow(() -> new IllegalArgumentException("라벨이 없습니다.")));
    }

    public LabelListDto findAllLabels() {
        List<Label> labelList = labelRepository.findAllLabels();


        return new LabelListDto(labelList, labelList.size());
    }

    /**
     * Label Id로 삭제합니다.
     * 예외처리 추가 필요
     * @param labelId
     */
    public Optional<Label> deleteLabelById(int labelId) {
        Label label = labelRepository.findById(labelId).orElseThrow(()->new IllegalArgumentException("없는 라벨입니다."));
        label.setDeleted(true);

        return Optional.ofNullable(labelRepository.save(label));
    }

    public Optional<Label> updateLabel(Label label) {
        return Optional.ofNullable(labelRepository.save(label));
    }
}
