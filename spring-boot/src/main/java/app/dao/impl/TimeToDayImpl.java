package app.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import app.dao.TimeToDayDao;
import app.model.TimeToDay;

@Repository
public class TimeToDayImpl implements TimeToDayDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(final TimeToDay timeToDay) {
        entityManager.persist(timeToDay);
    }

    @Override
    public void update(final TimeToDay timeToDay) {
        entityManager.merge(timeToDay);
    }

    @Override
    public TimeToDay getTimeToDayById(final long id) {
        return entityManager.find(TimeToDay.class, id);
    }

    @Override
    public void delete(final long id) {
        TimeToDay timeToDay = getTimeToDayById(id);
        if (timeToDay != null) {
            entityManager.remove(timeToDay);
        }
    }

}