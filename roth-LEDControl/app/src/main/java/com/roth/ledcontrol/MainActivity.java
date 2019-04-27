package com.roth.ledcontrol;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.SeekBar.*;
import eu.chainfire.libsuperuser.*;
import android.view.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final SeekBar sbBrightness = (SeekBar)findViewById(R.id.sbBrightness);
		final RadioButton rbNone = (RadioButton)findViewById(R.id.rbtrignone);
		final RadioButton rbAlwaysOn = (RadioButton)findViewById(R.id.rbtrigalwayson);
		final RadioButton rbBlinkCharge = (RadioButton)findViewById(R.id.rbtrigblinkcharge);
		final RadioButton rbCharge = (RadioButton)findViewById(R.id.rbtrigcharge);
		final RadioButton rbChargeOrFull = (RadioButton)findViewById(R.id.rbtrigchargeorfull);
		final RadioButton rbFull = (RadioButton)findViewById(R.id.rbtrigfull);
		final RadioButton rbmmc0 = (RadioButton)findViewById(R.id.rbtrigmmc0);
		final RadioButton rbmmc1 = (RadioButton)findViewById(R.id.rbtrigmmc1);
		final RadioButton rbmmc2 = (RadioButton)findViewById(R.id.rbtrigmmc2);
		final RadioButton rbrfkill0 = (RadioButton)findViewById(R.id.rbtrigrfkill0);
		final RadioButton rbrfkill1 = (RadioButton)findViewById(R.id.rbtrigrfkill1);
		final RadioButton rbrfkill2 = (RadioButton)findViewById(R.id.rbtrigrfkill2);
		final RadioButton rbUsb = (RadioButton)findViewById(R.id.rbtrigusb);
		final RadioButton rbWall = (RadioButton)findViewById(R.id.rbtrigwall);
		ActionBar ab = getActionBar();
		
		sbBrightness.setMax(255);
		ab.setElevation(0);
		
		sbBrightness.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
			{
				@Override
				public void onProgressChanged(SeekBar p1, int p2, boolean p3)
				{
					//Toast.makeText(MainActivity.this, Integer.toString(sbBrightness.getProgress()), Toast.LENGTH_SHORT).show();
					Shell.SU.run("echo " + Integer.toString(sbBrightness.getProgress()) + " > /sys/class/leds/roth-led/brightness");
				}

				@Override
				public void onStartTrackingTouch(SeekBar p1)
				{
					// TODO: Implement this method
				}

				@Override
				public void onStopTrackingTouch(SeekBar p1)
				{
					//Toast.makeText(MainActivity.this, Integer.toString(sbBrightness.getProgress()), Toast.LENGTH_SHORT).show();
				}
			}
		);
		
		rbNone.setOnClickListener(new RadioButton.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Shell.SU.run("echo none > /sys/class/leds/roth-led/trigger");
			}
		});
		rbAlwaysOn.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo default-on > /sys/class/leds/roth-led/trigger");
				}
			});
		rbBlinkCharge.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo battery-charging-blink-full-solid > /sys/class/leds/roth-led/trigger");
				}
			});
		rbCharge.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo battery-charging > /sys/class/leds/roth-led/trigger");
				}
			});
		rbFull.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo battery-full > /sys/class/leds/roth-led/trigger");
				}
			});
		rbChargeOrFull.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo battery-charging-or-full > /sys/class/leds/roth-led/trigger");
				}
			});
		rbmmc0.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo mmc0 > /sys/class/leds/roth-led/trigger");
				}
			});
		rbmmc1.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo mmc1 > /sys/class/leds/roth-led/trigger");
				}
			});
		rbmmc2.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo mmc2 > /sys/class/leds/roth-led/trigger");
				}
			});
		rbrfkill0.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo rfkill0 > /sys/class/leds/roth-led/trigger");
				}
			});
		rbrfkill1.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo rfkill1 > /sys/class/leds/roth-led/trigger");
				}
			});
		rbrfkill2.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo rfkill2 > /sys/class/leds/roth-led/trigger");
				}
			});
		rbUsb.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo bq2419x-usb-online > /sys/class/leds/roth-led/trigger");
				}
			});
		rbWall.setOnClickListener(new RadioButton.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					Shell.SU.run("echo bq2419x-ac-online > /sys/class/leds/roth-led/trigger");
				}
			});
    }
}
