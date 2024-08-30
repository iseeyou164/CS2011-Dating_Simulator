import java.util.Scanner;
import java.io.*;

public class DatingSimFinal{
  //public static final String ANSI_RESET = "\u001B[0m";
  //public static final String ANSI_PURPLE = "\u001B[35m";
  public static void main(String[] args){

    Scanner input = new Scanner(System.in);

    // This is a boolean to see if -help was executed
    boolean dashHelp = false;

    //Title
    border("star");
    type("+ [Kindred Hearts]");
    border("star");

    if(args.length != 0 && args[0].equals("-help")) {
      dashHelp = true;
      displayHelp("rules", dashHelp);
    }
    /*The player's name. The characters will refer to them as this name.*/
    String userName = "";

    /*Affection levels for each character. This increases as the user progresses
    the game. [love interest, best friend, classmate]*/
    int[] characterScore = {0,0,0};

    /*Shortcut names for all characters.*/
    final String loveInterest = "Melody";
    final String bestFriend = "Bob";
    final String classMate = "Sherry";

    /*This represents the choice the player gives in each decision. Make sure
    to reset this to zero after each decision. subChoice is a decision inside
    a decision. [If you want to cry, there's subSubChoice. (not recommended.)]*/
    int choice = 0;
    int subChoice = 0;
    int subSubChoice = 0;

    /*This string is for flags*/
    String[] flags = {"","",""};


    /*Start of Game*/
    //Put anything here that is supposed to run before game starts.

    border("space");
    type("> Midnight, Home:");
    type("> You heard someone knocking on your front door.");
    type("> ???: Delivery!");
    type("> You don't remember ordering anything recently. You opened the door.");
    type("> ???: Good evening, sir. Can you please sign your name here?");
    System.out.print("> "); userName = input.nextLine();
    type(("> ???: Then here's your package, " + userName + ".").toString());
    type("> The delivery man left. You shook the package a few times. It doesn't feel heavy.");
    type("> You decided to open it.");
    type("> It was a love letter. You cautiously opened it.");
    type("> You read the only bolded text on the letter:");
    type("> 'If you don't fall in love with me within a week, you will die.'");
    type("> Maybe this is a prank. You should get some rest.");

    //Rules right here (Future reference)


    /*Might change this later.*/
    /*(starting day | max days | increment) note: day = current day*/
    for (int day=1; day<=7; day++){
      if(day==1){

        border("space");
        border("equal");
        type("* Monday, 7 days remaining.");
        border("equal");
        border("space");

        type("> Early Morning, Classroom:");
        type("> Math Teacher: So, the Pythagoras Theorem revolves around...");
        type("> You couldn't help but think about that strange letter from last night." +
            "\n  Maybe you could ask around.");

        border("space");
        type("> Lunch Break, Hallway:");
        type("> Now that you think about it, you don't have friends to talk with.");
        type("> But there is a guy you remember talking to during middleschool...");
        type("> Then, there's that girl who you occassionally talk to for an eraser...");
        type("> Perhaps you can start with them? The cafeteria should be closer...");

        border("space");
        type("> Lunch Break, Cafeteria:");
        type(("> " + bestFriend + ": Oh, "+ userName + ". It's been a while. You need something?").toString());
        type("> You explained to him about last night.");
        type(("> " + bestFriend + ": So you're saying some love letter was delivered to you a box...").toString());
        type(("> " + bestFriend + ": And you have 7 more days to accept this love letter or else you die?").toString());
        type(("> " + bestFriend + ": Hey, are you okay?").toString());
        displayHelp("hints", dashHelp);
        /*Decision Events. Using switches is alot cleaner to look at compared to conditionals.*/
        /*A do-while sentient loop is used so that the player must select the required options.*/
        displayDecision("Give him the letter.", "Maybe this is a prank.", "empty");
        do{
          choice = input.nextInt();
          switch(choice){
            case 1: type(("> " + bestFriend + " read the letter. He still was not convinced.").toString());
                    type(("> " + bestFriend + ": I know this isn't your handwriting, but this is just stupid.").toString());
                    characterScore[1] += 1;
            break;
            case 2: type(("> " + bestFriend + ": Yeah. You don't seem like the type of guy who would pull this sort of thing.").toString());
            break;
            default: System.out.println("- Please enter a valid input.");
          }
        } while(choice<0||choice>2);
        type(("> " + bestFriend + ": Wait, is some crazy chick after you? Now I'm definitely curious.").toString());
        type(("> " + bestFriend + ": ...oh crap, I forgot I have a club meeting to attend soon. We can continue this later on "
        + "\n  if you want.").toString());
        type("> He sprinted away...");
        type("> Lunch break is almost over, you should head to the library now.");

        border("space");
        type("> Lunch Break, Library:");
        type(("> " + classMate + ": ...oh " + userName + ", right? Do you need something?").toString());
        type("> You awkwardly explained to her about last night. As you spoke, you wondered why you were speaking about"
        + "\n  this to a girl.");
        type(("> " + classMate + " A love letter?").toString());
        type(("> " + classMate + ": s-so sorry, but I'm not interested in this sort of thing...").toString());
        displayDecision("Give her the letter.", "I know it is a prank, but...", "empty");
        do{
          subChoice = input.nextInt();
          switch(subChoice){
            case 1: type(("> " + classMate + ": W-wait, you were serious? This is just creepy...").toString());
                    type("> She read the letter again.");
                    type(("> " + classMate + ": 'If you don't fall in love with me within a week, you will die.'").toString());
                    type(("> " + classMate + ": ...just woah.").toString());
                            characterScore[2] += 1;
            break;
            case 2: type(("> " + classMate + ": You were wondering if this...weird situation is known amongst girls?"
                    + "\n  No, this is...crazy...").toString());
                    type(("> " + classMate + ": Have you tried calling the cops? ...No, wait. I don't think they would"
                    + "\n  beleive you...").toString());
            break;
            default: System.out.println("- Please enter a valid input.");
            }
        } while(subChoice<0||subChoice>2);
        type(("> " + classMate + ": I'm sorry, but I don't really know if I want anything to do with this...").toString());
        type(("> " + classMate + ": All I can say is, good luck...?").toString());
        type(("> You felt awkward staying here. You should probably leave right now."));

        type("> Unfortunately, you didn't get much from asking around... Maybe this is all a prank.");
        type("> You felt very exhausted right now. Maybe you should get some sleep.");
        border("space");
        border("equal");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      } else if(day==2){
        //Day 2
        type("* Tuesday, 6 days remaining.");
        border("equal");
        border("space");

        type("> Early Morning, Classroom:");
        type("> Art Teacher: So, you mix red and blue to make purple...");
        type("> Something seems off...");
        type("> You look around and see your childhood crush." +
            "\n  You don't remember seeing her in your class before.");

        border("space");
        type("> Lunch Break, Hallway:");
        type("> Maybe she knows something about that letter. The timing fits, after all.");
        type("> You should approach her? But how?");
        displayDecision("Approach her", "Walk away", "Yell at her");
        do{
          choice = input.nextInt();
          switch(choice){
            case 1:
            border("space");
            type("> Lunch Break, Outside Art Class:");
            type("> You have decided to approach her.");
            type(("> " + loveInterest + ": Hey!! " + userName + " its been a while").toString());
            type(("> " + loveInterest + ": My dad quit his job in Texas, so we had to move back here").toString());
            type("> You exclaimed to her how you never expected to see her again.");
            type(("> " + loveInterest + ": Same here!").toString());
            type("> You're struggling to continue this conversation. Should you show her the letter? It" +
            "\n  might be a bad idea, but it's better than doing nothing...!");
            /*To Xavier: I made day 2 a bit longer. You can change it if you want.*/
            displayDecision("Show her the letter.", "Talk about classes.", "Let her talk.");
            do{
              subChoice = input.nextInt();
              switch(subChoice){
                case 1: type("> You showed her the letter you recieved.");
                        type(("> " + loveInterest + ": W-what is this!? Gross..!").toString());
                        type("> She ran away...");
                        type("> Maybe you should apologize the next time you see her.");
                        characterScore[1] += 1;
                break;
                case 2: type("> You asked her how it's like to be a transferred student.");
                        type(("> " + loveInterest + ": It's fine for now...I think. Wait, no. I hate my chemistry teacher.").toString());
                        type("> She started rambling...and she's not showing any sign of stopping.");
                        type("> You regretted your decision.");
                        type("> It would be awkward to bring up the letter at a time like this. It's best to bring it up next time.");
                break;
                case 3: type(("> " + loveInterest + ": Sorry, but I have to visit the faculty office.").toString());
                        type("> She walked away.");
                        type("> It would be awkward to bring up the letter at a time like this. It's best to bring it up next time.");
                break;
                default: System.out.println("- Please enter a valid input.");
              }
            } while(subChoice < 0 || subChoice > 3);
            break;
            case 2: border("space");
                    type("> Lunch Break, Cafeteria");
                    type("> You have decided to walk away.");
                    type("> You regretted your cowardness. If only you had approached her.");
                    type(("> " + bestFriend + ": Woah, what's up with you? Did you get rejected or something?").toString());
                    displayDecision("Explain yourself.","Shut it.","empty");
                    do{
                      subChoice = input.nextInt();
                      switch(subChoice){
                        case 1: type("> You desperately explained the situation about earlier to him...");
                                type(("> " +  bestFriend + ": Oh, so " + loveInterest + " is back. What timing.").toString());
                                type("> He laughed.");
                                type(("> " + bestFriend + ": Hey, what if it was " + loveInterest + " who sent that letter?").toString());
                                type("> He completely read your mind.");
                                type(("> " + bestFriend + ": Just kidding! I doubt she's the type of person who would do that.").toString());
                                characterScore[1] += 1;
                        break;
                        case 2: type(("> " +  bestFriend + ": Are you that mad about that?").toString());
                                type(("> " +  bestFriend + ": Well, my bad.").toString());
                                characterScore[1] -= 1;
                        break;
                        default: System.out.println("- Please enter a valid input.");
                      }
                    } while(subChoice < 0 || subChoice > 2);
                    type("> He finished his lunch and walked away.");
                    type("> You decided to eat some lunch since you're here.");
            break;
            case 3: border("space");
                    type("> Lunch Break, Outside Art Class");
                    type("> You decided to yell at her.");
                    type("> You yelled across the hall to ask about the letter");
                    type(("> "+ loveInterest + " became flustered and ran away.").toString());
                    type("> Was it even a good idea to shout these things out loud. Now everyone's" +
                    "\n  looking at you. You should probably get out of here.");
                    characterScore[0] -= 1;
            break;
            default: System.out.println("- Please enter a valid input.");
          }
        } while(choice < 0 || choice > 3);
        type(("> It was weird seeing " + loveInterest + " today maybe she has something to do with this.").toString());
        type("> You felt very exhausted right now. Maybe you should get some sleep.");
        border("space");
        border("equal");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      } else if(day==3){

        type("* Wednesday, 5 days remaining.");
        border("equal");
        border("space");
        type("> Morning, History Classroom:");
        type("> History Teacher: As you learned before, the American Revolution caused...");
        type("> You couldn't focus on the lecture. It feels as if someone is watching you.");

        border("space");
        type("> Late Noon, Walking Home");
        type(("> You see, " + loveInterest + ", " + classMate + ", and " + bestFriend + " about to walk home").toString());
        type("> You should see if they'd like to walk home with you. It would be better to be safe with another person.");
        type("> Who should you approach?");
        displayDecision((loveInterest).toString(), (classMate).toString(), (bestFriend).toString());
        do{
          choice =  input.nextInt();
          switch(choice){
            case 1: type(("You approached "+ loveInterest + ".").toString());
                    type(("> " + loveInterest + ": Oh, " + userName + ". Good afternoon.").toString());
                    type("> You ask her if she'd like to walk home with you.");
                    type(("> " + loveInterest + ": Walk home with me? I wouldn't mind if you tagged along with me.").toString());
                    type(("> " + loveInterest+": Thanks for walking me home it means alot.").toString());
                    type("> You seize this opprtunity to bring up the letter. Maybe this is a better time to bring this up.");
                    type(("> " + loveInterest +": ...a love letter? 'you die?' Maybe this person really likes you.").toString());
                    type(("> " + loveInterest + " laughs to herself. You wonder why.").toString());
                    type(("> " + loveInterest + ": S-sorry! It's just the how the letter is written. This looks more of a threat.").toString());
                    border("space");
                    type(("> Late Noon, Outside " + loveInterest + "'s house.").toString());
                    type("> As you walk to her door she runs inside.");
                    type(("> "+loveInterest+": Thanks and don't give up on your search, maybe they're closer then you think. ").toString());
            break;
            case 2: type(("You approached " + classMate + ".").toString());
                    type(("> " + classMate +": " + userName + "?").toString());
                    type("> You ask her if you can walk with her home.");
                    type(("> " + classMate +": Why would you want to walk home with me?").toString());
                    type("> You explain to her how you're parinoid about walking home alone.");
                    type(("> " + classMate +": You're so weird, but whatever you can come, I guess...").toString());
                    type("> You seize this opportuinity to bring up the letter.");
                    type("> What should you do?");
                    displayDecision("Confront Her","Ask her about the letter","empty");
                    do{
                      subChoice = input.nextInt();
                      switch(subChoice){
                        case 1: type(("> You confront " + classMate + ", about being the author of the letter. ").toString());
                                type(("> " + classMate + ": W-why are you acting so crazy all of a sudden?").toString());
                                type(("> " + classMate + ": That's...just insane, why would I write that to you?").toString());
                                type("> You apologized that you assumed it was her.");
                                type(("> " + classMate + ": It's fine, you just caught me off gaurd.").toString());
                                type("> You applogize at the crazy idea and continue in awkward silence until you reach her house");
                                type("> As you walk her to the door, she says:");
                                type(("> " + classMate + ": Good luck with your situation, but I can assure you.").toString());
                                type(("> " + classMate + ": It's not me... I swear.").toString());
                                type("> She hurried and ran away. Maybe you shouldn't follow her...");
                                characterScore[2] -= 2;
                        break;
                        case 2: type("> You decided to ask her about the letter. ");
                                type(("> " + classMate + ": I told you, I want nothing to do with this.").toString());
                                type("> You plead with her asking for any ounce of help she can provide.");
                                type(("> " + classMate + ": I feel bad for you, I guess I can try helping.").toString());
                                type("> You thank her pefusely and explain the situation once again.");
                                type(("> " + classMate + ": I know you want to figure this out, but I'm sure they'll show herself soon.").toString());
                                type(("> " + classMate + ": They could be someone you never expect. It can be possible.").toString());
                                type("> You get closer to her house.");
                                type(("> " + classMate + ": Thank you for walking me home. This was a first for me.").toString());
                                type("> As she closes the door, she turned towards you.");
                                type(("> " + classMate + ": Once again, good luck.").toString());
                                type("> Her last words prolong in your head as you walk home");
                                characterScore[2] += 2;
                        break;
                        default: System.out.println("- Please enter a valid input.");
                      }
                    } while(subChoice< 0 || subChoice> 2);
            break;
            case 3: type(("> You approached "+ bestFriend + ".").toString());
                    type("> You ask them if you could walk home with them.");
                    type(("> " + bestFriend + ": Just like in middle school, huh " + userName + ".").toString());
                    type("> You begin to walk as you reminisce on your history together");
                    type("> After reminiscing, you bring up the letter desperately tring to find answers.");
                    type(("> " + bestFriend + ": You're really eager about finding out who wrote this letter, huh.").toString());
                    type(("> " + bestFriend + ": They'll show sooner or later, I'm sure you'll find out eventually.").toString());
                    type("> You mentally cry inside your head, as you try to figure out possible answers. ");
                    type(("> " + bestFriend + ": Haha. Doesn't that sound like a movie line?").toString());
                    type("> You start to close in on " + bestFriend + "'s, house.");
                    type(("> " + bestFriend + ": This is my stop.").toString());
                    type(("> " + bestFriend + ": Maybe don't overthink it, they're probably closer then you think!! ").toString());
                    type(("> " + bestFriend + ": I'll see you at school tomorrow. Good luck!!! ").toString());
            break;
          }
        } while(choice < 0 || choice > 3);
        characterScore[2] += 1;
        characterScore[1] += 1;
        characterScore[0] += 1;
        type("> You should hurry home. That suspicous feeling from earlier is still there.");
        border("space");
        border("equal");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      } else if(day==4){

        type("* Thursday, 4 days remaining.");
        border("equal");
        border("space");

        type("> Early Afternoon, Lunch Break:");
        type(("> You and " + bestFriend + " were sitting down eating your lunch when you saw " + classMate + " looking for a seat.").toString());
        displayDecision("Offer her a seat.", "Look away.", "empty");
        do{
          choice = input.nextInt();
          switch(choice){
            case 1: type(("> You called out" + classMate + " and offered her the seat next to you.").toString());
                    type(("> " + classMate + ": R-really? Thanks.").toString());
                    characterScore[2] += 1;
                    type(("> " + bestFriend + ": You know " + classMate + "?").toString());
            break;
            case 2: type(("> " + bestFriend + ": Oh, " + classMate + ". Do you want to sit with us?").toString());
            break;
            default: System.out.println("- Please enter a valid input.");
          }
        } while (choice < 0 || choice > 2);
        type(("> " + bestFriend + " and " + classMate + " know each other?").toString());
        type(("> " + bestFriend + ": We're neighbors, so our parents know each other. You get the gist.").toString());
        type(("> " + classMate + ": This might be bad timing, but can you stop copying my math answers? The teacher's getting more suspicous.").toString());
        type(("> " + bestFriend + ": B-but my grade...?").toString());
        type(("> While you three were talking you had caught a glimpse of " + loveInterest + " and her friends two tables away from you.").toString());
        type(("> " + bestFriend + " and " + classMate + " had both took notice that you were looking at " + loveInterest + ".").toString());
        type(("> " + bestFriend + ": You know that this guy has a crush on her, right?").toString());
        type(("> " + classMate + ": S-seriously- I-I mean isn't it rude to blurt out things like this? L-look! He's turning red!").toString());
        type(("> " + bestFriend + ": Might be because she's there. Not my fault.").toString());
        type("> You should go. It's a rare opportunity for you to talk to her.");
        type(("> " + bestFriend + ": He's standing up. Is he really going to talk to her?").toString());
        displayDecision("Approach her.", "Sit back down.", "empty");
        do{
          choice = input.nextInt();
          switch(choice){
            case 1: type(("> Once you reached " + loveInterest + " and her friends table you opened up the the conversation with 'You mind if I sit here?'").toString());
            type(("> " + loveInterest + ": Can he?").toString());
            type("> Her friends didn't mind. You proceeded to look for a seat.");
            type(("> " + loveInterest + ": You could sit next to me!!").toString());
            type(("> " + loveInterest + ": I mean... If you wanted too of course. ").toString());
            type(("> You sit down, trying to keep your composure sitting next to " + loveInterest + ".").toString());
            type("> Out of nervousness you blert out a sentence about Mr. Beast to her table.");
            type("> They stare at you awkwardly. You're regretting your word choice.");
            type(("> " + loveInterest + ": Mr. Beast is so epic, I love his new content!!! ").toString());
            type(("> You and " + loveInterest + " fangirl over Mr. Beast and his recent videos.").toString());
            type(("> " + loveInterest + ": You're cooler than I thought " + userName + ", I really thought you we're weird.").toString());
            type("> Everyone at the table started to get up as the lunch bell rang. ");
            type(("> " + loveInterest + ": This was fun we should definitely talk more! ").toString());
            characterScore[0] += 1;
            type("> As you walk to your next period, the phrase 'We should definitely talk more' echos in your head");
            break;
            case 2: type(("> You gave it a second thought. Yeah, it's definitely a bad idea.").toString());
                    type(("> " + bestFriend + ": Pfft... Hahaha!").toString());
                    type(("> " + classMate + ": S-stop laughing... or else I'll...pfft-").toString());
                    characterScore[1] += 1;
                    characterScore[2] += 1;
                    type(("> You glanced at the other table and saw " + loveInterest + " staring at you.").toString());
                    type("> Your friends' laughter fills your head space as you die out of embarassment. ");
                    type("> You wanted to go home.");
            break;
            default: System.out.println("- Please enter a valid input.");
          }
        } while(choice < 0 || choice > 2);
        border("space");
        border("equal");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      } else if(day==5){
        type("* Friday, 3 days remaining.");
        border("equal");
        border("space");

        type("> Early Morning, Walking to school");;
        type("> You can't help but think about what happen yesterday during Lunch");
        displayDecision("Keep Thinking about it", "Forget about it and think about something else", "empty");
        do{
          choice = input.nextInt();
          switch(choice){
            case 1: type(("> The more you think about " + loveInterest + ", the more you realize that you're falling for her").toString());
                    type(("> And " + bestFriend + " and " + classMate + " kind of figured that I'm kind of into her.").toString());
                    type("> While you're thinking about it. It starts raining and you start running to school.");
                    type("> As you're running to school is starts getting foggy and its getting difficult to see.");
                    type("> You end up crashing into someone");
                    type(("> You apologized to the person you crashed into. It was " + loveInterest + ".").toString());
                    type("> As you hear the voice you realize who it is.");
                    type(("> " + loveInterest + ": Y-yes I'm okay. Just my notebook is all wet ").toString());
                    type(("> " + userName + ": " + loveInterest + "!, I-I'm sorry! I didn't see you, are you okay !?").toString());
                    type(("> " + loveInterest + ": Yes, I just said I'm fine.").toString());
                    type(("> "+ loveInterest + "*realizes its you*").toString());
                    type(("> "+ loveInterest + ": OH!"+ userName+ " YES YES!! I'm fine. Are you okay?").toString());
                    type("> You tell her you are okay");
                    type("> It stopped raining.");
                    type(("> You get the courage to ask" + loveInterest + "if she wants to skip school today to hang out.").toString());
                    displayDecision("Ask if she wants to come.", "Nevermind.", "empty");
                    do{
                      subChoice = input.nextInt();
                      switch(subChoice){
                        case 1: type(("> " + loveInterest + "decides to hang out with you").toString());
                                type(("> You and "+ loveInterest+" end up spending the whole the together.").toString());
                                type("> After you walk her home you think about giving her a kiss.");
                                displayDecision("You give her a kiss", "You don't give her a kiss.","empty");
                                do{
                                  subSubChoice = input.nextInt();
                                  switch(subSubChoice){
                                    case 1: type("> You give her a kiss and she kisses you back.");
                                            type("> You say your goodbyes and walked home.");
                                            type("> You couldn't believe you pulled that off.");
                                            characterScore[0] += 2;
                                    break;
                                    case 2: type("> You give her a hug and head home.");
                                            characterScore[0] += 1;
                                    break;
                                    default: System.out.println("- Please enter a valid input.");
                                  }
                                } while (subChoice < 0 || subChoice > 3);
                        break;
                        case 2: type(("> You and "+ loveInterest+" continued to walk to school" ).toString());
                                type("> The rest of the day continued as if nothing happened.");
                        break;
                      }
                    } while(choice < 0 || choice > 3);
            break;
            case 2: type("> You try to think about something else but can't because yesterday keeps replaying in ur head.");
                    type("> You decide that maybe you should ask her out.");
                    type(("> You eventually get to school and see "+ loveInterest).toString());
                    type("> You walk up to her and and you are about to ask her");
                    type(("> "+ userName+": hey "+loveInterest+"I have a question to ask you.").toString());
                    type("> As your about to ask her the floor starts moving harder and harder");
                    type("> The Earthquake alarm starts ringing and everyone starts running.");
                    type(("> You grabed "+ loveInterest +"'s' hand and run out the school away from tall fences and trees. ").toString());
                    type("> The trembling subsided, and both of you are you are okay.");
                    type("> But...");
                    type("> You were wrong, you realize that she isn't besides you.");
                    type("> you start panicking and run back to school.");
                    type(("> You see "+bestFriend+" and "+classMate+" you ask if they seen "+loveInterest+"both of them say no.").toString());
                    type("You panick even more so you think if you should call out for her or keep looking.");
                    displayDecision("Scream for her", "Continue to look for her", "empty");
                    do{
                      subChoice = input.nextInt();
                      switch(subChoice){
                        case 1: type("You decide to scream for her name.");
                                type("So you scream at the top of your lungs as hard as possible.");
                                type(("> "+loveInterest+"!!!!!").toString());
                                type("> You see her and run towards her and hug her.");
                                type(("> "+ userName+ ": What happenened I thought you were behind me ?").toString());
                                type(("> "+ loveInterest+ ": Someone pushed my friend and I saw her getting stepped on while everyone was runnung.").toString());
                                type(("> "+ loveInterest+ ": I went to go help her ").toString());
                                type(("> "+ userName+ ": Oh okay. I'm glad you are okay.").toString());
                                type("You then give her a long hug.");
                                type("Everything is okay, she's okay.");
                                characterScore[0] += 1;
                      break;
                      case 2: type("> You decided to look for her instead.");
                              type("> You find her eventually and you see her laying in the ground.");
                              type(("> "+ userName+ ": "+loveInterest+"!!!!").toString());
                              type("> You run towards her.");
                              type(("> "+ userName+ ": "+loveInterest+" Wake up. WAKE UP!!!").toString());
                              type(("> "+ userName+ ": Please wake up. I can't lose you.").toString());
                              type("> Her eyes they start opening and she sits up.");
                              type("> You then proceed to hug her.");
                              type(("> While hugging her, "+ userName+ ": I'm glad your okay.").toString());
                              type("> Everything is okay, you saved her.");
                              characterScore[0] += 1;
                      break;
                      default: System.out.println("- Please enter a valid input.");
                    }
                  } while (choice < 0 || choice > 2);
            break;
            default: System.out.println("- Please enter a valid input.");
          }
        } while (choice < 0 || choice > 3);

        // Alejandra
        //just have fun with the story/code as long as it somewhat connects to the previous days
        //oh and ask for help if you need help on something, especially the format
        // Well edit it later so it fits better

        border("space");
        border("equal");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      } else if(day==6){

        type("> Saturday, 2 days remaining.");
        border("equal");
        border("space");

        type("> Late Noon, Classroom:");
        type(("> You had stay back to clean the classroom, you had noticed that " + loveInterest + " left her notebook behind.").toString());
        type(("> You decided to rush out of the classroom to go and give " + loveInterest + " her notebook but soon after started to rain soon after you left the school.").toString());
        /*The player can confess to her when they have enough points for that character.*/
        if(characterScore[0] >= 7){
          type("> And kept running to your heart's content the feelings flustered inside of you.");
          type("> Finally, you made it to her, trying to get the words out but you can't.");
          displayDecision(("Show " + loveInterest + " her notebook.").toString(),"empty","empty");
          do{
            choice = input.nextInt();
            switch(choice){
              case 1: type(("> You showed " + loveInterest + " her notebook.").toString());
                      type("> Her reaction was that of both nonplussed and bashful.");
                      type(("> And out of the blue you felt the warmth of " + loveInterest + " body against yours as she hugged you.").toString());
                      type(("> The sunset shimmering down on both of you as the rain stopped and the clouds cleared making " + loveInterest + " eyes glow as she looked at you.").toString());
                      type("> But soon after she pushed away from you grabbing her notebook at the same time.");
                      type(" You couldn't get words out either as you yourself were nonplussed of what just happened. And before you say anything " + loveInterest + " ran off");
                      displayDecision("Run after her", "Decide to go back to school and grab your things and go home", "empty");
                      do{
                        subChoice = input.nextInt();
                        switch(subChoice){
                          case 1: type(("> You decided to run after her and finally caught up to her and had yelled WAIT!!!").toString());
                                  type(("> " + loveInterest + " stopped at the sound of your voice and you ask her on why she had hugged you.").toString());
                                  type(("> " + loveInterest + " explains on what she did while looking at the floor but you see the red in her ears.").toString());
                                  type("> You had felt a beat within your heart on what she had said...");

                                  border("space");
                                  border("dash");
                                  type("> Evening, Nearby Park:");
                                  type("> Alot of things have happened since that day... You couldn't help but think about it-");
                                  type(("> " + loveInterest + ": It's kind of cold, isn't it?").toString());
                                  type(("> " + userName + ": ...Do you need my sweater?").toString());
                                  type(("> " + loveInterest + ": I already have one on. I'd look weird if I have another.").toString());
                                  type(("> " + userName + ": If you say so.").toString());
                                  type(("> " + loveInterest + ": Do you want to crash at my place again?").toString());
                                  type(("> " + userName + ": Of course, but can we stay here for a bit longer?").toString());
                                  type(("> " + loveInterest + ": That's fine, but as your payment...").toString());
                                  type("> She held your chin.");
                                  type(("> " + loveInterest + ": I get to kiss you. That's fine, right?").toString());
                                  type(("> " + userName + ": Kissing? Have we gotten that far already?").toString());
                                  type(("> " + loveInterest + ": Hey! We've been dating for three years already! Now's definitely the time!").toString());
                                  type(("> " + userName + ": Then here goes...").toString());
                                  type("> Your heart couldn't help but race to the moon.");
                                  //Ending 1
                                  type("> [Good ending 1]");
                                  System.exit(1);
                          break;
                          case 2: type(("> You decided to let it go and walk back to the school but the feeling lingered insided of you.").toString());
                                  type(("> Once you had made it back to school you had noticed a figure at the entrence it was " + bestFriend + " with your backpack.").toString());
                                  type(("> " + bestFriend + " asked on where you had ran off too and he had finished up cleaning the rest of the class for you.").toString());
                                  type(("> Once you told " + bestFriend + " on what had happened all he could think of is 'why you didn't ran after her!'").toString());
                                  type(("> And all you could say is 'I didn't know what to do I was in the heat of the moment' still " + bestFriend + " in disbelifed.").toString());
                                  type("> You finally made it home but it was already late so you decided to rest for the night instead of doing classwork.");
                                  border("space");
                                  border("dash");
                                  type("> Evening, Graveyard:");
                                  type("> It was raining and you forgot your umbrella, but who cares anymore...");
                                  type("> It's been three years since that day and three years since she-");
                                  type(("> " + bestFriend + ": Oh, you're here too?").toString());
                                  type("> You nodded.");
                                  type(("> " + bestFriend + ": I only knew her around the end of middleschool, but for you...").toString());
                                  type(("> " + userName + ": Yeah, I know.").toString());
                                  type(("> " + bestFriend + ": It's been a while since we've had a proper conversation. How long was that?").toString());
                                  type(("> " + userName + ": One and a half years, I think. Last time we talked was during an argument.").toString());
                                  type(("> " + bestFriend + ": Oh, that. It's kind of ironic for that argument to be related to the...thing in front of us.").toString());
                                  type(("> " + userName + ": Do you still think it's my fault?").toString());
                                  type(("> " + bestFriend + ": Yes.").toString());
                                  type(("> " + userName + ": ...I'm not going to argue anymore. You're right anyway...").toString());
                                  type(("> " + bestFriend + ": Should we start paying our respects.").toString());
                                  type(("> " + userName + ": Yeah, I'll go after you.").toString());
                                  type(("> " + bestFriend + ": Gotcha.").toString());
                                  type("> After him, you started to pay your respects.");
                                  type("> Do you still regret your decision back then?");
                                  type(("> It doesn't matter anymore. " + loveInterest + " is dead.").toString());
                                  //Ending 2
                                  type("> [Bad ending 1]");
                                  System.exit(2);

                          break;
                          default: System.out.println("- Please enter a valid input.");
                        }
                      } while(subChoice < 0 || subChoice > 2);
              break;
              default: System.out.println("- Please enter a valid input.");
            }
          } while(subChoice < 0 || subChoice > 2);

        } else {
          type("> It would be bad for her to leave something that important. You ran after her.");
          border("space");
          type("> Late Noon, School Gate:");
          type("> Fortunately, she didn't get that far.");
          type(("> " + loveInterest + ": Hey. Did you need me for something?").toString());
          type("> She looked down at the notebook you were holding.");
          displayDecision("You left this.","Don't make me run this late.","empty");
          do{
            choice = input.nextInt();
            switch(choice){
              case 1: type("> " + "You gave her the notebook.");
                      type(("> " + loveInterest + ": Wait, I forgot that? Thanks for-").toString());
              break;
              case 2: type(("> " + loveInterest + ": What are you talking about?").toString());
                      type("> " + "You gave her the notebook.");
                      type(("> " + loveInterest + ": Are you that mad about running? You could of just-").toString());
              break;
              default: System.out.println("- Please enter a valid input.");
            }
          } while(choice < 0 || choice > 3);
          type("> She stopped talking. She then gave you a smile, a big, fake smile.");
          type(("> " + loveInterest + ": " + userName + ". Can I ask you something? Just one simple question?").toString());
          type("> Is she joking about this? You couldn't tell.");
          type(("> " + loveInterest + ": Did you read it?").toString());
          type("> Read what?");
          type(("> " + loveInterest + ": I'm asking you if you read it.").toString());
          type("> The notebook?");
          type(("> " + loveInterest + ": YOU READ IT, DIDN'T YOU!?").toString());
          displayDecision("No, I didn't!","Run away.","empty");
          do{
            choice = input.nextInt();
            switch(choice){
              //fall through switch:
              case 1: type(("> " + loveInterest + ": How should I know you didn't read it, huh!?").toString());
                      type("> She's walking towards you.");
                      type(("> " + loveInterest + ": Show me proof! Show me evidence!").toString());
                      type("> There's no one around. Barely anybody goes to Saturday classes...!");
                      type("> There's no time to think. The last thing to do is-");
              case 2: type(("> " + loveInterest + ": Get back here! You bastard!").toString());
                      type("> You started to sprint away from her.");
              break;
              default: System.out.println("- Please enter a valid input. Your life is on the line here.");
            }
          } while(choice < 0 || choice > 2);
          border("space");
          type("> Late Noon, Hallway:");
          type("> You looked back. There seems to be nobody around.");
          type(("> " + loveInterest + ": Um... " + userName + ". I'm really sorry for what I said...").toString());
          type("> Did she really not mean what she said earlier?");
          displayDecision("Forgive her.","Run.","empty");
          do{
            choice = input.nextInt();
            switch(choice){
              case 1: type("> You chose to forgive her.");
                      border("space");
                      type("> Late Noon, School Yard:");
                      type(("> " + loveInterest + ": I'm really sorry for lashing out! It's just that...It's just-").toString());
                      displayDecision("Take your time.","You don't need to tell me.","It's okay.");
                      do{
                        subChoice = input.nextInt();
                        switch(subChoice){
                          //fall through switch:
                          case 1:
                          case 2:
                          case 3: border("dash");
                                  type("> Huh? No matter what you try to say, words won't come out. What's going on...");
                                  type(("> " + loveInterest + ": That's too bad. For me, that is.").toString());
                                  type("> You felt numb. You fell down to your knees. Everything turned dark...");
                                  //Ending 3
                                  type("> [Bad ending 2]");
                                  System.exit(2);
                          break;
                          default: System.out.println("- There's no wrong answer.");
                        }
                      } while(subChoice < 0 || subChoice > 3);
              break;
              case 2: type("> You continued running.");
                      type("> Even with the physical exhaustion weighing you down, you didn't stop. You couldn't.");
                      border("space");
                      type("> Late Noon, Neighborhood:");
                      type("> Your legs are giving in. You looked back.");
                      type(("> " + classMate + ": Oh, good evening. H-hey... Is something wrong?").toString());
                      type("> Thank goodness... It's not her.");
                      type(("> " + classMate + ": " + userName + "?").toString());
                      displayDecision("Tell her everything.","Lie.","empty");
                      do{
                        subChoice = input.nextInt();
                        switch(subChoice){
                          case 1: type("> You told her without holding anything back.");
                                  type(("> " + classMate + ": She did what? I-isn't that really bad?").toString());
                                  type("> You confirmed her confusion.");
                                  type(("> " + classMate + ": Y-you could call the cops, but I don't think they can do anything.").toString());
                                  type(("> " + classMate + ": Maybe you should stay home until after tomorrow, but doesn't she know where you live?").toString());
                                  type("> You shook your head.");
                                  type(("> " + classMate + ": T-then, uh. I could walk you home...").toString());
                                  displayDecision("Aren't the roles reversed?","Thank you.","empty");
                                  do{
                                    subSubChoice = input.nextInt();
                                    switch(subSubChoice){
                                      case 1: type(("> " + classMate + ": Oh...shoot. Yeah, they are.").toString());
                                              type("> You both laughed for a while.");
                                      break;
                                      case 2: type(("> " + classMate + ": D-don't mention it. I wish I could do more...").toString());
                                      break;
                                      default: System.out.println("- Please enter a valid input.");
                                    }
                                  } while(subSubChoice < 0 || subSubChoice > 2);
                                  type(("> " + classMate + " walked you home.").toString());
                                  characterScore[2] += 1;
                          break;
                          case 2: type("> You told her that you were exercising.");
                                  type(("> " + classMate + ": Exercising? You look as if you're running from some monster.").toString());
                                  type("> She looked up.");
                                  type(("> " + classMate + ": I-it's getting late now, so I'll head home. See you at school.").toString());
                                  type("> You waved goodbye as she walked past you.");
                                  type("> It should be safe to walk home now.");
                          break;
                          default: System.out.println("- Please enter a valid input.");
                        }
                      } while(subChoice < 0 || subChoice > 2);
              break;
              default: System.out.println("- Please enter a valid input.");
            }
          } while (choice < 0 || choice > 3);
            type("> Evening, Home:");
            type("> Once you entered your room, you couldn't help but sleep.");
        }
        border("space");
        border("equal");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
      } else if(day==7){

        type("* Sunday, The last day!");
        border("equal");
        border("space");

        type("Midnight, Home:");
        type("> For some reason, you woke up this late at night. Is someone watching you?");
        type("> There's no way that is the case right? No, considering your situation, it's logical.");
        displayDecision("Maybe I should walk outside.","Sleep again","empty");
        do{
          choice = input.nextInt();
          switch(choice){
            case 1: type("> Fresh air would be nice.");
                    type("> Midnight, Nearby Park:");
                    type("> That feeling of being stalked hasn't gone away.");
                    type("> ???: Oh, that's a suprise.");
                    type("> You turned back.");
                    type(("> " + classMate + ": Good even- I mean morning.").toString());
                    type("> This situation is getting awkward. Should you say something?");
                    displayDecision("Why are you here?","Good evening.","Say nothing.");
                    do{
                      subChoice = input.nextInt();
                      switch(subChoice){
                        case 1: type(("> " + classMate + ": ...cause I couldn't sleep.").toString());
                                type(("> " + classMate + ": What about you?").toString());
                                type("> You mimicked her words.");
                                type(("> " + classMate + ": You too?").toString());
                        break;
                        case 2: type(("> " + classMate + ": You mean morning, right?").toString());
                                type("> She quietly laughed. You couldn't help but awkwardly laugh.");
                                characterScore[2] += 1;
                        break;
                        case 3: type(("> " + classMate + ": ha...ha. Nevermind...").toString());
                                characterScore[2] -= 1;
                        break;
                        default: System.out.println("- Please enter a valid input.");
                      }
                    } while(subChoice<0||subChoice>3);
                    type(("> " + classMate + ": ...I'm getting thirsty. Do you want something?").toString());
                    displayDecision("Water's fine.","Suprise me.","Nah, I'm fine.");
                    do{
                      subChoice = input.nextInt();
                      switch(subChoice){
                        case 1: type(("> " + classMate + ": Okay.").toString());
                                type("> She hurried over to the nearby vending machine and then walked back.");
                                type(("> " + classMate + ": Here...").toString());
                                type(("> Is this water? Isn't this Sprite?"));
                                displayDecision("Call her out.","Pretend it's water","empty");
                                do{
                                  subSubChoice = input.nextInt();
                                  switch(subSubChoice){
                                    case 1: type(("> " + classMate + ": Oh...I'm so sorry.").toString());
                                            type("> You told her to don't worry about it.");
                                            type(("> " + classMate + ": If you say so...").toString());
                                            type("> She looked relieved. You wondered why this sort of thing is a big" +
                                            "\n  deal to her, but she doesn't seem like a person who socializes often.");
                                            characterScore[2] += 1;
                                    break;
                                    case 2: type("> It wouldn't feel right for you to do that. Better than nothing at least.");
                                    break;
                                    default: System.out.println("- Please enter a valid input.");
                                  }
                                } while(subSubChoice<0 || subSubChoice>2);
                        break;
                        case 2: type(("> " + classMate + ": Suprise you? Sure.").toString());
                                type("> She hurried over to the nearby vending machine and then walked back.");
                                type(("> " + classMate + ": Here...").toString());
                                type(("> She handed you a Sprite bottle. You thanked her."));
                                type(("> " + classMate + ": Y-you're welcome.").toString());
                                characterScore[2] += 1;
                        break;
                        case 3: type(("> " + classMate + ": Okay.").toString());
                                type("> She hurried over to the nearby vending machine and then walked back.");
                        break;
                        default: System.out.println("- Please enter a valid input.");
                      }
                    } while(subChoice<0||subChoice>3);
                    type(("> " + classMate + ": This past week has been one of the most...unique ones ever.").toString());
                    type("> She walked towards the swings. You followed her.");
                    type(("> " + classMate + ": From telling me about that weird love letter to all the things that happened" +
                    "\n  and even now. I think I've done more socializing than I ever did in my life.").toString());
                    type("> You weren't sure whether you should congratulate her or laugh at her.");
                    type("> She sat on one of the swings.");
                    displayDecision("Sit next to her.","Give her a push.","Stand in front of her.");
                    do{
                      choice = input.nextInt();
                      switch(subChoice){
                        case 1: type(("> " + classMate + ": ...It's getting cold, huh.").toString());
                                type("> She smiled awkwardly.");
                                characterScore[2] += 1;
                        break;
                        case 2: type(("> " + classMate + ": W-wait why are you pushing me- Wait-").toString());
                                type("> She fell face first to the ground.");
                                type(("> " + classMate + ": ...A little help here?").toString());
                                type("> You apologized and helped her up.");
                                characterScore[2] -= 1;
                        break;
                        case 3: type(("> " + classMate + ": ...this is awkward. Are you counting to 60?").toString());
                                type("> You wondered what she was talking about.");
                                type(("> " + classMate + ": Please ignore what I said...").toString());
                        default: System.out.println("- Please enter a valid input.");
                        break;
                      }
                    } while(subChoice<0||subChoice>3);
                    type("> The two of you went back and forth on various topics for a while...");
                    type(("> " + classMate + ": Oh look at the time. My mom should be back home from work soon, so I need to go.").toString());
                    type("> She smiled and headed her way.");
                    type(("> " + classMate + ": It was nice meeting you.").toString());
                    type("> You should head back home too. You're starting to get tired.");
                    if(characterScore[2] >= 7){
                      type("> But as you tried to take your next step-");
                      type("> You felt someone's hand grasping on your shoulders. You turned around.");
                      type(("> " + classMate + ": H-hey... Um. Can I ask you something? Just one favor...").toString());
                      type("> She fidgets and nervously looks away.");
                      type(("> " + classMate + ": C-crap...crap...oh god. What am I doing...?").toString());
                      type("> Is she speaking her thoughts? Oh, she slapped herself on the cheeks. She stared at you nervously.");
                      type(("> " + classMate + ": Can you...go- I-I mean, uh- Can-you-go-out-with-me-thank-ya-berry-mush!").toString());
                      type("> 'Thank ya berry mush?' You should probably ask her to repeat that-");
                      type("> She ran off... Did she just...confess to you?");
                      displayDecision("Accept.","Reject.","empty");
                      do{
                        subChoice = input.nextInt();
                        switch(subChoice){
                          case 1:
                          case 2: type(("> Before you could say anything, you saw " + loveInterest + " running towards her.").toString());
                          break;
                          default: System.out.println("- Don't screw this up.");
                        }
                      } while (subChoice < 0 || subChoice > 2);
                      displayDecision("Behind you!","Run towards her","empty");
                      do{
                        subChoice = input.nextInt();
                        switch(subChoice){
                          case 1: type(("> " + classMate + ": W-what? AAHHHH!!").toString());
                                  type(("> " + loveInterest + " DON'T YOU EVER THINK OF STEALING HIM!").toString());
                                  if (characterScore[1] > (characterScore[0] + 1)){
                                    type(("> " + loveInterest + ": GET BACK HERE, YOU-").toString());
                                    type("> She was tackled by someone. It was " + bestFriend + ".");
                                    type(("> " + classMate + ": " + bestFriend + "don't! She has a knife!").toString());
                                    type(("> " + bestFriend + ": It's fine! As long as I hold her off, the cops will-").toString());
                                    type("> Before you knew it, he was stabbed.");
                                    type(("> " + loveInterest + " THIS IS WHAT YOU GET FOR GETTING IN MY WAY!").toString());
                                    type("> Instead of falling to the ground, his corpse was stabbed repeatedly over and over.");
                                    type(("> " + loveInterest + " I KNEW IT WAS YOU WHO FOLLOWED ME AROUND! LOOKS LIKE I WIN, HUH?").toString());
                                    type("> Now's not the time to look at the body! You need to do something or else-");
                                    type(("> " + loveInterest + " YOU'RE NEXT, YOU LITTLE WH-").toString());
                                    type("> ???: Freeze! Put your hands up where I can see them!");
                                    type("> It was the police. They came just at the right time...");
                                    type(("> " + loveInterest + " HOW DID YOU- " + bestFriend + "!!!!!!!!!!!!!!!!! YOU LITTLE-").toString());
                                    type("> Officer: This is your second warning! Put your hands where I can see em' and drop your weapon or I'll shoot!");
                                    type("> You sighed in relief, but now's not the right time to relax. You remembered something drastic happened. You headed" +
                                    "\n  towards" + bestFriend + ".");
                                    type("> You frantically try to stop his bleeding, but nothing is working...! Not even your jacket!");
                                    type(("> " + classMate + ": T-take my sweater!").toString());
                                    type("> No good, her sweater isn't working either...!");
                                    type(("> " + loveInterest + ": I LOVED YOU, " + userName + "! I REALLY DID!").toString());
                                    type("> Those words scorched your heart. After all of this and she still dares to say that...!");
                                    displayDecision("Get out of my life!","Get out of my life!","Get out of my life!");
                                    do{
                                      subSubChoice = input.nextInt();
                                      switch(subSubChoice){
                                        case 1:
                                        case 2:
                                        case 3: type(("> " + userName + ": Get out of my life!").toString());
                                        default: System.out.println("- She deserves your hatred.");
                                      }
                                    } while (subSubChoice < 0 || subSubChoice > 3);
                                    type(("> " + loveInterest + ": W-WHY!? " + userName + "! AM I NOT GOOD ENOUGH!?").toString());
                                    type("> She was forced into the police car, never to be heard nor seen again.");
                                    type("> Officer: The ambulance is almost there.");
                                    type("> But will he make it in time? You couldn't tell...");
                                    border("space");
                                    border("dash");
                                    type("> Afternoon, Hospital:");
                                    type("> It's been three whole years since that event. We were told that " + bestFriend + " woke up yesterday from a coma.");
                                    type(("> " + bestFriend + ": Oh, "+ userName + ". It's been a while. You need something?").toString());
                                    type("> Those words that came out... For some reason they felt familiar to you.");
                                    type(("> " + bestFriend + ": Those were the first words I said to you in highschool. It's funny how long we've gotten, huh.").toString());
                                    type("> The both of you laughed.");
                                    type(("> " + bestFriend + ": So where's " + classMate + " right now? You texted me that she's coming too.").toString());
                                    type(("> " + userName + ": She's coming back from her college exams. She'll be here any minute now.").toString());
                                    type(("> " + bestFriend + ": Oh, I forgot you two are now seniors now!").toString());
                                    type("> It's sad he couldn't experience highschool himself, but now's not the time to bring it up.");
                                    type("> You couldn't help but smile at the fact he's back.");
                                    type(("> " + classMate + ": Sorry! I'm late! Traffic ruined my bus ride here!").toString());
                                    type(("> " + bestFriend + ": Don't worry about it! Hey, " + userName + ", are you a prophet or something?").toString());
                                    type(("> " + userName + ": Maybe I am. You can call me Kindred-").toString());
                                    type(("> " + classMate + ": Hey! Now's not the time to joke around!").toString());
                                    type("> She slapped your back a few times.");
                                    type(("> " + userName + ": Ow! That hurts!").toString());
                                    type(("> " + bestFriend + ": Woah, you're more...energetic compared to the last time I saw you. Is it the almightly Kindred's work?").toString());
                                    type(("> " + userName + ": No, she's just excit-").toString());
                                    type(("> " + classMate + ": And what if it is?").toString());
                                    type(("> " + classMate + " took your hand and grasped it tightly.").toString());
                                    type(("> " + bestFriend + ": W-w-w-wait wait wait. Are you two...?").toString());
                                    type(("> " + userName + ": We're dating now.").toString());
                                    type(("> " + bestFriend + ": No way...").toString());
                                    type(("> " + classMate + ": It's true.").toString());
                                    type(("> " + bestFriend + ": S-so what about that letter?").toString());
                                    type(("> " + classMate + ": Who cares about that anymore.").toString());
                                    type("> The three of you laughed before continuing chatting back and forth, losing all sense of time.");
                                    type("> Who cares about some dumb love letter anyway?");
                                    //Ending 4
                                    type("> [Good ending 2]");
                                    System.exit(4);


                                  } else{
                                    border("dash");
                                    type("> Before you knew it, she was stabbed.");
                                    type(("> " + classMate + ": ..." + userName + ". Please...please don't...forget me...").toString());
                                    type("> She fell on her knees, then fell face first to the floor. A pool of blood followed suit.");
                                    type(("> " + loveInterest + " stepped on her corpse, as if her life was a joke to her. She then stomped on it repeatedly.").toString());
                                    type(("> " + loveInterest + ": SEE! THAT'S WHAT YOU GET FOR STEALING HIM! HAHAHAHAHA!").toString());
                                    type("> She laughed maniacially before walking towards you.");
                                    type("> You tried running away, but your legs won't budge. You fell to the floor, unable to move another inch.");
                                    type(("> " + loveInterest + " I'll prove to you why I should be your beloved.").toString());
                                    type("> You couldn't respond. Nothing came out. You can't move anymore. Everything faded to black.");
                                    //Ending 5
                                    type("> [Bad ending 3]");
                                    System.exit(5);
                                  }
                          break;
                          case 2: type(("> You ran towards " + classMate + " as if your life depended on it.").toString());
                                  type(("> " + loveInterest + ": GET BACK HERE, YOU LITTLE- h-h-h-huh?").toString());
                                  type("> You smiled. You felt as if you've achieved a gold medal. You couldn't think of much else at this point.");
                                  type(("> " + classMate + ": " + userName + "? " + userName + "!").toString());
                                  type(("> " + loveInterest + ": H-h-h-h-hey...? Are...are you okay?").toString());
                                  type(("> " + loveInterest + " tried to scoop up your blood from the ground.").toString());
                                  type(("> " + classMate + ": W-what have you done!?").toString());
                                  type(("> " + loveInterest + ": SHUT UP! IT-IT'S YOUR FAULT!").toString());
                                  type("> You felt as if you could only say one last thing.");
                                  displayDecision("I love you...","I love you...","I love you...");
                                  do{
                                    subSubChoice = input.nextInt();
                                    switch(subSubChoice){
                                      case 1:
                                      case 2:
                                      case 3: border("dash");
                                              type(("> " + userName + ": I love you...").toString());
                                      default: System.out.println("- You're going to die.");
                                    }
                                  } while (subSubChoice < 0 || subSubChoice > 3);
                                  type(("> " + loveInterest + ": Y-you do? I'm glad-").toString());
                                  type(("> " + userName + ": " + classMate + ".").toString());
                                  type(("> Everything went dark. You hoped " + classMate + " got out safely. It's time to say goodbye.").toString());
                                  //Ending 6
                                  type("> [Bad ending 4]");
                                  System.exit(6);
                          break;
                          default: System.out.println("- Please enter a valid input.");
                        }
                      } while (subChoice < 0 || subChoice > 2);
                    } else {
                      type("> But as you tried to take your next step-");
                      type("> You felt someone's hand grasping on your shoulders tightly. You turned around.");
                      type(("> " + loveInterest + ": Found you!").toString());
                      type(("> " + classMate + ": " + userName + "! Behind you!").toString());
                      type(("> " + loveInterest + ": " + classMate + ", was it? Stay out of my way!").toString());
                      type(("> " + classMate + ": A-and what if...what if I don't?").toString());
                      type(("> A sharp object came out of " + classMate + "'s sleeves. It was tucked in there the whole time.'").toString());
                      type(("> " + classMate + ": A...A knife!?").toString());
                      type(("> " + classMate + " took a step back. Then she took another.").toString());
                      type(("> " + loveInterest + ": Ha...ha. You wouldn't dare to step in anymore. Man, this thing's such a wonder.").toString());
                      type(("> " + loveInterest + " spun her knife around before pointing it towards your neck. She then opened her lips.").toString());
                      type(("> " + loveInterest + ": W-w-w-w-will you go out with me?").toString());
                      type("> You were too scared to answer. Her exhausted breath began to haze you.");
                      type(("> " + loveInterest + ": I said, WILL YOU GO OUT WITH ME!? HUH!?").toString());
                      type(("> You should say yes. Any other answer and she'll most likely- huh?"));
                      type(("> " + classMate + " pointed to her right towards the playground. " + bestFriend + " was hiding there.").toString());
                      type(("> " + classMate + " then held up three fingers. Is she counting down?").toString());
                      type(("> " + loveInterest + ": WELL!? ARE YOU GOING TO ANSWER!?").toString());
                      type(("> Three.").toString());
                      type("> The knife gradually got closer to your neck.");
                      type(("> Two.").toString());
                      type("> You could feel the tip of the knife. It hurts.");
                      type(("> One.").toString());
                      type(("> " + loveInterest + ": ARE YOU THAT STUPID!?").toString());
                      displayDecision("Push her away.","Reject her.","Laugh.");
                      do{
                        subChoice = input.nextInt();
                        switch(subChoice){
                          case 1: type("> You shoved her away as hard as you can.");
                          break;
                          case 2: type("> You shook your head.");
                          break;
                          case 3: type("> You laughed. You just couldn't help it at this point.");
                          break;
                          default: System.out.println("- Please enter a valid input.");
                        }
                      } while (subChoice < 0 || choice > 3);
                      type(("> " + loveInterest + ": Y-y-y-y-you reject me!? D-DO YOU SEE WHAT'S GOING-").toString());
                      type(("> " + bestFriend + " tackled " + loveInterest + " to the ground.").toString());
                      type(("> " + bestFriend + ": RUN!").toString());
                      type("As if his words were absolute, you, " + classMate + ", and " + bestFriend + " ran off in" +
                      "\n  different directions.");
                      type(("> But before you started running, you turned back to " + loveInterest + ".").toString());
                      type(("> " + loveInterest + ": B-but...but why?").toString());
                      type("> Wasn't it obvious?");
                      type(("> " + userName + ": I'd date anyone but you.").toString());
                      type("> Before hearing her response, you sprinted away from the scene.");
                      type(("> " + loveInterest + ": YOU LITTLE- I SWEAR I'LL GET YOU FOR THIS!").toString());
                      type("> You continued running as if you've never heard a thing.");

                      border("space");
                      border("dash");
                      type("> Midnight, Fast Food Restaurant:");
                      type(("> You arrived inside to see " + classMate + " and " + bestFriend + " waiting for you.").toString());
                      type(("> " + bestFriend + ": Took you long!").toString());
                      type(("> " + classMate + ": G-glad you're safe.").toString());
                      type("> As you sat down with them, you felt as if you were missing some important information.");
                      displayDecision("What happened?","Was this all planned?","empty");
                      do{
                        subChoice = input.nextInt();
                        switch(subChoice){
                          case 1:
                          case 2: type(("> " + classMate + ": I overheard " + loveInterest + " screaming at you.").toString());
                                  type("> She was there the whole time? Then how did she get to-");
                                  type(("> " + classMate + ": I help out the track team from time to time...and they had a meet soon.").toString());
                                  type(("> " + bestFriend + ": Can I go from here? Then, she called me about it.").toString());
                                  type(("> " + bestFriend + ": So we followed you to your house just in case. Figured she'd know where you live and all" +
                                  "\n  and she was there. She knew where exactly your room was and kept peeking at your window...").toString());
                                  type("> Then that creeping suspicion from earlier was true!");
                                  type(("> " + bestFriend + ": Honestly, you leaving your house was pretty much a miracle. If it weren't for that, I" +
                                  "\n  couldn't imagine what would happen.").toString());
                                  type(("> " + bestFriend + ": And for everything else, you already know what happened.").toString());
                          break;
                          default: System.out.println("- Please enter a valid input.");
                        }
                      } while (subChoice < 0 || subChoice > 2);
                      type("> There is also one more thing.");
                      displayDecision("What about her?","Is she coming back?","empty");
                      do{
                        subChoice = input.nextInt();
                        switch(subChoice){
                          case 1:
                          case 2: type(("> " + bestFriend + ": I doubt it. Here, look.").toString());
                                  type("> He showed you his phone.");
                                  type(("> " + bestFriend + ": I recorded the whole thing. Clever, ain't I?").toString());
                                  type(("> " + classMate + ": T-that was my idea. And it's going to the police, of course.").toString());
                                  type(("> " + bestFriend + ": A-ahem. And for that love letter, let's just assume it was " + loveInterest + ".").toString());
                                  type(("> " + classMate + ": Is that fine with you, " + userName + "?").toString());
                                  type("> You nodded.");
                          break;
                          default: System.out.println("- Please enter a valid input.");
                        }
                      } while (subChoice < 0 || subChoice > 2);
                      type(("> " + bestFriend + ": Since we're here, should we eat something?").toString());
                      type(("> " + classMate + ": I've rarely eaten here... What should I pick?").toString());
                      type(("> " + bestFriend + ": Seriously? Then you have to try the Paserimon Special!").toString());
                      type(("> " + classMate + ": P-passermom? S-sure? I guess...").toString());
                      type(("> " + bestFriend + ": Then, what about you, " + userName + "?").toString());
                      type(("> " + userName + ": How about the Kindred special. That looks good.").toString());
                      type("> It doesn't matter who the sender of that letter is anyway. Looking at current events, you should be" +
                      "\n  all safe and sound from now on.");
                      //Ending 7
                      type("> [Good ending 3]");
                      System.exit(7);
                    }
            break;
            case 2: type("> You told yourself to sleep better... It somehow worked.");

                    border("space");
                    border("dash");
                    type("> Morning, ???:");
                    type("> Where are you? Everywhere is pitch dark... You tried stuggling around, but-");
                    type(("> " + loveInterest + ": Good morning, honey.").toString());
                    type("> The lights were turned on. You looked around.");
                    type(("> " + loveInterest + ": Why do you look scared? Don't worry, I'm here.").toString());
                    type("> Your hands and legs are tied together... This isn't your room at all.");
                    type(("> " + loveInterest + ": It's alright. I took care of the other two for you...").toString());
                    type("> The other two? What is she talking-");
                    type(("> " + loveInterest + ": " + bestFriend + "...and " + classMate + " was it? They're no longer here...").toString());
                    type("> You tried screaming, but something was forced into your throat.");
                    type(("> " + loveInterest + ": Here, honey. I made some sphagetti for you. The sauce is a secret!").toString());
                    type("> It tastes disgusting... You should spit it out-");
                    type(("> " + loveInterest + ": Nuh-uh. You need this. This is your breakfast.").toString());
                    type("> She forced it through your throat. You couldn't help but cough repeatedly.");
                    type(("> " + loveInterest + ": Oh, did I do that too hard? No worries.").toString());
                    type("> She gave a big, terrifying smile. She then took out a notebook... Is it that notebook?");
                    type(("> " + loveInterest + ": Are you curious? It's my diary...!").toString());
                    type(("> " + loveInterest + ": I can try again and again. Why? Because we'll be together forever.").toString());
                    type("> Everything turned white. It was over.");
                    type(("> " + loveInterest + ": Did you like my love letter?").toString());
                    type(("> " + loveInterest + ": I love you, " + userName + ".").toString());
                    //Ending 8
                    type("> [Bad ending 5]");
                    System.exit(8);
            break;
            default: System.out.println("- Please enter a valid input.");
          }
        } while(choice<0||choice>2);

      }
    }

    //End of game segment

  }



