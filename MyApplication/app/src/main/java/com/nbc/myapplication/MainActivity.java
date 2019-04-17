package com.nbc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nbc.myapplication.upload.ITask;
import com.nbc.myapplication.upload.TaskQueue;
import com.nbc.myapplication.upload.UploadTask;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ITask.OnUploadCallback {

    private TaskQueue taskQueue = new TaskQueue(1); // 文件上传队列
    private List<String> picImagePaths = new ArrayList<>();// 存储待上传照片本地地址

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 将上传文件的sd路径添加到picImagePaths
        // picImagePaths.add("filepath");

        findViewById(R.id.btnUpload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskQueue.start();
                for (int index = 0; index < picImagePaths.size(); index++) {
                    taskQueue.add(new UploadTask(index, picImagePaths.get(index), MainActivity.this));
                }
            }
        });
    }

    @Override
    public void uploadSingleImageCompleted(int position, String imageUrl) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (taskQueue != null) {
            taskQueue.stop();
            taskQueue = null;
        }
    }
}
