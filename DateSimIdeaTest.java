import java.util.Scanner;
public class DateSimIdeaTest{

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    /*The player's name. The characters will refer to them as this name.*/
    String userName = "";

    /*weekDayNum is used to properly check the current day of the week for
    weekly events. For example, club meetings that occur every monday and
    wednesday or enjoying weekends every saturday and sunday.*/
    int weekDayNum = 0;

    /*Affection levels for each character. This increases as the user progresses
    the game. [childhood friend, classmate, upperclasswoman]*/
    int[] affectionLevel = {0,0,0};

    /*Start of Game*/
    System.out.print("Please sign your name here: ");
    userName = input.nextLine();

    System.out.println("You read the letter.");

    System.out.println("Romantic Fever is the curse that kills any and every one of its victims\n" +
                       "who fail to achieve love in the next four weeks.\n" +
                       "You, '" + userName + "', are unfortunately infected by this curse. Consider this\n" +
                       "a warning for what you plan to do from now on.\n");

    System.out.println("You should get some sleep soon. Tomorrow's a big day.");
    decision("Sleep", "empty", "empty");

    int choice = input.nextInt();
    switch(choice){
      case 1: System.out.println("You have decided to get a good night's rest.");
      default: System.out.println("You decided to read the letter thoroughly before sleeping.");
    }



