package Modul09;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class image extends document{
    private int imageDimension;

    public image(String namaFile, int sizeFile, LocalDateTime waktu , int imageDimension) {
        super(namaFile, sizeFile, waktu);
        this.imageDimension = imageDimension;
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
        super.printDoc(); //mengoverride method untuk menampilkan nama file dan size
        String fillspace = "";
        fillspace += imageDimension + "px";
        fillspace += Spacing(5-Integer.toString(imageDimension).length());
        fillspace += Spacing(10);
        fillspace += getCreateTime().format(DateTimeFormatter.ofPattern("dd-MM-yy hh:mm"));
        System.out.println(fillspace);
    }
}
