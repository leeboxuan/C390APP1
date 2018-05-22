package sg.edu.rp.c346.c390app1;

import java.io.Serializable;

/**
 * Created by 16046473 on 8/1/2018.
 */

public class GetPortfoliosFromFb implements Serializable {
    private String id;
    private String pdUrls;

    public GetPortfoliosFromFb(String pdUrls) {
        this.pdUrls = pdUrls;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPdUrls() {
        return pdUrls;
    }

    public void setPdUrls(String pdUrls) {
        this.pdUrls = pdUrls;
    }


    @Override
    public String toString() {
        return pdUrls;
    }

}

