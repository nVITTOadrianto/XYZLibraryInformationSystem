package PerpustakaanXYZ;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Buku> daftarBuku = new ArrayList<>();
    static ArrayList<Notifikasi> daftarNotifikasi = new ArrayList<>();
    static ArrayList<AnggotaPerpustakaan> daftarAnggota = new ArrayList<>();
    static ArrayList<TransaksiPeminjaman> daftarPeminjaman = new ArrayList<>();
    static ArrayList<TransaksiPengembalian> daftarPengembalian = new ArrayList<>();
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Inisiasi Buku
        daftarBuku.add(new Buku("B1", "Harry Potter", "J.K. Rowling", "ISBN001", true));
        daftarBuku.add(new Buku("B2", "Lord of the Rings", "J.R.R. Tolkien", "ISBN002", true));
        daftarBuku.add(new Buku("B3", "To Kill a Mockingbird", "Harper Lee", "ISBN003", true));
        daftarBuku.add(new Buku("B4", "1984", "George Orwell", "ISBN004", true));
        daftarBuku.add(new Buku("B5", "The Great Gatsby", "F. Scott Fitzgerald", "ISBN005", true));
        
        // Inisiasi Anggota
        daftarAnggota.add(new AnggotaPerpustakaan("Nicholas Vitto Adrianto", "M1", "Bandar Lampung"));
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Admin");
            System.out.println("2. Member");
            System.out.println("3. Keluar");

            System.out.print("Pilih opsi: ");
            int opsi = scanner.nextInt();

            if (opsi == 1) {
                Admin.adminMenu();
            } else if (opsi == 2) {
                AnggotaPerpustakaan.memberMenu();
            } else if (opsi == 3) {
                System.out.println("Program berhenti.");
                break;
            } else {
                System.out.println("Opsi tidak valid. Silakan pilih lagi.");
            }
        }

        scanner.close();
    }
}
