package Utils;

import java.util.Objects;

public class obj {
    private int num1;
    private int num2;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        obj obj = (obj) o;
        return num1 == obj.num1 && num2 == obj.num2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1, num2);
    }
}
