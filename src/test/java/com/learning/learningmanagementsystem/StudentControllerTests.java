// package com.learning.learningmanagementsystem;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.learning.learningmanagementsystem.models.Student;

// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @WebMvcTest
// @AutoConfigureMockMvc
// @SpringBootTest
// public class StudentControllerTests {
//     @Autowired
//     private MockMvc mockMvc;

//     @Test
//     public void testGetAllStudents() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("/students")
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.students").isArray())
//                 .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.students.length()").value(2))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.students[0].registrationId").value("12345"))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.students[0].name").value("John Doe"))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.students[1].registrationId").value("12346"))
//                 .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.students[1].name").value("John Doe"))
//                 .andDo(print()); // Print response for debugging
//     }



//     @Test
//     public void testGetStudentById() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("students/{id}", 1).contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(status().isOk());
//     }

//         @Test
//     public void testGetAllStudents2() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("/students")
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andDo(print()); // Print response for debugging
//     }

//     @Test
//     public void testGetAllExams() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("/exams")
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk())
//                 .andDo(print()); // Print response for debugging
//     }

//     @Test
//     public void testGetExamById() throws Exception {
//         mockMvc.perform(MockMvcRequestBuilders.get("/exams/{id}", 1)
//                 .contentType(MediaType.APPLICATION_JSON))
//                 .andExpect(MockMvcResultMatchers.status().isOk());
//     }


 
// }
