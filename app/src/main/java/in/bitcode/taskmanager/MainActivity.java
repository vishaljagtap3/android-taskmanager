package in.bitcode.taskmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import in.bitcode.taskmanager.adapters.TaskAdapter;
import in.bitcode.taskmanager.model.Task;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListViewTasks;
    private ArrayList<Task> mListTasks;
    private TaskAdapter mTaskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mListViewTasks = findViewById(R.id.listViewTasks);

        mListTasks = new ArrayList<Task>();
        mListTasks.add(
                new Task(
                        1,
                        "Pay Bills...",
                        R.mipmap.ic_launcher,
                        "10-Oct-2020 13:00",
                        2)
        );
        mListTasks.add(
                new Task(
                        2,
                        "Complete the assignments",
                        R.mipmap.ic_launcher,
                        "12-Oct-2020 13:00",
                        3)
        );
        mListTasks.add(
                new Task(
                        3,
                        "Call home..",
                        R.mipmap.ic_launcher,
                        "9-Oct-2020 13:00",
                        2)
        );

        mTaskAdapter = new TaskAdapter(this, mListTasks);
        mListViewTasks.setAdapter(mTaskAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.menuItemNewTask) {
            Intent intent = new Intent(this, NewTaskActivity.class);
            startActivityForResult(intent, 1);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(data != null) {
            Task newTask = (Task) data.getSerializableExtra("new_task");
            mListTasks.add(newTask);
            mTaskAdapter.notifyDataSetChanged();
        }
    }
}