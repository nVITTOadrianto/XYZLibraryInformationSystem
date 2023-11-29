package PerpustakaanXYZ;

import java.util.ArrayList;

public class Buku {
    private String IDBuku;
    private String judul;
    private String Pengarang;
    private String nomorISBN;
    private boolean statusKetersediaan;

    public Buku(String IDBuku, String judul, String Pengarang, String nomorISBN, boolean statusKetersediaan) {
        this.IDBuku = IDBuku;
        this.judul = judul;
        this.Pengarang = Pengarang;
        this.nomorISBN = nomorISBN;
        this.statusKetersediaan = statusKetersediaan;
    }

    public String getIDBuku() {
        return IDBuku;
    }

    public void setIDBuku(String IDBuku) {
        this.IDBuku = IDBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public String getNomorISBN() {
        return nomorISBN;
    }

    public void setNomorISBN(String nomorISBN) {
        this.nomorISBN = nomorISBN;
    }

    public boolean isStatusKetersediaan() {
        return statusKetersediaan;
    }

    public void setStatusKetersediaan(boolean statusKetersediaan) {
        this.statusKetersediaan = statusKetersediaan;
    }
    
    public static void cariBukuByJudul(String judul) {
        System.out.println("\nHasil Pencarian Berdasarkan Judul: " + judul);
        for (Buku buku : Main.daftarBuku) {
            if (buku.judul.contains(judul)) {
                System.out.println(buku.getIDBuku() + " - " + buku.getJudul() + " - " + buku.getPengarang());
            }
        }
    }
    
    public static void cariBukuByPengarang(String Pengarang) {
        System.out.println("\nHasil Pencarian Berdasarkan Pengarang: " + Pengarang);
        for (Buku buku : Main.daftarBuku) {
            if (buku.Pengarang.contains(Pengarang)) {
                System.out.println(buku.getIDBuku() + " - " + buku.getJudul() + " - " + buku.getPengarang());
            }
        }
    }
    
    public static void cariBukuByISBN(String isbn) {
        System.out.println("\nHasil Pencarian Berdasarkan ISBN: " + isbn);
        for (Buku buku : Main.daftarBuku) {
            if (buku.nomorISBN.equals(isbn)) {
                System.out.println(buku.getIDBuku() + " - " + buku.getJudul() + " - " + buku.getPengarang() + " - " + buku.getNomorISBN());
            }
        }
    }
    
    public static Buku cariBukuByID(String id) {
        for (Buku buku : Main.daftarBuku) {
            if (buku.IDBuku.equals(id)) {
                return buku;
            }
        }
        return null;
    }
}
