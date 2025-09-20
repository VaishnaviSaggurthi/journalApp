package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//  MongoRepository --> extend the interface to use in current interface to use MongoDB standard CRUD operations functions/methods
//  This interface will run queries from the DB (Database)
// Here the JournalEntry Datatype is an entity which a collection should have and ObjectId datatype of id which is unique

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {


}
