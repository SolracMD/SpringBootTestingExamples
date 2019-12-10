package com.example.demo;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloWorldTest {

  @Autowired private MockMvc mockMvc;

  @MockBean
  private UserSevice userSevice;

  @Test
  public void UTHelloWorld() throws Exception{
   mockMvc.perform(get("/")).andExpect(status().isOk()).andDo(print());
  }

  /**
   * Unit Test Example with mocking the service.
   * @throws Exception
   */
  @Test
  public void getUsersHellowWorld() throws Exception{
    User user = new User();
    user.setName("asdasd");
    user.setSurname("hola");
    List<User> userList = new ArrayList<>();
    userList.add(user);
    given(userSevice.getAllUsers()).willReturn(userList);

    mockMvc.perform(get("/user")).andExpect(status().isOk()).andDo(print());
  }
}
