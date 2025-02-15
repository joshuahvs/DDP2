import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class SofitaGrader {
    static Scanner sc = new Scanner(System.in);
    static File direktoriUtama = new File(".");
    // Main method untuk menjalankan program
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to SOFITA GRADER!");
            while (true) {
                printWelcomingMsg();
                System.out.print("Input: ");
                int actionCode = sc.nextInt();
                sc.nextLine();
                switch (actionCode) {
                    case 1:
                        buatQuiz();
                        break;
                    case 2:
                        jawabQuiz();
                        break;
                    case 3:
                        nilaiQuiz();
                        break;
                    case 10:
                        System.out.println("Terima kasih sudah memakai SOFITA GRADER!");
                        sc.close();
                        return;
                    default:
                    System.out.println("Invalid input. Masukkan perintah yang valid");
                    break;
                }
            }
            // Implement the logic for handling exceptions
            //exception untuk kuis tidak valid dan input tidak valid
        } catch(InvalidQuizException e) {
            System.out.println("Tidak valid");
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Masukkan perintah yang valid");
        }
    }
    //method yang berfungsi print welcome message dan menu
    public static void printWelcomingMsg() {
        System.out.println("=".repeat(64));
        System.out.println("Silakan pilih salah satu opsi berikut:");
        System.out.println("[1] Buat Quiz baru");
        System.out.println("[2] Input Jawaban Quiz");
        System.out.println("[3] Nilai Jawaban Quiz");
        System.out.println("[10] Exit");
        System.out.println("=".repeat(64));
    }
    // method untuk membuat kuis, dan akan throw invalid question exception jika error
    public static void buatQuiz() throws SofitaGrader.InvalidQuizException {
        System.out.println("\n---BUAT QUIZ---");
        // Implement the logic for creating a new quiz
        File newFolder = makeFile();
        if (newFolder.exists()) {
            makeKJ(newFolder);
        }
    }
    // method untuk menjawab kuis, dan membuat file baru dengan nama murid sebagai nama txt nya
    public static void jawabQuiz() {
        System.out.println("\n---JAWAB QUIZ---");
        System.out.println("Berikut adalah daftar folder yang ada:\n-----------------------------");
        printCurrentDirectory();
        System.out.println("-----------------------------\n");
        File pilihFolder = aksesFolder();
        // jika folder tidak ditemukan 
        while (pilihFolder == null) {
            System.out.println("Input tidak valid. Masukkan nama folder yang valid.");
            pilihFolder = aksesFolder();
        }
        //jika folder ditemukan
        if (pilihFolder != null) {
            makeJawaban(pilihFolder);
        }
    }
    // method untuk menulai quiz dan menyimpan nilai rekapan quiz
    public static void nilaiQuiz() {
        System.out.println("\n---NILAI QUIZ---");
        System.out.println("Berikut adalah daftar folder yang ada:\n-----------------------------");
        //mengecheck apakah sudah ada folder yang dibuat
        File[] folders = direktoriUtama.listFiles(File::isDirectory);
        if (folders.length == 0){
            System.out.println("Belum ada folder yang dibuat!");
            System.out.println("-----------------------------");
            return;
        }
        printCurrentDirectory();
        System.out.println("-----------------------------\n");
        // mengakses folder yang diinginkan
        File pilihFolder = aksesFolder();
        while (pilihFolder == null) {
            System.out.println("Input tidak valid. Masukkan nama folder yang valid.");
            pilihFolder = aksesFolder();
        }
        //mengecheck apakah nilai rekap nilai sudah ada
        File rekapSebelumnya = findFile(pilihFolder, String.format("Nilai Rekap %s.txt", pilihFolder.getName()));
        if (rekapSebelumnya != null) {
            rekapSebelumnya.delete();
            System.out.println("-------------------------------------");
            System.out.println("| ! Nilai Rekap akan di-overwrite ! |");
            System.out.println("-------------------------------------");
        }
        //mengecheck apakan sudah ada jawaban murid di folder
        File[] files = pilihFolder.listFiles();
        if (files.length == 1) {
            System.out.println("Belum ada yang input jawaban");
            return;
        }
        
        File kjQuiz = findFile(pilihFolder, String.format("KJ %s.txt", pilihFolder.getName()));

        try {
            // mengimplementasikan logika untuk menilai kuis dengan membandingkannya dengan kjQuiz dan membuat file rekap jawaban
            System.out.println("Isi Rekap Nilai " + pilihFolder.getName() + ":");
            File rekapFile = new File(pilihFolder, "Nilai Rekap " + pilihFolder.getName() + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(rekapFile));
            for (File file : files) {
                if (!file.getName().contains("KJ")){
                    int matchingLines = countMatchingLines(file, kjQuiz);
                    int jumlahSoal = hitungSoal(kjQuiz);
                    double nilai = (double) matchingLines / jumlahSoal * 100;
                    String formattedNilai = String.format("%.2f%%", nilai);
                    System.out.println(file.getName().replace(".txt", "") + ": " + formattedNilai);
                    writer.write(file.getName().replace(".txt", "") + ": " + formattedNilai + "\n");
                }
            }
            writer.close();
            //Implement the logic for handling exceptions
        } catch (Exception e) {
            System.out.println("Terjadi Error");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////

    //Methid untuk membuat folder baru
    public static File makeFile() throws InvalidQuizException {
        System.out.print("Masukkan nama folder baru: ");
        String inputNama = sc.nextLine();

        File contents[] = direktoriUtama.listFiles();

        for (File file : contents) {
            if (file.getName().equals(inputNama)) {
                System.out.println("Nama sudah terambil!");
                throw new InvalidQuizException();
            }
        }
        if (inputNama.contains("/")){
            throw new InvalidQuizException();
        }
        File folderBaru = new File(inputNama);
        folderBaru.mkdir();
        System.out.printf("Berhasil buat folder dengan nama %s\n\n", inputNama);
        return folderBaru;
    }

    //method untuk membuat kunci jawaban
    public static void makeKJ(File folderQuiz) {
        // Implement the logic for creating quiz answers
        // mengutilisasi bufferwriter untuk menulis ke file txt
        try {
            System.out.println("Silahkan  input KJ untuk " + folderQuiz.getName());
            System.out.print("Jumlah soal: ");
            int jumlahSoal = sc.nextInt();
            File kjFile = new File(folderQuiz, "KJ " + folderQuiz.getName() + ".txt");
            if (kjFile.createNewFile() == true) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(kjFile));
                int counter = 1;
                sc.nextLine();
                while (counter != jumlahSoal + 1) {
                    System.out.print(counter + ". ");
                    String jawaban = sc.nextLine();
                    if (jawaban.equals("A") || jawaban.equals("B") || jawaban.equals("C") || jawaban.equals("D")) {
                        writer.write(counter + ". " + jawaban + "\n");
                        counter++;
                    } else {
                        System.out.println("Input tidak valid. Masukkan A, B, C, atau D.");
                    }
                }
                writer.close();
                System.out.println("Berhasil buat file " + kjFile.getName());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan");
        } catch (IOException e){
            System.out.println("error oopsie");
        }
    }
    // method untuk mengisi jawaban murid 
    public static void makeJawaban(File folderQuiz) {
        System.out.print("Masukkan nama murid: ");
        String namaMurid = sc.nextLine();
        // Implement the logic for creating a new answer file
        try {
            File fileName = findFile(folderQuiz, "KJ " + folderQuiz.getName() + ".txt");
            int jumlahSoal = hitungSoal(fileName);
            File jawabanMuridSebelumnya = findFile(folderQuiz, namaMurid + ".txt");
            if (jawabanMuridSebelumnya != null) {
                jawabanMuridSebelumnya.delete();
                System.out.println("-------------------------------------");
                System.out.println("| ! Jawaban akan di-overwrite ! |");
                System.out.println("-------------------------------------");
            }
            int counter = 1;
            File jawabanMurid = new File(folderQuiz, namaMurid + ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(jawabanMurid));
            System.out.println("Masukkan jawaban:");
            //meminta masukan jawaban dan menulis ke file
            while (counter != jumlahSoal + 1) {
                System.out.print(counter + ". "); 
                String jawaban = sc.nextLine();
                if (jawaban.equals("A") || jawaban.equals("B") || jawaban.equals("C") || jawaban.equals("D")){
                    writer.write(counter + ". " + jawaban);
                    writer.newLine(); 
                    counter++;
                } else{
                    System.out.println("Input tidak valid. Masukkan A, B, C, atau D.");
                }
            }
            writer.close();
            System.out.println("Berhasil buat file " + jawabanMurid.getName());
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }catch (IOException e) {
            System.out.println(" IO error oopsie");
        }
    }

    //method untuk mengakses folder yang diinginkan
    public static File aksesFolder() {
        System.out.print("Pilih nama folder untuk diakses: ");
        String fileToAccess = sc.nextLine();

        File[] folders = direktoriUtama.listFiles(File::isDirectory);
        for (File folder : folders) {
            if (folder.getName().equals(fileToAccess)) {
                return folder;
            }
        }
        return null;
    }
    //method untuk mencari file didalam folder
    public static File findFile(File selectedFolder, String fileName) {
        // TODO: Implement the logic for finding a file in the given folder
        File[] filesInFolder = selectedFolder.listFiles();
        if (filesInFolder != null) {
            for (File file : filesInFolder) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }
    // method untuk mencocokan berapa line yang sama dengan kunci jawaban dan return integernya
    public static int countMatchingLines(File file, File kjFile) {
        // TODO: Implement the logic for counting matching lines between two files
        int matchingLines = 0;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            BufferedReader kjFileReader = new BufferedReader(new FileReader(kjFile));

            String fileLine;
            String kjFileLine;

            // Read lines from both files and compare
            while ((fileLine = fileReader.readLine()) != null && (kjFileLine = kjFileReader.readLine()) != null) {
                // Assuming case-sensitive comparison, you can change it to case-insensitive if
                // needed
                if (fileLine.equals(kjFileLine)) {
                    matchingLines++;
                }
            }
            fileReader.close();
            kjFileReader.close();
        } catch (IOException e) {
            System.out.println("error");
        }

        return matchingLines;
    }
    // class untuk InvalidQuizException
    public  static class InvalidQuizException extends Exception {
        public InvalidQuizException() {
            super("Nama quiz tidak valid. Periksa kembali nama foldernya.");
        }
    }
    

    /**
     * Prints the names of all files in the given folder that do not have a ".java"
     * extension.
     *
     * @param folderName the folder to search for files
     */

    public static void printCurrentDirectory() {
        printFiles(direktoriUtama);
    }

    /**
     * Prints the names of all files in the given folder that have a ".java"
     * extension.
     *
     * @param folderName the folder to search for files
     */
    public static void printFiles(File folderName) {
        File contents[] = folderName.listFiles();
        for (File file : contents) {
            if (!file.getName().endsWith(".java")) {
                System.out.printf("> %s\n", file.getName());
            }
        }
    }

    /**
     * Calculates the number of questions in a given file.
     * 
     * @param file the file containing the questions
     * @return the number of questions in the file
     * @throws IOException if an I/O error occurs while reading the file
     */
    public static int hitungSoal(File file) throws IOException {
        Scanner reader = new Scanner(file);
        int soalCount = 0;
        while (reader.hasNextLine()) {
            reader.nextLine();
            soalCount++;
        }
        reader.close();
        return soalCount;
    }
}
