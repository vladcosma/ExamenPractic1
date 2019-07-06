package UI;

import Domain.Examinare;
import Domain.Examinator;
import Service.ExaminatorService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {
    public TableView tableViewExaminator;
    public TableColumn ExaminatorId;
    public TableColumn ExaminatorNume;
    public TableColumn ExaminatorCnp;
    public TextField examinatorId;
    public TextField examinatorNume;
    public TextField examinatorCnp;

    public TextField searchNumeExaminator;
    public Button AddExaminator;
    public Button SortExaminator;
    public Button SearchExaminator;
    public Button RefreshExaminator;

    public TableView tableViewExaminare;
    public TableColumn ExaminareId;
    public TableColumn ExaminareIdexam;
    public TableColumn ExaminareRezultat;
    public TableColumn ExaminareZiua;
    public TextField examinareId;
    public TextField examinareIdexam;
    public TextField examinareRezultat;
    public TextField examinareZiua;
    public TextField searchIdexamExaminare;
    public Button AddExaminare;
    public Button SortExaminare;
    public Button SearchExaminare;
    public Button RefreshExaminare;


    private ExaminatorService examinatorService;
    private ObservableList<Examinator> examinators = FXCollections.observableArrayList();

    public void AddExaminator(ActionEvent actionEvent) {
        try {
            String id = examinatorId.getText();
            String nume = examinatorNume.getText();
            double cnp = Double.parseDouble(examinatorCnp.getText());

            examinatorService.add(id,nume,cnp);

            examinatorId.clear();
            examinatorNume.clear();
            examinatorCnp.clear();


            examinators.clear();
            examinators.addAll(examinatorService.getAll());

        } catch (RuntimeException ex) {
            Common.showValidationError(ex.getMessage());
        }
    }

    public void setServices(ExaminatorService examinatorService, Examinare examinareService) {
        this.examinatorService = examinatorService;
        this.examinareService = examinareService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            examinators.addAll(examinatorService.getAll());
            tableViewExaminator.setItems(examinators);
        });

        Platform.runLater(() -> {
            examinares.addAll(examinareService.getAll());
            tableViewExaminare.setItems(examinares);
        });
    }

    private Examinare examinareService;
    private ObservableList<Examinare> examinares = FXCollections.observableArrayList();

    public void AddExaminare(ActionEvent actionEvent) {
        try {
            String id = examinareId.getText();
            String idexam = examinareIdexam.getText();
            boolean rezultat; != Double.parseDouble(examinareRezultat.getText());
            double ziua = Double.parseDouble(examinareZiua.getText());
            examinareService.add(id,idexam,rezultat,ziua);

            examinareId.clear();
            examinareIdexam.clear();
            examinareRezultat.clear();
            examinareZiua.clear();

            examinares.clear();
            examinares.addAll(examinareService.getAll());

        } catch (RuntimeException ex) {
            Common.showValidationError(ex.getMessage());
        }
    }

    public void SortExaminare (ActionEvent actionEvent) {

        examinares.clear();
        List<Examinare> temp = examinareService.sort();
        examinares.addAll(temp);
    }

    public void SortExaminator (ActionEvent actionEvent) {

        examinators.clear();
        List<Examinator> temp = examinatorService.sort();
        examinators.addAll(temp);
    }

    public void RefreshExaminator (ActionEvent actionEvent) {
        examinators.clear();
        examinators.addAll(examinatorService.getAll());
    }

    public void RefreshExaminare (ActionEvent actionEvent) {
        examinares.clear();
        examinares.addAll(examinareService.getAll());
    }

    public void SearchExaminator (ActionEvent actionEvent) {
        examinators.clear();
        String nume = searchNumeExaminator.getText();
        examinators.addAll(examinatorService.cautareNume(nume));
    }

    public void SearchExaminare (ActionEvent actionEvent) {
        examinares.clear();
        String idexam = searchIdexamExaminare.getText();
        examinares.addAll(examinareService.cautareIdexam(idexam));
    }

}