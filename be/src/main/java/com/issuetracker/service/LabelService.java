package com.issuetracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.issuetracker.domain.Label;
import com.issuetracker.repository.LabelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LabelService {
    private final LabelRepository labelRepository;

    public Label createLabel(Label label) {
        return labelRepository.save(label);
    }

    public Label findLabelById(int labelId) {
        return labelRepository.findById(labelId).orElseThrow(() -> new IllegalArgumentException("라벨이 없습니다."));
    }

    public List<Label> findAllLabels() {
        return labelRepository.findAllLabels();
    }

    /**
     * Label Id로 삭제합니다.
     * 예외처리 추가 필요
     * @param labelId
     */
    public void deleteLabelById(int labelId) {
        labelRepository.deleteById(labelId);
    }

    public void updateLabel(Label label) {
        labelRepository.save(label);
    }
}
