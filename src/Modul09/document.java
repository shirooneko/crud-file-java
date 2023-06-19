package Modul09;

import java.time.LocalDateTime;

public class document {
    private String fileName;
    private int fileSize;
    private LocalDateTime createTime;

    //membuat constraktor overloading
    public document(String namaFile, int sizeFile, LocalDateTime waktu) {
        this.fileName = namaFile;
        this.fileSize = sizeFile;
        this.createTime = waktu;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    //memberi spacing untuk print nama document, size, waktu
    private String Spacing(int k){
        String space = "";
        for (int x = 0;x < k; x++){
            space += " ";
        }
        return space;
    }

    //method untuk mencetak nilai array + memberi jarak spacing antar array dari input
    public void printDoc() {
        String fillspace = "";
        fillspace += fileName;
        fillspace += Spacing(30-fileName.length());
        fillspace += Integer.toString(getFileSize()) + " KB";
        fillspace += Spacing(10 - Integer.toString(getFileSize()).length());
        System.out.print(fillspace);
    }
}
