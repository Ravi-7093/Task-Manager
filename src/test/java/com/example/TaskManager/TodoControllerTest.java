package com.example.TaskManager;

import com.example.TaskManager.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static java.lang.reflect.Array.get;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@ActiveProfiles("test")
@WebMvcTest

public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    @Test


    @WithMockUser(username = "admin", roles = {"USER", "ADMIN"}) // This mocks a logged-in user
    public void testAddTodoSuccess() throws Exception {




        // Disable CSRF protection
        //request.setAttribute(MockHttpServletRequest.C, true);
        // Create a valid Todo object for the request body
        String requestBody = "{"
                + "\"description\": \"Test Todo\","
                + "\"targetDate\": \"2023-09-30\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/add-todo")
                        .contentType(MediaType.APPLICATION_JSON).with(anonymous())
                        .content(requestBody))
                       .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Todo added successfully"));

    }
}

