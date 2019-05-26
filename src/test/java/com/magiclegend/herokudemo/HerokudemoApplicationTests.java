package com.magiclegend.herokudemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HerokudemoApplicationTests {
    private static final Logger LOGGER = Logger.getLogger(HerokudemoApplicationTests.class.getName());

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testTestApi() throws Exception {
        MvcResult result = mockMvc.perform(get("/test?input=JohnDoe"))
                .andExpect(status().isOk()).andReturn();

        assertEquals("Hi JohnDoe", result.getResponse().getContentAsString());
    }
}
