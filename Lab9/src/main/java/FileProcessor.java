import java.io.*;

public class FileProcessor {

    public void writeToFile(MonitorState state) {
        try {
            FileOutputStream fileOut = new FileOutputStream("src/main/java/files/state.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(state);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public MonitorState readFromFile() {
        MonitorState state = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/java/files/state.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            state = (MonitorState) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return state;
    }
}
