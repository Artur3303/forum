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
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    private TopicService topicService;

    public MainController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping({"/", "/topics"})
    public String getTopicsPage(Model model) {
        LOGGER.info("HTTP method GET (topics page) has been called");
        List<Topic> topicList = topicService.findAll();
        LOGGER.debug("Returned topic list size: {}", topicList.size());
        model.addAttribute("topics", topicList);
        return "topics";
    }

}
