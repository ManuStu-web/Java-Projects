package Project.FlappyBird;

import java.awt.*;
import java.awt.event.*;
import java.util.*;


import javax.swing.*;
import javax.swing.Timer;

public class FB extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 360;
    int boardHeight = 640;

    Image backgroundImg, birdImg, topPipeImg, bottomPipeImg;

    int birdX = boardWidth / 8;
    int birdY = boardHeight / 2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX, y = birdY;
        int width = birdWidth, height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    int pipeX = boardWidth, pipeY = 0;
    int pipeWidth = 64, pipeHeight = 512;

    class Pipe {
        int x = pipeX, y = pipeY;
        int width = pipeWidth, height = pipeHeight;
        Image img;
        boolean passed = false;

        Pipe(Image img) {
            this.img = img;
        }
    }

    JButton againPlay;
    JLabel GO;
    JPanel scorePanel;

    Bird bird;
    int VelocityX = -4;
    int gravity = 1;
    int VelocityY = 0;

    ArrayList<Pipe> pipes;
    Random random = new Random();
    Timer gameLoop, placePipeTimer;
    boolean gameOver = false;
    double score = 0;
    boolean uiDisplayed = false;

    public FB() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setLayout(null);  // Enable setBounds()
        setFocusable(true);
        addKeyListener(this);

        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        bird = new Bird(birdImg);
        pipes = new ArrayList<>();

        placePipeTimer = new Timer(1500, e -> placePipes());
        placePipeTimer.start();

        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();
    }

    public void placePipes() {
        int randomPipeY = pipeY - pipeHeight / 4 - random.nextInt(pipeHeight / 2);
        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y + pipeHeight + boardHeight / 4;
        pipes.add(bottomPipe);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

        for (Pipe pipe : pipes) {
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Raleway", Font.PLAIN, 32));

        if (gameOver && !uiDisplayed) {
            uiDisplayed = true;

            scorePanel = new JPanel();
            scorePanel.setBounds(70, 265, 240, 60); 
            scorePanel.setBackground(new Color(0, 0, 0, 120)); 
            scorePanel.setLayout(null); 
            add(scorePanel);

            GO = new JLabel("Game Over: " + (int) score);
            GO.setFont(new Font("Arial", Font.BOLD, 30));
            GO.setForeground(Color.WHITE);
            GO.setBounds(10, 5, 300, 50);
            scorePanel.add(GO);


            ImageIcon rawIcon = new ImageIcon(getClass().getResource("./PlayAgain.png"));
            Image scaled = rawIcon.getImage().getScaledInstance(150, 80,0);
            ImageIcon playIcon = new ImageIcon(scaled);

            againPlay = new JButton(playIcon);
            againPlay.setBorderPainted(false);
            againPlay.setContentAreaFilled(false);
            againPlay.setFocusPainted(false);
            againPlay.setBounds(100, 350, 150, 80);
            againPlay.setCursor(new Cursor(Cursor.HAND_CURSOR));
            add(againPlay);

            againPlay.addActionListener(this);
        } else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }

    public void move() {
        VelocityY += gravity;
        bird.y += VelocityY;
        bird.y = Math.max(bird.y, 0);

        for (Pipe pipe : pipes) {
            pipe.x += VelocityX;

            if (!pipe.passed && bird.x > pipe.x + pipe.width) {
                pipe.passed = true;
                score += 0.5;
            }

            if (collision(bird, pipe)) {
                gameOver = true;
            }
        }

        if (bird.y > boardHeight) gameOver = true;
    }

    public boolean collision(Bird a, Pipe b) {
        return a.x < b.x + b.width &&
               a.x + a.width > b.x &&
               a.y < b.y + b.height &&
               a.y + a.height > b.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == againPlay) {
            remove(scorePanel);
            remove(GO);
            remove(againPlay);
            GO = null;
            againPlay = null;
            uiDisplayed = false;

            bird.y = birdY;
            VelocityY = 0;
            pipes.clear();
            score = 0;
            gameOver = false;

            gameLoop.start();
            placePipeTimer.start();
            repaint();
            return;
        }

        move();
        repaint();

        if (gameOver) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }

    @Override public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) VelocityY = -9;
    }

    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}
