# ImagePickerWithCrop
A library designated for selecting an image via gallery or camera, with cropping abilities, in an easy way.

![Alt Text](https://github.com/Tofira/ImagePickerWithCrop/blob/master/sampleGif.gif)

Simple sample usage - 

```java
  new PickerBuilder(MainActivity.this, PickerBuilder.SELECT_FROM_CAMERA)
          .setOnImageReceivedListener(new PickerBuilder.onImageReceivedListener() {
              @Override
              public void onImageReceived(Uri imageUri) {
                  Toast.makeText(MainActivity.this,"Got image - " + imageUri,Toast.LENGTH_LONG).show();
                  imageView.setImageURI(imageUri);
              }
          })
          .start();
```

A slighly more customized example - 
```java
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
```

##How to install
Import the following in your app's `Gradle` file - 
```compile 'com.yalantis:ucrop:2.2.0'```

Copy the following files to your project - 
```java
CameraPickerManager.java
GlobalHolder.java
ImagePickerManager.java
PickerBuilder.java
PickerManager.java
TempActivity.java
```

Next, add the following two Activities to your Manifest file - 
```xml
  <activity
      android:name=".TempActivity"
      android:screenOrientation="portrait"
      android:theme="@style/Theme.AppCompat.Translucent"/>
  <activity
      android:name="com.yalantis.ucrop.UCropActivity"
      android:screenOrientation="portrait"
      android:theme="@style/Theme.AppCompat.Light.NoActionBar"/>
```

Finally, add the following to your `styles.xml` file - 
```xml
    <style name="Theme.AppCompat.Translucent" parent="Theme.AppCompat.NoActionBar">
        <item name="android:background">#33000000</item> <!-- Or any transparency or color you need -->
        <item name="android:windowNoTitle">true</item>
        <item name="android:windowBackground">@android:color/transparent</item>
        <item name="android:colorBackgroundCacheHint">@null</item>
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:windowAnimationStyle">@android:style/Animation</item>
    </style>
```
##How to use
* See the samples above.
* The picker will get the image from the Camera or the gallery based on the type attribute it receives. It can be one of the following - 
`PickerBuilder.SELECT_FROM_CAMERA` or `PickerBuilder.SELECT_FROM_GALLERY`.
* The image will be provided through the `onImageReceivedListener` listener.
* The default image location is `/DCIM/[APP_NAME]/[APP_NAME]_[TIMESTAMP].jpg`, and it can be customized.

##Customization
The library offers several customization options - 
* `setCropScreenColor(Color)` - default is the app's primary color.
* `setImageName(name)`  - default it the app's name.
* `setImageFolderName(name)`  - default it the app's name.
* `setOnPermissionRefusedListener(PickerBuilder.onPermissionRefusedListener)`

##Credits
The library uses the great cropping library <a href="https://github.com/Yalantis/uCrop">Ucrop</a>.
