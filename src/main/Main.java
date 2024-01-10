/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;


import java.awt.Frame;
import view.LoginDiolog;
import view.MainFrame;
import view.MainSinhVienXem;


public class Main {

    private static Frame parent;
    public static void main(String[] args) {
//        new MainFrame().setVisible(true);
//        new MainSinhVienXem().setVisible(true);
         new LoginDiolog(parent, true).setVisible(true);
    }
}
