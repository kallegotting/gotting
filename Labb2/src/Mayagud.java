import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Mayagud implements Comparable<Mayagud> {
    private String namn;
    private String typAvGud;
    private String beskrivning;

    public Mayagud() {
    }

    public Mayagud(String namn){
        this.namn = namn;
    }

    public Mayagud(String namn, String typAvGud, String beskrivning) {
        this.namn = namn;
        this.typAvGud = typAvGud;
        this.beskrivning = beskrivning;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getTypAvGud() {
        return typAvGud;
    }

    public void setTypAvGud(String typAvGud) {
        this.typAvGud = typAvGud;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    @Override
    public int compareTo(Mayagud o) {
        Mayagud n = o;
        return this.namn.compareToIgnoreCase(n.namn);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (!(obj instanceof Mayagud))
            return false;
        if (obj == this)
            return true;
        return this.getNamn() == ((Mayagud) obj).getNamn();
    }

    @Override
    public int hashCode() {
        return namn.hashCode();
    }
}
