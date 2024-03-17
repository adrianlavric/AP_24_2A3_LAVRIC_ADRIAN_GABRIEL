package lab3;

import java.time.LocalTime;

public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        if (!first.equals(pair.first))
            return false;
        return second.equals(pair.second);
    }
}

class TimeInterval extends Pair<LocalTime, LocalTime> {
    public TimeInterval(LocalTime startTime, LocalTime endTime) {
        super(startTime, endTime);
    }

}
