import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class work_with_tomato extends PApplet {



Minim minim;
AudioPlayer player_work;
AudioPlayer player_rest;
AudioInput input;

int work_time = 2700; // seconds
int rest_time = 300;
public void setup()
{
  size(240, 120);
  background(137, 218, 255);
  frameRate(1);
  minim = new Minim(this);
  player_work = minim.loadFile("work.mp3");
  player_rest = minim.loadFile("alert.wav");
  input = minim.getLineIn();  
}
public void draw()
{
  if (work_time > 0)
  {
    player_work.play();
    int mins = (int)Math.floor((--work_time) / 60);
    int secs = work_time % 60; 
    //work_time--; 
    background(137, 218, 255);
    fill(0, 102, 153);  
    textAlign(CENTER);
    textSize(32);
    text("WORK WORK\n", width/2, height/2+30);
    text(mins + " : " + secs + "\n", width/2, height/2-20);    
  }

  else if (work_time > -rest_time) 
  {

    background(137, 218, 255);
    player_rest.play();
    textSize(24);
    text("GO EAT A TOMATO!", width/2, height/2+30); 
    int mins = (int)Math.floor((Math.abs(--work_time)) / 60);
    int secs = Math.abs(work_time) % 60;
    textSize(32);
    text(mins + " : " + secs + "\n", width/2, height/2-20);    
  }
  else // back to start
  {
    background(137, 218, 255);
    work_time = 2700;
    player_work.close();
    player_rest.close();
    player_rest = minim.loadFile("alert.wav"); 
    player_work = minim.loadFile("work.mp3");       
  }
    
}

  

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "work_with_tomato" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
