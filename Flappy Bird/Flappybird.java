package Project.FlappyBird;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


import javax.swing.*;
import javax.swing.Timer;

public class FB extends JPanel implements ActionListener,KeyListener
{
    int boardWidth=360;
    int boardHeight=640;

    //Images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;

    //Bird
    int birdX = boardWidth/8;
    int birdY = boardHeight/2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird
    {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;  

        Bird(Image img)
        {
            this.img=img;
        }
    }

    //Pipes
    int pipeX = boardWidth;
    int pipeY=0;
    int pipeWidth=64;
    int pipeHeight=512;

    class Pipe
    {
        int x= pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed=false;

        Pipe(Image img)
        {
            this.img = img;
        }
    }


    //game logic
    Bird bird;
    int VelocityX=-4;//moves pipe to left speed
    int gravity =1;
    int VelocityY=0;

    ArrayList<Pipe> pipes;
    Random random = new Random();


    Timer gameLoop;
    Timer placePipeTimer;
    boolean gameOver=false;
    double score=0;

    public FB()
    {
        setPreferredSize(new Dimension(boardWidth , boardHeight));

        setFocusable(true);
        addKeyListener(this);
        //load Image
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        //bird
        bird = new Bird(birdImg); 
        pipes = new ArrayList<>();

        //pipe timer
        placePipeTimer = new Timer(1500 , new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                placePipes();
            }
        });

        placePipeTimer.start();

        //game timer
       gameLoop = new Timer(1000 / 60, this); 
       gameLoop.start();


    }

    public void placePipes()
    {
        int randomPipeY=(int)(pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
        Pipe topPipe = new Pipe(topPipeImg);
        int openingSpace = boardHeight/4;
        topPipe.y=randomPipeY; 
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y=topPipe.y + pipeHeight + openingSpace;
        pipes.add(bottomPipe); 
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        draw(g);
    }

    public void draw (Graphics g)
    {
        //background
        g.drawImage(backgroundImg, 0, 0, boardWidth , boardHeight,null);

        //bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

        //pipes
        for(int i=0;i<pipes.size();i++)
        {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        //score
        g.setColor(Color.black);
        g.setFont(new Font("Raleway",Font.PLAIN,32));
        if(gameOver)
        {
            g.drawString("GAME OVER: "+String.valueOf((int) score),60,300) ;
        }
        else
        {
            g.drawString(String.valueOf((int)score),10,35);
        }
        
    }

    public void move()
    {
        //bird
         VelocityY+=gravity;
         bird.y +=VelocityY;
         bird.y = Math.max(bird.y,0);

         //pipe
         for(int i=0;i<pipes.size();i++)
         {
            Pipe pipe = pipes.get(i);
            pipe.x+=VelocityX;

            if(!pipe.passed && bird.x>pipe.x+pipe.width)
            {
                pipe.passed=true;
                score+=0.5;
            }

            if(collision(bird, pipe))
            {
                gameOver=true;
            }
         }

         if(bird.y> boardHeight)
         {
            gameOver=true;
         }
    }

    public boolean collision(Bird a ,Pipe b)
    {
         return a.x < b.x + b.width &&   
               a.x + a.width > b.x &&   
               a.y < b.y + b.height &&  
               a.y + a.height > b.y;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
      move();
      repaint();
      if(gameOver)
      {
        placePipeTimer.stop();
        gameLoop.stop();
      }
    }


    @Override
    public void keyPressed(KeyEvent e) 
    {
       if(e.getKeyCode()==KeyEvent.VK_SPACE)
       {
         VelocityY=-9;
       }

       if(gameOver)
       {
         //restart the game
         bird.y=birdY;
         VelocityY=0;
         pipes.clear();
         score=0;
         gameOver=false;
         gameLoop.start();
         placePipeTimer.start();  
          
       }
    }

    //Not going to use these 2 fucntions , but necessary to write

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
