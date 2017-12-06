package Misc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

interface CloseListener
{
    public void ClosePressed();
}
public class MessageBox extends JDialog
{
    private static MessageBox StaticInstance;
    MessageBox(JFrame f, String title, String message, ActionListener l)
    {
        super(f, title, true);
        Color backgroundColor = Color.white;
        int padding = 8;
        Insets insets = new Insets(padding, padding, padding, padding);
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(backgroundColor);
        panel.setBorder(new EmptyBorder(insets));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = insets;
        JTextArea ta = new JTextArea(message);
        ta.setEditable(false);
        ta.setFont(new java.awt.Font("Comic Sans MS", 0, 16));
        ta.setBackground(backgroundColor);
        gbc.gridy = 0;
        panel.add(ta, gbc);
        JButton OKButton = new JButton("OK");
        OKButton.setPreferredSize(new Dimension(80, 30));
        OKButton.setBackground(Color.blue);
        OKButton.setForeground(Color.white);
        OKButton.setFont(new java.awt.Font("Comic Sans MS", 0, 16));
        OKButton.addActionListener((ActionEvent e) ->
        {
            setVisible(false);
        });
        OKButton.addActionListener(l);
        gbc.gridy = 1;
        panel.add(OKButton, gbc);
        add(panel);
        setResizable(false);
        pack();
        if (getWidth() < 300)
            setPreferredSize(new Dimension(300, getHeight()));
        pack();
        setLocationRelativeTo(null);
        getContentPane().setBackground(backgroundColor);
    }
    public static void Show(JFrame f, String message)
    {
        StaticInstance = new MessageBox(f, "", message, null);
        StaticInstance.setVisible(true);
    }
    public static void Show(JFrame f, String title, String message)
    {
        StaticInstance = new MessageBox(f, title, message, null);
        StaticInstance.setVisible(true);
    }
    public static void Show(JFrame f, String message, ActionListener l)
    {
        StaticInstance = new MessageBox(f, "", message, l);
        StaticInstance.setVisible(true);
    }
    public static void Show(JFrame f, String title, String message, ActionListener l)
    {
        StaticInstance = new MessageBox(f, title, message, l);
        StaticInstance.setVisible(true);
    }
}
