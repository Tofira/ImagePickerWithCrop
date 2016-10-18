package tofira.imagepicker;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import static com.yalantis.ucrop.UCrop.REQUEST_CROP;

public class TempActivity extends AppCompatActivity {

    PickerManager pickerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        this.pickerManager = GlobalHolder.getInstance().getPickerManager();
        this.pickerManager.setActivity(TempActivity.this);
        this.pickerManager.pickPhotoWithPermission();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != MainActivity.RESULT_OK) {
            finish();
            return;
        }
        switch (requestCode) {
            case PickerManager.REQUEST_CODE_SELECT_IMAGE:
                if (data != null) {
                    final Uri uri = data.getData();
                    pickerManager.setUri(uri);
                    pickerManager.startCropActivity();
                }
                else finish();
                break;
            case REQUEST_CROP:
                if (data != null) {
                    pickerManager.handleCropResult(data);
                } else finish();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == PickerManager.REQUEST_CODE_IMAGE_PERMISSION)
                pickerManager.handlePermissionResult(grantResults);
        else
            finish();

    }

}
