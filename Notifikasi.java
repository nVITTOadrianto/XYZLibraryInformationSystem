package PerpustakaanXYZ;

import java.util.Scanner;

public class Notifikasi {
    private String notifikasi;

    public Notifikasi(String notifikasi) {
        this.notifikasi = notifikasi;
    }

    public String getNotifikasi() {
        return notifikasi;
    }

    public void setNotifikasi(String notifikasi) {
        this.notifikasi = notifikasi;
    }
    
    public static void addNotifikasiBatasWaktu(TransaksiPeminjaman tp) {
        Main.daftarNotifikasi.add(new Notifikasi(tp.getAnggota().getName() + " telah meminjam buku " + tp.getBuku().getJudul() + ". Durasi Peminjaman " + tp.getDurasi() + " hari."));
    }
    
    public static void addNotifikasiBukuRestored(Buku buku) {
        Main.daftarNotifikasi.add(new Notifikasi("Buku " + buku.getJudul() + " oleh " + buku.getPengarang() + " telah tersedia kembali."));
    }
    
    public static void addNotifikasiBukuBaru(Buku buku) {
        Main.daftarNotifikasi.add(new Notifikasi("Ada buku baru! " + buku.getJudul() + " oleh " + buku.getPengarang() + "."));
    }
    
    public static void showNotifikasi() {
        Scanner scanner = new Scanner(System.in);
        
        if(Main.daftarNotifikasi.isEmpty()) {
            System.out.println("\nTidak ada Notifikasi");
            return;
        }
        
        System.out.println("\nNotifikasi:");
        for (Notifikasi notifikasi : Main.daftarNotifikasi) {
            System.out.println("(*) " + notifikasi.getNotifikasi());
        }
        while (true) {
            System.out.println("\n0. Kembali ke Menu Sebelumnya");
            
            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();

            if (opsi == 0) {
                break;
            } else {
                System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }
    }
}