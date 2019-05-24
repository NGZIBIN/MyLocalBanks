package c346.rp.edu.mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btndbs;
    Button btnOCBC;
    Button btnUOB;

    int mode = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btndbs = findViewById(R.id.dbs);
        btnOCBC = findViewById(R.id.OCBC);
        btnUOB = findViewById(R.id.UOB);

        registerForContextMenu(btndbs);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.dbs) {
            mode = 1;
        } else if (v.getId() == R.id.OCBC) {
            mode = 2;
        } else if (v.getId() == R.id.UOB) {
            mode = 3;
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (mode == 1) {
            if (id == R.id.Website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;

            } else if (id == R.id.Call) ;
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001 + 111111));
            startActivity(i);
            return true;
        } else if (mode == 2) {
            if (id == R.id.Website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);

                return true;

            } else if (id == R.id.Call) ;
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180036 + 33333));
            startActivity(i);
            return true;
        } else {
            if (id == R.id.Website) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;

            } else if (id == R.id.Call) ;
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002 + 222121));
            startActivity(i);
            return true;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle action bar item clicks here
        int id = item.getItemId();
        if (id == R.id.English) {
            btndbs.setText("DBS");
            btnUOB.setText("UOB");
            btnOCBC.setText("OCBC");
        } else if (id == R.id.Chinese) {
            btndbs.setText("星展银行");
            btnUOB.setText("华侨银行");
            btnOCBC.setText("大华银行");
        }

        return true;
    }
}