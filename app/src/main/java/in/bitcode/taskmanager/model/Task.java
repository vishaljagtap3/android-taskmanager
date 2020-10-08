package in.bitcode.taskmanager.model;

import java.io.Serializable;

public class Task implements Serializable {
    private int mId;
    private String mTitle;
    private int mImageId;
    private String mDueDateTime;
    private int mPriority;

    public Task(int id, String title, int imageId, String dueDateTime, int priority) {
        mId = id;
        mTitle = title;
        mImageId = imageId;
        mDueDateTime = dueDateTime;
        mPriority = priority;
    }

    public String getTitle(){
        return mTitle;
    }

    public int getImageId() {
        return mImageId;
    }

    public String getDueDateTime() {
        return mDueDateTime;
    }
}
