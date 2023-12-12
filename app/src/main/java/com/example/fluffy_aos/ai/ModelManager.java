package com.example.fluffy_aos.ai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ModelManager {
    public static void main(String[] args) {
        try {
            // 실행할 파이썬 스크립트 경로
            String pythonScriptPath = "./main";

            // 파이썬 스크립트 실행
            ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScriptPath);
            Process process = processBuilder.start();

            // 파이썬 스크립트의 출력을 읽기
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            process.getInputStream(),
                            "euc-kr")
            );
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("파이썬 출력: " + line);
            }

            // 프로세스 종료 대기
            int exitCode = process.waitFor();
            System.out.println("파이썬 프로세스 종료 코드: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
