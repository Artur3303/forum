package com.akarpov.forum.controller;

import com.akarpov.forum.service.TopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest({TopicController.class})
@MockBeans({
        @MockBean(UserDetailsService.class)
})
class TopicControllerTests {

    private static final String TOPICS_PAGE_URI = "/topics";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    @Test
    @WithMockUser
    public void whenAuthenticated_getTopicsPageShouldReturnHtmlContent() throws Exception {
        String expected = MediaType.TEXT_HTML_VALUE + ";charset=UTF-8";
        when(topicService.findAll()).thenReturn(Collections.emptyList());
        mockMvc.perform(get(TOPICS_PAGE_URI))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(expected))
                .andExpect(content().string(not(blankOrNullString())));
    }

    @Test
    public void whenNotAuthenticated_getTopicsPageShouldRedirectToLogin() throws Exception {
        mockMvc.perform(get(TOPICS_PAGE_URI))
                .andDo(print())
                .andExpect(status().isFound())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @WithMockUser
    @Test
    public void whenAuthenticated_getTopicsPageShouldInvokeTopicService_findAll() throws Exception {
        mockMvc.perform(get(TOPICS_PAGE_URI))
                .andDo(print());
        verify(topicService).findAll();
    }

}