  /*This method is for displaying the decision choices.*/
  public static void displayDecision(String optionA, String optionB, String optionC){
    String[] optionList = {optionA, optionB, optionC};
    for(int i=1; i<=optionList.length; i++){
      if(optionList[i-1] != "empty"){
        System.out.println("* [ " + (i) + ": " + optionList[i-1] + " ]");
      }
    }
  }

  /*This method is for displaying border lines, such as empty lines.*/
  public static void border(String form){
    if (form == "star"){
      System.out.println("****************************************************************************************************");
    } else if (form == "equal"){
      System.out.println("====================================================================================================");
    } else if (form == "dash"){
      System.out.println("----------------------------------------------------------------------------------------------------");
    } else if (form == "space"){
      System.out.println("");
    }
  }

/*Pause method*/
  public static void pause(long milliseconds) {
    try {
      Thread.sleep(milliseconds);
    }catch (InterruptedException ie) {}
  }

/*Type method*/
  public static void type(String text){
    char letter;
    for(int i = 0; i < text.length(); i++){
      letter = text.charAt(i);
      System.out.print(letter);
      pause(30);
    }
    System.out.println("");
    pause(60);
  }

  /*This is for the -help option*/
  public static void displayHelp(String help, boolean dashHelp) {
    if (dashHelp == true){
      Scanner input = new Scanner(System.in);
      int choice = 0;
      if (help == "rules"){
        border("space");
        type(" | Rules Of Kindred Hearts |");
        type("- You have 7 days to find the author of the mysterious letter.");
        type("- Decisions will display as shown: (Choice 1, Choice 2, Choice 3) or (Choice 1, Choice 2)");
        type("- Answer with the number of the corresponding position of the decision. Let's try it now.");
        type("- EXAMPLE:");
        type("> Timmy: Can you give me some water? I'm thirsty.");
        displayDecision("Chug the water bottle.","Give it to Timmy.","empty");
        type("- To choose an answer the player would either input 1 or 2.");
        do{
          choice = input.nextInt();
          switch(choice){
            case 1: type("> Timmy is now sad.");
            break;
            case 2:type("> Timmy is now happy.");
            break;
            default: System.out.println("> Wrong number.");
          }
        } while (choice < 0 || choice > 2);
        type("- Warning: If anything but a number is inputted, the game will break.");
        type("- Becareful about the choices you make, it will impact what ending you get. ");
        type("- There are a total of 8 endings, 3 good endings and 5 bad endings.");
        border("space");
      } else if (help == "hints"){
        border("space");
        type(" | HINTS |");
        border("space");
        type(" [Good Ending Hint]");
        type("- Make the best impression on each character for the best chance of a good ending");
        border("space");
        type(" [Bad Ending Hint]");
        type("- Throw ethics out the window when finding the bad ending.");
          border("space");
        type("- Your next decision may increase the character level for this character.");
        border("space");
      }
    }
  }

}
