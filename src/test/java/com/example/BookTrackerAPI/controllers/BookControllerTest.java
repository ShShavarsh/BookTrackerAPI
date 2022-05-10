package com.example.BookTrackerAPI.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.BookTrackerAPI.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

	@Autowired
	private BookController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void getBookByIdAPI() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/book/{id}", 1).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}

	// AC1: When I enter the title, author, year of publication, and length of the
	// book into the UI and hit submit, my book will saved to the list.
	@Test
	public void createBookAPI() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/book")
				.content(asJsonString(Book.builder().author("Shavarsh").length(199).yearOfPublication(1999)
						.title("The last chance").build()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isCreated()).andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}

	// AC2: When I click “View All Books” the application will display a list of all
	// the books in my list.
	@Test
	public void getBookListAPI() throws Exception {
		this.mockMvc.perform(get("/api/v1/book")).andDo(print()).andExpect(status().isOk());
	}

	// AC3: When I click the checkbox next to a book, and then the press the “Delete
	// Book” button, the application will remove the book from my list.
	@Test
	public void deleteBookByIdAPI() throws Exception {
		// setup
		Book book = controller.bookService.insert(Book.builder().author("Shavarsh").length(199).yearOfPublication(1999)
				.title("The last chance").id(1111L).build());
		
		// execute
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/book/{id}", book.getId())).andExpect(status().isNoContent());
	}

	// AC4: When I click the checkbox next to a book, and then press the “Update
	// Book” button, the application will allow me to update any of the information
	// about the book
	@Test
	public void updateBookAPI() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/book/{id}", 1)
				.content(asJsonString(Book.builder().author("Shavarsh").length(199).yearOfPublication(1999)
						.title("The last chance").build()))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").value("The last chance"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.yearOfPublication").value(1999))
				.andExpect(MockMvcResultMatchers.jsonPath("$.author").value("Shavarsh"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.length").value(199));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
