package com.pboreg;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

class Orang {
    private int umur;
    private String nama;

    public Orang() {
        this.nama = " ";
        this.umur = 0;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    static class Pegawai extends Orang {
        private String nip;
        private int golongan;

        public Pegawai() {
            this.nip = nip;
            this.golongan = golongan;
        }

        public String getNip() {
            return nip;
        }

        public void setNip(String nip) {
            this.nip = nip;
        }

        public int getGolongan() {
            return golongan;
        }

        public void setGolongan(int golongan) {
            this.golongan = golongan;
        }
    }
}
    public class HitungGaji {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

            String nama, nip;
            int jum, gol, jkerja, jlembur, gapok, glembur, tun_pengabdian;
            int umur;
            double pajakgapok, pajaklembur, totpajak, gajibersih;

            Orang.Pegawai pegawai = new Orang.Pegawai();
            System.out.print("Masukan Nama : ");
            nama = input.next();
            pegawai.setNama(nama);
            System.out.print("Masukkan NIP : ");
            nip = input.next();
            pegawai.setNip(nip);
            System.out.print("Masukkan umur : ");
            umur = input.nextInt();
            pegawai.setUmur(umur);
            System.out.print("Masukan Golongan : ");
            gol = input.nextInt();
            pegawai.setGolongan(gol);
            System.out.print("Masukan Jam Kerja : ");
            jkerja = input.nextInt();

            switch (gol) {
                case 1:
                    gapok = 1486500;
                    tun_pengabdian = 250000;
                    break;
                case 2:
                    gapok = 1926000;
                    tun_pengabdian = 300000;
                    break;
                case 3:
                    gapok = 2456700;
                    tun_pengabdian = 350000;
                    break;
                case 4:
                    gapok = 2899500;
                    tun_pengabdian = 400000;
                    break;
                default:
                    gapok = 0;
                    tun_pengabdian = 0;
            }

            if (jkerja > 173) {
                jlembur = jkerja - 173;
            } else {
                jlembur = 0;
            }

            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');
            kursIndonesia.setDecimalFormatSymbols(formatRp);

            glembur = jlembur * 20000;
            pajakgapok = 0.05 * gapok;
            pajaklembur = 0.05 * glembur;
            totpajak = pajakgapok + pajaklembur;
            gajibersih = ((gapok + tun_pengabdian + glembur) - totpajak);

            System.out.println("Nama                 : " + pegawai.getNama());
            System.out.println("NIP                  : " + pegawai.getNip());
            System.out.println("Umur                 : " + pegawai.getUmur());
            System.out.println("Gaji Pokok           : " + kursIndonesia.format(gapok));
            System.out.println("Gaji Lembur          : " + kursIndonesia.format(glembur));
            System.out.println("Pajak Gaji Pokok     : " + kursIndonesia.format(pajakgapok));
            System.out.println("Pajak Lembur         : " + kursIndonesia.format(pajaklembur));
            System.out.println("Total Pajak          : " + kursIndonesia.format(totpajak));
            System.out.println("Tunjangan Pengabdian : " + kursIndonesia.format(tun_pengabdian));
            System.out.println("Gaji Diterima        : " + kursIndonesia.format(gajibersih));
        }

    }

