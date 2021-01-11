package world.sake.brewery;

import java.time.LocalDate;
import java.util.List;

public class BreweryResource {

    public String brewery_name;

    public String brewery_name_kana;

    public String address;

    public Integer founded_year;

    public LocalDate established_date;

    public LocalDate defunct_date;

    public List<String> liquors;

    public Status status;

    public String url;

    public String note;

    public Long version_no;

    @Override
    public String toString() {
        return "BreweryResource [brewery_name=" + brewery_name + ", brewery_name_kana=" + brewery_name_kana + ", address=" + address
                + ", founded_year=" + founded_year + ", established_date=" + established_date + ", defunct_date=" + defunct_date
                + ", liquors=" + liquors + ", status=" + status + ", url=" + url + ", note=" + note + ", version_no=" + version_no + "]";
    }

    public static enum Status {
        DRAFT("draft"), RUNNING("running"), STOP("stop");

        private String code;

        Status(String code) {
            this.code = code;
        }

    }
}
