package com.akarpov.forum.controller;

import com.akarpov.forum.service.TopicService;
import com.sun.net.httpserver.HttpPrincipal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
@WithMockUser(username = "user", password = "user")
class MainControllerTests {

    private static final String TOPICS_PAGE_URI = "/topics";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController mainController;

    @MockBean
    private TopicService topicService;

    @Test
    public void contextLoads() {
        assertThat(mainController).isNotNull();
    }

    @Test
    public void getTopicsPageShouldReturnHtmlContent() throws Exception {
        String expected = MediaType.TEXT_HTML_VALUE + ";charset=UTF-8";
        when(topicService.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get(TOPICS_PAGE_URI).principal(new HttpPrincipal("user", "user")))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(expected))
                .andExpect(content().string(not(blankOrNullString())));
    }

    @Test
    public void getTopicsPageShouldInvokeTopicService_findAll() throws Exception {
        mockMvc.perform(get(TOPICS_PAGE_URI).principal(new HttpPrincipal("user", "user")))
                .andDo(print());
        verify(topicService).findAll();
    }

}
