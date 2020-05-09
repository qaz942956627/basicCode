package lu;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小卢
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Comparable {
    private int age;
    private String name;


    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return getAge() - person.getAge();
    }
}
