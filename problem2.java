import java.io.*;
import java.util.*;

public class problem2 {

  public static void main(String[] args) {
    // set up
    try {
      // create instances of writers/readers
      PrintWriter writer =  new PrintWriter("output.txt", "UTF-8");
      BufferedReader bReader = new BufferedReader(new FileReader(new File(args[0])));
      // initialize arrays
      //List<Integer> charCount = new ArrayList<Integer>();
      int[] charCount = new int[26];
      List<Node> nodes = new ArrayList<Node>();
      List<outEnt> outEnts = new ArrayList<outEnt>();
      int count = 0;
      int in = bReader.read();
      while (in != 10) { // while we keep reading something
        switch ((char) in) { // read() returns int, cast to char
          case 'a': charCount[0]++;
          break;
          case 'b': charCount[1]++;
          break;
          case 'c': charCount[2]++;
          break;
          case 'd': charCount[3]++;
          break;
          case 'e': charCount[4]++;
          break;
          case 'f': charCount[5]++;
          break;
          case 'g': charCount[6]++;
          break;
          case 'h': charCount[7]++;
          break;
          case 'i': charCount[8]++;
          break;
          case 'j': charCount[9]++;
          break;
          case 'k': charCount[10]++;
          break;
          case 'l': charCount[11]++;
          break;
          case 'm': charCount[12]++;
          break;
          case 'n': charCount[13]++;
          break;
          case 'o': charCount[14]++;
          break;
          case 'p': charCount[15]++;
          break;
          case 'q': charCount[16]++;
          break;
          case 'r': charCount[17]++;
          break;
          case 's': charCount[18]++;
          break;
          case 't': charCount[19]++;
          break;
          case 'u': charCount[20]++;
          break;
          case 'v': charCount[21]++;
          break;
          case 'w': charCount[22]++;
          break;
          case 'x': charCount[23]++;
          break;
          case 'y': charCount[24]++;
          break;
          case 'z': charCount[25]++;
          break;
          default: System.out.println("invalid character, must be a-z (lowercase)");
          break;
        } /* switch(in) */
        in = bReader.read();
      } /* while (char != null) */
      // charCount is now full with counts of each char in input String
      // charCount[0] represents frequency of a
      // charCount[1] = b
      // charCount[2] = c...
      for (int i = 0; i < charCount.length; i++) {
        if (charCount[i] != 0) {
          Node n =  new Node(numToChar(i), charCount[i], null, null, null);
          nodes.add(n);

        } /* if() */
      } /* for */
      // each char present in input string now has associated Node w/ freq
      // nodes are stored in List<Node> nodes
      Node head = new Node(nodes.get(0).ch,1,null,null, null);
      while (nodes.size() > 1){

        Node min1 = nodes.get(0);


        for (int i = 0; i < nodes.size(); i++) {
          if (min1.freq > nodes.get(i).freq) {
          min1 = nodes.get(i);
          }
        }
        nodes.remove(min1);
        Node min2 = nodes.get(0);
        for (int i = 0; i < nodes.size(); i++) {
          if (min2.freq > nodes.get(i).freq) {
            min2 = nodes.get(i);
          }
        }
        nodes.remove(min2);
        head = new Node('Q',min1.freq+min2.freq,min1,min2,null);
        nodes.add(head);

      } /* while() */
      // binary tree has been formed, with top node head

//      List<Integer> bin = new ArrayList<Integer>();
      traverse(head,outEnts);//, bin));

      printEnts(outEnts, writer);

      writer.close();
      bReader.close();

    } catch(Exception e) {
      System.err.println(e.getMessage());
    }
  } /* main */

  public static void printEnts(List<outEnt> l, PrintWriter pw) {
    for (int i = 0; i < l.size(); i++){
      pw.print(l.get(i).character + ":" + l.get(i).binaryRep + '\n');
    }
  }

  public static void traverse(Node root, List<outEnt> outList) {//}, List<Integer> i) {
    if (root.ch == 'Q') {
      // do nothing, is count node
    } else {
      outEnt k = new outEnt(root.ch , root.BR);
      outList.add(k);
    }
    if (root.left != null) {
      root.left.BR.addAll(root.BR);
      root.left.BR.add(0);
      traverse(root.left,outList);
    }
    if (root.right != null) {
      root.right.BR.addAll(root.BR);
      root.right.BR.add(1);
      traverse(root.right,outList);
    }
  }


  public static char numToChar(int num) {
    switch (num) {
      case 0: return 'a';
      case 1: return 'b';
      case 2: return 'c';
      case 3: return 'd';
      case 4: return 'e';
      case 5: return 'f';
      case 6: return 'g';
      case 7: return 'h';
      case 8: return 'i';
      case 9: return 'j';
      case 10: return 'k';
      case 11: return 'l';
      case 12: return 'm';
      case 13: return 'n';
      case 14: return 'o';
      case 15: return 'p';
      case 16: return 'q';
      case 17: return 'r';
      case 18: return 's';
      case 19: return 't';
      case 20: return 'u';
      case 21: return 'v';
      case 22: return 'w';
      case 23: return 'x';
      case 24: return 'y';
      case 25: return 'z';
      default: return '\0';
    } /* switch(num) */
  } /* numToChar */
} /* P2 */
