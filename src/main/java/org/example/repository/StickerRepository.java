package org.example.repository;

import org.example.model.Sticker;
import org.hibernate.SessionFactory;

public class StickerRepository extends EntityRepository<Sticker>{
    public StickerRepository(SessionFactory sessionFactory) {
        super(sessionFactory, Sticker.class);
    }
}
