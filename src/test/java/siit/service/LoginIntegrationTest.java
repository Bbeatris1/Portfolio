package siit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import siit.Application;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
class LoginIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getShouldDisplayLogin() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(view().name("login"));
    }

    @Test
    void postWithCorrectCredentialsShouldRedirectToCustomers() throws Exception {
        mockMvc.perform(post("/login")
                    .param("user", "abcd")
                    .param("password", "bcda"))
                .andExpect(view().name("redirect:/customers"));
    }

    @Test
    void postWithIncorrectCredentialsShouldDisplayError() throws Exception {
        mockMvc.perform(post("/login")
                    .param("user", "abcd")
                    .param("password", "qqrr"))
                .andExpect(view().name("login"))
                .andExpect(model().attribute("error", "Invalid user and/or password"));
    }

}
