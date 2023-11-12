package leetcode.demo.chat.client;

import leetcode.demo.chat.network.TCPConnection;
import leetcode.demo.chat.network.TCPConnectionListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientWindow extends JFrame implements ActionListener, TCPConnectionListener {


    private static final String IP_ADDRESS = "89.222.248.131";

    private static final int PORT = 8189;

    private static final int WIGHT = 600;

    private static final int HEIGHT = 400;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        new ClientWindow();
                    }
                }
        );

    }


    private final JTextArea log = new JTextArea();
    private final JTextArea fieldNickname = new JTextArea("anton");
    private final JTextArea fieldInput = new JTextArea();

    private TCPConnection connection;


    private ClientWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIGHT, HEIGHT);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        log.setEditable(false);
        log.setLineWrap(true);

        //    fieldInput.addActionListener(this);
        add(log, BorderLayout.CENTER);
        add(fieldNickname, BorderLayout.NORTH);
        add(fieldInput, BorderLayout.SOUTH);

        setVisible(true);
        try {
            connection = new TCPConnection(this, IP_ADDRESS, PORT);
        } catch (IOException e) {
            printMsg("Connection exception " + e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = fieldInput.getText();
        if (msg.equals("")) return;

        fieldInput.setText(null);
        connection.sendString(fieldNickname.getText() + ": " + msg);


    }


    @Override
    public synchronized void onConnectionReady(TCPConnection tcpConnection) {
        printMsg("Connection Ready...");

    }


    @Override
    public synchronized void onReceiveString(TCPConnection tcpConnection, String value) {
        printMsg("value");


    }


    @Override
    public synchronized void onDisconnect(TCPConnection tcpConnection) {
        printMsg("Connection Close...");

    }


    @Override
    public synchronized void onException(TCPConnection tcpConnection, Exception e) {

        printMsg("Connection exception " + e);
    }

    private synchronized void printMsg(String msg) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    @Override
                    public void run() {
                        log.append(msg + "/n");
                        log.setCaretPosition(log.getDocument().getLength());
                    }
                }
        );


    }
}
