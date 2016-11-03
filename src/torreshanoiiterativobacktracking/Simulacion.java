/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torreshanoiiterativobacktracking;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Kerinvel
 */
public class Simulacion {

    Stack<Torres> estadotorres = new Stack<>();
    Stack<Torres> estadotorresAux = new Stack<>();
    Stack<Integer> to = new Stack<>();
    Stack<Integer> tx = new Stack<>();
    Stack<Integer> td = new Stack<>();
//    Stack<Integer> toAux = new Stack<>();
//    Stack<Integer> txAux = new Stack<>();
//    Stack<Integer> tdAux = new Stack<>();
    int ndisc, movAux;
    boolean reinicio;

    public void iniciar() {

        System.out.println("Introduce el número de discos que tendrá la partida:");
        ndisc = leerValorEntero();
        for (int i = ndisc; i > 0; i--) {
            to.push(i);
        }
        print(to, tx, td);
        while (td.size() != ndisc) {
            reinicio = false;
            if (to.empty()) {

            } else {
                if (tx.empty()) {
                    movimiento0();
                } else if (to.peek() < tx.peek()|| to.empty()) {
                    movimiento0();
                }
            }
            if (reinicio == false) {
                if (to.empty()) {

                } else {
                    if (td.empty()) {
                        movimiento1();
                    } else if (to.peek() < td.peek()|| to.empty()) {
                        movimiento1();
                    }
                }
            }
            if (reinicio == false) {
                if (tx.empty()) {

                } else {
                    if (to.empty()) {
                        movimiento2();
                    } else if (tx.peek() < to.peek()|| tx.empty()) {
                        movimiento2();
                    }
                }
            }
            if (reinicio == false) {
                if (tx.empty()) {

                } else {
                    if (td.empty()) {
                        movimiento3();
                    } else if (tx.peek() < td.peek()|| tx.empty()) {
                        movimiento3();
                    }
                }
            }
            if (reinicio == false) {
                if (td.empty()) {

                } else {
                    if (tx.empty()) {
                        movimiento4();
                    } else if (td.peek() < tx.peek()|| td.empty()) {
                        movimiento4();
                    }
                }
            }
            if (reinicio == false) {
                if (td.empty()) {

                } else {
                    if (to.empty()) {
                        movimiento5();
                    } else if (td.peek() < to.peek()|| td.empty()) {
                        movimiento5();
                    }
                }
            }
            if (reinicio == false) {
                backtraking();
            }
        }
    }


    public void guardarEstadoTorres() {
        Torres tor = new Torres(to, tx, td);
        estadotorres.push(tor);
        System.out.println(estadotorres.peek());
    }

    public void backtraking() {
        System.out.println("Se hizo backtracking");
        estadotorres.pop();
        to = estadotorres.peek().getTorre1();
        tx = estadotorres.peek().getTorre2();
        td = estadotorres.peek().getTorre3();
    }

    public void movimiento0() {
        //Hacemos el movimiento
        int encontrado = 0;
        movAux = to.pop();
        tx.push(movAux);
        //Lo guardamos en una pila auxiliar para comprobar si se repite
        Torres torAux = new Torres(to, tx, td);
        estadotorresAux.push(torAux);
        encontrado = estadotorres.search(estadotorresAux);
        System.out.println(encontrado);
        //Si se repite, retrocedemos en el movimiento, borramos estado auxiliar y salimos del método sin hacer cambios.
        //Si no se repite se mantiene el cambio lo comenta, lo guarda y sigue.
        if (encontrado >= 0) {
            movAux = tx.pop();
            to.push(movAux);
            estadotorresAux.pop();
        } else {
            guardarEstadoTorres();
            System.out.println("Movemos el disco de t. origen a t. auxiliar");
            print(to, tx, td);
            reinicio = true;
        }

    }

    public void movimiento1() {
        int encontrado = 0;
        movAux = to.pop();
        td.push(movAux);
        //Lo guardamos en una pila auxiliar para comprobar si se repite
        Torres torAux = new Torres(to, tx, td);
        estadotorresAux.push(torAux);
        encontrado = estadotorres.search(estadotorresAux);
        //Si se repite, retrocedemos en el movimiento, borramos estado auxiliar y salimos del método sin hacer cambios.
        //Si no se repite se mantiene el cambio lo comenta, lo guarda y sigue.
        if (encontrado >= 0) {
            movAux = td.pop();
            to.push(movAux);
            estadotorresAux.pop();
        } else {
            guardarEstadoTorres();
            System.out.println("Movemos el disco de t. origen a t. destino");
            print(to, tx, td);
            reinicio = true;
           
        }

    }

