import java.io.*;
import java.util.*;

import static java.sql.Types.NULL;

public class MovieTicket {

    public static void main(String[] args) throws Exception {
        File file;
        file = new File("Movie names.txt");
        Scanner moviescan = new Scanner(file);
        String movie;
        int win = 0;
        char[] wrongLetters = new char[100];
        int r = 0;

        while (moviescan.hasNextLine()) {
            movie = moviescan.nextLine();
            System.out.println(movie);
        }
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Movie names.txt"));
            String line = reader.readLine();
            List<String> words = new ArrayList<>();
            while(line != null) {
                String[] wordsLine = line.split("\n");
                words.addAll(Arrays.asList(wordsLine));
                line = reader.readLine();
            }

            Random rand = new Random(System.currentTimeMillis());
            String randomWord = words.get(rand.nextInt(words.size()));
            System.out.println(randomWord);
            int l = randomWord.length();
            System.out.println(l);

            char fullname[] = randomWord.toCharArray();
            for(int i=0; i<l; i++)
            {
                if(fullname[i] == ' ')
                {
                    fullname[i] = ' ';
                }else {
                    fullname[i] = '_';
                }
                System.out.print(fullname[i]);
             }

            char userInput;
            int flag = 0;



                 for (int i = 0; i < l; i++) {
                     Scanner user = new Scanner(System.in);
                     System.out.println("Type a Character of a Movie");
                     userInput = user.next().charAt(0);
                     for(int k=0; k<l; k++)
                     {
                        if (randomWord.charAt(k) == userInput) {
                            fullname[k] = userInput;
                            flag++;
                        }
                                for(int t=0; t<l; t++){
                                    if(randomWord.charAt(t) != userInput){

                                     wrongLetters[r] = userInput;

                        }}


                     }
                     if(wrongLetters[r] != NULL){
                         r++;
                         System.out.println(r);
                     }
                     for(int h=0; h<=r ; h++){
                         System.out.println(wrongLetters[h]);
                     }
                     if(flag == 0) {

                         System.out.println("The character you choose was wrong!! Try choosing again ");
                     }
                     System.out.println(fullname);
                     flag = 0;



                 }

            for(int j=0; j<l; j++){
                if(fullname[j] == '_'){
                    win++;
                }
            }

            if(win >= 1){
                System.out.println("YOU FUCKING LOSER!!!");
            }else{
                System.out.println("You WIN!!!!!!!");
            }
        } catch (Exception e) {
           System.out.println("File not found"); // Handle this
        }


    }
}

