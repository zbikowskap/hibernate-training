package org.example.repository;

import org.example.model.Sticker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StickerRepository extends EntityRepository<Sticker>{
    public StickerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Sticker.class);
    }

    //SELECT * FROM STICKER WHERE NAME = 'FIRE'
    //SQL INJECTION !!
    public List<Sticker> getStickersByName(String name){
        Session session = getSessionFactory().openSession();
        List<Sticker> resultList = session.createQuery(
                "From Sticker s Where s.name = '" + name + "'", Sticker.class)
                .getResultList();
        session.close();
        return resultList;
    }

    public List<Sticker> getStickerByName2(String functionParamName){
        Session session = getSessionFactory().openSession();
        Query<Sticker> query = session.createQuery("From Sticker s Where s.name = :queryName", Sticker.class);
        query.setParameter("queryName", functionParamName);
        List<Sticker> resultList = query.getResultList();
        session.close();
        return resultList;
    }

    public void managedContextExample(Sticker sticker){
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(sticker);
        //TO SIE ZAPISZE DO BAZY DANYCH !!!
        sticker.setName("DUMMY VALUE");
        sticker.setHeight(0.1F);
        transaction.commit();
        session.close();
    }
}
