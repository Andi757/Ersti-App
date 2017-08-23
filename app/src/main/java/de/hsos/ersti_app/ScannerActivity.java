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
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void handleResult(Result result){
        switch (result.getText()){
            case "mensa":
                ((MyVariable)this.getApplication()).setStudentVariable("Mensa");
                break;
            case "bibliothek":
                ((MyVariable)this.getApplication()).setStudentVariable("Bibliothek");
                break;
            case "sl-gebäude":
                ((MyVariable)this.getApplication()).setStudentVariable("SL-Gebäude");
                break;
            case "si-gebäude":
                ((MyVariable)this.getApplication()).setStudentVariable("SI-Gebäude");
                break;
            case "validierungsautomat":
                ((MyVariable)this.getApplication()).setStudentVariable("Validierungsautomat");
                break;
            case "fitnessstudio":
                ((MyVariable)this.getApplication()).setStudentVariable("Fitnessstudio");
                break;
            case "bushaltestelle":
                ((MyVariable)this.getApplication()).setStudentVariable("Bushaltestelle");
                break;
            case "aa-gebäude":
                ((MyVariable)this.getApplication()).setStudentVariable("AA-Gebäude");
                break;
            case "aula":
                ((MyVariable)this.getApplication()).setStudentVariable("Aula");
                break;
            case "studierendensekretariat":
                ((MyVariable)this.getApplication()).setStudentVariable("Studierendensekretariat");
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
