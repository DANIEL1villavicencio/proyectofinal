package trabajo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String marca;
        String placa;
        boolean tipo = false;
        boolean traslado = false;
        int diaDePago;
        int emisionDePago;
        double valorLiquidacion;
        int opcion1;
        List<Auto> autos = new ArrayList<>();
        ;
        int opcion;
        do {
            marca = JOptionPane.showInputDialog("Ingrese la marca de carro");
            placa = (JOptionPane.showInputDialog("Ingrese la placa"));
            do {
                opcion1 = Integer.parseInt(JOptionPane.showInputDialog("su carro es un transporte publico?\n (presione 1 para si o 2 para no)"));
                if (opcion1 != 1 && opcion1 != 2) {
                    JOptionPane.showMessageDialog(null, "opcion no valida");
                } else {
                    switch (opcion1) {
                        case 1:
                            tipo = true;
                            break;
                        case 2:
                            tipo = false;
                            break;
                    }
                }
            } while (opcion1 != 1 && opcion1 != 2);
            do {
                opcion1 = Integer.parseInt(JOptionPane.showInputDialog("su carro va a ser trasladado?\n (presione 1 para si o 2 para no)"));
                if (opcion1 != 1 && opcion1 != 2) {
                    JOptionPane.showMessageDialog(null, "opcion no valida");
                } else {
                    switch (opcion1) {
                        case 1:
                            traslado = true;
                            break;
                        case 2:
                            traslado = false;
                            break;
                    }
                }
            } while (opcion1 != 1 && opcion1 != 2);
            diaDePago = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de pago"));
            emisionDePago = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia de la emision de pago"));
            valorLiquidacion = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de la liquidacion"));
            Liquidacion auto = new Liquidacion(marca, placa, tipo, diaDePago, emisionDePago, valorLiquidacion, traslado);
            autos.add(auto);
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Menu\n 1. Calcular descuento pronto pago\n 2. Calcular descuento transporte publico\n 3. Calcular descuento traslado\n 4. Calcular todos los descuentos\n\n 5. salir"));
            switch (opcion) {
                case 1:
                    auto.CalcularDescuentoProntoPago();
                    break;
                case 2:
                    auto.CalcularDescuentoServicioPublico();
                    break;
                case 3:
                    auto.CalcularDescuentotrasladoo();
                    break;
                case 4:
                    auto.CalcularDescuentoProntoPago();
                    auto.CalcularDescuentoServicioPublico();
                    auto.CalcularDescuentotrasladoo();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "fin del programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "no existe esta opcion");
                    break;
            }
        } while (opcion != 5);
    }
}