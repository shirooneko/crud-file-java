package Modul09;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class pdf extends document{
    public pdf(String fileName, int fileSize, LocalDateTime createTime) {
        super(fileName, fileSize, createTime);
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
        fillspace += Spacing(18);
        fillspace += getCreateTime().format(DateTimeFormatter.ofPattern("dd-MM-yy hh:mm"));
        System.out.println(fillspace);
    }
}
