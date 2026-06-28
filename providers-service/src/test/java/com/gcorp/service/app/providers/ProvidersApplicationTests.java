package com.gcorp.service.app.providers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WithMockUser(
        username = "authusername",
        roles = {"CUSTOMER"}
)
@AutoConfigureMockMvc
@SpringBootTest
class ProvidersApplicationTests
{
    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads()
    {
    }

    @Test
    void shouldReturnAirportById() throws Exception
    {
        Integer idAirport = 10;
        this.mockMvc.perform(
                        get("http://localhost:4747/api/v1/airports/" + idAirport))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idAirport));
    }

    @Test
    @WithAnonymousUser
    void shouldDenyAccessToProtectedResource() throws Exception
    {
        this.mockMvc.perform(
                        get("http://localhost:4747/api/v1/airports/10"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void shouldReturnIterableAirports() throws Exception
    {
        this.mockMvc.perform(
                get("http://localhost:4747/api/v1/airports")
                        .param("name", "Jorge")
        ).andExpect(status().isOk());
    }
}
