package controller;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.PackageHandler;
import org.w3c.dom.Text;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;

public class PackageHandlerController {
    @FXML
    private TextField packageId;
    @FXML
    private TextField packageHeight;
    @FXML
    private TextField packageWeight;
    @FXML
    private TextField packageValue;
    @FXML
    private Label extraheightFee;
    @FXML
    private Label extraweightFee;
    @FXML
    private Label systemFee;
    @FXML
    private Label totalCost;
    private PackageHandler packageHandler;




    @FXML
    public void initialize()
    {
        packageHandler= new PackageHandler();
    }






    public void calculatingfees(ActionEvent actionEvent) throws Exception{
        var objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        var objectMapperTime = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        var pkg = new PackageHandlerJson();

        // Ui-ra írás
        int standardfee=400;
        int v1 = Integer.parseInt(packageHandler.heightCost(packageHeight.getText()));
        int v2 = Integer.parseInt(packageHandler.weightCost(packageWeight.getText()));
        int v3 = Integer.parseInt(packageHandler.systemCost(packageValue.getText()));
        int total = v1+v2+v3+standardfee;
        extraheightFee.setText(packageHandler.heightCost(packageHeight.getText()) + " Ft");
        extraweightFee.setText(packageHandler.weightCost(packageWeight.getText()) + " Ft");
        systemFee.setText(packageHandler.systemCost(packageValue.getText()) + " Ft");
        totalCost.setText(String.valueOf(total) + " Ft");

        //Json
        var localDate = objectMapperTime.writeValueAsString(LocalDate.now());
        pkg.setPackageId(packageId.getText());
        pkg.setPackageHeight(Integer.parseInt(packageHeight.getText()));
        pkg.setPackageWeight(Integer.parseInt(packageWeight.getText()));
        pkg.setPackageValue(Integer.parseInt(packageValue.getText()));
        pkg.setPackageFees(total);
        pkg.setHandlingDate(localDate);
        try (var writer = new FileWriter("pkg.json")) {
            objectMapper.writeValue(writer, pkg);
        }
       System.out.println(objectMapper.readValue(new FileReader("pkg.json"), PackageHandlerJson.class));
    }
}
