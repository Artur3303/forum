package com.akarpov.forum.controller;

import com.akarpov.forum.entity.Topic;
import com.akarpov.forum.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TopicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TopicController.class);

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping({"/", "/topics"})
    public String getTopicsPage(Model model) {
        LOGGER.info("HTTP method GET (topics page) has been called");
        List<Topic> topicList = topicService.findAll();
        model.addAttribute("topics", topicList);
        return "topics";
    }

}
