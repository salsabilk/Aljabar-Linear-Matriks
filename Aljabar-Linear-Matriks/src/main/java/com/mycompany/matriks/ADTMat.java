/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.matriks;

/**
 *
 * @author Alisha Nara
 */
import java.util.Scanner;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ADTMat {
	/* Tipe data matriks */
	public class MATRIKS {
		/* Memori matriks yang dipakai selalu di "ujung kiri atas" */
		public double[][] Data = new double[100][100];
		/* Indeks matriks yang digunakan: [0..NBaris-1][0..NBaris-1] */
		public int NBaris;
		public int NKolom;
		/*
		 * des merupakan deskripsi proses dan hasil perhitungan matriks, NDeskripsi
		 * menghitung Deskripsi
		 */
		public String[] Deskripsi = new String[100];
		public int NDeskripsi;
	}

	static final Scanner sc = new Scanner(System.in);

	/* ********** DEFINISI PROTOTIPE PRIMITIF ********** */
	/* *** Konstruktor membentuk MATRIKS *** */
	public void BuatMATRIKS(int UkBaris, int UkKolom, MATRIKS M) {
		/*
		 * Membentuk sebuah MATRIKS "kosong" yang siap diisi berukuran UkBaris x UkKolom
		 * di "ujung kiri" memori
		 */
		/* I.S. UkBaris dan UkKolom adalah valid untuk memori matriks yang dibuat */
		/* F.S. Matriks M sesuai dengan definisi di atas terbentuk */
		M.NBaris = UkBaris;
		M.NKolom = UkKolom;
	}

	/* ********** BACA/TULIS MATRIKS ********** */
	public void BacaMATRIKS(MATRIKS M) {
		/* I.S. M kosong */
		/*
		 * F.S. M terdefinisi nilai elemen efektifnya,
		 * berukuran UkBaris x UkKolom dengan nilai ordo sama sehingga membentuk matriks
		 * persegi
		 */
		/*
		 * Proses: Melakukan BuatMATRIKS(M,UkBaris,UkKolom) dan mengisi nilai efektifnya
		 */
		/* Selanjutnya membaca nilai elemen per baris dan kolom */
		/*
		 * n untuk input nilai ordo, i untuk loop jumlah baris, j untuk loop jumlah
		 * kolom
		 */
		int i, j, n;
		Scanner input = new Scanner(System.in);
		System.out.print("Masukkan ordo matriks n (contoh: 3) : ");
		n = input.nextInt();
		System.out.println("Tulis Elemen Matriks : ");
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				M.Data[i][j] = input.nextDouble();
			}
		}
		BuatMATRIKS(n, n, M);
		System.out.println("Matriks yang anda masukkan adalah :");
		TulisMATRIKS(M);
		System.out.println();
	}

	public boolean BacaMATRIKS2(MATRIKS M1, MATRIKS M2) {
            int i, j, n, n2;
            Scanner input = new Scanner(System.in);
            System.out.print("Masukkan ordo matriks ke-1 (contoh: 3) : ");
            n = input.nextInt();
            System.out.print("Masukkan ordo matriks ke-2 (contoh: 3) : ");
            n2 = input.nextInt();

            if (n == n2) {
                System.out.println("\nMasukkan Elemen Matriks ke-1 : ");
                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        M1.Data[i][j] = input.nextDouble();
                    }
                }
                BuatMATRIKS(n, n, M1);
                System.out.println("Matriks yang anda masukkan adalah :");
                TulisMATRIKS(M1);
                System.out.println();
                
                System.out.println("\nMasukkan Elemen Matriks ke-2: ");
                for (i = 0; i < n; i++) {
                    for (j = 0; j < n; j++) {
                        M2.Data[i][j] = input.nextDouble();
                    }
                }
                BuatMATRIKS(n, n, M2);
                System.out.println("Matriks yang anda masukkan adalah :");
                TulisMATRIKS(M2);
                System.out.println();

                return true; // Mengembalikan true jika jumlah ordo sama.
            } else {
                return false; // Mengembalikan false jika jumlah ordo berbeda.
            }
        }

	public void BacaMATRIKSAugmented(MATRIKS M) {
		/* I.S. M kosong */
		/*
		 * F.S. M terdefinisi nilai elemen efektifnya,
		 * berukuran UkBaris x UkKolom dengan nilai ordo yang bisa berbeda
		 */
		/*
		 * Proses: Melakukan BuatMATRIKS(UkBaris,UkKolom,M) dan mengisi nilai efektifnya
		 */
		/* Selanjutnya membaca nilai elemen per baris dan kolom */
		/*
		 * m untuk input nilai baris, n untuk input nilai kolom, i untuk loop jumlah
		 * baris, j untuk loop jumlah kolom
		 */
		int i, j, m, n;
		Scanner input = new Scanner(System.in);
		System.out.print("Masukkan ordo matriks mxn (contoh: 2 3) : ");
		m = input.nextInt();
		n = input.nextInt();
		System.out.println("Tulis Elemen Matriks ");
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				M.Data[i][j] = input.nextDouble();
			}
		}
		BuatMATRIKS(m, n, M);
		System.out.println("Matriks yang anda masukkan adalah :");
		TulisMATRIKS(M);
		System.out.println();
	}

	public void TulisMATRIKS(MATRIKS M) {
		/* I.S. M terdefinisi */
		/*
		 * F.S. Nilai M(i,j) ditulis ke layar per baris per kolom, masing-masing elemen
		 * per baris
		 * dipisahkan sebuah spasi
		 */
		/*
		 * Proses: Menulis nilai setiap elemen M ke layar dengan traversal per baris dan
		 * per kolom
		 */
		/* i untuk loop jumlah baris, j untuk loop jumlah kolom */
		int i, j;
		for (i = 0; i <= M.NBaris - 1; i++) {
			for (j = 0; j <= M.NKolom - 1; j++) {
				if (M.Data[i][j] == -0.0) {
					M.Data[i][j] = -0.0 + 0.0;
				}
				if (j == (M.NKolom - 1) && i == (M.NBaris - 1)) {
					System.out.printf("%.2f", M.Data[i][j]);
				} else if (j == (M.NKolom - 1)) {
					System.out.printf("%.2f", M.Data[i][j]);
					System.out.println();
				} else {
					System.out.printf("%.2f", M.Data[i][j]);
					System.out.print(" ");
				}
			}
		}
	}

	/* ********** KELOMPOK OPERASI TERHADAP MATRIKS ********** */
	public boolean IsPersegi(MATRIKS M) {
		/* Mengirimkan true jika M adalah matriks dengan ukuran baris dan kolom sama */
		return (M.NBaris == M.NKolom);
	}

	public MATRIKS penjumlahanMatriks(MATRIKS M1, MATRIKS M2) {
		/* Melakukan penjumlahan terhadap 2 matriks */
		int n = M1.NBaris;
		MATRIKS hasil = new MATRIKS();
		BuatMATRIKS(n, n, hasil);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				hasil.Data[i][j] = M1.Data[i][j] + M2.Data[i][j];
			}
		}
		return hasil;
	}

	public MATRIKS penguranganMatriks(MATRIKS M1, MATRIKS M2) {
		int n = M1.NBaris;
		MATRIKS hasil = new MATRIKS();
		BuatMATRIKS(n, n, hasil);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				hasil.Data[i][j] = M1.Data[i][j] - M2.Data[i][j];
			}
		}
		return hasil;
	}

	public MATRIKS perkalianMATRIKS(MATRIKS M1, MATRIKS M2) {
		/* Prekondisi : Ukuran kolom efektif M1 = ukuran baris efektif M2 */
		/* Mengirim hasil perkalian matriks: salinan M1 * M2 */
		int i, j, k;
		double el;
		MATRIKS M3 = new MATRIKS();
		BuatMATRIKS(M1.NBaris, M2.NKolom, M3);
		for (i = 0; i <= M3.NBaris - 1; i++) {
			for (j = 0; j <= M3.NKolom - 1; j++) {
				el = 0;
				for (k = 0; k <= M1.NKolom; k++) {
					el = el + M1.Data[i][k] * M2.Data[k][j];
				}
				M3.Data[i][j] = el;
			}
		}
		return M3;
	}

	public void MenuPenjumlahan() {
		// MODIFIKASI
		MATRIKS MTR1 = new MATRIKS();
		MATRIKS MTR2 = new MATRIKS();
		MATRIKS hasil = new MATRIKS();

		System.out.println("Anda telah memilih menu penjumlahan");
		boolean isInputValid = BacaMATRIKS2(MTR1, MTR2);

		if (isInputValid) {
			hasil = penjumlahanMatriks(MTR1, MTR2);

			System.out.println("\nHasil Penjumlahan Matriksnya adalah:");
			TulisMATRIKS(hasil);
			System.out.println("\n");
		} else {
			System.out.println("Jumlah ordo harus sama, tidak dapat melakukan penjumlahan.");
			System.out.println("\n");
		}
		MainMenu();
	}

	public void MenuPengurangan() {
		// MODIFIKASI
		MATRIKS MTR1 = new MATRIKS();
		MATRIKS MTR2 = new MATRIKS();
		MATRIKS hasil = new MATRIKS();

		System.out.println("Anda telah memilih menu pengurangan");
		boolean isInputValid = BacaMATRIKS2(MTR1, MTR2);

		if (isInputValid) {
			hasil = penguranganMatriks(MTR1, MTR2);

			System.out.println("\nHasil Pengurangan Matriksnya adalah:");
			TulisMATRIKS(hasil);
			System.out.println("\n");
		} else {
			System.out.println("Jumlah ordo harus sama, tidak dapat melakukan pengurangan.");
			System.out.println("\n");
		}
		MainMenu();
	}

	public void MenuPerkalian() {
		// MODIFIKASI
		MATRIKS MTR1 = new MATRIKS();
		MATRIKS MTR2 = new MATRIKS();
		MATRIKS hasil = new MATRIKS();

		System.out.println("Anda telah memilih menu perkalian");
		BacaMATRIKSAugmented(MTR1);
		BacaMATRIKSAugmented(MTR2);

		hasil = perkalianMATRIKS(MTR1, MTR2);

		System.out.println("\nHasil Perkalian Matriksnya adalah:");
		TulisMATRIKS(hasil);
		System.out.println("\n");
		MainMenu();
	}

	public void Transpose(MATRIKS M) {
		/* I.S. M terdefinisi dan IsPersegi(M) */
		/*
		 * F.S. M "di-transpose", yaitu setiap elemen M(i,j) ditukar nilainya dengan
		 * elemen M(j,i)
		 */
		MATRIKS M3 = new MATRIKS();
		int i, j;
		BuatMATRIKS(M.NBaris, M.NKolom, M3);
		for (i = 0; i < M.NBaris; i++) {
			for (j = 0; j < M.NKolom; j++) {
				M3.Data[i][j] = M.Data[j][i];
			}
		}
		M.Data = M3.Data;
	}

	public MATRIKS Inverse(MATRIKS M) {
		/* I.S. M terdefinisi dan pasti punya invers */
		/* F.S. return matriks hasil inverse */
		MATRIKS Invers = new MATRIKS();
		// Invers = MATRIKSKofaktor(M);
		Transpose(Invers);
		double perdet;
		// perdet = 1 / EkspansiKofaktor(M);
		// PKaliKons(Invers, perdet);
		return (Invers);
	}

	public void PKaliKons(MATRIKS M, double K) {
		/* I.S. M terdefinisi, K terdefinisi */
		/* F.S. Mengalikan setiap elemen M dengan K */
		int i, j;
		for (i = 0; i < M.NBaris; i++) {
			for (j = 0; j < M.NKolom; j++) {
				M.Data[i][j] = M.Data[i][j] * K;
			}
		}
	}

	// public boolean IsInversExist(MATRIKS M) {
	/* I.S. M terdefinisi */
	/* F.S. Mereturn true apabila matriks m mempunyai invers */
	// return (EkspansiKofaktor(M) != 0);
	// }

	public void CopyMATRIKS(MATRIKS MIn, MATRIKS MHsl) {
		/* I.S. MIn, dan MHsl terdefinisi */
		/* F.S. Melakukan assignment MHsl MIn */
		int i, j;
		BuatMATRIKS(MIn.NBaris, MIn.NKolom, MHsl);
		for (i = 0; i < MIn.NBaris; i++) {
			for (j = 0; j < MIn.NKolom; j++) {
				MHsl.Data[i][j] = MIn.Data[i][j];
			}
		}
	}

	public void TukarBaris(MATRIKS M, int i1, int i2) {
		int j;
		double temp;
		for (j = 0; j < M.NKolom; j++) {
			temp = M.Data[i1][j];
			M.Data[i1][j] = M.Data[i2][j];
			M.Data[i2][j] = temp;
		}
	}

	public boolean IsTidakAdaSolusi(MATRIKS M) {
		MATRIKS M2 = new MATRIKS();
		CopyMATRIKS(M, M2);
		GaussJordan(M2);
		eliminasiBaris(M2);
		int i, j;
		boolean solusi, hasil;
		hasil = false;
		for (i = 0; i < M2.NBaris; i++) {
			solusi = true;
			for (j = 0; j < M2.NKolom - 1; j++) {
				if (M2.Data[i][j] != 0) {
					solusi = false;
				}
			}
			if (solusi) {
				if (M2.Data[i][j] != 0) {
					hasil = true;
				}
			}
		}
		return hasil;
	}

	public void BagiBaris(MATRIKS M, int i) {
		int j, j1, j2;
		double penyebut;
		j = 0;
		boolean a = true;
		for (j2 = 0; j2 < M.NKolom; j2++) {
			if (M.Data[i][j2] >= -0.00000000000001 && M.Data[i][j2] < 0) {
				M.Data[i][j2] = 0;
			}
		}
		while (M.Data[i][j] == 0 && j < M.NKolom) {
			j += 1;
		}
		if (j < M.NKolom) {
			penyebut = M.Data[i][j];
			for (j1 = j; j1 < M.NKolom; j1++) {
				M.Data[i][j1] = M.Data[i][j1] / penyebut;
			}
		}
	}

	public int IndeksKolom(MATRIKS M, int i) {
		// mencari indeks kolom yang berawal nilai 0
		int j, idxKol;
		boolean isKetemu;
		isKetemu = false;
		j = 0;
		idxKol = 0;
		while (j < M.NKolom && !isKetemu) {
			if (M.Data[i][j] != 0) {
				isKetemu = true;
				idxKol = j;
			} else {
				j += 1;
			}
		}
		if (j >= M.NKolom) {
			idxKol = M.NKolom;
		}
		return idxKol;

	}

	public void SortBaris(MATRIKS M) {
		int i, j;
		for (i = 0; i < M.NBaris - 1; i++) {
			for (j = i + 1; j < M.NBaris; j++) {
				if (IndeksKolom(M, i) > IndeksKolom(M, j)) {
					TukarBaris(M, i, j);
				}
			}
		}
	}

	////////// DETERMINAN////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void MenuDeterminan() {
            MATRIKS M = new MATRIKS();
            int pil;
            System.out.println("Anda telah memilih menu Determinan");
            BacaMATRIKS(M);

            System.out.println("Silahkan pilih metode pencarian determinan [1 = Ekspansi Kofaktor, 2 = Segitiga Atas, 3 = Segitiga Bawah]");
            System.out.print("Masukkan pilihan: ");
            pil = sc.nextInt();
            while (pil != 1 && pil != 2 && pil != 3){
                    System.out.println("Pilihan salah !! Silahkan pilih metode pencarian determinan [1 = Ekspansi Kofaktor, 2 = Segitiga Atas, 3 = Segitiga Bawah]");
                    System.out.print("Masukkan pilihan: ");
                    pil = sc.nextInt();
                    System.out.println("");
            }
            if (pil == 1) {
                    DeterminanKofaktor(M);
            } else if (pil == 2){
                    Segiatas(M);
            } else if (pil == 3){
                    Segibawah(M);
            }
            MainMenu();
	}

	public double EkspansiKofaktor(MATRIKS M) {
            /* Prekondisi: IsPersegi(M) */
            /* Menghitung nilai determinan M menggunakan ekspansi kofaktor pada baris ke-1 */
            if (M.NBaris == 1){
		return M.Data[0][0]; // Jika M adalah matriks 1x1, maka determinannya adalah elemen tunggal di matriks
            } else {
		MATRIKS Minor = new MATRIKS(); // Membuat matriks Minor untuk menghitung determinan
		BuatMATRIKS((M.NBaris - 1), (M.NKolom - 1), Minor); // Inisialisasi matriks Minor
		
                int i, j, k, ci, cj;
		double det;
                int koef = 1; // Koefisien untuk menghitung determinan

		det = 0;
		if (M.NBaris == 2){ // untuk matriks 2x2, langsung hitung determinannya
                    det = M.Data[0][0] * M.Data[1][1] - M.Data[0][1] * M.Data[1][0];
                    return det;
		} else {
                    // Jika matriks M lebih besar dari 2x2, lakukan ekspansi kofaktor
                    for (i = 0; i < M.NBaris; i++){
			ci = 0; 
			cj = 0;
			for (j = 0; j < M.NBaris; j++){
                            for (k = 0; k < M.NBaris; k++){
                                if (j != 0 && k != i){
                                    // Buat minor matriks dengan menghilangkan baris dan kolom yang sesuai
                                    Minor.Data[ci][cj] = M.Data[j][k];
                                    cj = cj + 1;
                                    if (cj > M.NBaris - 2){
                                        ci = ci + 1;
                                        cj = 0;
                                    }
                                }
                            }
                        }
                        // Hitung determinan dengan mengakumulasi hasil rekursif
			det = det + koef * ((M.Data[0][i]) * EkspansiKofaktor(Minor));
			// Ganti tanda koefisien untuk setiap iterasi
                        koef = -1 * koef;
                    }
		}
            return det;
            }
	}

	public void DeterminanKofaktor(MATRIKS M) {
            double det = EkspansiKofaktor(M);
            MATRIKSKofaktor2(M);
            System.out.println("Matriks kofaktornya adalah: ");
            TulisMATRIKS(M);
            System.out.println("");
            System.out.print("Determinannya adalah: ");
            System.out.println(det);
            M.NDeskripsi = 1;
            M.Deskripsi[0] = "Matriks Kofaktor, Determinannya adalah " + String.valueOf(det); // Menyimpan deskripsi hasil dalam matriks.
	}

	public double KofakElmt(MATRIKS M, int i, int j) {
            /* I.S. M terdefinisi, i, j dalam range matriks */
            /* F.S. Mengeluarkan elemen kofaktor(i,j) dari sebuah matriks */
            MATRIKS Minor = new MATRIKS();
            BuatMATRIKS((M.NBaris - 1), (M.NKolom - 1), Minor);
            int ii, jj, mi, mj;
            double koef = Math.pow(-1, (i+j+2)) ; // Menghitung koefisien (-1)^(i+j+2) untuk kofaktor
            mi = 0; 
            mj = 0;
            for (ii = 0; ii < M.NBaris; ii++) {
		for (jj = 0; jj < M.NKolom; jj++) {
                    if (ii != i && jj != j) {
			Minor.Data[mi][mj] = M.Data[ii][jj]; // Memasukkan elemen-elemen matriks minor
			mj = mj + 1;
			if (mj > M.NBaris - 2) {
                            mi = mi + 1;
                            mj = 0;
			}
                    }
		}
            }
            return EkspansiKofaktor(Minor)*koef ; // Menghitung kofaktor dengan mengalikan determinan matriks minor dengan koefisien	
	}

	public MATRIKS MATRIKSKofaktor(MATRIKS M) {
            /* I.S. M terdefinisi */
            /* F.S. Mengeluarkan Matriks kofaktor dari sebuah matriks */
            int i,j;
            MATRIKS Kofaktor = new MATRIKS();
            BuatMATRIKS(M.NBaris,M.NKolom,Kofaktor);
            for (i = 0; i < M.NBaris; i++){
		for (j = 0; j < M.NKolom; j++){
                    Kofaktor.Data[i][j] = KofakElmt(M, i, j); // Menghitung kofaktor untuk elemen (i, j) dan memasukkannya ke dalam matriks Kofaktor
		}
            }
            return Kofaktor;
	}

	public void MATRIKSKofaktor2(MATRIKS M) {
            /* I.S. M terdefinisi */
            /* F.S. Mengeluarkan Matriks kofaktor dari sebuah matriks */
            int i,j;
            MATRIKS Kofaktor = new MATRIKS();
            BuatMATRIKS(M.NBaris,M.NKolom,Kofaktor);
            for (i = 0; i < M.NBaris; i++){
		for (j = 0; j < M.NKolom; j++){
                    Kofaktor.Data[i][j] = KofakElmt(M, i, j);
		}
            }
            M.Data = Kofaktor.Data; // Mengganti data matriks input dengan data matriks kofaktor
	}

	public void Segiatas(MATRIKS M) {
            /* I.S. M terdefinisi, IsPersegi(M) */
            /* F.S. Menghitung nilai determinan matriks M dengan metode segitiga atas. 
                Menulis ke layar matriks segitiga atas yang terbentuk dan determinan matriks awal. */
            int n, i, j; 
            double line1, line2;
            float count = 1;
            boolean found;
            for (n = 0; n < M.NBaris; n++){
		if (M.Data[n][n] == 0){
                    found = false;
                    i = n+1;
                    while (!found && i < M.NBaris){
			if (M.Data[i][n] != 0){
                            found = true;
                            for (j = n; j < M.NKolom; j++){
				M.Data[n][j] += M.Data[i][j];
                            }
			}
			i++;
                    }
                    if (!found){
			count = 0;
			n = M.NBaris;
			System.out.println("Matriks tidak dapat membentuk matriks segitiga atas.");
			System.out.println("Kondisi matriks setelah melakukan OBE:");
			TulisMATRIKS(M);
			System.out.println();
			System.out.println("Determinan matriks = 0.0");
                    }  
		}
		for (i = n+1; i < M.NBaris; i++){       
                    if (M.Data[i][n] != 0){        
                        line1 = M.Data[n][n];
                        line2 = M.Data[i][n]; 
			for (j = n; j < M.NKolom; j++){
                            M.Data[n][j] /= line1;
                            M.Data[i][j] /= line2;
                            M.Data[i][j] -= M.Data[n][j];
			}
			count *= (line1 * line2);
                    }
		}
		count *= M.Data[n][n];
            }
            if (count != 0){
		System.out.println("Matriks segitiga atas berhasil terbentuk.");
		System.out.println("Matriks segitiga atas tersebut adalah:");
		TulisMATRIKS(M);
		System.out.println();
		System.out.println("Determinan matriks = " + count);
		M.NDeskripsi = 1;
		M.Deskripsi[0] = "Matriks Segitiga Atas, Determinannya adalah " + String.valueOf(count);
            }
	}

	public void Segibawah(MATRIKS M) {
            /* I.S. M terdefinisi, IsPersegi(M) */
            /* F.S. Menghitung nilai determinan matriks M dengan metode segitiga bawah. 
                Menulis ke layar matriks segitiga bawah yang terbentuk dan determinan matriks awal. */
            int n, i, j; 
            double line1, line2;
            float count = 1;
            boolean found;
            for (n = M.NBaris-1; n >= 0; n--){
		if (M.Data[n][n] == 0){
                    found = false;
                    i = n-1;
                    while (!found && i >= 0){
			if (M.Data[i][n] != 0){
                            found = true;
                            for (j = n; j >= 0; j--){
                                M.Data[n][j] += M.Data[i][j];
                            }
			}
                        i--;
                    }
                    if (!found){
			count = 0;
			n = -1;
			System.out.println("Matriks tidak dapat membentuk matriks segitiga bawah.");
			System.out.println("Kondisi matriks setelah melakukan OBE:");
			TulisMATRIKS(M);
			System.out.println();
			System.out.println("Matriks Segitiga Bawah, Determinan matriks = 0.0");
                    }  
		}
		for (i = n-1; i >= 0; i--){       
                    if (M.Data[i][n] != 0){        
			line1 = M.Data[n][n];
			line2 = M.Data[i][n]; 
			for (j = n; j >= 0; j--){
                            M.Data[n][j] /= line1;
                            M.Data[i][j] /= line2;
                            M.Data[i][j] -= M.Data[n][j];
			}
			count *= (line1 * line2);
                    }
		}
		count *= M.Data[n][n];
            }
            if (count != 0){
		System.out.println("Matriks segitiga bawah berhasil terbentuk.");
		System.out.println("Matriks segitiga bawah tersebut adalah:");
		TulisMATRIKS(M);
		System.out.println();
		System.out.println("Determinan matriks = " + count);
		M.NDeskripsi = 1;
		M.Deskripsi[0] = "Matriks Segitiga Bawah, Determinannya adalah " + String.valueOf(count);
            }
	}

	////////// INVERS////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void MenuInvers() {

	}

	// public void InverseKofaktor(MATRIKS M) {

	// }

	// public void InverseGaussJordan(MATRIKS M) {

	// }

	// public MATRIKS AugmentedInverseJordan(MATRIKS M) {

	// }

	// public MATRIKS MergeInverseJordan(MATRIKS M) {

	// }

	// public void HasilInverseJordan(MATRIKS M) {

	// }

	////////// SPL////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void MenuSPL() {

		// Driver SPL
		MATRIKS Maug = new MATRIKS();
		int op2;
		System.out.println("Anda telah memilih menu SPL");
		BacaMATRIKSAugmented(Maug);
		if (IsTidakAdaSolusi(Maug)) {
			System.out.println("Matriks tidak konsisten sehingga tidak memiliki solusi");
			System.out.println("Kembali ke Menu Utama");
			System.out.println("");
			MainMenu();
		}
		System.out.println("Silahkan pilih metode penyelesaian SPL [1= Gauss, 2= Gauss Jordan]");
		System.out.print("Masukkan pilihan : ");
		op2 = sc.nextInt();
		while (op2 != 1 && op2 != 2 && op2 != 3) {
			System.out.println("Pilihan salah !! Silahkan pilih metode penyelesaian SPL [1= Gauss, 2= Gauss Jordan]");
			System.out.print("Masukkan pilihan : ");
			op2 = sc.nextInt();
			System.out.println("");
		}
		if (op2 == 1) {
			// Gauss
			GaussSPL(Maug);
			System.out.println("Matriks Hasil Eliminasi Gaussnya adalah");
			TulisMATRIKS(Maug);
			System.out.println("");
			solusiGauss(Maug);
		} else if (op2 == 2) {
			// Gauss Jordan
			GaussJordan(Maug);
			System.out.println("Matriks Hasil Gauss Jordannya adalah");
			TulisMATRIKS(Maug);
			System.out.println("");
			eliminasiBaris(Maug);
			solusiGaussJordan(Maug);
		}
		MainMenu();
	}

	// public void GetMATRIKSKoefisien(MATRIKS MAug, MATRIKS MK) {

	// }

	// public void GetMATRIKSHasil(MATRIKS MAug, MATRIKS MH) {

	// }

	// public void EliminasiOBE(MATRIKS M, int indeks) {

	// }

	// public void EliminasiOBEjordan(MATRIKS M, int indeks) {

	// }

	public void GaussSPL(MATRIKS M) {

	}

	public void GaussJordan(MATRIKS M) {

	}

	public void eliminasiBaris(MATRIKS M) {

	}

	// public Boolean isFree(MATRIKS M, int j) {

	// }

	// public boolean isAllZero(MATRIKS M, int i) {

	// }

	public void solusiGauss(MATRIKS M) {

	}

	// public String ParametrikOrUnik(MATRIKS M, int j) {

	// }

	public void solusiGaussJordan(MATRIKS M) {

	}

	public void MainMenu() {
		int op;
		System.out.println("\nMENU PROGRAM");
		System.out.println("1. Determinan");
		System.out.println("2. Invers");
		System.out.println("3. Sistem Persamaan Linear");
		System.out.println("4. Perkalian Matriks");
		System.out.println("5. Penjumlahan Matriks");
		System.out.println("6. Pengurangan Matriks");
		System.out.println("7. Keluar");
		System.out.print("Masukkan pilihan menu yang diinginkan : ");
		op = sc.nextInt();
		while (op != 1 && op != 2 && op != 3 && op != 4 && op != 5 && op != 6 && op != 7) {
			System.out.println("");
			System.out.println("Anda Memasukkan Menu yang salah, silahkan ulangi");
			System.out.println("Masukkan pilihan menu yang diinginkan : ");
			System.out.println("MENU PROGRAM");
			System.out.println("1. Determinan");
			System.out.println("2. Invers");
			System.out.println("3. Sistem Persamaan Linear");
			System.out.println("4. Perkalian Matriks");
			System.out.println("5. Penjumlahan Matriks");
			System.out.println("6. Pengurangan Matriks");
			System.out.println("7. Keluar");
			System.out.print("Masukkan pilihan menu yang diinginkan : ");
			op = sc.nextInt();
		}
		System.out.println("");
		if (op == 1) {
			MenuDeterminan();
		} else if (op == 2) {
			MenuInvers();
		} else if (op == 3) {
			MenuSPL();
		} else if (op == 4) {
			MenuPerkalian();
		} else if (op == 5) {
			MenuPenjumlahan();
		} else if (op == 6) {
			MenuPengurangan();
		} else if (op == 7) {
			Exit();
		}
	}

	public void Exit() {
		// Exit
		System.exit(0);
	}
}
