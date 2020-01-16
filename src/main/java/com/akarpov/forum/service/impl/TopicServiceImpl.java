package com.akarpov.forum.service.impl;

import com.akarpov.forum.entity.Topic;
import com.akarpov.forum.repository.TopicRepository;
import com.akarpov.forum.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    private TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
}
