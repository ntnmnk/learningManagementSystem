package com.learning.learningmanagementsystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class SubjectControllerTests {
      @Autowired
    private MockMvc mockMvc;

//     @Test
//     public void testGetAllSubjects() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/subjects"))
//        // .andExpect(status().isOk())
//         .andExpect(jsonPath("$.page.size").value(20))  // Assert page size
//         .andExpect(jsonPath("$.page.totalElements").value(1))  // Assert total elements
//         .andExpect(jsonPath("$._embedded.subjects[0].subjectId").value("CS101"))
//         .andExpect(jsonPath("$._embedded.subjects[0].name").value("Computer Science"))
//         .andExpect(jsonPath("$._embedded.subjects[0]._links.self.href").value("http://localhost:8080/subjects/1"));
// }

    @Test
    public void testGetSubjectById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/subjects/{id}", 1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
      @Test
    public void givenUserId_whenGetUser_thenStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/subjects/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
