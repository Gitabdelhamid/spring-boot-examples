package com.springboot.rest.example.student;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springboot.rest.example.SpringBoot2RestServiceApplication;
import com.springboot.rest.example.student.StudentResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBoot2RestServiceApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentResourceTest {

	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}
	/**
	 * {@link StudentResource#retrieveAllStudents()}
	 * @throws Exception
	 */
	@Test
	public void retrieveAllStudentsTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/students").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(2))).andDo(print());
	}
	/**
	 * {@link StudentResource#retrieveStudent(long)}
	 * @throws Exception
	 */
	@Test
	public void retrieveStudentTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/students/10001").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.passportNumber").exists())
		.andExpect(jsonPath("$.id").value(10001))
		.andExpect(jsonPath("$.name").value("Abdelhamid"))
		.andExpect(jsonPath("$.passportNumber").value("E1234567"))
		.andDo(print());
	}	

}