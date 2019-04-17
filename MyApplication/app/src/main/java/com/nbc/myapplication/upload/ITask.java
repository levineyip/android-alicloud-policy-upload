package com.nbc.myapplication.upload;

public interface ITask {

    void run();

    interface OnUploadCallback {
        void uploadSingleImageCompleted(int position, String imageUrl);
    }
}
