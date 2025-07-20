package campus;

import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class Person {
    private String name;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Date getBirthday() {
        return birthday;
    }

    protected void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAgeYears() {
        Date now = new Date();
        return (int) birthday.toInstant().until(now.toInstant(), ChronoUnit.YEARS);
    }
}
