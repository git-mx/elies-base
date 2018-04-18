package com.elies.base.controller;

/**
 * @author 牟雪
 * @since 2018/4/4
 */

import com.elies.base.domain.UserInsert;
import com.elies.base.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
public class UserControllerTest extends BaseControllerTestCase {
    @Autowired
    private UserService userService;

    @Test
    public void insertUser() throws Exception {
        UserInsert userInsert = new UserInsert();
        userInsert.setLoginName("elies");
        userInsert.setLoginPassword("1");
        userInsert.setUserAccount("2222");
        userInsert.setUserAddress("DFSDFSDFS");
        userInsert.setUserAge(18);
        userInsert.setUserName("DFSDFDS");
        userInsert.setUserSex(1);
        for(int i=0; i<50; i++){
            mockMvc.perform(get("/user/insertUser")
                    .param("userInsert", ""))
                    .andExpect(status().isOk());
        }
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(post("/user/deleteUser")
                .param("userId", "100"))
                .andExpect(status().isOk());
        System.out.println("...........................................success...........................................");
    }
}
