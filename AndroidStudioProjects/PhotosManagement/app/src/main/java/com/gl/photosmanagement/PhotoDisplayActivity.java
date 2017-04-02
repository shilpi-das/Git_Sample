package com.gl.photosmanagement;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhotoDisplayActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton mIbtnCamera, mIbtnGallery;
    private ImageView mIvPhotoDisplay;
    private Uri mSelectedImageUri;
    private String mSelectedPath;
    private File imageFile;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_display);
        initialize();
    }

    private void initialize() {
        mIbtnCamera = (ImageButton) findViewById(R.id.btnCamera);
        mIbtnGallery = (ImageButton) findViewById(R.id.btnGallery);
        mIvPhotoDisplay = (ImageView) findViewById(R.id.imageViewPhotoDisplay);
        mIbtnGallery.setOnClickListener(this);
        mIbtnCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCamera:
                getImageFromCamera();
                break;
            case R.id.btnGallery:
                getImageFromGallery();
                break;
        }
    }

    private void getImageFromCamera() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String pictureName = getPictureName();
         imageFile = new File(pictureDirectory, pictureName);
         imageUri = Uri.fromFile(imageFile);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraIntent, 1);
    }

    private String getPictureName() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_hhmmss");
        String timeStamp = dateFormat.format(new Date());
        return "PhotosManagement" + timeStamp + ".jpg";
    }

    private void getImageFromGallery() {

        Intent intent = new Intent();

        intent.setType("image/*");

        intent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(intent, "Select file to upload "), 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*else {
                Log.d("selectedPath1 : ", "Came here its null !");
                Toast.makeText(getApplicationContext(), "failed to get Image!", Toast.LENGTH_LONG).show();
            }*/
        // }


        if (requestCode == 1 && resultCode == RESULT_OK) {
            mIvPhotoDisplay.setImageURI(imageUri);

        }

        if (requestCode == 2)

        {
            if (resultCode == RESULT_OK) {
                if (data.getData() != null) {
                    mSelectedImageUri = data.getData();
                }

                mSelectedPath = getPath(mSelectedImageUri);
                mIvPhotoDisplay.setImageURI(mSelectedImageUri);
                Log.i("selectedPath1 : ", mSelectedPath);

            }
        }
    }

    public String getPath(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};

        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);

        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        cursor.moveToFirst();

        return cursor.getString(column_index);

    }
}
