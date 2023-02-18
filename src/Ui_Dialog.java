/********************************************************************************
 ** Form generated from reading ui file 'CalculadoraCliente.src.Cliente.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Ui_Dialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton CJ_Button;
    public QPushButton X_Button;
    public QPushButton PR_Button;
    public QPushButton R_Button;
    public QPushButton asteriscoButton;
    public QLineEdit RespuestaServidor;
    public QLineEdit EntradaUsuario;
    public QPushButton enviarButton;
    public QLabel labelUsuario;
    public QLabel labelServidor;

    boolean CJPulsado = false;
    boolean XPulsado = false;
    boolean PRPulsado = false;
    boolean RPulsado = false;
    boolean asteriscoPulsado = false;

    String cadena;


    String Host = "localhost";
    int Puerto = 6000;  //Utilizamos el puerto 6000 para conectar el Cliente con el Servidor

    Socket Cliente = new Socket(Host, Puerto); //Conexión en local a través del puerto 6000

    // Creo flujo de salida al servidor
    PrintWriter cadenaEnviada = new PrintWriter(Cliente.getOutputStream(), true);
    PrintWriter cadenaEnviadaDos = new PrintWriter(Cliente.getOutputStream(), true);

    // Creo flujo de entrada para el servidor
    BufferedReader cadenaRecibida = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));

    // Creo flujo para entrada estándar
    BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));

    String boton = "", numero = "", respuestaServidor = "HOLA";



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
        asteriscoButton.setGeometry(new QRect(10, 380, 251, 161));
        RespuestaServidor = new QLineEdit(Dialog);
        RespuestaServidor.setObjectName("RespuestaServidor");
        RespuestaServidor.setGeometry(new QRect(60, 690, 531, 71));
        EntradaUsuario = new QLineEdit(Dialog);
        EntradaUsuario.setObjectName("EntradaUsuario");
        EntradaUsuario.setGeometry(new QRect(200, 600, 231, 31));
        enviarButton = new QPushButton(Dialog);
        enviarButton.setObjectName("enviarButton");
        enviarButton.setGeometry(new QRect(370, 380, 251, 161));
        labelUsuario = new QLabel(Dialog);
        labelUsuario.setObjectName("labelUsuario");
        labelUsuario.setGeometry(new QRect(270, 570, 101, 16));
        labelServidor = new QLabel(Dialog);
        labelServidor.setObjectName("label_2");
        labelServidor.setGeometry(new QRect(270, 660, 121, 16));
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
        enviarButton.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "ENVIAR", null));
        labelUsuario.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Entrada Usuario", null));
        labelServidor.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Respuesta Servidor", null));

        CJ_Button.clicked.connect(this, CJ());
        X_Button.clicked.connect(this, X());
        PR_Button.clicked.connect(this, PR());
        R_Button.clicked.connect(this, R());
        asteriscoButton.clicked.connect(this, enviarAsterisco());

        if(CJPulsado){
            enviarButton.clicked.connect(this, enviarDatosCJ(cadena));
        }
        if(XPulsado){
            enviarButton.clicked.connect(this, enviarDatosX(cadena));
        }
        if(PRPulsado) {
            enviarButton.clicked.connect(this, enviarDatosPR(cadena));
        }
        if(RPulsado) {
            enviarButton.clicked.connect(this, enviarDatosR(cadena));
        }
        if(asteriscoPulsado){
            enviarButton.clicked.connect(this, enviarAsterisco(cadena));
        }
    }



    } // retranslateUi


    public void CJ(){
            CJPulsado = true;
            RespuestaServidor.setText("Introduce un número en metros cuadrados.");
            numero = EntradaUsuario.getText();
    }

    public void X(){
        XPulsado = true;
        RespuestaServidor.setText("Introduce el número de meses que has trabajado.");
        numero = EntradaUsuario.getText();
    }

    public void PR(){
        PRPulsado = true;
        RespuestaServidor.setText("Introduce un número cualquiera.");
        numero = EntradaUsuario.getText();
    }

    public void R(){

        RPulsado = true;
        RespuestaServidor.setText("Introduce el precio de gasolina por litro que has pagado.");
        numero = EntradaUsuario.getText();
    }


    public void enviarDatosCJ(String numero){
        boton = "CJ";

        while(true) {
            if (contieneSoloNumeros(numero)) {
                break;
            }
            if (esDecimal(numero)) {
                RespuestaServidor.setText("Sólo se puede introducir un número entero.");
            } else {
                RespuestaServidor.setText("Introduce sólo caracteres numéricos.");
            }
        }

        while (boton != null && numero != null) {
            cadenaEnviada.println(boton); // envio cadena al servidor
            cadenaEnviadaDos.println(numero);
            try {
                respuestaServidor = cadenaRecibida.readLine(); // recibo cadena del servidor
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            RespuestaServidor.setText(respuestaServidor);

            /*if (respuestaServidor.equals("END!")) { // si la cadena recibida del servidor es END, finaliza conexión con el Servidor y fin de clase Cliente
                break;
            }*/
        }

    }

    public void enviarDatosX(String numero) {

    }

    public void enviarDatosPR(String numero) {

    }

    public void enviarDatosR(String numero) {

    }

    public void enviarAsterisco(String numero){

    }








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

