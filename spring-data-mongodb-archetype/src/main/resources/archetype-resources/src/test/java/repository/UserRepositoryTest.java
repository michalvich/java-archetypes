#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import ${package}.domain.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void setUp() {
        mongoTemplate.dropCollection("user");
    }

    @After
    public void tearDown() {
        mongoTemplate.dropCollection("user");
    }

    @Test
    public void insert_and_find_user_based_on_id() {

        User user = new User();
        user.setName("Michal");
        user.setAge(32);
        userRepository.insert(user);

        User savedUser = userRepository.findById(user.getId());
        Assert.assertEquals(user.getName(), savedUser.getName());
        Assert.assertEquals(user.getAge(), savedUser.getAge());

    }

    @Test
    public void find_all_users() {

        User user = new User();
        user.setName("Michal");
        user.setAge(32);

        userRepository.insert(user);

        Assert.assertEquals(1, userRepository.findAll().size());

    }


}
