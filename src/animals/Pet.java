package animals;

import exception.CantTalkException;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Pet extends Object {
    private String name;
    private String address;
    private String phone;
    private int birthYear;

    public Pet(String name) {
        this(name, 0);
    }

    public Pet(String name, int age) {
        setName(name);

        if (age >= 0) {
            this.birthYear = LocalDate.now().getYear() - age;
        } else {
            throw new IllegalArgumentException("Возраст должен быть положительным");
        }
    }

    public void talk() throws CantTalkException {
        System.out.println("Меня зовут " + getName());
    }

    public abstract void eat();

    public String getName() {
        return name;
    }

//    public final String getName() {
//        return name;
//    }

    public void setName(String name) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя животного должно быть заполнено");
        }
    }

    public int getAge() {
        return LocalDate.now()
            .getYear() - birthYear;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Pet{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", birthYear=" + birthYear +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) o;
        return getBirthYear() == pet.getBirthYear()
            && Objects.equals(getName(), pet.getName())
            && Objects.equals(getAddress(), pet.getAddress())
            && Objects.equals(getPhone(), pet.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getPhone(), getBirthYear());
    }
}