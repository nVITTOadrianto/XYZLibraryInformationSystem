package PerpustakaanXYZ;

import java.util.Date;

public class TransaksiPengembalian {
    private String IDTransaksi;
    private Date tanggalWaktu;
    private AnggotaPerpustakaan anggota;
    private Buku buku;

    public TransaksiPengembalian(String IDTransaksi, Date tanggalWaktu, AnggotaPerpustakaan anggota, Buku buku) {
        this.IDTransaksi = IDTransaksi;
        this.tanggalWaktu = tanggalWaktu;
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

    public void setTanggal(Date tanggalWaktu) {
        this.tanggalWaktu = tanggalWaktu;
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
    
    public static void infoTransaksiPengembalian() {
        System.out.println("\nInfo Transaksi Pengembalian:");
        if(Main.daftarPengembalian.isEmpty()){
            System.out.println("-");
        } else {
            for(TransaksiPengembalian tp : Main.daftarPengembalian) {
                System.out.println(tp.getIDTransaksi() + " - " + tp.getBuku().getJudul() + " - Dikembalikan pada " + tp.getTanggalWaktu().toString());
            }
        }
    }
}
