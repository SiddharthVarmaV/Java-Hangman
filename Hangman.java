package Java_Hangman;
import java.util.*;
public class Hangman
{
    // all static delerations
    
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
	static String[] words = {"apple", "heart", "cow", "milk","execute","command","lose","loss", "brother", "funny" ,"pizza", "length", "building", "success", "string", "static", "swap", "bilingual", "python", "galaxy", "luxury", "zodiac", "zigzag", "math", "eagle","earth", "future","confuse","annoy", "beatle", "catastrophe"};
    static String dash = "-";
    static int rand = rd.nextInt(words.length);
    static String rand_word = words[rand];
    
    
    static void make_dash_correct_size(){
	    while(rand_word.length()>dash.length()){
	        dash = dash + ("-");
	    }
    }
    
    static void input_and_swap(){
        int lives = 7;
        char letter_input, letter_input_any_case;
        StringBuilder dashes = new StringBuilder(dash);
        String check = "a";
        while(lives > 0){
           System.out.println(dashes);
           System.out.print(" ");
           System.out.println("lives : " + lives);
           System.out.print(" ");
           System.out.print("Enter a letter : ");
           letter_input_any_case = sc.next().charAt(0);
           letter_input = Character.toLowerCase(letter_input_any_case);
           int loop_count = 0;
           for(;loop_count<dash.length();loop_count++){
               if(rand_word.charAt(loop_count)==(letter_input)){
                   dashes.setCharAt(loop_count, letter_input);
               }
           }
           check = dashes.toString();
           if (check.equals(dash)){
               lives--;
           }
           
           if (check.equals(rand_word)){
               break;
           }
           dash = check;
        }
        System.out.println(check);
        String fail = (lives > 0)? "You Win" : "You Lose" ;
        System.out.println(fail);
        if (fail.equals("You Lose")) {
            System.out.println("The word is : \'" + rand_word + "\'");
        }
    } 
	public static void main(String[] args) {
	    make_dash_correct_size();
		input_and_swap();
	}
}