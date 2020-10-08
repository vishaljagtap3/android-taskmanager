package in.bitcode.taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import in.bitcode.taskmanager.model.Task;

public class NewTaskActivity extends AppCompatActivity {

    private ImageView mImgTask;
    private EditText mEdtTaskTitle, mEdtTaskDueDateTime;
    private Button mBtnSave;

    private int mImageId = R.mipmap.ic_launcher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task_activity);

        init();
    }

    private void init() {
        mImgTask = findViewById(R.id.imgTask);
        mEdtTaskTitle = findViewById(R.id.edtTaskTitle);
        mEdtTaskDueDateTime = findViewById(R.id.edtTaskDueDateTime);
        mBtnSave = findViewById(R.id.btnSave);

        mBtnSave.setOnClickListener(new OnBtnSaveClickListener());
    }

    private class OnBtnSaveClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Task newTask = new Task(
                    101,
                    mEdtTaskTitle.getText().toString(),
                    mImageId,
                    mEdtTaskDueDateTime.getText().toString(),
                    2
            );

            Intent resultIntent = new Intent();
            resultIntent.putExtra("new_task", newTask);
            setResult(1, resultIntent);

            finish();
        }
    }

}
