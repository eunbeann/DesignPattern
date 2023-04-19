package ch02.A2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


// 어댑터 (위임을 이용함)
public class FileProperties implements FileIO {
    Properties property = new Properties(); //어댑티, java.util 패키지 (JDK에서 제공됨)

    @Override
    public void readFromFile(String filename) throws IOException {
        property.load(new FileReader(filename)); //어댑티에 로드 호출
    }

    @Override
    public void writeToFile(String filename) throws IOException { //라이투파일 호출되면
        property.store(new FileWriter(filename), "written by FileProperties"); //파일라이터호출, 어댑티에게 위임
    }

    @Override
    public void setValue(String key, String value) {
        property.setProperty(key, value);
    } //키밸류 그대로 전송해서 위임, 메서드 호출되면 어댑티에게 위임한다.

    @Override
    public String getValue(String key) {
        return property.getProperty(key, "");
    }
}
