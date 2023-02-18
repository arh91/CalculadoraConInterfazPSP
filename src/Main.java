package CalculadoraCliente.src;

import com.trolltech.qt.gui.QApplication;

public class Main {

    public static void main(String[]args){
        QApplication.initialize(args);
        QApplication.setStyle("plastique");
        Cliente c = new Cliente();
        c.show();
        QApplication.execStatic();
        QApplication.shutdown();
    }
}
