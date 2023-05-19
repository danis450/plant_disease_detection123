package example.com.finalyearproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IssueDao {

    @Insert
    void insert(IssueModel issueModel);

    @Update
    void update(IssueModel issueModel);

    @Delete
    void delete(IssueModel issueModel);

    @Query("DELETE FROM issue_table")
    void deleteAll();

    @Query("SELECT * FROM issue_table where id=:id")
    IssueModel getIssue(int id);

    @Query("SELECT * from issue_table ORDER BY id ASC")
    LiveData<List<IssueModel>> getAllIssues();
}
