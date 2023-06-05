package com.issuetracker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.issuetracker.domain.Issue;
import com.issuetracker.repository.IssueRepository;

@SpringBootTest
public class BulkInsertHelper {
    @Autowired
    private IssueRepository issueRepository;

    @Test
    public void test() {
        insert();
    }

    public void insert() {


        for (int k = 0; k < 1000; k++) {
            List<Issue> issues = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                issues.add(
                        new Issue(null, (long)2, 2, getRandomString(), true, LocalDateTime.now(),
                                null, null));
            }
            issueRepository.saveAll(issues);
            System.out.println(k);

        }
    }

    private static String getRandomString() {
        String source = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(source.length());
            sb.append(source.charAt(index));
        }
        return sb.toString();
    }

    private static String getRandomString(int length) {
        String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(source.length());
            sb.append(source.charAt(index));
        }
        return sb.toString();
    }
}