    /*(starting day | max days | increment) note: day = current day*/
    for (int day=1; day<=30; day++){
      //Displays current day number.
      System.out.print("\nDay " + day + ", ");

      if(day%7==1){
        System.out.println("Monday");
        weekDayNum = 1;
        //Run Monday Method
        runDay(day, userName, affectionLevel);
      } else if(day%7==2){
        System.out.println("Tuesday");
        weekDayNum = 2;
        //Run Tuesday Method
        runDay(day, userName, affectionLevel);
      } else if(day%7==3){
        System.out.println("Wednesday");
        weekDayNum = 3;
        //Run Wednesday Method
        runDay(day, userName, affectionLevel);
      } else if(day%7==4){
        System.out.println("Thursday");
        weekDayNum = 4;
        //Run Thursday Method
        runDay(day, userName, affectionLevel);
      } else if(day%7==5){
        System.out.println("Friday");
        weekDayNum = 5;
        //Run Friday Method
        runDay(day, userName, affectionLevel);
      } else if(day%7==6){
        System.out.println("Saturday");
        weekDayNum = 6;
        //Run Saturday Method
        runDay(day, userName, affectionLevel);
      } else if(day%7==0){
        System.out.println("Sunday");
        weekDayNum = 7;
        //Run Sunday Method
        runDay(day, userName, affectionLevel);
      }
    }
    //End of game segment





  }
  /*Maybe have scripted days be located directly underneath runDay method.
  Make other methods that represent 'hangout' events with certain characters
  or something similar to that.*/
  public static void runDay(int currentDay, String player, int affectionLevel[]){
    Scanner input = new Scanner(System.in);

    /*Shortcut names for all characters.*/
    final String ch = "Placeholder A";
    final String cl = "Placeholder B";
    final String up = "Placeholder C";

    /*This represents the choice the player gives in each decision. Make sure
    to reset this to zero after each decision. subChoice is a decision inside
    a decision.*/
    int choice = 0;
    int subChoice = 0;

    /*This string is used to test players based on their previous choices.
    For example: You agree to meet a girl next week, so you must meet her by
    then or you face consequences. Use keywords to represent each promise made
    and make sure to reset to "" once said promise is fulfilled/broken.
    [childhood friend, classmate, upperclasswoman]*/
    String[] promise = {"","",""};

    if (currentDay==1){
      //Day One. This is an example day, so feel free to change this. Might be pretty long though.
      System.out.println("\n[Front Door]\n");
      System.out.println("* Reading that warning last night, you feel tired.");
      System.out.println(ch + ": Good morning, " + player + "! You look weird. Is something wrong?");
      decision("Not enough sleep", "About this letter...", "empty");

      /*Decision Events. Using switches is alot cleaner to look at compared to conditionals.*/
      choice = input.nextInt();
      switch(choice){
        case 1: System.out.println(ch + ": Then you need to get more sleep!");
                System.out.println("* While laughing, she slaps you in the back.");
                break;
        case 2: System.out.println(ch + ": A letter about a curse? It's definitely a joke.\n" +
                                   "No doubt about it.");
                break;
        default: System.out.println(ch + ": Huh? Did you say something just now?");
      }

      System.out.println(ch + ": So nevermind about that. Are you ready for today?");
      decision("The big day?", "What are you talking about?", "Not really.");

      /*Another example of decision making but with affection level opportunities.*/
      choice = input.nextInt();
      switch(choice){
        case 1: System.out.println(ch + ": I guess you can call it that...");
                System.out.println("* Unfortunately, you have no idea what she's talking about.\n" +
                                   "But at least she thinks you understand her well. [+1]");
                affectionLevel[0] += 1;
                break;
        case 2: System.out.println(ch + ": Did you completely forget about our Math test today?");
                System.out.println("* Unfortunately, last night's letter had distracted you from studying.\n"+
                                   "Hence you have completely forgotten about the upcoming test.");
                break;
        case 3: System.out.println(ch + ": Same here... I rarely pay attention to the lectures these days.");
                System.out.println("* Unfortunately, last night's letter had distracted you from studying\n" +
                                   "You are very not looking forward to the upcoming test. [+1]");
                affectionLevel[0] += 1;
                break;
        default: System.out.println(ch + ": Are you that tired?");
      }

      System.out.println("\n" + ch + ": We're almost there.");
      System.out.println(ch + ": Hold on. Let me check on something.");
      System.out.println("* She looked inside her bag and was left with" +
                         " a panicked expression.");
      decision("Did you forget something?", "Again?", "Not my problem.");
      choice = input.nextInt();


      /*Just incase there is a situation where we need to have a decision in a decision, we have subChoice.*/
      switch(choice){
        case 1: System.out.println(ch + ": Crap, I forgot my lunch.");
                System.out.println("* For some reason, she's staring at you.");
                decision("I can share.", "Mine.", "empty");
                subChoice = input.nextInt();
                switch(subChoice){
                  case 1: System.out.println("Thanks, " + player + "! I promise I'll repay you sometime.");
                          System.out.println("* You saved " + ch + " from her current crisis. [+1]");
                          promise[0] = "shareLunch";
                          affectionLevel[0] += 1;
                          break;
                  case 2: System.out.println("I was going to consider buying school lunch. What's your damage?");
                          break;
                  default: System.out.println("Whatever. Thank goodness I brought my wallet at least.");
                }
                break;
        case 2: System.out.println(ch + ": Yeah. I completely forgot.");
                System.out.println(ch + ": Wait a moment. Why did you say 'again'? Say, what did I forget this time?");
                System.out.println("* It seems she's glaring at you. How should you answer her?");
                decision("Textbook?", "Lunch?", "Homework?");
                subChoice = input.nextInt();
                switch(subChoice){
                  case 1:
                  case 3: System.out.println(ch + ": I knew it. You're just messing with me.");
                          System.out.println("* She seems slightly irritated.");
                          System.out.println(ch + ": That must have been payback from earlier.");
                          break;
                  case 2: System.out.println(ch + ": Oh. So you weren't lying to me.");
                          System.out.println(ch + ": Yep. I forgot about my lunch again...");
                          System.out.println("* Fortunately, you gave the right answer. [+1]");
                          affectionLevel[0] += 1;
                          break;
                  default: System.out.println(ch + ": Time's up. The answer is lunch! You suck.");
                           System.out.println("* You felt a slight aura of disappointment.");
                }
                System.out.println(ch + ": We're going to be late if we keep standing around like this. Let's go!");
                break;
        case 3: System.out.println(ch + ": At least pretend to care!");
                break;
        default: System.out.println("* You continued walking ahead.");
                 System.out.println(ch + ": Hello? Where are you going? Wait up!");
      }

      System.out.println("\n[School Gates]\n");

      System.out.println(ch + ": We're finally here.");
      System.out.println(ch + ": Well, see you soon!");

      System.out.println("\n[Math Classroom]\n");

      System.out.println("* After a sequence of lectures, you have finally arrived to your math class.\n" +
                        "You should hurry to your seat. The test is about to start soon.");
      decision("Commence last minute study.", "Restroom Break!", "Pray.");
      choice = input.nextInt();

      /*Another example of making decisions in decisions. This can be used to make different branching scenarios. If you
      want to go crazy with it, you can create a new choice variable called subSubChoice or something similar.*/
      switch(choice){
        case 1: System.out.println("* You went over your previous notes. The messy handwriting did anything\n" +
                                   "but help.");
                System.out.println("???: Do you need my notes instead?");
                System.out.println("\n[1: Accept.] \n[2: Decline.] ");
                decision("Accept", "Decline", "empty");

                subChoice = input.nextInt();
                switch(subChoice){
                  case 1: System.out.println("???: H-here you go.");
                          System.out.println("* She handed you her notebook. You gave her your thanks.");
                          System.out.println("* You skimmed the necessary formulas and theorems. Above the neat writing\n" +
                                             "was her name written in different unique fonts. Did she doodle this? After\n" +
                                             "memorizing them, you handed back the notebook and thanked her again.");
                          System.out.println(cl + ": D-don't mention it.");
                          System.out.println("* For some reason, she seemed happy. [+1]");
                          affectionLevel[1] += 1;
                          break;
                  case 2: System.out.println("* You thought it would be rude to borrow a stranger's notes, so you declined.");
                          System.out.println("???: O-oh, okay then. Sorry for bothering you.");
                          break;
                  default: System.out.println("???: D-do you need my notes?");
                }
                break;
        case 2: System.out.println("* You rushed towards the nearest restroom. Perhaps you are running a little too fast-");
                System.out.println("???: Hey! No running in the halls!");
                System.out.println("\n[1: Stop.] ");
                decision("Stop", "empty", "empty");

                subChoice = input.nextInt();
                switch(subChoice){
                  case 1: System.out.println("* You stopped and turned back.");
                          System.out.println(ch + ": Did you like my hall monitor impersonation?");
                          System.out.println("* You couldn't hold it any longer.");
                          break;
                  default: System.out.println("???: Why are you not stopping!? Get back here!");
                }
                break;
        case 3: System.out.println("* You put your hands together and hoped for easier questions.");
                System.out.println("???: What the...?");
                System.out.println("* Now that you think about it. Doing this sort of thing is embarrassing.");
                break;
        default: System.out.println("* You decided to do nothing.");
      }

      System.out.println("\nSchool Yard\n");
      System.out.println("* The test was harder than you expected. You decided to not think about it.");

      if (promise[0] == "shareLunch"){
        System.out.println("\n[1: Start eating your lunch.] \n[2: Wait.] ");
        decision("Start eating your lunch", "Wait.", "empty");
        choice = input.nextInt();
        switch(choice){
          case 1: System.out.println("* As you ate, you felt as if you have forgotten something important.");
                  System.out.println(ch + ": My bad! Some of my friends wanted to talk about the test and-");
                  System.out.println("* What did you forget again?");
                  System.out.println(ch + ": Weren't you going to share that? Really...?");
                  System.out.println("* Lunch break afterwards became awkwardly silent. [-2]");
                  affectionLevel[0] -= 2;
                  break;
          case 2: System.out.println("* Three minutes of waiting later...");
                  System.out.println(ch + ": My bad! Some of my friends wanted to talk about the test and\n" +
                                    "that took a while. Thanks for waiting for me.");
                  System.out.println("* You remembered to share your lunch with " + ch + ". [+1]");
                  affectionLevel[0] += 1;
                  System.out.println(ch + ": Your sandwiches are great as always!");
                  System.out.println("* You spent the rest of lunch break conversing with " + ch + ".");
                  break;
          default: System.out.println("* You hid your lunch.");
                   System.out.println(ch + ": My bad! Some of my friends wanted to talk about the test and-");
                   System.out.println("* Before she could continue, you explained your 'cooking accident'.");
                   System.out.println(ch + "Oh... Then that's too bad I guess. I'll head over to the cafeteria then.");
        }
      } else{
        System.out.print("* You began eating your lunch.");
      }



      System.out.println(ch + ": " + affectionLevel[0]);
      System.out.println(cl + ": " + affectionLevel[1]);
      System.out.println(up + ": " + affectionLevel[2]);












    } else if (currentDay==2){
      //Day Two...


    } else{

    }
  }

  /*Hangout Events take up a whole day. This allows the player to specifically
  focus on a specific character. (Add two more of these later)*/
  public static void hangoutA(int affectionLevel[]){
    int childhoodFriend = affectionLevel[0];
    if (childhoodFriend <= 5){
      //Hangout Event 1
    } else if (childhoodFriend >= 6 && childhoodFriend <= 10){
      //Hangout Event 2
    } else if (childhoodFriend >= 11 && childhoodFriend <=15){
      //Hangout Event 3
    } else if (childhoodFriend >=16 && childhoodFriend <= 20){
      //Hangout Event 4
    }
  }

  public static void decision(String optionA, String optionB, String optionC){
    String[] optionList = {optionA, optionB, optionC};
    for(int i=1; i<=optionList.length; i++){
      if(optionList[i-1] != "empty"){
        System.out.println("[ " + (i) + ": " + optionList[i-1] + " ]");
      }
    }
  }

}
