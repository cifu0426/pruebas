package com.udea.busquedaA;

import com.udea.busquedaA.resolver.FlightResolver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc // Añade esta anotación
class BusquedaAApplicationTests {

	@Autowired
	FlightResolver flightResolver;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindFlightById() throws Exception {
		String query = "{ findFlightById(id: \"1\") { idFlight origin destination } }";

		mockMvc.perform(post("/graphql")
						.contentType("application/json")
						.content("{\"query\":\"" + query.replace("\"", "\\\"") + "\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.findFlightById.idFlight").value("1"));
	}

	@Test
	public void testFindFlightsByOrigin() throws Exception {
		String query = "{ findFlightsByOrigin(origin: \"Cali\") { idFlight origin destination } }";

		mockMvc.perform(post("/graphql")
						.contentType("application/json")
						.content("{\"query\":\"" + query.replace("\"", "\\\"") + "\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.findFlightsByOrigin").isArray());
	}

	@Test
	public void testFindFlightsByDestination() throws Exception {
		String query = "{ findFlightsByDestination(destination: \"Cartagena\") { idFlight origin destination } }";

		mockMvc.perform(post("/graphql")
						.contentType("application/json")
						.content("{\"query\":\"" + query.replace("\"", "\\\"") + "\"}"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.findFlightsByDestination").isArray());
	}

}
