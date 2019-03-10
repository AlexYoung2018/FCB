package com.example.work;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends BaseActivity {
    private DrawerLayout mDraweLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDraweLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        navView.setCheckedItem(R.id.version);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.version:
                        mDraweLayout.closeDrawers();
                        break;
                    case R.id.random:
                        Intent intent2 = new Intent(MainActivity.this,RandomActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.location:
                        Intent intent5 = new Intent("com.example.work.FORCE_OFFLINE");
                        sendBroadcast(intent5);
                        break;
                    case R.id.wiki:
                        Intent intent3 = new Intent(MainActivity.this,WebViewActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.exit:
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("注意");
                        dialog.setMessage("你确定退出应用吗?");
                        dialog.setCancelable(true);
                        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        dialog.show();
                        break;
                        default:
                }
                return true;
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDraweLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.upload:
                Toast.makeText(this, "You clicked Upload",Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.vibrate:
                Intent intent1 = new Intent(MainActivity.this,SensorActivity.class);
                startActivity(intent1);
                break;
            case R.id.setting:
                Toast.makeText(this, "You clicked Setting",Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.check:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("组员");
                dialog.setMessage("\n后端：徐杨阳  叶云帆  阮世晟\n文档：黄斌\n测试：刘江梅  彭常玉\n前端：徐杨阳\n答辩：徐杨阳");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.show();
                break;
                default:
        }
        return true;
    }

}
