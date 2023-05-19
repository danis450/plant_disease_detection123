package example.com.finalyearproject.camera_tf;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import java.io.ByteArrayOutputStream;

import example.com.finalyearproject.CameraFragmentInterface;
import example.com.finalyearproject.R;

public class CameraActivity extends Activity implements CameraFragmentInterface {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_camera);


    if (null == savedInstanceState) {
      getFragmentManager()
          .beginTransaction()
          .replace(R.id.container, Camera2BasicFragment.newInstance())
          .commit();
    }
  }

    @Override
    public void onScanDone(String scanResult, Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        Intent intent=new Intent();
        intent.putExtra("MESSAGE",scanResult);
        intent.putExtra("image",byteArray);
        setResult(2,intent);
        finish();
    }
}
