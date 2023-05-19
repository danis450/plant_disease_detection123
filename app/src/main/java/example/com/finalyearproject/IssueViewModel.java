package example.com.finalyearproject;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class IssueViewModel extends AndroidViewModel {

    private IssueRepository mRepository;

    private LiveData<List<IssueModel>> mAllIssues;

    public IssueViewModel(Application application) {
        super(application);
        mRepository = new IssueRepository(application);
        mAllIssues = mRepository.getAllIssues();
    }

    LiveData<List<IssueModel>> getAllWords() {
        return mAllIssues;
    }

    public void insert(IssueModel issueModel) {
        mRepository.insert(issueModel);
    }

    public void delete(IssueModel issueModel) {
        mRepository.delete(issueModel);
    }

    public void update(IssueModel issueModel) {
        mRepository.update(issueModel);
    }
}
