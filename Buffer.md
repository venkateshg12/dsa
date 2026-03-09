Why BufferedReader is faster than Scan function() ?

How scan function read and process input ?

Scanner scan = new Scanner(System.in);
int x = scan.nextInt();
input: 123

-- When we type 123, each key press goes to the keyboard driver in the OS.
The keyboard sends hardware scan codes, which the OS driver converts into characters
according to the keyboard layout.

     These characters are then encoded into bytes (usually using UTF-8 encoding).
     For ASCII characters like 1, 2, 3 the UTF-8 bytes are the same as ASCII values
     (49, 50, 51).

     These bytes are stored in the terminal input buffer until the user presses the Enter key.
     after that it goes to the OS STDIN.
     -- OS STDIN:  STDIN is an operating system input stream (file descriptor 0) that holds input data sent from the terminal so that the program can read it.

now java program runs:
-- [49,50,51,10] --Here 10 represents new line /n
-- The Scanner class uses System.in as an InputStream resource to read input from the operating system's standard (STDIN).
-- (System.in) is an InputStream that is connected to the operating system's standard input (STDIN).
It allows Java programs to read input from the keyboard through the OS stdin.
-- InputStream: InputStream is a Java class that reads data sequentially coming into your program.
-- The input [49,50,51] reads by System.in.read() and after that InputStreadReader converts into characters.
-- InputStreamReader reader = new InputStreamReader(System.in) (Take the byte stream coming from System.in and convert  
 those bytes into characters.)
-- [49, 50, 51, 10] -------> stream of characters: '1' → '2' → '3' → '\n'

      class Scanner {
        InputStreamReader reader;
        Scanner(InputStream source) {
        reader = new InputStreamReader(source);
        }
      }

-- (System.in) passes as constructor in Scanner class and reads the byte source from STDIN and inside the Scanner
constructor java converts into characters by using InputStreamReader.

-- Scanner reads the characters sequentially and stores into token buffer.
read '1' read = 1, buffer="1"
read '2' read = 2, buffer="12"
read '3' read = 3, buffer="123"
read '\n'
-- while converting to token_buffer it also does regex delimiter detection(checking for white spaces and end of lines).
-- A delimiter is a character or pattern that separates pieces of data.
-- After token building Scanner checks if token matches integer pattern ([-+]?[0-9]+) then it converts
-- now Scanner converts that token buffer and into respective type in our case to int (scan.nextInt()).
-- Inside nextInt() it runs Integer.parseInt(token_buffer) or Integer.parseInt("123).

How BufferReader read and process input ?
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
String line = br.readLine();

-- same process till the OS STDIN now it will change slightly.
-- when readLine() function calls.
-- it calls in.read(buffer) where in = InputStreamReader
-- in that read() data from OS STDIN was read (System.in.read) and converts into character stream
   and store into the buffer.
-- after read() function was over and control goes to the readLine() it scans the buffer.
-- buffer = ['1','2','3','\n']
          read '1'  ----   line = "1"
          read '2'  ----   line = "12"
          read '3'  ----   line = "123"   
-- when readLine() finds '\n' it stops 
-- '\n' is NOT included in the string
-- returns a string 

    class BufferedReader {
      Reader in; // in = InputStreamReader
      char[] buffer;
      BufferedReader(Reader in) {
          this.in = in;
          buffer = new char[8192]
      }

      readLine() {

        if (buffer is empty) {
          in.read(buffer);   // fill buffer with characters
        }

        StringBuilder line = "";

        while (true) {
          char c = buffer[nextPosition];
          if (c == '\n') {
              break;         // end of line
          }
          line.append(c);    // collect character
          move pointer forward;
        }
        return line.toString();
      }

      // where in = InputStreadReader
      InputStreamReader.read(char[] buffer) {

          // 1. Read bytes from System.in
          byteData = System.in.read();

          // 2. Convert bytes → characters
          charData = decode(byteData);

          // 3. Put characters into buffer
          buffer = ['1','2','3','\n'];
      }
    }

why bufferedReader more faster than Scanner 

      -- if char matches delimiter (\s+)
            stop token
         else
            token += char
     --  Scanner reads characters one by one.
         For each character it checks if it matches the delimiter regex (\s+) which uses regex engine which is heavier than character comparision.
         If it matches → token stops.
         Otherwise → character is appended to the token.

         After the token is built, Scanner checks if it matches the datatype regex
         (e.g. [-+]?[0-9]+ for integers) before converting it.

         Because of repeated regex checks and token parsing,
         Scanner is slower than BufferedReader.

     -- BufferedReader is faster because it only reads raw text efficiently using a buffer, while Scanner performs      
        additional regex-based tokenization and datatype parsing.
     -- After reading the text we convert into our desirable data types like Integer.parseInt which is cheaper than Scanner 
        parsing