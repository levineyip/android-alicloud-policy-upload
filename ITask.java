package com.nbc.smartcar.phonecenter.upload;

public interface ITask {

    void run();

    interface OnUploadCallback {
        void uploadSingleImageCompleted(int position, String imageUrl);
    }
}
