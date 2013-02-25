#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import ${package}.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private MongoTemplate template;

    public void insert(User user) {
        template.insert(user);
    }

    public List<User> findAll() {
        return template.findAll(User.class);
    }

    public User findById(String id) {
        return template.findById(id, User.class);
    }

}
