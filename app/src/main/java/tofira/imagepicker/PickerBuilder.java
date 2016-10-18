package tofira.imagepicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;

import java.io.Serializable;

/**
 * Created by Mickael on 13/10/2016.
 */

public class PickerBuilder {
    public static final int SELECT_FROM_GALLERY = 0;
    public static final int SELECT_FROM_CAMERA = 1;
    private int pickerType = SELECT_FROM_GALLERY;
    private Activity activity;
    private onPermissionRefusedListener permissionRefusedListener;
    protected onImageReceivedListener imageReceivedListener;
    private PickerManager pickerManager;
    public PickerBuilder(Activity activity, int type)
    {
        this.activity = activity;
        pickerManager = (type == PickerBuilder.SELECT_FROM_GALLERY) ? new ImagePickerManager(activity) : new CameraPickerManager(activity);

    }

    public interface onPermissionRefusedListener {
        void onPermissionRefused();
    }

    public interface onImageReceivedListener
    {
        void onImageReceived(Uri imageUri);
    }


    public void start()
    {
        Intent intent = new Intent(activity, TempActivity.class);
        activity.startActivity(intent);

        GlobalHolder.getInstance().setPickerManager(pickerManager);

    }

    public PickerBuilder setOnImageReceivedListener(PickerBuilder.onImageReceivedListener listener) {
        pickerManager.setOnImageReceivedListener(listener);
        return this;
    }

    public PickerBuilder setOnPermissionRefusedListener(PickerBuilder.onPermissionRefusedListener listener) {
        pickerManager.setOnPermissionRefusedListener(listener);
        return this;
    }

    public PickerBuilder setCropScreenColor(int cropScreenColor) {
        pickerManager.setCropActivityColor(cropScreenColor);
        return this;
    }

    public PickerBuilder setImageName(String imageName) {
        pickerManager.setImageName(imageName);
        return this;
    }

    public PickerBuilder withTimeStamp(boolean withTimeStamp) {
        pickerManager.withTimeStamp(withTimeStamp);
        return this;
    }

    public PickerBuilder setImageFolderName(String folderName) {
        pickerManager.setImageFolderName(folderName);
        return this;
    }

}
