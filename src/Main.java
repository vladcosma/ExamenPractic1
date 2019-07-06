import Domain.*;
import Repository.FileRepository;
import Repository.IRepository;
import Service.ExaminareService;
import Service.ExaminatorService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage newStage) throws Exception{

        IValidator<Examinator> examinatorValidator = new ExaminatorValidator();
        IRepository<Examinator> examinatorRepository= new FileRepository<>(examinatorValidator, "examinators.json", Examinator[].class);
        ExaminatorService examinatorService = new ExaminatorService(examinatorRepository);

        IValidator<Examinare> examinareValidator = new ExaminareValidator();
        IRepository<Examinare> examinareRepository= new FileRepository<>(examinareValidator, "examinares.json", Examinare[].class);
        ExaminareService examinareService = new ExaminareService(examinareRepository);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = fxmlLoader.load();
        Controller mainController = fxmlLoader.getController();
        mainController.setServices(examinatorService,examinareService);
        newStage.setTitle("Examinari");
        newStage.setScene(new Scene(root, 700, 700));
        newStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
