import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class B extends A{
    int age;

    public B(String name) {
        super(name);
    }

    public B() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
