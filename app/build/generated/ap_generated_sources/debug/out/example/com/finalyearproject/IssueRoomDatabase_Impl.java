package example.com.finalyearproject;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class IssueRoomDatabase_Impl extends IssueRoomDatabase {
  private volatile IssueDao _issueDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `issue_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `issue_name` TEXT NOT NULL, `issueDesc` TEXT, `issueSymptoms` TEXT, `issueState` TEXT, `issueResults` TEXT, `issueDate` TEXT, `image` BLOB, `extraImage` BLOB)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"df3a0f7c9c1e63616a6b5aaeec8dfc04\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `issue_table`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsIssueTable = new HashMap<String, TableInfo.Column>(9);
        _columnsIssueTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsIssueTable.put("issue_name", new TableInfo.Column("issue_name", "TEXT", true, 0));
        _columnsIssueTable.put("issueDesc", new TableInfo.Column("issueDesc", "TEXT", false, 0));
        _columnsIssueTable.put("issueSymptoms", new TableInfo.Column("issueSymptoms", "TEXT", false, 0));
        _columnsIssueTable.put("issueState", new TableInfo.Column("issueState", "TEXT", false, 0));
        _columnsIssueTable.put("issueResults", new TableInfo.Column("issueResults", "TEXT", false, 0));
        _columnsIssueTable.put("issueDate", new TableInfo.Column("issueDate", "TEXT", false, 0));
        _columnsIssueTable.put("image", new TableInfo.Column("image", "BLOB", false, 0));
        _columnsIssueTable.put("extraImage", new TableInfo.Column("extraImage", "BLOB", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysIssueTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesIssueTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoIssueTable = new TableInfo("issue_table", _columnsIssueTable, _foreignKeysIssueTable, _indicesIssueTable);
        final TableInfo _existingIssueTable = TableInfo.read(_db, "issue_table");
        if (! _infoIssueTable.equals(_existingIssueTable)) {
          throw new IllegalStateException("Migration didn't properly handle issue_table(example.com.finalyearproject.IssueModel).\n"
                  + " Expected:\n" + _infoIssueTable + "\n"
                  + " Found:\n" + _existingIssueTable);
        }
      }
    }, "df3a0f7c9c1e63616a6b5aaeec8dfc04", "d383b86bce786e9d2eb3fba8f53b7f57");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "issue_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `issue_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public IssueDao issueDao() {
    if (_issueDao != null) {
      return _issueDao;
    } else {
      synchronized(this) {
        if(_issueDao == null) {
          _issueDao = new IssueDao_Impl(this);
        }
        return _issueDao;
      }
    }
  }
}
