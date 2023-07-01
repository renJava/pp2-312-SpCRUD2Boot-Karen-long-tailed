package academy.kata.educational_process.pp2SB.PP2_312_SpCRUD2Boot_Karen.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users3")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Wrong format: only letters are allowed.")
    @NotEmpty(message = "Field cannot be empty.")
    private String name;

    @Column(name = "lastName")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$", message = "Wrong format: only letters are allowed.")
    @NotEmpty(message = "Field cannot be empty.")
    private String lastName;

    @Column(name = "age")
    @Min(value = 12, message = "Age must be above 12.")
    @NotNull(message = "Age cannot be null.")
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

}
