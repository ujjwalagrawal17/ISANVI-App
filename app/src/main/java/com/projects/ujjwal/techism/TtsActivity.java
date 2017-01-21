package com.projects.ujjwal.techism;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.util.Locale;

public class TtsActivity extends AppCompatActivity {
	private TextToSpeech tts;
	private String message;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tts);
		Bundle bundle = getIntent().getExtras();
		message = bundle.getString("message");
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
			@Override
			public void onInit(int status) {
				if (status == TextToSpeech.SUCCESS) {
					int result = tts.setLanguage(Locale.US);
					if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
						Log.e("TTS", "This Language is not supported");
					}
					speak("Hello");

				} else {
					Log.e("TTS", "Initilization Failed!");
				}
			}
		});

	}

			private void speak(String text){
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
				tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
			}else{
				tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
			}
		}


	@Override
	protected void onDestroy() {
		if (tts != null) {
			tts.stop();
			tts.shutdown();
		}
		super.onDestroy();
	}
}
