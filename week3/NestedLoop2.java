public class NestedLoop2 {
    
        public static void main(String[] args) {
    
            int counter = 0;
    
            // Loop luar akan berjalan sebanyak 5 kali
            for (int i = 0; i < 5; i++) {
    
                // Loop dalam akan berjalan sebanyak 5 kali
                for (int j = 0; j < 5; j++) {
    
                    // Loop terdalam akan berjalan sebanyak 5 kali
                    for (int k = 0; k < 5; k++) {
    
                        // Jika nilai j sama dengan 2, maka loop terdalam akan
                        // keluar dari loop
                        if (j == 2) {
                            break;
                        }
    
                        // Menambahkan nilai 1 ke variabel counter
                        counter++;
                    }
                }
            }
    
            // Mencetak nilai variabel counter
            System.out.println(counter);
        }

    
}
