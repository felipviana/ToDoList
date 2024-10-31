package com.felps.ToDoList;

import com.felps.ToDoList.entity.ToDo;
import com.felps.ToDoList.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Autowired
	private ToDoRepository toDoRepository;

	@BeforeEach
	void setup(){toDoRepository.deleteAll();}

	@Test
	void testCreateToDoSuccess() {
		var ToDo = new ToDo("todo 1", "desc todo 1", false, 1);

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(ToDo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(ToDo.getName())
				.jsonPath("$[0].description").isEqualTo(ToDo.getDescription())
				.jsonPath("$[0].done").isEqualTo(ToDo.isDone())
				.jsonPath("$[0].priority").isEqualTo(ToDo.getPriority());
	}

	@Test
	void testCreateToDoFailure(){
		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(
						new ToDo("","",false,0)
				).exchange()
				.expectStatus().isBadRequest();
	}
}
