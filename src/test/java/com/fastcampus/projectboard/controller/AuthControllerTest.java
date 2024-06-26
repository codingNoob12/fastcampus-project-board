package com.fastcampus.projectboard.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fastcampus.projectboard.config.TestSecurityConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@DisplayName("View 컨트롤러 - 인증")
@Import(TestSecurityConfig.class)
@WebMvcTest(Void.class)
public class AuthControllerTest {

    private final MockMvc mvc;

    @Autowired
    public AuthControllerTest(MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view] [GET] 로그인 페이지 - 정상 호출")
    @Test
    void givenNothing_whenRequestingLoginPage_thenReturnsLoginPage()
        throws Exception {
        // Given

        // When & Then
        mvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(
                content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
}
