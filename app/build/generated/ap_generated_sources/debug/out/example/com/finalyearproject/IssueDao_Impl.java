package example.com.finalyearproject;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class IssueDao_Impl implements IssueDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfIssueModel;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfIssueModel;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfIssueModel;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public IssueDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfIssueModel = new EntityInsertionAdapter<IssueModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `issue_table`(`id`,`issue_name`,`issueDesc`,`issueSymptoms`,`issueState`,`issueResults`,`issueDate`,`image`,`extraImage`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IssueModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getIssueName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIssueName());
        }
        if (value.getIssueDesc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIssueDesc());
        }
        if (value.getIssueSymptoms() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIssueSymptoms());
        }
        if (value.getIssueState() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIssueState());
        }
        if (value.getIssueResults() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIssueResults());
        }
        if (value.getIssueDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getIssueDate());
        }
        if (value.getImage() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindBlob(8, value.getImage());
        }
        if (value.getExtraImage() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindBlob(9, value.getExtraImage());
        }
      }
    };
    this.__deletionAdapterOfIssueModel = new EntityDeletionOrUpdateAdapter<IssueModel>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `issue_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IssueModel value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfIssueModel = new EntityDeletionOrUpdateAdapter<IssueModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `issue_table` SET `id` = ?,`issue_name` = ?,`issueDesc` = ?,`issueSymptoms` = ?,`issueState` = ?,`issueResults` = ?,`issueDate` = ?,`image` = ?,`extraImage` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, IssueModel value) {
        stmt.bindLong(1, value.getId());
        if (value.getIssueName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getIssueName());
        }
        if (value.getIssueDesc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getIssueDesc());
        }
        if (value.getIssueSymptoms() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIssueSymptoms());
        }
        if (value.getIssueState() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getIssueState());
        }
        if (value.getIssueResults() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIssueResults());
        }
        if (value.getIssueDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getIssueDate());
        }
        if (value.getImage() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindBlob(8, value.getImage());
        }
        if (value.getExtraImage() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindBlob(9, value.getExtraImage());
        }
        stmt.bindLong(10, value.getId());
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM issue_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(IssueModel issueModel) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfIssueModel.insert(issueModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(IssueModel issueModel) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfIssueModel.handle(issueModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(IssueModel issueModel) {
    __db.beginTransaction();
    try {
      __updateAdapterOfIssueModel.handle(issueModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public IssueModel getIssue(int id) {
    final String _sql = "SELECT * FROM issue_table where id=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfIssueName = _cursor.getColumnIndexOrThrow("issue_name");
      final int _cursorIndexOfIssueDesc = _cursor.getColumnIndexOrThrow("issueDesc");
      final int _cursorIndexOfIssueSymptoms = _cursor.getColumnIndexOrThrow("issueSymptoms");
      final int _cursorIndexOfIssueState = _cursor.getColumnIndexOrThrow("issueState");
      final int _cursorIndexOfIssueResults = _cursor.getColumnIndexOrThrow("issueResults");
      final int _cursorIndexOfIssueDate = _cursor.getColumnIndexOrThrow("issueDate");
      final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
      final int _cursorIndexOfExtraImage = _cursor.getColumnIndexOrThrow("extraImage");
      final IssueModel _result;
      if(_cursor.moveToFirst()) {
        final String _tmpIssueName;
        _tmpIssueName = _cursor.getString(_cursorIndexOfIssueName);
        final String _tmpIssueDesc;
        _tmpIssueDesc = _cursor.getString(_cursorIndexOfIssueDesc);
        final String _tmpIssueSymptoms;
        _tmpIssueSymptoms = _cursor.getString(_cursorIndexOfIssueSymptoms);
        _result = new IssueModel(_tmpIssueName,_tmpIssueDesc,_tmpIssueSymptoms);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpIssueState;
        _tmpIssueState = _cursor.getString(_cursorIndexOfIssueState);
        _result.setIssueState(_tmpIssueState);
        final String _tmpIssueResults;
        _tmpIssueResults = _cursor.getString(_cursorIndexOfIssueResults);
        _result.setIssueResults(_tmpIssueResults);
        final String _tmpIssueDate;
        _tmpIssueDate = _cursor.getString(_cursorIndexOfIssueDate);
        _result.setIssueDate(_tmpIssueDate);
        final byte[] _tmpImage;
        _tmpImage = _cursor.getBlob(_cursorIndexOfImage);
        _result.setImage(_tmpImage);
        final byte[] _tmpExtraImage;
        _tmpExtraImage = _cursor.getBlob(_cursorIndexOfExtraImage);
        _result.setExtraImage(_tmpExtraImage);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<IssueModel>> getAllIssues() {
    final String _sql = "SELECT * from issue_table ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<IssueModel>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<IssueModel> compute() {
        if (_observer == null) {
          _observer = new Observer("issue_table") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfIssueName = _cursor.getColumnIndexOrThrow("issue_name");
          final int _cursorIndexOfIssueDesc = _cursor.getColumnIndexOrThrow("issueDesc");
          final int _cursorIndexOfIssueSymptoms = _cursor.getColumnIndexOrThrow("issueSymptoms");
          final int _cursorIndexOfIssueState = _cursor.getColumnIndexOrThrow("issueState");
          final int _cursorIndexOfIssueResults = _cursor.getColumnIndexOrThrow("issueResults");
          final int _cursorIndexOfIssueDate = _cursor.getColumnIndexOrThrow("issueDate");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfExtraImage = _cursor.getColumnIndexOrThrow("extraImage");
          final List<IssueModel> _result = new ArrayList<IssueModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final IssueModel _item;
            final String _tmpIssueName;
            _tmpIssueName = _cursor.getString(_cursorIndexOfIssueName);
            final String _tmpIssueDesc;
            _tmpIssueDesc = _cursor.getString(_cursorIndexOfIssueDesc);
            final String _tmpIssueSymptoms;
            _tmpIssueSymptoms = _cursor.getString(_cursorIndexOfIssueSymptoms);
            _item = new IssueModel(_tmpIssueName,_tmpIssueDesc,_tmpIssueSymptoms);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpIssueState;
            _tmpIssueState = _cursor.getString(_cursorIndexOfIssueState);
            _item.setIssueState(_tmpIssueState);
            final String _tmpIssueResults;
            _tmpIssueResults = _cursor.getString(_cursorIndexOfIssueResults);
            _item.setIssueResults(_tmpIssueResults);
            final String _tmpIssueDate;
            _tmpIssueDate = _cursor.getString(_cursorIndexOfIssueDate);
            _item.setIssueDate(_tmpIssueDate);
            final byte[] _tmpImage;
            _tmpImage = _cursor.getBlob(_cursorIndexOfImage);
            _item.setImage(_tmpImage);
            final byte[] _tmpExtraImage;
            _tmpExtraImage = _cursor.getBlob(_cursorIndexOfExtraImage);
            _item.setExtraImage(_tmpExtraImage);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
