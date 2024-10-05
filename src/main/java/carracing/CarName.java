package carracing;

import java.util.Objects;

public class CarName {
    private static final int CAR_NAME_LENGTH_LIMIT = 5;
    private final String value;

    public CarName(String value) {
        if (!Objects.isNull(value) && value.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return value.equals(carName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
