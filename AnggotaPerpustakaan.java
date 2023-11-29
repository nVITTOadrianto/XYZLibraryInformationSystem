package PerpustakaanXYZ;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AnggotaPerpustakaan {
    private String name;
    private String nomorAnggota;
    private String alamat;
    private ArrayList<TransaksiPeminjaman> riwayatPeminjaman;

    public AnggotaPerpustakaan(String name, String nomorAnggota, String alamat) {
        this.name = name;
        this.nomorAnggota = nomorAnggota;
        this.alamat = alamat;
        this.riwayatPeminjaman = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNomorAnggota() {
        return nomorAnggota;
    }

    public void setNomorAnggota(String nomorAnggota) {
        this.nomorAnggota = nomorAnggota;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public ArrayList<TransaksiPeminjaman> getRiwayatPeminjaman() {
        return riwayatPeminjaman;
    }

    public void setRiwayatPeminjaman(ArrayList<TransaksiPeminjaman> riwayatPeminjaman) {
        this.riwayatPeminjaman = riwayatPeminjaman;
    }
    
    public static void tampilkanBuku() {
        System.out.println("\nDaftar Buku:");
        for (int i = 0; i < Main.daftarBuku.size(); i++) {
            Buku buku = Main.daftarBuku.get(i);
            System.out.println(buku.getIDBuku() + " - " + buku.getJudul() + " - " + buku.getPengarang());
        }
    }
    
    public static void tampilkanAnggota() {
        System.out.println("\nDaftar Anggota:");
        for (int i = 0; i < Main.daftarAnggota.size(); i++) {
            AnggotaPerpustakaan anggota = Main.daftarAnggota.get(i);
            System.out.println(anggota.getNomorAnggota() + " - " + anggota.getName());
        }
    }
    
    public static AnggotaPerpustakaan cariAnggotaByID(String nomorID) {
        for (AnggotaPerpustakaan anggota : Main.daftarAnggota) {
            if (anggota.nomorAnggota.equals(nomorID)) {
                return anggota;
            }
        }
        return null;
    }
    
    public static void pinjamBuku() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            tampilkanBuku();
            
            System.out.print("Masukkan nomor ID buku yang akan dipinjam: ");
            String nomorID = scanner.nextLine();
            
            Buku validBook = Buku.cariBukuByID(nomorID);
            
            tampilkanAnggota();
            
            System.out.print("Masukkan nomor anggota yang meminjam: ");
            String nomorAnggota = scanner.nextLine();
            
            AnggotaPerpustakaan validAnggota = AnggotaPerpustakaan.cariAnggotaByID(nomorAnggota);

            if(validBook != null && validAnggota != null) {
                int i, j = 0;
                for(i = 0; i < Main.daftarBuku.size(); i++) {
                    if(Main.daftarBuku.get(i) == validBook) {
                        break;
                    }
                }
                
                for(j = 0; j < Main.daftarAnggota.size(); j++) {
                    if(Main.daftarAnggota.get(j) == validAnggota) {
                        break;
                    }
                }
                
                Buku bukuDipinjam = Main.daftarBuku.get(i);
                AnggotaPerpustakaan anggotaMeminjam = Main.daftarAnggota.get(j);
                
                if (bukuDipinjam.isStatusKetersediaan()) {
                    TransaksiPeminjaman transaksiPeminjaman = new TransaksiPeminjaman("T" + Integer.toString(Main.daftarPeminjaman.size() + 1), new Date(), 7, anggotaMeminjam, bukuDipinjam);

                    Main.daftarPeminjaman.add(transaksiPeminjaman);
                    
                    Notifikasi.addNotifikasiBatasWaktu(transaksiPeminjaman);                    

                    bukuDipinjam.setStatusKetersediaan(false);
                    
                    anggotaMeminjam.riwayatPeminjaman.add(transaksiPeminjaman);
                    
                    System.out.println("Buku berhasil dipinjam! Transaksi ID: " + transaksiPeminjaman.getIDTransaksi());
                    break;
                } else {
                    System.out.println("Buku tidak tersedia.");
                    break;
                }
            } else {
                    System.out.println("Nomor ID anggota atau Nomor ID buku tidak valid.");
            }
        }
    }

    public static void kembalikanBuku() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan ID Transaksi: ");
        String idTransaksi = scanner.nextLine();

        for (TransaksiPeminjaman peminjaman : Main.daftarPeminjaman) {
            if (peminjaman.getIDTransaksi().equals(idTransaksi)) {
                Buku bukuDikembalikan = peminjaman.getBuku();
                bukuDikembalikan.setStatusKetersediaan(true);
                
                Notifikasi.addNotifikasiBukuRestored(bukuDikembalikan);

                TransaksiPengembalian pengembalian = new TransaksiPengembalian(peminjaman.getIDTransaksi(), new Date(), peminjaman.getAnggota(), peminjaman.getBuku());
                Main.daftarPengembalian.add(pengembalian);
                
                Main.daftarPeminjaman.remove(peminjaman);

                System.out.println("Buku berhasil dikembalikan!");
                return;
            }
        }

        System.out.println("ID Transaksi tidak ditemukan.");
    }
    
    public static void infoAnggota() {
        Scanner scanner = new Scanner(System.in);
        
        tampilkanAnggota();
        
        System.out.print("Masukkan nomor ID anggota: ");
        String idAnggota = scanner.nextLine();
        
        for (AnggotaPerpustakaan anggota : Main.daftarAnggota) {
            if(anggota.getNomorAnggota().equals(idAnggota)) {
                System.out.println("\nNomor:\t " + anggota.getNomorAnggota());
                System.out.println("Nama:\t " + anggota.getName());
                System.out.println("Alamat:\t " + anggota.getAlamat());
                System.out.println("Riwayat Peminjaman:");
                
                ArrayList<TransaksiPeminjaman> rp = anggota.getRiwayatPeminjaman();
                
                if(rp.isEmpty()) {
                    System.out.println("-");
                } else {
                    for(TransaksiPeminjaman tp : rp) {
                        System.out.println(tp.getIDTransaksi() + " - " + tp.getBuku().getJudul() + " - Dipinjam pada " + tp.getTanggalWaktu().toString() + " - Durasi peminjaman" + tp.getDurasi() + " hari");
                    }
                }
                return;
            }
        }
        System.out.println("Nomor ID Anggota tidak valid.");
    }
    
    public static void memberMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Member:");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Notifikasi");
            System.out.println("6. Kembali ke Menu Utama");

            System.out.print("Pilih opsi: ");
            int opsiMember = scanner.nextInt();

            if (opsiMember == 1) {
                tampilkanBuku();
            } else if (opsiMember == 2) {
                pinjamBuku();
            } else if (opsiMember == 3) {
                kembalikanBuku();
            } else if (opsiMember == 4) {
                search();
            } else if (opsiMember == 5) {
                Notifikasi.showNotifikasi();
            } else if (opsiMember == 6) {
                break;
            } else {
                System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }    
    }
    
    public static void search() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nCari Buku:");
            System.out.println("1. Berdasarkan Judul Buku");
            System.out.println("2. Berdasarkan Pengarang Buku");
            System.out.println("3. Berdasarkan ISBN Buku");
            System.out.println("4. Kembali ke Menu Sebelumnya");

            System.out.print("Pilih opsi: ");
            int opsiMember = scanner.nextInt();
            scanner.nextLine();

            if (opsiMember == 1) {
                System.out.print("Masukkan judul buku: ");
                String judul = scanner.nextLine();
                Buku.cariBukuByJudul(judul);
            } else if (opsiMember == 2) {
                System.out.print("Masukkan pengarang buku: ");
                String pengarang = scanner.nextLine();
                Buku.cariBukuByPengarang(pengarang);
            } else if (opsiMember == 3) {
                System.out.print("Masukkan ISBN buku: ");
                String ISBN = scanner.nextLine();
                Buku.cariBukuByISBN(ISBN);
            } else if (opsiMember == 4) {
                break;
            } else {
                System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }    
    }
    
}
