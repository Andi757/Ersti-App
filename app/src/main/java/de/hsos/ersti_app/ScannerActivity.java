package de.hsos.ersti_app;


import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckedTextView;
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
                ((MyVariable)this.getApplication()).setStudentVariable("mensa");
                break;
            case "bibliothek":
                ((MyVariable)this.getApplication()).setStudentVariable("bibliothek");
                break;
            case "sl-gebäude":
                ((MyVariable)this.getApplication()).setStudentVariable("sl-gebäude");
                break;
            case "si-gebäude":
                ((MyVariable)this.getApplication()).setStudentVariable("si-gebäude");
                break;
            case "validierungsautomat":
                ((MyVariable)this.getApplication()).setStudentVariable("validierungsautmoat");
                break;
            case "fitnessstudio":
                ((MyVariable)this.getApplication()).setStudentVariable("fitnessstudio");
                break;
            case "bushaltestelle":
                ((MyVariable)this.getApplication()).setStudentVariable("bushaltestelle");
                break;
            case "aa-gebäude":
                ((MyVariable)this.getApplication()).setStudentVariable("aa-gebäude");
                break;
            case "aula":
                ((MyVariable)this.getApplication()).setStudentVariable("aula");
                break;
            case "studiensekretariat":
                ((MyVariable)this.getApplication()).setStudentVariable("studiensekreteriat");
                break;
            default:
                Toast.makeText(this, "Kein Gültiger QR-Code.", Toast.LENGTH_SHORT).show();
        }

        Log.v("handleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Ergebnis");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        finish();
    }
}
