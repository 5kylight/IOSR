package com.wiet.math.core.dividers.service;

import com.wiet.math.core.dividers.communication.DividersServiceClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DividersProductService.class)
public class DividersProductServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DividersServiceClient dividersServiceClientMock;

    @Autowired
    DividersProductService service;

    @Test
    public void testNoAccessWithoutToken() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/10")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void testHappyPath() throws Exception {
        Mockito.when(dividersServiceClientMock.getDividers(Matchers.eq(10))).thenReturn(Arrays.asList(1,2,5,10));

        assertEquals(1L * 2L * 5L * 10L, service.getDividers(10).getBody().longValue());
        assertEquals("1 * 2 * 5 * 10 = 100", service.getDividersAsStringInfo(10).getBody());
    }

    @Test
    public void testBadRequest() throws Exception {
        assertEquals(HttpStatus.BAD_REQUEST, service.getDividers(21).getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST, service.getDividersAsStringInfo(21).getStatusCode());
    }

}
