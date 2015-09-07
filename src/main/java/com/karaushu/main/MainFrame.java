package com.karaushu.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.karaushu.main.AudioUtil;

/**
 * @author Andrew Karauahu
 */
public class MainFrame extends JFrame {
    private JButton playButton;
    private JButton recButton;
    private JButton stopButton;
    private JLabel timeLabel;
    private JPanel buttonsPanel;
    private Timer timer;
    private int timerCount;

    public static final Dimension BUTTON_SIZE = new Dimension(100, 40);

    public MainFrame() {
        super();
        init();
        addListeners();
    }

    private void init() {

        recButton = new JButton("REC");
        recButton.setIcon(new ImageIcon("src/main/java/com/karaushu/resources/rec.png"));
        recButton.setPreferredSize(BUTTON_SIZE);
        playButton = new JButton("PLAY");
        playButton.setIcon(new ImageIcon("src/main/java/com/karaushu/resources/play.png"));
        playButton.setPreferredSize(BUTTON_SIZE);
        stopButton = new JButton("STOP");
        stopButton.setIcon(new ImageIcon("src/main/java/com/karaushu/resources/stop.png"));
        stopButton.setPreferredSize(BUTTON_SIZE);
        timeLabel = new JLabel("Record time:");
        timeLabel.setPreferredSize(new Dimension(150, 40));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        buttonsPanel = new JPanel();
        buttonsPanel.add(recButton);
        buttonsPanel.add(playButton);
        buttonsPanel.add(stopButton);
        setLayout(new BorderLayout(10, 10));
        setTitle("Audio Recorder");
        // setPreferredSize(new Dimension(500,300));
        add(buttonsPanel, BorderLayout.CENTER);
        add(timeLabel, BorderLayout.SOUTH);
        //---------
        playButton.setEnabled(false);
        stopButton.setEnabled(false);
    }

    private void addListeners() {
        recButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recButton.setIcon(new ImageIcon("src/main/java/com/karaushu/resources/rec-on.png"));

                stopButton.setEnabled(true);
                playButton.setEnabled(false);
                timer.start();
                AudioUtil.recordAudio();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recButton.setIcon(new ImageIcon("src/main/java/com/karaushu/resources/rec.png"));
                recButton.setEnabled(true);
                playButton.setEnabled(true);
                timer.stop();
                timerCount = 0;
                AudioUtil.isRunning = false;
            }
        });
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                recButton.setEnabled(true);
                stopButton.setEnabled(false);
                AudioUtil.playAudio();
                System.out.println("test");
            }
        });
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timerCount++;
                timeLabel.setText("Record time: " + timerCount + " sec");
            }
        });
    }


}
