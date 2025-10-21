package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.User;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.schema.JsonSchemaObject;

import java.util.List;

public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<User> getUserForSentimentAnalysis(){
        // Criteria based querying using MongoTemplate and Query object -- it is suitable for complex queries
        Query query = new Query();

        /*
        More Criteria Conditions
        query.addCriteria(Criteria.where("userName").is("vaishnavi")); -- fetches all the usernames with "vaishnavi"
        query.addCriteria(Criteria.where("email").exists(true));
        query.addCriteria(Criteria.where("email").ne(null).ne("")); -- use regular expression for email validations
        query.addCriteria(Criteria.where("age").gt(18)); -- greater than 18
        query.addCriteria(Criteria.where("age").lt(60)); -- less than 60
        query.addCriteria(Criteria.where("age").lte(60)); -- less than equal to 60
        query.addCriteria(Criteria.where("userName").in("vaishnavi", "john", "shyam"));
        query.addCriteria(Criteria.where("sentimentAnalysis").type(JsonSchemaObject.Type.BsonType.BOOLEAN));
         */

        query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$"));
        query.addCriteria(Criteria.where("sentimentAnalysis").is(true));

        List<User> users = mongoTemplate.find(query, User.class);
        return users;
    }
}
