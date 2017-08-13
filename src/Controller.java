import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

/**
 * Created by JohnPank on 20.07.17
 */
public class Controller {

    @FXML
    Button btnGen, btnExit;

    @FXML
    Label labelLength;

    @FXML
    CheckBox checkDigit, checkUpper, checkRus, checkSpec, checkEn;

    @FXML
    TextField textPassword;

    @FXML
    Slider sliderLength;

    public void initialize(){

        PasswordGenCore passwordGenCore = new PasswordGenCore();
        labelLength.setText("Password length: " + String.valueOf((int)sliderLength.getValue()));

        //обработка кнопки Exit
        btnExit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.exit(0);
            }
        });

        //обработка кнопки Generate
        btnGen.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                passwordGenCore.reset();

                if(checkSpec.isSelected())
                    passwordGenCore.addSpec();

                if (checkDigit.isSelected())
                    passwordGenCore.addDigit();

                if(checkRus.isSelected()){
                    passwordGenCore.addLowerRus();
                    if(checkUpper.isSelected())
                        passwordGenCore.addUpperRus();
                }

                if(checkEn.isSelected()){
                    passwordGenCore.addLowerEn();
                    if(checkUpper.isSelected())
                        passwordGenCore.addUpperEn();
                }

                textPassword.setText(passwordGenCore.generateNext((int) sliderLength.getValue()));
            }
        });

        //обработка слайдера
        sliderLength.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                labelLength.setText("Password length: " + String.valueOf((int)sliderLength.getValue()));
            }
        });

        sliderLength.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                labelLength.setText("Password length: " + String.valueOf((int)sliderLength.getValue()));
            }
        });
    }
}
