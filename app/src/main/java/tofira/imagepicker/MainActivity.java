package tofira.imagepicker;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        (findViewById(R.id.startCameraBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new PickerBuilder(MainActivity.this, PickerBuilder.SELECT_FROM_CAMERA)
                        .setOnImageReceivedListener(new PickerBuilder.onImageReceivedListener() {
                            @Override
                            public void onImageReceived(Uri imageUri) {
                                Toast.makeText(MainActivity.this,"Got image - " + imageUri,Toast.LENGTH_LONG).show();
                                imageView.setImageURI(imageUri);
                            }
                        })
                        .setImageName("testImage")
                        .setImageFolderName("testFolder")
                        .withTimeStamp(false)
                        .setCropScreenColor(Color.CYAN)
                        .start();
            }
        });

        (findViewById(R.id.startGalleryBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PickerBuilder(MainActivity.this, PickerBuilder.SELECT_FROM_GALLERY)
                        .setOnImageReceivedListener(new PickerBuilder.onImageReceivedListener() {
                            @Override
                            public void onImageReceived(Uri imageUri) {
                                imageView.setImageURI(imageUri);
                                Toast.makeText(MainActivity.this,"Got image - " + imageUri,Toast.LENGTH_LONG).show();
                            }
                        })
                        .setImageName("test")
                        .setImageFolderName("testFolder")
                        .setCropScreenColor(Color.CYAN)
                        .start();
            }
        });


    }
}
