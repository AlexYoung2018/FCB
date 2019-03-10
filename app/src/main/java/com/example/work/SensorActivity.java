package com.example.work;

import android.app.Activity;
import android.app.Service;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager; import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SensorActivity extends Activity implements SensorEventListener
{
    Button clearBtn;
    private SensorManager mSensorManager;
    private Vibrator vibrator;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        mSensorManager=
                (SensorManager)getSystemService(SENSOR_SERVICE);
        vibrator = (Vibrator)getApplication()
                .getSystemService(Service.VIBRATOR_SERVICE);
        clearBtn = (Button) findViewById(R.id.sensor_b);
        clearBtn.setOnClickListener(new mClick());
    }

    class mClick  implements OnClickListener
    {
        public void onClick(View v)
        {
            clearBtn.setText("设备开始振动");
            try{
                vibrator.vibrate(new long[]{100, 100, 100, 1000}, 0);
            }catch(Exception e){
                System.out.println("振动错误！！！！！！");
            }
        }
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL );
    }
    @Override
    protected void onStop()
    {
        super.onStop();
    }
    @Override
    protected void onPause()
    {
        super.onPause();
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {            }
    public void onSensorChanged(SensorEvent event)
    {
        int sensorType = event.sensor.getType();
        float[] values = event.values;
        if(sensorType == Sensor.TYPE_ACCELEROMETER )
        {
                 /* 由于一般正常情况下，任意轴数值最大在9.8－10之间，
71          * 当突然摇动手机的时候，瞬时加速度突然增大或减少。
72          * 所以，只需监听任一轴的加速度大于14的时候，改变需要的设置
73          */
            if((Math.abs(values[0])>14 || Math.abs(values[1])>14
                    || Math.abs(values[2])>14))
            {
                clearBtn.setText("已检测到设备摇动，停止振动");
                vibrator.cancel();
            }
        }
    }

}




