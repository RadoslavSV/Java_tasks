import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLSerializationUser
{
    public static void main(String[] args) throws IOException
    {
        User u1 = new User("ivan2003", "12345678");
        User u2 = new User("ToddHemp", "iamtoddh");
        User u3 = new User("maria123", "myPassword");

        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);

        serializeToXML(users);

        List<User> loadedUsers = deserializeFromXML();

        System.out.println("DATABASE:");
        for(var x : loadedUsers) {
            System.out.println(x);
        }
    }

    private static void serializeToXML(List<User> users) throws IOException {
        FileOutputStream fos = new FileOutputStream("users.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(users);
        encoder.close();
        fos.close();
    }

    private static List<User> deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("users.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        List<User> decodedObject = (List<User>) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedObject;
    }
}
