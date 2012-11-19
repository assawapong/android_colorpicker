package com.example.backgroundchange;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class BackgroundChange extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_change);
        
        TextView t_red=(TextView)findViewById(R.id.textView1); 
        TextView t_green=(TextView)findViewById(R.id.textView2);
        TextView t_blue=(TextView)findViewById(R.id.textView3);
        SeekBar sb_red=(SeekBar)findViewById(R.id.seekBar1);
        SeekBar sb_green=(SeekBar)findViewById(R.id.seekBar2);
        SeekBar sb_blue=(SeekBar)findViewById(R.id.seekBar3);
        Window w=getWindow();
        ColorFun color=new ColorFun(t_red,t_green,t_blue,w);
		
        sb_red.setOnSeekBarChangeListener(new GeoBar(t_red,color)); 
        sb_green.setOnSeekBarChangeListener(new GeoBar(t_green,color));
        sb_blue.setOnSeekBarChangeListener(new GeoBar(t_blue,color));
        
        //View v=(View)findViewById(R.id.background);
        //v.setBackgroundColor(0xFF0000);
        //getWindow().setBackgroundDrawable(new ColorDrawable(Color.rgb(20, 100, 50)));
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_background_change, menu);
        return true;
    }
    
    public static void colorChange(){
    	
    }
}

class ColorFun{
	TextView r;
	TextView g;
	TextView b;
	Window w;
	public ColorFun(TextView t_red, TextView t_green, TextView t_blue, Window w) {
		this.r=t_red;
		this.g=t_green;
		this.b=t_blue;
		this.w=w;
	}
	public void setVal(TextView t){		
		int comp=t.getId();
		if(comp==r.getId()){
			r.setText(t.getText());
			System.out.println("R value: "+r.getText());
		}else if(comp==g.getId()){
			g.setText(t.getText());
			System.out.println("G value: "+g.getText());
		}else if(comp==b.getId()){
			b.setText(t.getText());
			System.out.println("B value: "+b.getText());
		}
		setBackground();
	}
	public void setBackground(){
		w.setBackgroundDrawable
		(new ColorDrawable
				(Color.rgb
						(Integer.parseInt((String)r.getText()),
						Integer.parseInt((String)g.getText()),
						Integer.parseInt((String)b.getText()))));
	}
	
	
}

class GeoBar extends Activity implements OnSeekBarChangeListener{
	TextView t;
	ColorFun color;
	
	public GeoBar(TextView t, ColorFun color){
		this.t=t;
		this.color=color;
	}
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
			//System.out.println(progress);
			
			t.setText(Integer.toString(progress));
			color.setVal(t);
			
			
	}
			
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
	
}
