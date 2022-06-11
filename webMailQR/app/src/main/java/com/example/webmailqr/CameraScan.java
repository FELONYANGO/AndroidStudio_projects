package com.example.webmailqr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;


public class CameraScan<uri> extends AppCompatActivity {
    private static int CAMERA_PERMISSION_CODE = 100;
    private static int VIDEO_RECORD_PERMISSION = 101;
    private uri videoPath;
    private uri cameraSpace;
    private static int REQUEST_CAMERA_PERMISSION = 1;
    Button btakepicture, btrecording;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;


    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_scan);
        getSupportActionBar().hide();


        btakepicture = (Button) findViewById(R.id.image_capture_button);
        btakepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //WAT THE CAMERA SHOULD ACTUALLY DO
                takepicture();
            }
        });
        if (isCameraPresent()) {
            Log.i("VIDEO_RECORD_TAG", "Camera detected");
            getCameraPermission();
        } else {
            Log.i("VIDEO_RECORD_TAG", "no camera detected");
        }


        btrecording = (Button) findViewById(R.id.video_capture_button);
        btrecording.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recordVideo();
            }
        });
        if (isCameraPresent()) {
            Log.i("VIDEO_RECORD_TAG", "Camera detected");
            getCameraPermission();
        } else {
            Log.i("VIDEO_RECORD_TAG", "no camera detected");
        }
    }

    private void takepicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA_PERMISSION);
    }

    private boolean isCameraPresent() {
        if (getPackageManager().hasSystemFeature(getPackageManager().FEATURE_CAMERA_ANY)) {
            return true;
        } else {
            return false;
        }
    }

    private void getCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        }

    }

    private void recordVideo() {
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent, VIDEO_RECORD_PERMISSION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == VIDEO_RECORD_PERMISSION) {
            if (resultCode == RESULT_OK) {
                videoPath = (uri) data.getData();
                Log.i("VIDEO_RECORD_TEG", "Video is recorded and available at" + videoPath);
            } else if (resultCode == RESULT_CANCELED) {
                Log.i("VIDEO_RECORD_TEG", "Recording video is cancelled");

            } else {
                Log.i("VIDEO_RECORD_TEG", "Recording has got some error");

            }
        }
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (resultCode == RESULT_OK) {
                cameraSpace = (uri) data.getData();
                Log.i("CAMERA_RECORD_TAG", "Video is recorded and is available at" + cameraSpace);

            } else if (resultCode == RESULT_CANCELED) {
                Log.i("VIDEO_RECORD_TEG", "Recording video is cancelled");

            } else {
                Log.i("VIDEO_RECORD_TEG", "Recording has got some error");

            }
        }

    }
}