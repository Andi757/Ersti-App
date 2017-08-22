package de.hsos.ersti_app;


import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView mScannerView;
    public OpenTasksActivity openTasksActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }


    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();
        //mScannerView.stopCameraPreview();
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }


    @Override
    public void handleResult(Result result){
        //Do anything with the Result here --------------------------------------------------->
        switch (result.getText()){
            case "mensa":
                //openTasksActivity = new OpenTasksActivity();
                //openTasksActivity.setChecked("mensa");
                Toast.makeText(this, "Result: mensa", Toast.LENGTH_SHORT).show();
                break;
            case "bibliothek":
                break;
            case "sl_gebäude":
                break;
            case "si_gebäude":
                break;
            case "validierungsautomat":
                break;
            case "fitnessstudio":
                break;
            case "bushaltestelle":
                break;
            case "aa-gebäude":
                break;
            case "aula":
                break;
            case "studiensekritariat":
                break;
        }

        Log.v("handleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Ergebnis");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
