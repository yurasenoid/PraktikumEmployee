package pakson_employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Member member = new Member();
        Barang barang = new Barang();
        Transaksi transaksi = new Transaksi();
        Laporan laporan = new Laporan();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Tabel Barang");
        System.out.println("Nama Barang\tStok\tHarga");
        for (int i = 0; i < barang.getJmlBarang(); i++) {
            System.out.println(barang.getNamaBarang(i) + "\t" + barang.getStok(i) + "\t" + barang.getHarga(i));
        }

        System.out.println("\nTabel Member");
        System.out.println("Nama\tAlamat\t\tTelepon\t\tSaldo");
        for (int i = 0; i < member.getJmlMember(); i++) {
            System.out.println(member.getNama(i) + "\t" + member.getAlamat(i) + "\t" +
                    member.getTelepon(i) + "\t" + member.getSaldo(i));
        }

        System.out.println("\nLaporan Transaksi");
        System.out.println("Nama Barang\tQty\tHarga\tJumlah");
        int totalOmset = 0;
        for (int i = 0; i < transaksi.getJmlTransaksi(); i++) {
            int idBarang = transaksi.getIdBarang(i);
            int qty = transaksi.getBanyaknya(i);
            int harga = barang.getHarga(idBarang);
            int jumlah = qty * harga;

            System.out.println(barang.getNamaBarang(idBarang) + "\t" + qty + "\t" + harga + "\t" + jumlah);

            totalOmset += jumlah;
        }
        System.out.println("Total Omset =" + totalOmset);

        System.out.println("\nSilahkan belanja");
        System.out.println("Masukkan ID Member");
        int idMember = scanner.nextInt();
        System.out.println("Selamat datang " + member.getNama(idMember));

        transaksi.prosesTransaksi(member, transaksi, barang);

        System.out.println("\nLaporan Transaksi Setelah Pembelian");
        System.out.println("Nama Barang\tQty\tHarga\tJumlah");
        totalOmset = 0;
        for (int i = 0; i < transaksi.getJmlTransaksi(); i++) {
            int idBarang = transaksi.getIdBarang(i);
            int qty = transaksi.getBanyaknya(i);
            int harga = barang.getHarga(idBarang);
            int jumlah = qty * harga;

            System.out.println(barang.getNamaBarang(idBarang) + "\t" + qty + "\t" + harga + "\t" + jumlah);

            totalOmset += jumlah;
        }
        System.out.println("Total Omset =" + totalOmset);

      
        System.out.println("\nTabel Barang Setelah Pembelian");
        System.out.println("Nama Barang\tStok\tHarga");
        for (int i = 0; i < barang.getJmlBarang(); i++) {
            System.out.println(barang.getNamaBarang(i) + "\t" + barang.getStok(i) + "\t" + barang.getHarga(i));
        }

        System.out.println("\nTabel Member Setelah Pembelian");
        System.out.println("Nama\tAlamat\t\tTelepon\t\tSaldo");
        for (int i = 0; i < member.getJmlMember(); i++) {
            System.out.println(member.getNama(i) + "\t" + member.getAlamat(i) + "\t" +
                    member.getTelepon(i) + "\t" + member.getSaldo(i));
        }

        scanner.close();
    }
}
