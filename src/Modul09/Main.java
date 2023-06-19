package Modul09;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        //inputan disimpan di dalam array list
        ArrayList<document> fileDocument = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("        Sistem Pengelolaan Konten");
        System.out.println("=========================================");
        System.out.println("create ==> Membuat File Baru");
        System.out.println("list   ==> Menampilkan semua file");
        System.out.println("list <condition>   ==> filter dokumen");
        System.out.println("Ketik X untuk keluar");
        System.out.println("-----------------------------------------");

        do {
            String inpDoc = scanner.nextLine();
            String[] arrDoc = inpDoc.split(" ");
            if (arrDoc[0].equals("create")) { //kondisi dijalankan dimana jika user mengetikan create
                if (arrDoc[1].split("[.]")[1].equals("pdf")){
                    fileDocument.add(new pdf(arrDoc[1],Integer.valueOf(arrDoc[2]),LocalDateTime.now()));
                    System.out.println(arrDoc[1] + " Berhasil dibuat!");
                } else if (arrDoc[1].split("[.]")[1].equals("docx")) {
                    fileDocument.add(new word(arrDoc[1], Integer.valueOf(arrDoc[2]),LocalDateTime.now()));
                    System.out.println(arrDoc[1] + " Berhasil dibuat!");
                } else if (arrDoc[1].split("[.]")[1].equals("doc")) {
                    fileDocument.add(new word(arrDoc[1], Integer.valueOf(arrDoc[2]),LocalDateTime.now()));
                    System.out.println(arrDoc[1] + " Berhasil dibuat!");
                } else if (arrDoc[1].split("[.]")[1].equals("jpg")) {
                    fileDocument.add(new image(arrDoc[1], Integer.valueOf(arrDoc[2]),LocalDateTime.now(),Integer.valueOf(arrDoc[3])));
                    System.out.println(arrDoc[1] + " Berhasil dibuat!");
                } else if (arrDoc[1].split("[.]")[1].equals("png")) {
                    fileDocument.add(new image(arrDoc[1], Integer.valueOf(arrDoc[2]),LocalDateTime.now(),Integer.valueOf(arrDoc[3])));
                    System.out.println(arrDoc[1] + " Berhasil dibuat!");
                } else if (arrDoc[1].split("[.]")[1].equals("jpeg")) {
                    fileDocument.add(new image(arrDoc[1], Integer.valueOf(arrDoc[2]),LocalDateTime.now(),Integer.valueOf(arrDoc[3])));
                    System.out.println(arrDoc[1] + " Berhasil dibuat!");
                } else if (arrDoc[1].split("[.]")[1].equals("mp4")) {
                    fileDocument.add(new video(arrDoc[1], Integer.valueOf(arrDoc[2]), LocalDateTime.now(), Integer.valueOf(arrDoc[3]), arrDoc[4]));
                    System.out.println(arrDoc[1] + " Berhasil dibuat!");
                } else if (arrDoc[1].split("[.]")[1].equals("mov")) {
                    fileDocument.add(new video(arrDoc[1], Integer.valueOf(arrDoc[2]), LocalDateTime.now(), Integer.valueOf(arrDoc[3]), arrDoc[4]));
                    System.out.println(arrDoc[1] + " Berhasil dibuat!");
                } else {
                    System.out.println("File Gagal Dibuat!! Periksa pengetikan Format");
                    System.out.println("Format Tersedia doc,docx,pdf,mov,mp4,png,jpg,jpeg");
                }
            }
            else if (arrDoc[0].equals("list")) {
                if (arrDoc.length > 1) {
                    if (arrDoc[1].equals("filename")) {
                        int hasil = 0;
                        for (int i = 0; i < fileDocument.size(); i++) {
                            if (fileDocument.get(i).getFileName().contains((arrDoc[2]))){
                                hasil ++;
                            }
                        }
                        System.out.println(hasil + " dokument ditemukan!");
                        for (int i = 0; i < fileDocument.size(); i++) {
                            if (fileDocument.get(i).getFileName().contains((arrDoc[2]))) {
                                fileDocument.get(i).printDoc();
                            }
                        }
                    } else if (arrDoc[1].equals("filesize")) {
                        int hasil = 0;
                        if (arrDoc[2].equals("<")) {
                            for (int i = 0; i < fileDocument.size(); i++) {
                                if (fileDocument.get(i).getFileSize() < Integer.valueOf(arrDoc[3])) {
                                    hasil ++;
                                }
                            }
                        }else if (arrDoc[2].equals(">")) {
                            for (int i = 0; i < fileDocument.size(); i++) {
                                if (fileDocument.get(i).getFileSize() > Integer.valueOf(arrDoc[3])) {
                                    hasil ++;
                                }
                            }
                        } else if (arrDoc[2].equals("<=")) {
                            for (int i = 0; i < fileDocument.size(); i++) {
                                if (fileDocument.get(i).getFileSize() <= Integer.valueOf(arrDoc[3])) {
                                    hasil ++;
                                }
                            }
                        } else if (arrDoc[2].equals(">=")) {
                            for (int i = 0; i < fileDocument.size(); i++) {
                                if (fileDocument.get(i).getFileSize() >= Integer.valueOf(arrDoc[3])) {
                                    hasil ++;
                                }
                            }
                        }
                        System.out.println(hasil + " dokument ditemukan!");
                        if (arrDoc[2].equals("<")) {
                            for (int i = 0; i < fileDocument.size(); i++) {
                                if (fileDocument.get(i).getFileSize() < Integer.valueOf(arrDoc[3])) {
                                    fileDocument.get(i).printDoc();
                                }
                            }
                        }else if (arrDoc[2].equals(">")) {
                            for (int i = 0; i < fileDocument.size(); i++) {
                                if (fileDocument.get(i).getFileSize() > Integer.valueOf(arrDoc[3])) {
                                    fileDocument.get(i).printDoc();
                                }
                            }
                        } else if (arrDoc[2].equals("<=")) {
                            for (int i = 0; i < fileDocument.size(); i++) {
                                if (fileDocument.get(i).getFileSize() <= Integer.valueOf(arrDoc[3])) {
                                    fileDocument.get(i).printDoc();
                                }
                            }
                        }else if (arrDoc[2].equals(">=")) {
                            for (int i = 0; i < fileDocument.size(); i++) {
                                if (fileDocument.get(i).getFileSize() >= Integer.valueOf(arrDoc[3])) {
                                    fileDocument.get(i).printDoc();
                                }
                            }
                        }
                    }
                } else {
                    int hasil = 0;
                    for (int i = 0; i < fileDocument.size(); i++) {
                        fileDocument.get(i).printDoc();
                        hasil ++;
                    }
                    System.out.println("\nHasil Pencarian : " + hasil + " dokument ditemukan!");
                }
            } else if (arrDoc[0].equals("X")) {
                System.out.println("Exit!");
                System.out.println("Have Nice Day...");
                break;
            }
        }while (true);
    }
}
