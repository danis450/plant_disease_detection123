package example.com.finalyearproject;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {IssueModel.class}, version = 1)
public abstract class IssueRoomDatabase extends RoomDatabase {

    public abstract IssueDao issueDao();

    private static volatile IssueRoomDatabase INSTANCE;

    static IssueRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (IssueRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            IssueRoomDatabase.class, "issue_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
