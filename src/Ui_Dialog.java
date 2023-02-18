/********************************************************************************
 ** Form generated from reading ui file 'CalculadoraCliente.src.Cliente.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/

package CalculadoraCliente.src;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Dialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton CJ_Button;
    public QPushButton X_Button;
    public QPushButton PR_Button;
    public QPushButton R_Button;
    public QPushButton asteriscoButton;
    public QLineEdit RespuestaServidor;
    public QLineEdit EntradaUsuario;

    public Ui_Dialog() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(708, 805).expandedTo(Dialog.minimumSizeHint()));
        CJ_Button = new QPushButton(Dialog);
        CJ_Button.setObjectName("CJ_Button");
        CJ_Button.setGeometry(new QRect(12, 10, 251, 161));
        X_Button = new QPushButton(Dialog);
        X_Button.setObjectName("X_Button");
        X_Button.setGeometry(new QRect(370, 10, 251, 161));
        PR_Button = new QPushButton(Dialog);
        PR_Button.setObjectName("PR_Button");
        PR_Button.setGeometry(new QRect(10, 190, 251, 161));
        R_Button = new QPushButton(Dialog);
        R_Button.setObjectName("R_Button");
        R_Button.setGeometry(new QRect(370, 190, 251, 161));
        asteriscoButton = new QPushButton(Dialog);
        asteriscoButton.setObjectName("asteriscoButton");
        asteriscoButton.setGeometry(new QRect(190, 380, 251, 161));
        RespuestaServidor = new QLineEdit(Dialog);
        RespuestaServidor.setObjectName("RespuestaServidor");
        RespuestaServidor.setGeometry(new QRect(60, 680, 531, 71));
        EntradaUsuario = new QLineEdit(Dialog);
        EntradaUsuario.setObjectName("EntradaUsuario");
        EntradaUsuario.setGeometry(new QRect(222, 590, 191, 31));
        retranslateUi(Dialog);

        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        CJ_Button.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "CJ", null));
        X_Button.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "X", null));
        PR_Button.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "PR", null));
        R_Button.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "R", null));
        asteriscoButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "*", null));
    } // retranslateUi



    //Método que devuelve true si una cadena contiene sólo números o false en caso contrario
    public static boolean contieneSoloNumeros(String cadena) {

        return cadena.matches("[0-9]+");
    }


    //Método que es true si la cadena contiene números o puntos
    public static boolean contieneSoloNumerosYPunto(String cadena) {

        return cadena.matches("[0-9.]+");
    }


    //Método que devuelve true si la cadena es un número decimal o false en caso contrario
    public static boolean esDecimal(String cadena){
        int contador = 0;
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            if(c=='.'){
                contador++;
            }
            if (c == '.' && x == 0) {
                return false;
            }
            if (c == '.' && x == cadena.length()-1) {
                return false;
            }
        }
        if(contador == 0){
            return false;
        }
        return true;
    }

}

