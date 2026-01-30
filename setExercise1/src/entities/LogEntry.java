package entities;

import java.util.Date;
import java.util.Objects;

public class LogEntry {

    private String usernmae;
    private Date date;

    public LogEntry(String usernmae, Date date) {
        this.usernmae = usernmae;
        this.date = date;
    }

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(usernmae, logEntry.usernmae);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(usernmae);
    }
}
