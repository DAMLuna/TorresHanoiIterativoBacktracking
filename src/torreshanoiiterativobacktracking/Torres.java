/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package torreshanoiiterativobacktracking;

import java.util.Stack;

/**
 *
 * @author Kerinvel
 */
public class Torres {

    Stack<Integer> torre1;
    Stack<Integer> torre2;
    Stack<Integer> torre3;

    public Torres(Stack<Integer> torre1, Stack<Integer> torre2, Stack<Integer> torre3) {
        this.torre1 = torre1;
        this.torre2 = torre2;
        this.torre3 = torre3;
    }

    
    
    public Torres() {
    }

    public Stack<Integer> getTorre1() {
        return torre1;
    }

    public void setTorre1(Stack<Integer> torre1) {
        this.torre1 = torre1;
    }

    public Stack<Integer> getTorre2() {
        return torre2;
    }

    public void setTorre2(Stack<Integer> torre2) {
        this.torre2 = torre2;
    }

    public Stack<Integer> getTorre3() {
        return torre3;
    }

    public void setTorre3(Stack<Integer> torre3) {
        this.torre3 = torre3;
    }

}
