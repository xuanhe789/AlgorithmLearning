import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class JaxbTest {
    public static void main(String[] args) throws JAXBException {
        StringWriter stringWriter = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(A.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        B b = new B();
        b.setAge(14);
        b.setName("bbb");
        marshaller.marshal(b,stringWriter);
        System.out.println(stringWriter.toString());
    }
}
