package np.com.paurakhsaud.week8lab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.ImageFormat;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private Button defaultButton,costumeButton,openCamButton;
    public static final int from_camera = 1; //This is media store constant,

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Dialog costumeDig = new Dialog(this);
        defaultButton = findViewById(R.id.buttonDefault);
        costumeButton = findViewById(R.id.buttonCustomDialog);
        openCamButton = findViewById(R.id.buttonopenCamera);
        ImageView fromCam = new ImageView(this);
        fromCam.findViewById(R.id.imageView3);



        //This onclick method for the defaultButton
        defaultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new AlertDialog.Builder(HomeActivity.this)
                        .setIcon(R.drawable.ic_baseline_warning_24)
                        .setTitle("Exit")
                        .setCancelable(false)
                        .setMessage("Are You sure to exit the app ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                             finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                            }
                        }).show();
            }
        });

        //This onclick method for the costumeButton

        costumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Dialog costumeDig = new Dialog(HomeActivity.this);
                costumeDig.setContentView(R.layout.costume_dialog);
                costumeDig.setCancelable(false);
                /* The default properties to dismiss of the dialog message after
                 touching outside of the dialog message is disabled */
                Button btnOkay = costumeDig.findViewById(R.id.btnOkay);
                costumeDig.show();

                //This will triggered after the button is clicked in the dialog message which id is "btnOkay"
                btnOkay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomeActivity.this, "Costume Dialog message is Tested Successfully", Toast.LENGTH_SHORT).show();
                        costumeDig.dismiss();
                    }
                });

            }
        });

        //This onclick method for the openCamButton

        openCamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //mediaStore present in android.provide package.
                startActivityForResult(i,from_camera);

            }


        });

    }
}