import java.io.*;
import java.net.*;

class client {
  public static void main(String[] args) {
    try {
      Socket s = new Socket("127.0.0.1", 1201); // Server ip and port

      DataInputStream din = new DataInputStream(s.getInputStream());
      DataOutputStream dout = new DataOutputStream(s.getOutputStream());

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String msgin = "", msgout = "";

      while (!msgin.equals("end")) {
        msgout = br.readLine();
        dout.writeUTF(msgout);
        msgin = din.readUTF();
        System.out.println(msgin); // Printing Server msg.
      }
      s.close();
    } catch (Exception e) {
      // Handle Exceptions
    }
  }
}
