package com.akarpov.forum.service;

import com.akarpov.forum.entity.Topic;
import com.akarpov.forum.repository.TopicRepository;
import com.akarpov.forum.service.impl.TopicServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {TopicServiceImpl.class})
class TopicServiceTests {

    @Autowired
    private TopicService topicService;

    @MockBean
    private TopicRepository topicRepository;

    @Test
    public void findAllShouldReturnTopicList() {
        List<Topic> expected = Arrays.asList(new Topic(1L, "A"), new Topic(2L, "B"));
        when(topicRepository.findAll()).thenReturn(expected);
        List<Topic> actual = topicService.findAll();
        assertEquals(expected, actual);
    }

    @Test
    public void findAllShouldInvokeTopicRepository_findAll() {
        topicService.findAll();
        verify(topicRepository).findAll();
    }

}
