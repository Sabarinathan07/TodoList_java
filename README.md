STEPS TO BE FOLLOWED WHILE RUNNING OUR APP

STEP 1:
    Navigate inside the project directory and Do "npm install" in the terminal.

STEP 2:
    Compile the Todo.java by "javac Todo.java" in the terminal.

STEP 3:
    IN MAC OR LINUX:
        Run the command "chmod 777 ./todo.sh"
    IN WINDOWS:
        RIGHT AND RUN AS ADMINISTRATOR

STEP 4:
    IN MAC OR LINUX:
        change the  variable "todoTxtCli" in todo.test.js as mentioned below.
        let todoTxtCli = (...args) => [`${__dirname}/todo.sh`, ...args].join(" ");
    IN WINDOWS:
        change the  variable "todoTxtCli" in todo.test.js as mentioned below.
        let todoTxtCli = (...args) => [`${__dirname}/todo.bat`, ...args].join(" ");

STEP 5:
    RUN "npm test" in terminal.



        