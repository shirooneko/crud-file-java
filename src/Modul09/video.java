package Modul09;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class video extends document{
    private LocalTime durasi;
    private int imageDimension;

    public video(String fileName, int fileSize, LocalDateTime createTime, int imageDimension, String durasi) {
        super(fileName, fileSize, createTime);
        this.imageDimension = imageDimension;
        this.durasi = LocalTime.parse(durasi);
    }

    private String Spacing(int k){
        String space = " ";
        for(int x = 0;x<k;x++){
            space+= " ";
        }
        return space;
    }
    @Override
    public void printDoc() {
        super.printDoc();
        String fillspace = "";
        fillspace += imageDimension + "px";
        fillspace += Spacing(5 - Integer.toString(imageDimension).length());
        fillspace += Spacing(10);
        fillspace += getCreateTime().format(DateTimeFormatter.ofPattern("dd-MM-yy hh:mm"));
        System.out.println(fillspace);
    }
}
