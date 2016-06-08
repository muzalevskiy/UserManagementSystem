package com.vmuzalevskyi.app.repository;

import com.vmuzalevskyi.SpringBootDemoApplication;
import com.vmuzalevskyi.app.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by root on 5/29/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(
        classes= SpringBootDemoApplication.class)
@WebIntegrationTest
@ActiveProfiles("test")
public class UserRepositoryTest extends AbstractDbunitTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    @Rollback(false)
    @DbunitDataSets(before = "initialDataSet.xml", after = "initialDataSet.xml")
    @DirtiesContext
    public void testGetAllUsers() {
        User user1 = new User();
        user1.setId(1);
        user1.setUsername("user");
        user1.setAddress("address");
        user1.setEmail("email@mail");
        User user2 = new User();
        user2.setId(2);
        user2.setUsername("user2");
        user2.setAddress("address2");
        user2.setEmail("email2@mail");
        List<User> users = userRepository.findAll();
        assertThat(users.size(), equalTo(2));
        assertThat(user1.getId(), equalTo(users.get(0).getId()));
        assertThat(user1.getUsername(), equalTo(users.get(0).getUsername()));
        assertThat(user1.getAddress(), equalTo(users.get(0).getAddress()));
        assertThat(user1.getEmail(), equalTo(users.get(0).getEmail()));
        assertThat(user2.getId(), equalTo(users.get(1).getId()));
        assertThat(user2.getUsername(), equalTo(users.get(1).getUsername()));
        assertThat(user2.getAddress(), equalTo(users.get(1).getAddress()));
        assertThat(user2.getEmail(), equalTo(users.get(1).getEmail()));
    }

    @Test
    @Rollback(false)
    @DbunitDataSets(before = "initialDataSet.xml", after = "initialDataSet.xml")
    @DirtiesContext
    public void testGetUserById() {
        User user = new User();
        user.setId(1);
        user.setUsername("user");
        user.setAddress("address");
        user.setEmail("email@mail");
        User loadedUser = userRepository.getOne(1L);
        assertThat(user.getId(), equalTo(loadedUser.getId()));
        assertThat(user.getUsername(), equalTo(loadedUser.getUsername()));
        assertThat(user.getAddress(), equalTo(loadedUser.getAddress()));
        assertThat(user.getEmail(), equalTo(loadedUser.getEmail()));
    }

    @Test
    @Rollback(false)
    @DbunitDataSets(before = "initialDataSet.xml", after = "initialDataSet.xml")
    @DirtiesContext
    public void testGetUserByName() {
        User user = new User();
        user.setId(1);
        user.setUsername("user");
        user.setAddress("address");
        user.setEmail("email@mail");
        User loadedUser = userRepository.findUserByUsername("user");
        assertThat(user.getId(), equalTo(loadedUser.getId()));
        assertThat(user.getUsername(), equalTo(loadedUser.getUsername()));
        assertThat(user.getAddress(), equalTo(loadedUser.getAddress()));
        assertThat(user.getEmail(), equalTo(loadedUser.getEmail()));
    }

    @Test
    @Rollback(false)
    @DbunitDataSets(before = "initialDataSet.xml", after = "addNewUserDataSet.xml")
    @DirtiesContext
    public void testAddNewUser() {
        User user = new User();
        user.setId(3);
        user.setUsername("user3");
        user.setAddress("address3");
        user.setEmail("email3@mail");
        userRepository.save(user);
    }

    @Test
    @Rollback(false)
    @DbunitDataSets(before = "initialDataSet.xml", after = "updateUserDataSet.xml")
    @DirtiesContext
    public void testUpdateUser() {
        User user = userRepository.getOne(2L);
        user.setUsername("user3");
        user.setAddress("address3");
        user.setEmail("email3@mail");
        userRepository.save(user);
    }

    @Test
    @Rollback(false)
    @DbunitDataSets(before = "initialDataSet.xml", after = "deleteUserDataSet.xml")
    @DirtiesContext
    public void testDeleteUser() {
        userRepository.delete(2L);
    }

    @Test
    @Rollback(false)
    @DbunitDataSets(before = "initialDataSet.xml", after = "deleteAllUsersDataSet.xml")
    @DirtiesContext
    public void testDeleteAllUser() {
        userRepository.deleteAll();
    }
}
