package ch02.A2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileIO f = new FileProperties(); //어댑터 생성

//        어댑터를 통해서 일 시키기
        try {
//            프로젝트 폴더 바로 아래에서 부터 찾음 : 그래서 DP 열면 안 읽혀
            f.readFromFile("file.txt");
//            위 위치에 어떤 것이든지 키:밸류로 넣을 수 있음
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");

            f.writeToFile("newfile.txt"); // 파일 쓰기
            System.out.println("newfile.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
