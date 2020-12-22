
import java.util.*;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  

public class Todo {

    
    static ArrayList<String> currentList= new ArrayList<>(); 
    
    public static void main(String[] args) throws IOException{
        TodoManager manager = TodoManager.getInstance();
        String TODO_PATH = manager.getTodoPath();
        String DONE_PATH = manager.getDonePath();

        manager.createFile();
        ArrayList<String> todoRemainingList = manager.readFile(TODO_PATH);
        
            
            if(args.length == 0){
                manager.showMenu();
            }
            else if(args[0].contains("ls")){
                if(todoRemainingList.size()>0){
                showList(todoRemainingList);
                }
                else{
                    System.out.println("There are no pending todos!");
                }
            }

            else if(args[0].contains("add")){

                    if(args.length == 2){
                
                    todoRemainingList.add(0,args[1]);
                   
                    manager.writeFile(TODO_PATH, todoRemainingList);
                    System.out.println("Added todo: "+"\""+args[1]+"\"");
                    } else{
                        System.out.println("Error: Missing todo string. Nothing added!");
                    }


                } else if (args[0].contains("del")) {
                    
                    if(args.length!=2){
                        System.out.println("Error: Missing NUMBER for deleting todo.");
                    }
                    
                    else if(!todoRemainingList.isEmpty()&& Integer.parseInt(args[1])<=todoRemainingList.size()
                    && Integer.parseInt(args[1])>0
                    ){
                        int x = Integer.parseInt(args[1])-1;
                        
                        todoRemainingList.remove(todoRemainingList.get(x));
                       
                        manager.writeFile(TODO_PATH, todoRemainingList);
                        System.out.println("Deleted todo #"+args[1]);
                    }
                    else{
                        System.out.println("Error: todo #"+args[1]+" does not exist. Nothing deleted.");
                    }

                    
                   


                } else if (args[0].contains("done")) {

                    if(args.length!=2){
                        System.out.println("Error: Missing NUMBER for marking todo as done.");
                    }
                    else if(!todoRemainingList.isEmpty()&& Integer.parseInt(args[1])<=todoRemainingList.size() &&
                    Integer.parseInt(args[1])>0
                    ){
                    int x = Integer.parseInt(args[1]);
                    String data = todoRemainingList.get(x-1);
                    todoRemainingList.remove(x-1);

                    
                    List<String> temp = manager.readFile(DONE_PATH);
                    temp.add(0,data);
                    manager.writeFile(DONE_PATH,temp );
                    manager.writeFile(TODO_PATH,todoRemainingList);
                    System.out.println("Marked todo #"+args[1] +" as done.");

                    }
                    else{
                        System.out.println("Error: todo #"+ args[1] +" does not exist.");
                    }




                } else if (args[0].contains("help")) {
                   manager.showMenu();

                } else if (args[0].contains("report")) {
                    String date = getDate();
                    String pending = manager.readFile(TODO_PATH).size()+"";
                    String completed = manager.readFile(DONE_PATH).size()+"";
                    String message = date+" Pending : "+pending+ " Completed : "+completed;
                    System.out.println(message);

                    
                } else {
                    System.out.println("No such commands exist");
                }
            }

            
            




    public static void showList(ArrayList<String> todoRemainingList) {
        int number = 0;
        int size = todoRemainingList.size();
        for (String item : todoRemainingList) {
            ++number;
            int index = size-number;
            System.out.println("["+ (index+1) + "] " + item);
        }
    }
    public static String getDate(){
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        return new String(dtf.format(now));
    }
    
}