    public void movimiento2() {
        //Hacemos el movimiento
        int encontrado = 0;
        movAux = tx.pop();
        to.push(movAux);
        //Lo guardamos en una pila auxiliar para comprobar si se repite
        Torres torAux = new Torres(to, tx, td);
        estadotorresAux.push(torAux);
        encontrado = estadotorres.search(estadotorresAux);
        //Si se repite, retrocedemos en el movimiento, borramos estado auxiliar y salimos del método sin hacer cambios.
        //Si no se repite se mantiene el cambio lo comenta, lo guarda y sigue.
        if (encontrado >= 0) {
            movAux = to.pop();
            tx.push(movAux);
            estadotorresAux.pop();
        } else {
            guardarEstadoTorres();
            System.out.println("Movemos el disco de t. auxiliar a t. origen");
            print(to, tx, td);
            reinicio = true;
        }

    }

    public void movimiento3() {
        int encontrado = 0;
        //Hacemos el movimiento
        movAux = tx.pop();
        td.push(movAux);
        //Lo guardamos en una pila auxiliar para comprobar si se repite
        Torres torAux = new Torres(to, tx, td);
        estadotorresAux.push(torAux);
        encontrado = estadotorres.search(estadotorresAux);
        //Si se repite, retrocedemos en el movimiento, borramos estado auxiliar y salimos del método sin hacer cambios.
        //Si no se repite se mantiene el cambio lo comenta, lo guarda y sigue.
        if (encontrado >= 0) {
            movAux = td.pop();
            tx.push(movAux);
            estadotorresAux.pop();
        } else {
            guardarEstadoTorres();
            System.out.println("Movemos el disco de t. auxiliar a t. destino");
            print(to, tx, td);
            reinicio = true;
        }

    }

    public void movimiento4() {
        int encontrado = 0;
        //Hacemos el movimiento
        movAux = td.pop();
        tx.push(movAux);
        //Lo guardamos en una pila auxiliar para comprobar si se repite
        Torres torAux = new Torres(to, tx, td);
        estadotorresAux.push(torAux);
        encontrado = estadotorres.search(estadotorresAux);
        //Si se repite, retrocedemos en el movimiento, borramos estado auxiliar y salimos del método sin hacer cambios.
        //Si no se repite se mantiene el cambio lo comenta, lo guarda y sigue.
        if (encontrado >= 0) {
            movAux = tx.pop();
            td.push(movAux);
            estadotorresAux.pop();
        } else {
            guardarEstadoTorres();
            System.out.println("Movemos el disco de t. destino a t. auxiliar");
            print(to, tx, td);
            reinicio = true;
        }

    }

    public void movimiento5() {
        int encontrado = 0;
        //Hacemos el movimiento
        movAux = td.pop();
        to.push(movAux);
        //Lo guardamos en una pila auxiliar para comprobar si se repite
        Torres torAux = new Torres(to, tx, td);
        estadotorresAux.push(torAux);
        encontrado = estadotorres.search(estadotorresAux);
        //Si se repite, retrocedemos en el movimiento, borramos estado auxiliar y salimos del método sin hacer cambios.
        //Si no se repite se mantiene el cambio lo comenta, lo guarda y sigue.
        if (encontrado >= 0) {
            movAux = to.pop();
            td.push(movAux);
            estadotorresAux.pop();
        } else {
            guardarEstadoTorres();
            System.out.println("Movemos el disco de t. destino a t. origen");
            print(to, tx, td);
            reinicio = true;
        }

    }

    public void print(Stack to, Stack tx, Stack td) {
        System.out.println("Torre Origen:\t " + to);
        System.out.println("Torre Auxiliar:\t " + tx);
        System.out.println("Torre Destino:\t " + td);
        System.out.println("");
    }

    public String printest(Stack to, Stack tx, Stack td) {
        String prinTorres = "Torre Origen:\t " + to + "\nTorre Auxiliar:\t " + tx + "\nTorre Destino:\t " + td + "\n";
        return prinTorres;
    }

    public int leerValorEntero() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
