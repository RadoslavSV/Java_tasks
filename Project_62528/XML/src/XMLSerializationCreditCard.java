import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLSerializationCreditCard
{
    public static void main(String[] args) throws IOException
    {
        CreditCard c1 = new CreditCard("4563960122019991");
        CreditCard c2 = new CreditCard("6011111111111117");
        CreditCard c3 = new CreditCard("4024007177224507");
        CreditCard c4 = new CreditCard("5506900490000444");
        CreditCard c5 = new CreditCard("3530111333300000");
        CreditCard c6 = new CreditCard("4007702835532454");

        List<CreditCard> cards = new ArrayList<>();
        cards.add(c1);
        cards.add(c2);
        cards.add(c3);
        cards.add(c4);
        cards.add(c5);
        cards.add(c6);

        serializeToXML(cards);

        List<CreditCard> loadedCards = deserializeFromXML();

        System.out.println("DATABASE:");
        for(var x : loadedCards) {
            System.out.println(x);
        }
    }

    public static void serializeToXML(List<CreditCard> cards) throws IOException {
        FileOutputStream fos = new FileOutputStream("cards.xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(cards);
        encoder.close();
        fos.close();
    }

    public static List<CreditCard> deserializeFromXML() throws IOException {
        FileInputStream fis = new FileInputStream("cards.xml");
        XMLDecoder decoder = new XMLDecoder(fis);
        List<CreditCard> decodedObject = (List<CreditCard>) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedObject;
    }
}

/* valid cards
4563960122019991
6011111111111117
4024007177224507
5506900490000444
3530111333300000
4007702835532454
 */
