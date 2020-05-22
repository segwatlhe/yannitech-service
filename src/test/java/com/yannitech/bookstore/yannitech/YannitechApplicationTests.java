package com.yannitech.bookstore.yannitech;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yannitech.bookstore.yannitech.controller.BookController;
import com.yannitech.bookstore.yannitech.model.Book;
import com.yannitech.bookstore.yannitech.model.Books;
import com.yannitech.bookstore.yannitech.repository.BookCustomRepository;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class YannitechApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private BookController bookConytroller;
	
	@Autowired
	private MockMvc mockMvc;
	
    @InjectMocks
    private BookController bookController;
    
	@Test
	void contextLoads() {
	}
	
	@MockBean
	private BookCustomRepository bookCustomRepository;
	
	
	@Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/yannitech/api/hello/",
				String.class)).contains("Hello, World");
	}
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(bookConytroller).isNotNull();
	}
	

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/api/hello/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, World")));
	}	
	
	
//	@Sql({ "classpath:schema.sql", "classpath:data.sql" })
//	@Test
//	public void testAllEmployees() 
//	{
//		assertTrue(
//				this.restTemplate
//					.getForObject("http://localhost:" + port + "/yannitech/api/books", Books.class)
//					.getEmployeeList().size() == 3);
//	}
	
    
}
