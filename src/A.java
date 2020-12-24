import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class A {
    String name;

    public A(String name) {
        this.name = name;
    }

    public A() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
