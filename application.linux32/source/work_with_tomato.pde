import ddf.minim.*;

Minim minim;
AudioPlayer player_work;
AudioPlayer player_rest;
AudioInput input;

int work_time = 2700; // seconds
int rest_time = 300;
void setup()
{
  size(320, 320);
  background(137, 218, 255);
  frameRate(1);
  minim = new Minim(this);
  player_work = minim.loadFile("work.mp3");
  player_rest = minim.loadFile("alert.wav");
  input = minim.getLineIn();  
}
void draw()
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
    text("WORK WORK\n", width/2, height/2);
    text(mins + " : " + secs + "\n", width/2, height/2-40);    
  }

  else if (work_time > -rest_time) 
  {

    background(137, 218, 255);
    player_rest.play();
    text("GO EAT A TOMATO!", width/2, height/2); 
    int mins = (int)Math.floor((Math.abs(--work_time)) / 60);
    int secs = Math.abs(work_time) % 60;
    text(mins + " : " + secs + "\n", width/2, height/2-40);    
  }
  else // back to zero
  {
    background(137, 218, 255);
    work_time = 5;
    player_work.close();
    player_rest.close();
    player_rest = minim.loadFile("alert.wav"); 
    player_work = minim.loadFile("work.mp3");       
  }
    
}

  

