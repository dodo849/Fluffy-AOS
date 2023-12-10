package com.example.fluffy_aos.ai;

// 필요한 라이브러리 추가
// implementation 'org.tensorflow:tensorflow-lite:버전'
// implementation 'org.tensorflow:tensorflow-lite-gpu:버전' // GPU 지원이 필요한 경우

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import org.tensorflow.lite.Interpreter;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/// 추론하는법: https://www.tensorflow.org/lite/guide/inference?hl=ko
public class TfliteSample{
    private static final String MODEL_PATH = "your_model.tflite"; // 모델 파일 경로
    private static final int IMAGE_SIZE = 224; // 모델의 입력 크기에 맞게 조정
    private static final int NUM_CLASSES = 3;

    private Interpreter tflite;
    private ByteBuffer imgData;

//    public void TfliteSample() {
//
//        // 모델 초기화
//        try {
//            tflite = new Interpreter(loadModelFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 이미지 데이터를 담을 ByteBuffer 초기화
//        imgData = ByteBuffer.allocateDirect(IMAGE_SIZE * IMAGE_SIZE * 3 * 4);
//        imgData.order(ByteOrder.nativeOrder());
//
//        // 이미지를 분류하고 결과를 출력하는 메서드 호출
//        classifyImage("your_image.jpg"); // 분류하려는 이미지 파일 경로
//    }

    ///
    private byte[] getImageBytes(String imagePath) throws IOException {
        InputStream inputStream = new FileInputStream(imagePath);
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        return byteBuffer.toByteArray();
    }

    private void classifyImage(String imagePath) {
        // 이미지를 모델의 입력 포맷에 맞게 변환
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        bitmap = Bitmap.createScaledBitmap(bitmap, IMAGE_SIZE, IMAGE_SIZE, true);
        imgData.rewind();
        for (int i = 0; i < IMAGE_SIZE; ++i) {
            for (int j = 0; j < IMAGE_SIZE; ++j) {
                int pixelValue = bitmap.getPixel(j, i);
                imgData.putFloat((pixelValue & 0xFF) / 255.0f);
                imgData.putFloat(((pixelValue >> 8) & 0xFF) / 255.0f);
                imgData.putFloat(((pixelValue >> 16) & 0xFF) / 255.0f);
            }
        }

        // 모델의 입력 데이터 설정 및 추론 실행
        float[][] outputScores = new float[1][NUM_CLASSES];
        tflite.run(imgData, outputScores);

        // 분류 결과 출력
        displayResult(outputScores);
    }

    private void displayResult(float[][] outputScores) {
        // 분류 결과를 TextView 등을 사용하여 화면에 표시
        // 결과에 따라 필요한 동작을 추가할 수 있습니다.
    }
}
