import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;

public class App extends Application {
    // Atribut yang diperlukan
    private ChoiceBox<String> genderChoiceBox;
    private TextField weightInput;
    private TextField heightInput;
    private Text hasilBeratBadanIdealText;
    private Text hasilBMIText;
    private Text hasilKlasifikasiText;

    // Main method
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    // Method start
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Mengatur title dan Vbox, bagian atas akan diberi teks dan bawahnya dibuat stackpane
        primaryStage.setTitle("BMI Calculator");
        VBox vBox = new VBox(20);
        addText(vBox);

        //Stack yang pertama adalah rectangle hitam, yang akan ditumpuk lagi dengan gridpane
        StackPane stack = new StackPane();
        Rectangle rect = new Rectangle(400, 500);
        GridPane contentBox = new GridPane();
        contentBox.setPadding(new Insets(50, 30, 20, 30));

        // Mengatur gridpane, dan memanggil fungsi yang diperlukan, mengatur colomn dan rownya juga
        contentBox.setVgap(25);
        contentBox.setHgap(40);
        chooseGender(contentBox, 0); // Row 0, Column 0
        chooseWeight(contentBox, 1); // Row 1, Column 0
        chooseHeight(contentBox, 2);
        pembatas(contentBox, 3);

        // Label
        labelBeratBadanIdeal(contentBox, 4);
        labelBMI(contentBox, 5);
        labelklasifikasi(contentBox, 6);

        // untuk menampilkan hasil perhitungan
        hasilBeratBadanIdeal(contentBox, 4);
        hasilBMI(contentBox, 5);
        hasilklasifikasi(contentBox, 6);


        // Membuat button yang akan menjalankan fungsi
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        Button computeButton = new Button("Compute!");
        Button exitButton = new Button("Exit");
        buttonBox.getChildren().addAll(computeButton, exitButton);
        GridPane.setConstraints(buttonBox, 0, 10, 2, 1); // colIndex, rowIndex, colSpan, rowSpan
        computeButton.setOnAction(this::computeButtonEventHandler);
        exitButton.setOnAction(this::exitEventHandler);

