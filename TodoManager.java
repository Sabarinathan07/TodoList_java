import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoManager {


    private final String MENU_STRING  = "Usage :-" + "\n" +
    "$ ./todo add \"todo item\"  # Add a new todo" +"\n"+
    "$ ./todo ls               # Show remaining todos"+"\n"+
    "$ ./todo del NUMBER       # Delete a todo"+"\n"+
    "$ ./todo done NUMBER      # Complete a todo"+"\n"+
    "$ ./todo help             # Show usage"+"\n"+
    "$ ./todo report           # Statistics";

    private final String  TODO_FILE_PATH = "todo.txt";
    private final String  DONE_FILE_PATH = "done.txt";

    public static TodoManager getInstance(){
        return new TodoManager();
    }
    public void showMenu(){
        System.out.println(MENU_STRING);
    }

    public String getTodoPath(){
        return TODO_FILE_PATH;
    }
    public String getDonePath(){
        return DONE_FILE_PATH;
    }


    


public  void createFile(){
    try {
        File myObj1 = new File("todo.txt");
        File myObj2 = new File("done.txt");
        
        if(!myObj1.exists()){
            myObj1.createNewFile();

        }
        if (!myObj2.exists()){
            myObj2.createNewFile();

        }

      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }

    public ArrayList<String> readFile(String filepath) {

        ArrayList<String> todoRemainingList = new ArrayList<>();
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                   
                    todoRemainingList.add(data);
        
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return todoRemainingList;

    }

public void writeFile(String filepath, List<String> currentList) {
try {
FileWriter fileWriter = new FileWriter(filepath);
for (int i = 0; i < currentList.size(); i++) {
    String content = currentList.get(i).toString();
    if(content.length()>0){
    String data = (String)currentList.get(i)+ "\n";
    fileWriter.write(data);
}
}

fileWriter.close();
} catch (Exception e) {

e.printStackTrace();
}

}


   



    
}
