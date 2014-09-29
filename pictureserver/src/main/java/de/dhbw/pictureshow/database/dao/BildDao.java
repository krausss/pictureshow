package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.Bild;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by krausss on 23.09.2014.
 */
@ApplicationScoped
public class BildDao extends JpaDao<UuidId,Bild> {
    public BildDao() {
    super(Bild.class);
    }

    //Verbindungen erforschen

    public List<Bild> findByUser(User user) //gib mir Bilder für den User
    {
        TypedQuery<Bild> query= entityManager.createQuery("SELECT b FROM Bild b WHERE b.user =:user", Bild.class); //Rückgabe typ und JPQL
        query.setParameter("user", user);
        return query.getResultList();
    }


}
