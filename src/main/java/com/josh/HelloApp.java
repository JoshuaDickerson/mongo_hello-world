package com.josh;

import com.josh.config.SpringMongoConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class HelloApp {
    public static void main(String[] args) {
        // For XML
        //ApplicationContext ctx = new GenericXmlApplicationContext("SpringConfig.xml");

        // For Annotation
        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

        User user = new User("mkyong", "password123");

        // save
        mongoOperation.save(user);

        // List, it should be empty now.
        List<User> listUser = mongoOperation.findAll(User.class);
        System.out.println("4. Number of user = " + listUser.size());

    }
}
