package in.bitcode.taskmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.bitcode.taskmanager.R;
import in.bitcode.taskmanager.model.Task;

public class TaskAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Task> mListTasks;

    public TaskAdapter(Context context, ArrayList<Task> listTasks) {
        mContext = context;
        mListTasks = listTasks;
    }

    @Override
    public int getCount() {
        if( mListTasks != null ) {
            return mListTasks.size();
        }

        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ImageView imgTask;
        TextView txtTaskTitle, txtTaskDueDateTime;
        View view;

        if(convertView == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.task, null);
        }
        else {
            view = convertView;
        }

        imgTask = view.findViewById(R.id.imgTask);
        txtTaskTitle = view.findViewById(R.id.txtTaskTitle);
        txtTaskDueDateTime = view.findViewById(R.id.txtTaskDueDateTime);

        Task task = mListTasks.get(position);
        imgTask.setImageResource(task.getImageId());
        txtTaskTitle.setText(task.getTitle());
        txtTaskDueDateTime.setText(task.getDueDateTime());

        return view;
    }
}