        // Menambahkan button ke gridpane lalu gridpane ke stackpane, dan stackpane ke vbox lalu menampilkannnya
        contentBox.getChildren().addAll(buttonBox);
        stack.getChildren().addAll(rect, contentBox);
        vBox.getChildren().add(stack);
        primaryStage.setScene(new Scene(vBox, 420, 550));
        primaryStage.show();
    }

    //Method untuk mengatur dan menambahkan teks "Welcome to BMI Calculator"
    private void addText(VBox pn) {
        pn.setAlignment(Pos.TOP_LEFT);
        pn.setSpacing(10);
        pn.setPadding(new Insets(10));
        Text title = new Text("Welcome to BMI Calculator");
        title.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
        pn.getChildren().add(title);
    }

    //Method untuk manampilkan label gender dan choiceBoxnya
    private void chooseGender(GridPane pn, int row) {
        Label label = new Label("Gender");
        // Mengatur warna dan ukuran dari label yang sesuai
        label.setTextFill(Color.WHITE); 
        label.setFont(Font.font(label.getFont().getFamily(), 15));
        GridPane.setConstraints(label, 0, row);

        genderChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList("Laki-Laki", "Perempuan"));
        GridPane.setConstraints(genderChoiceBox, 1, row); //Menempatkannya di row dan column yang sesuai
        pn.getChildren().addAll(label, genderChoiceBox);
    }


    // Method untuk menampilkan label berat badan dan text field untuk input dari usernya
    private void chooseWeight(GridPane pn, int row) {
        Label label = new Label("Berat Badang (kg)");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font(label.getFont().getFamily(), 15));
        GridPane.setConstraints(label, 0, row);

        weightInput = new TextField();
        GridPane.setConstraints(weightInput, 1, row); 
        pn.getChildren().addAll(label, weightInput);
    }

    // Method untuk menampilkan label tinggi badan dan text field untuk input dari user
    private void chooseHeight(GridPane pn, int row) {
        Label label = new Label("Tinggi Badan (cm)");
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font(label.getFont().getFamily(), 15));
        GridPane.setConstraints(label, 0, row);

        heightInput = new TextField();
        GridPane.setConstraints(heightInput, 1, row); 
        pn.getChildren().addAll(label, heightInput);
    }

    // Method untuk menambahkan pembatas yaitu teks "---- Hasil ----"
    private void pembatas(GridPane pn, int row) {
        Text title = new Text("---- Hasil ----");
        title.setFill(Color.WHITE);
        title.setFont(Font.font(title.getFont().getFamily(), 22));
        GridPane.setConstraints(title, 0, row); 
        pn.getChildren().addAll(title);
    }

    // Method untuk menampilkan label berat badan ideal
    private void labelBeratBadanIdeal(GridPane pn, int row) {
        Text title = new Text("Berat Badan Ideal");
        title.setFill(Color.WHITE);
        title.setFont(Font.font(title.getFont().getFamily(), 15));
        GridPane.setConstraints(title, 0, row); 
        pn.getChildren().addAll(title);
    }

    // Method untuk menampilkan label BMI
    private void labelBMI(GridPane pn, int row) {
        Text title = new Text("Index Massa Tubuh (BMI)");
        title.setFill(Color.WHITE);
        title.setFont(Font.font(title.getFont().getFamily(), 15));
        GridPane.setConstraints(title, 0, row); 
        pn.getChildren().addAll(title);
    }

    // Method untuk menampilakan label Klasifikasi
    private void labelklasifikasi(GridPane pn, int row) {
        Text title = new Text("Klasifikasi");
        title.setFill(Color.WHITE);
        title.setFont(Font.font(title.getFont().getFamily(), 15));
        GridPane.setConstraints(title, 0, row);
        pn.getChildren().addAll(title);
    }

    // Method untuk menampilkan hasil dari berat badan yang ideal
    private void hasilBeratBadanIdeal(GridPane pn, int row) {
        hasilBeratBadanIdealText = new Text("");
        hasilBeratBadanIdealText.setFill(Color.WHITE);
        hasilBeratBadanIdealText.setFont(Font.font(hasilBeratBadanIdealText.getFont().getFamily(), 15));
        GridPane.setConstraints(hasilBeratBadanIdealText, 1, row); // Specify row & column
        pn.getChildren().addAll(hasilBeratBadanIdealText);
    }

    // method yang menampilkan hasil BMI
    private void hasilBMI(GridPane pn, int row) {
        hasilBMIText = new Text("");
        hasilBMIText.setFill(Color.WHITE);
        hasilBMIText.setFont(Font.font(hasilBMIText.getFont().getFamily(), 15));
        GridPane.setConstraints(hasilBMIText, 1, row); 
        pn.getChildren().addAll(hasilBMIText);
    }

    // Method untuk menampilkan hasil klasifikasi
    private void hasilklasifikasi(GridPane pn, int row) {
        hasilKlasifikasiText = new Text("");
        hasilKlasifikasiText.setFill(Color.WHITE);
        hasilKlasifikasiText.setFont(Font.font(hasilKlasifikasiText.getFont().getFamily(), 15));
        GridPane.setConstraints(hasilKlasifikasiText, 1, row);
        pn.getChildren().addAll(hasilKlasifikasiText);
    }


    // Method untuk process even ketika tombol compute ditekan
    private void computeButtonEventHandler(ActionEvent event) {
        try {
            // Mengampil data dari input user
            String selectedGender = genderChoiceBox.getValue();
            double weight = Double.parseDouble(weightInput.getText());
            double height = Double.parseDouble(heightInput.getText());
            double bmi = (weight*10000)/(height*height);
            double beratideal=0;
            String hasilKlasifikasi;
            // Menghitung berat badan ideal berdasarkan gender
            if (selectedGender.equals("Perempuan")){
                beratideal = (height-100)-((height-100)*15/100);
            } else if (selectedGender.equals("Laki-Laki")){
                beratideal = (height-100)-((height-100)*10/100);
            }
            //Menampilkan hasil berat badan ideal dan BMI nya
            hasilBeratBadanIdealText.setText(String.format("%.2f", beratideal));
            hasilBMIText.setText(String.format("%.2f", bmi));

            // Menghitung BMI dan menampilkan hasilnya
            if (bmi<18.5){
                hasilKlasifikasi = "Underweight";
                hasilKlasifikasiText.setText(hasilKlasifikasi);
                hasilKlasifikasiText.setFill(Color.BLUE);
            }else if (18.5<=bmi && bmi<=24.9){
                hasilKlasifikasi = "Normal";
                hasilKlasifikasiText.setText(hasilKlasifikasi);
                hasilKlasifikasiText.setFill(Color.GREEN);
            }else if (25<=bmi&&bmi<=29.9){
                hasilKlasifikasi = "Overweight";
                hasilKlasifikasiText.setText(hasilKlasifikasi);
                hasilKlasifikasiText.setFill(Color.ORANGE);
            }else if (bmi>30){
                hasilKlasifikasi = "Obese";
                hasilKlasifikasiText.setText(hasilKlasifikasi);
                hasilKlasifikasiText.setFill(Color.RED);
            }
            //Jika terjadi error, berarti input yang diberikan tidak valid
        } catch (NumberFormatException e) {
            hasilBeratBadanIdealText.setText("Invalid input!");
            hasilBMIText.setText("Invalid input!");
            hasilKlasifikasiText.setText("Invalid input!");
            hasilKlasifikasiText.setFill(Color.WHITE);
        }
    }

    // Method yang akan memberhentikan program ketika tombol exit di klik
    private void exitEventHandler(ActionEvent event){
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close(); 
    }
}