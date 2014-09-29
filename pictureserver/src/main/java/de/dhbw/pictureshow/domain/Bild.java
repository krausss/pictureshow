package de.dhbw.pictureshow.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by krausss on 23.09.2014.
*/

 @Entity // also add to persistence.xml !!
 @XmlRootElement // needed for REST JSON marshalling



public class Bild extends PersistentObject {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getDaten() {
        return daten;
    }

    public void setDaten(byte[] daten) {
        this.daten = daten;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @Column(length = 200)
    private String title;
    @Lob
    private byte[] daten;
    @ManyToOne                  //1 zu n Beziehung
    @JoinColumn(name="user_id")  //registrieren in Persitence XML
    private User user;
}
