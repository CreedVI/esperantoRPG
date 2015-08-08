package com.kappaDelta.espRPG;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class settingWindow extends JFrame implements java.awt.event.KeyListener{

    JButton btn;
    JLabel lbl;

    public settingWindow(){
        setTitle("");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(360, 360);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setLayout(new FlowLayout());

        btn = new JButton("Okej, dankon");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(btn)){
                    dispose();
                }
            }
        });

        lbl = new JLabel("Neniajxo estas cxi tie!\n");

        add(lbl);
        add(btn);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
