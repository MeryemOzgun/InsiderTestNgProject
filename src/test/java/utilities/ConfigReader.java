package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {  //config okuyucu


    /*
                .properties uzantılı dosyadaki dayaları  test classımızda okuyabilmemiz için return type 'ı  String olan bir  parametreli static method oluştururuz ve bu method içinde
                 Properties classından bir obje oluştururuz. Sonra FileInputStream ile bu dosyayı akışa alır Properties class'ından oluşturmuş olduğumuz obje ye
                 load() metodu ile yükleriz.
                 Son olarak oluşturmuş olduğumuz obje ile getProperty() methodunu kullanarak method içine parametre olarak girilen key in değerini bize
                 return eder

     */


    public static String getProperty(String key) {   // key göndereceğiz valuesi ni return edecek
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("configuration.properties");    //dosyayı akışa alıyoruz sonra o dosyayı
            properties.load(fis);                 //   properties.load diyerek o dosyayı properties adlı objeye yüklüyoruz
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);  //bize girdiğimiz key in valuesini yani değerini return edeiyor

    }




}