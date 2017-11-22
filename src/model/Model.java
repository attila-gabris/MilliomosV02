
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Model {

    public Model() {
    }

    /*
     * A program egy bin fájlból deszerializálja a kérdéseket, és beolvassa a kerdesek listába.
     */
    public List<Kerdes> kerdesDeser() {
        List<Kerdes> kerdesek = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("bin/kerdesek.bin"));
            kerdesek = (List<Kerdes>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        return kerdesek;

    }

    /*
    * A kérdések listáját szerializálja a bin fájlba.
    */
    public void kerdesSer(List<Kerdes> kerdesek) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("bin/kerdesek.bin"));
            oos.writeObject(kerdesek);
            oos.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
