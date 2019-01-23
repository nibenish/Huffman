import java.io.*;
import java.util.*;


public class outEnt {

  char character;
  List<Integer> binaryRep = new ArrayList<Integer>();

  public outEnt(char c, List<Integer> l) {
    this.character = c;
    this.binaryRep.addAll(l);;
  }

  public String out() {
    String out = new String();
    for (int i = 0; i < this.binaryRep.size(); i++) {
      out += this.binaryRep.get(i);
    }
    return out;
  }

  public outEnt() {}


}
