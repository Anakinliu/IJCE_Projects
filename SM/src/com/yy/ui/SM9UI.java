package com.yy.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import com.yy.Main;
import com.yy.gm.sm3.SM3;
import com.yy.gm.sm4.SM4;
import com.yy.gm.sm9.KGC;
import com.yy.gm.sm9.KGCWithStandardTestKey;
import com.yy.gm.sm9.MasterKeyPair;
import com.yy.gm.sm9.MasterPrivateKey;
import com.yy.gm.sm9.MasterPublicKey;
import com.yy.gm.sm9.PrivateKey;
import com.yy.gm.sm9.PrivateKeyType;
import com.yy.gm.sm9.SM9;
import com.yy.gm.sm9.ResultKeyExchange;
import com.yy.gm.sm9.SM9Curve;
import com.yy.gm.sm9.ResultEncapsulate;
import com.yy.gm.sm9.ResultEncapsulateCipherText;
import com.yy.gm.sm9.G1KeyPair;
import com.yy.gm.sm9.ResultCipherText;
import com.yy.gm.sm9.ResultSignature;
import com.yy.gm.sm9.SM9Utils;
import com.yy.gm.sm9.SM9WithStandardTestKey;

import java.math.BigInteger;
/*
    AUTHOR: linux
    TIME: 2020/4/21
    GOOD LUCK AND NO BUG.
*/
public class SM9UI extends JFrame {
    private JTabbedPane tabbedPane;
    private JTabbedPane nestTabbedPane;
    private JPanel panel4;
    private JPanel nestPanel4;
    private JPanel nestPanel5;

    private SM9Curve sm9Curve;
//        Main.showMsg(sm9Curve.toString());
    public SM9UI(String title) throws HeadlessException {
        super(title);
        sm9Curve = new SM9Curve();

        initUI();
    }

    private void initUI() {
        setSize(750,750);

        tabbedPane=new JTabbedPane();   //创建选项卡面板对象
        nestTabbedPane = new JTabbedPane();
        panel4 = new JPanel();
        nestPanel4 = new JPanel();
        nestPanel5 = new JPanel();
        tabbedPane.addTab("SM9", null, panel4, "Forth Panel");
        tabbedPane.add("套娃", nestTabbedPane);
        nestTabbedPane.addTab("SM-1",null, nestPanel4, "4 Panel");
        nestTabbedPane.addTab("SM-2",null, nestPanel5, "5 Panel");

        this.add(tabbedPane);
        this.setBackground(Color.WHITE);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        curveMsg(sm9Curve.toString());

    }

    public void curveMsg(String curvePara) {
        final JTextArea curveTextArea = new JTextArea();
        Font font = new Font("宋体", Font.PLAIN, 13);
        curveTextArea.setColumns(90);
        curveTextArea.setLineWrap(false);
        curveTextArea.setFont(font);
        curveTextArea.setBorder(new EmptyBorder(0, 10, 0, 10));
        panel4.add(curveTextArea);
        curveTextArea.setText(curvePara);
    }

    public void inSignature() {

    }
    public void outSignature() {

    }

    public static void main(String[] args) {
        SM9UI w = new SM9UI("商密-SM9");
    }
}
