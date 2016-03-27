package com.magus.backend.texttospeech;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

public class TTSClient {

	TextToSpeech service;
	
	public TTSClient() {
		service = new TextToSpeech();
		service.setUsernameAndPassword(TTSConstants.USERNAME, TTSConstants.PASSWORD);
	}

	public void getVoice() {
		List<Voice> voices = service.getVoices();
		for (Voice voice : voices) {
			System.out.println(voice);
		}
	}

	public InputStream convertToSpeech(String text) {
		return service.synthesize(text, Voice.EN_ALLISON, TTSConstants.AUDIO_FORMAT_WAV);
	}

	public static void main(String[] args) throws IOException {
		TTSClient s = new TTSClient();
		// s.getVoice();
		InputStream is = null;
		try {
			is = s.convertToSpeech("Hello world");
//			System.out.println(is.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(is);
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
}
