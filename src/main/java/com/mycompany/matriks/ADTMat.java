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

	}

	// public double EkspansiKofaktor(MATRIKS M) {

	// }

	// public void DeterminanKofaktor(MATRIKS M) {

	// }

	// public double KofakElmt(MATRIKS M, int i, int j) {

	// }

	// public MATRIKS MATRIKSKofaktor(MATRIKS M) {

	// }

	public void MATRIKSKofaktor2(MATRIKS M) {

	}

	// public void Segiatas(MATRIKS M) {

	// }

	// public void Segibawah(MATRIKS M) {

	// }

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

	public void EliminasiOBE(MATRIKS M, int indeks) {
		// I.S MATRIKS
		// F.S dieliminasikan baris dengan indeks indeks
		int i, j, a;
		// buat semua dimulai dengan angka 1
		for (i = 0; i < M.NBaris; i++) {
			BagiBaris(M, i);
		}
		j = 0;
		while (M.Data[indeks][j] != 1 && j < M.NKolom) {
			j += 1;
		}
		if (j < M.NKolom) {
			for (i = indeks + 1; i < M.NBaris; i++) {
				if (M.Data[i][j] == 1) {
					for (a = j; a < M.NKolom; a++) {
						M.Data[i][a] -= M.Data[indeks][a];
					}
				}
			}
		}
	}

	public void EliminasiOBEjordan(MATRIKS M, int indeks) {
		// I.S INPUTAN MATRIKS dan Indeks yang akan menjadi acuan untuk dikurangi 
		// F.S semua diatas angka 1 adalah 0 
		int i,j,a;
		double kali; 
		j = 0;
		while (j < M.NKolom && M.Data[indeks][j] != 1){
			j+=1;
		}
		if (j < M.NKolom){
			for (i=0; i < indeks; i++){
				if (M.Data[i][j] != 0){
					kali = M.Data[i][j];
					for (a=j; a < M.NKolom; a++){
						if (j < M.NKolom -1){
							M.Data[i][a] -= (M.Data[indeks][a] * kali);
						}
					}
				}
			}
		}
	}

	public void GaussSPL(MATRIKS M) {
		// I.S Matriks M
		// F.S Matriks Eksilon Terbentuk
		int i;
		for (i = 0; i < M.NBaris - 1; i++) {
			SortBaris(M);
			EliminasiOBE(M, i);
		}
		BagiBaris(M, i);
	}

	public void GaussJordan(MATRIKS M) {
		// I.S MATRIKS M
		// F.S matriks echelon tereduksi 
		int i;
		GaussSPL(M);
		for (i = 1; i < M.NBaris; i++){
				EliminasiOBEjordan(M, i);
		}
	}

	public void eliminasiBaris(MATRIKS M) {
		// Mengeliminasi baris yang isallzero
		int i, j, eliminasi;
		MATRIKS M1 = new MATRIKS();
		eliminasi = 0;
		for (i = 0; i < M.NBaris; i++) {
			if (isAllZero(M, i)) {
				eliminasi += 1;
			}
		}
		i = 0;
		// BUAT matriks baru
		BuatMATRIKS(M.NBaris - eliminasi, M.NKolom, M1);
		for (i = 0; i < M1.NBaris; i++) {
			for (j = 0; j < M1.NKolom; j++) {
				M1.Data[i][j] = M.Data[i][j];
			}
		}
		// Copy matriks
		BuatMATRIKS(M1.NBaris, M1.NKolom, M);
		for (i = 0; i < M1.NBaris; i++) {
			for (j = 0; j < M1.NKolom; j++) {
				M.Data[i][j] = M1.Data[i][j];
			}
		}
	}

	public Boolean isFree(MATRIKS M, int j) {
		//  APAKAH MATRIKS dengan indeks  kolom j free
		int i;
		boolean isfree;
		isfree = true;
		for (i=0; i < M.NBaris; i++ ){
			if (M.Data[i][j]  != 0){
				isfree = false;
			}
		}
		return isfree;
	}

	public boolean isAllZero(MATRIKS M, int i) {
		// apakah pada baris tersebut semuanya bernilai 0
		int j;
		boolean isZero = true;
		for (j =0; j <M.NKolom; j++){
			if (M.Data[i][j] != 0){
				isZero = false;
			}
		}
		return isZero;
	}

	public void solusiGauss(MATRIKS M) {
		// I.S MATRIKS M 
		// F.S SOLUSI DARI MATRIKS 
		MATRIKS Gauss = new MATRIKS();
		CopyMATRIKS(M, Gauss);
		int i,j,now;
		boolean firstparam;
		String[] solusi = new String[100];
		for (i = 1; i < M.NBaris; i++){
			EliminasiOBEjordan(M, i);
		}
		eliminasiBaris(M);
		// variabel yang sebenarnya tidak berguna
		for (j=0; j < M.NKolom - 1; j++){
			if (isFree(M,j)){
				solusi[j] = "Free";
			} else {
				solusi[j] = ParametrikOrUnik(M,j);
			}
		}
		for (i=0; i < M.NBaris; i++){
			now = 99;
			firstparam = true;
			for (j=0; j <M.NKolom-1; j++){
				if (M.Data[i][j]!= 0){
					if (solusi[j] == "Unik" && now != 99){
						solusi[j] = "Parametrik";
					}
					if (solusi[j] == "Unik" && M.Data[i][j]==1){
						now = j ;
						if (M.Data[i][M.NKolom-1]==0){
							solusi[j] ="X"+String.valueOf(j+1)+" :" +" 0" ;
						} else {
							solusi[j] ="X"+String.valueOf(j+1)+" : " + String.format("%.2f",M.Data[i][M.NKolom-1]);
						}
					}
					if (solusi[j] == "Parametrik"){
						if (firstparam && M.Data[i][M.NKolom-1]==0){
							solusi[now] = solusi[now] +" "+String.valueOf(M.Data[i][j]*-1)+"X"+String.valueOf(j+1);
							firstparam = false;
						} else {
							solusi[now] = solusi[now] +" + "+String.valueOf(M.Data[i][j]*-1)+"X"+String.valueOf(j+1);
						} 
					}
				}
			}
		}
		System.out.println("Solusinya adalah :");
		for (j=0; j < M.NKolom - 1; j++){
			if (solusi[j]=="Free" || solusi[j]=="Parametrik"){
				solusi[j] = "X"+String.valueOf(j+1)+" : " + "Free";
			}
			System.out.println(solusi[j]);
			M.Deskripsi[j] = "\n" + solusi[j];
		}
		M.NDeskripsi = M.NKolom - 1;
		CopyMATRIKS(Gauss, M);
	}

	public String ParametrikOrUnik(MATRIKS M, int j) {
		//  APAKAH MATRIKS dengan indeks  kolom parametrik
		int i, notzero, satu;
		notzero = 0;
		satu = 0;
		for (i=0; i < M.NBaris; i++ ){
			if (M.Data[i][j]  != 0){
				notzero = notzero + 1;
			}
			if (M.Data[i][j]  == 1){
				satu = satu + 1;
			}
		}
		if (satu ==1 && notzero ==1){
			return "Unik";
		} else {
			return "Parametrik";
		}
	}

	public void solusiGaussJordan(MATRIKS M) {
		// I.S MATRIKS M 
		// F.S SOLUSI DARI MATRIKS 
		int i,j,now;
		boolean firstparam;
		String[] solusi = new String[100];
		
		// variabel yang sebenarnya tidak berguna
		for (j=0; j < M.NKolom - 1; j++){
			if (isFree(M,j)){
				solusi[j] = "Free";
			} else {
				solusi[j] = ParametrikOrUnik(M,j);
			}
		}
		for (i=0; i < M.NBaris; i++){
			now = 99;
			firstparam = true;
			for (j=0; j <M.NKolom-1; j++){
				if (M.Data[i][j]!= 0){
					if (solusi[j] == "Unik" && now != 99){
						solusi[j] = "Parametrik";
					}
					if (solusi[j] == "Unik" && M.Data[i][j]==1){
						now = j ;
						if (M.Data[i][M.NKolom-1]==0){
							solusi[j] ="X"+String.valueOf(j+1)+" :"+" 0"  ;
						} else {
							solusi[j] ="X"+String.valueOf(j+1)+" : " + String.format("%.2f",M.Data[i][M.NKolom-1]);
						}
					}
					if (solusi[j] == "Parametrik"){
						if (firstparam && M.Data[i][M.NKolom-1]==0){
							solusi[now] = solusi[now] +" "+String.valueOf(M.Data[i][j]*-1)+"X"+String.valueOf(j+1);
							firstparam = false;
						} else {
							solusi[now] = solusi[now] +" + "+String.valueOf(M.Data[i][j]*-1)+"X"+String.valueOf(j+1);
						} 
					}
				}
			}
		}
		System.out.println("Solusinya adalah :");
		for (j=0; j < M.NKolom - 1; j++){
			if (solusi[j]=="Free" || solusi[j]=="Parametrik"){
				solusi[j] = "X"+String.valueOf(j+1)+" : " + "Free";
			}
			System.out.println(solusi[j]);
			M.Deskripsi[j] = "\n" + solusi[j];
		}
		M.NDeskripsi = M.NKolom - 1;
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
