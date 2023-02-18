package CalculadoraCliente.src;

import com.trolltech.qt.gui.QApplication;

public class Cliente extends QDialog{
    private Ui_Dialog ui;

    public Cliente(){
        ui = new Ui_Dialog();
        ui.setupUi(this);
    }
}