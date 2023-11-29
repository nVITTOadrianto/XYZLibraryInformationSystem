package PerpustakaanXYZ;

import java.util.Date;

public class TransaksiPeminjaman {
    private String IDTransaksi;
    private Date tanggalWaktu;
    private int durasi;
    private AnggotaPerpustakaan anggota;
    private Buku buku;

    public TransaksiPeminjaman(String IDTransaksi, Date tanggalWaktu, int durasi, AnggotaPerpustakaan anggota, Buku buku) {
        this.IDTransaksi = IDTransaksi;
        this.tanggalWaktu = tanggalWaktu;
        this.durasi = durasi;
        this.anggota = anggota;
        this.buku = buku;
    }

    public String getIDTransaksi() {
        return IDTransaksi;
    }

    public void setIDTransaksi(String IDTransaksi) {
        this.IDTransaksi = IDTransaksi;
    }

    public Date getTanggalWaktu() {
        return tanggalWaktu;
    }

    public void setTanggalWaktu(Date tanggalWaktu) {
        this.tanggalWaktu = tanggalWaktu;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public AnggotaPerpustakaan getAnggota() {
        return anggota;
    }

    public void setAnggota(AnggotaPerpustakaan anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }
    
    public static void infoTransaksiPeminjaman() {
        System.out.println("\nInfo Transaksi Peminjaman yang sedang berlangsung:");
        if(Main.daftarPeminjaman.isEmpty()) {
            System.out.println("-");
        } else {
            for(TransaksiPeminjaman tp : Main.daftarPeminjaman) {
                System.out.println(tp.getIDTransaksi() + " - " + tp.getBuku().getJudul() + " - Dipinjam pada " + tp.getTanggalWaktu().toString() + " - Durasi peminjaman " + tp.getDurasi() + " hari");
            }
        }
    }
}
