package net.engineeringdigest.journalApp.service;

// controller ---> service ---> repository

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;
    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry); // step 1
            user.getJournalEntries().add(saved);
            // user.setUserName(null); // This will cause an error! since we kept @NonNull annotation for userName
            userService.saveUser(user); // step 2
        }
        catch(Exception e){
            System.out.println(e);
            throw new RuntimeException("An Error occurred while saving the entry.",e);
        }
    }

    /*
      Without @Transactional: If Step 1 succeeds but Step 2 fails, you'd have an orphaned journal entry in the database.

      With @Transactional: If Step 2 fails, Spring automatically rolls back Step 1, keeping your database consistent.
      This is the desired behavior for a transactional method.
     */
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName){
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(id));
            if(removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        }catch(Exception e){
            System.out.println(e);
            throw new RuntimeException("An Error occurred while deleting the entry.", e);
        }
        return false;
    }
}
