package PerpustakaanXYZ;

import java.util.Scanner;

public class Admin {
    public static void tampilkanBuku() {
        System.out.println("\nDaftar Buku:");
        for (int i = 0; i < Main.daftarBuku.size(); i++) {
            Buku buku = Main.daftarBuku.get(i);
            System.out.println(buku.getIDBuku() + " - " + buku.getJudul() + " - " + buku.getPengarang());
        }
    }
    
    public static void tambahBuku() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan pengarang: ");
        String pengarang = scanner.nextLine();
        System.out.print("Masukkan ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Apakah buku tersedia? (true/false): ");
        boolean ketersediaan = scanner.nextBoolean();
        
        Buku newBuku = new Buku("B" + Integer.toString(Main.daftarBuku.size() + 1), judul, pengarang, isbn, ketersediaan);
        
        Main.daftarBuku.add(newBuku);
        
        Notifikasi.addNotifikasiBukuBaru(newBuku);

        System.out.println("Buku berhasil ditambahkan!");
    }

    public static void hapusBuku() {
        Scanner scanner = new Scanner(System.in);

        tampilkanBuku();

        System.out.print("Masukkan nomor ID buku yang akan dihapus: ");
        String nomorBuku = scanner.nextLine();

        Buku buku = Buku.cariBukuByID(nomorBuku);
        
        if (buku != null) {
            int i = 0;
            for(i = 0; i < Main.daftarBuku.size(); i++) {
                if(Main.daftarBuku.get(i) == buku) {
                    break;
                }
            }
            Main.daftarBuku.remove(i);
            
            System.out.println("Buku berhasil dihapus!");
        } else {
            System.out.println("Nomor buku tidak valid.");
        }
    }
    
    public static void tampilkanAnggota() {
        System.out.println("\nDaftar Anggota:");
        for (int i = 0; i < Main.daftarAnggota.size(); i++) {
            AnggotaPerpustakaan anggota = Main.daftarAnggota.get(i);
            System.out.println(anggota.getNomorAnggota() + " - " + anggota.getName());
        }
    }
    
    public static void daftarAnggota() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan nama anggota: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan alamat anggota: ");
        String alamat = scanner.nextLine();

        Main.daftarAnggota.add(new AnggotaPerpustakaan(name, "M" + Integer.toString(Main.daftarAnggota.size() + 1), alamat));

        System.out.println("Anggota berhasil didaftarkan!");
    }
    
    public static void hapusAnggota() {
        Scanner scanner = new Scanner(System.in);
        
        tampilkanAnggota();
        
        System.out.print("Masukkan nomor ID anggota yang akan dihapus: ");
        String noAnggota = scanner.nextLine();
        
        for (AnggotaPerpustakaan anggota : Main.daftarAnggota) {
            if(anggota.getNomorAnggota().equals(noAnggota)) {
                Main.daftarAnggota.remove(anggota);
                System.out.println("Anggota berhasil dihapuskan!");
                return;
            }
        }
        
        System.out.println("Nomor ID anggota tidak valid.");
    }
    
    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu Admin:");
            System.out.println("1. Tampilkan Semua Buku");
            System.out.println("2. Tambah Buku");
            System.out.println("3. Hapus Buku");
            System.out.println("4. Tampilkan Semua Anggota");
            System.out.println("5. Info Lengkap Anggota");
            System.out.println("6. Daftar Anggota");
            System.out.println("7. Hapus Anggota");
            System.out.println("8. Lihat Transaksi Peminjaman Sekarang");
            System.out.println("9. Lihat Transaksi Pengembalian");
            System.out.println("10. Kembali ke Menu Utama");

            System.out.print("Pilih opsi: ");
            int opsiAdmin = scanner.nextInt();

            if (opsiAdmin == 1) {
                tampilkanBuku();
            } else if (opsiAdmin == 2) {
                tambahBuku();
            } else if (opsiAdmin == 3) {
                hapusBuku();
            } else if (opsiAdmin == 4) {
                tampilkanAnggota();
            } else if (opsiAdmin == 5) {
                AnggotaPerpustakaan.infoAnggota();
            } else if (opsiAdmin == 6) {
                daftarAnggota();
            } else if (opsiAdmin == 7) {
                hapusAnggota();
            } else if (opsiAdmin == 8) {
                TransaksiPeminjaman.infoTransaksiPeminjaman();
            } else if (opsiAdmin == 9) {
                TransaksiPengembalian.infoTransaksiPengembalian();
            } else if (opsiAdmin == 10) {
                break;
            } else {
                System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }
    }
    
}
