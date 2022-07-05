package org.example.repository;

import org.example.model.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OwnerRepository extends EntityRepository<Owner> {
    public OwnerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Owner.class);
    }

    public List<String> getLastName(){
        Session session = getSessionFactory().openSession();
        List<String> resultList = session.createQuery("Select o.lastName From Owner o", String.class)
                .getResultList();
        session.close();
        return resultList;
    }

    public List<Owner> getAllByName(String name){
        //to czesto zostaje takie samo
        Session session = getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Owner> query = cb.createQuery(Owner.class);
        Root<Owner> root = query.from(Owner.class); //<- zbior informacji o tablece

        //glownie tutaj zmieniamy zapytanie
        query.select(root).where(cb.equal(root.get("firstName"), name));

        //wywolanie
        List<Owner> resultList = session.createQuery(query).getResultList();
        session.close();
        return resultList;
    }
}
