package app.dao;

import app.model.TimeToDay;

public interface TimeToDayDao {

    void create(TimeToDay timeToDay);

    void update(TimeToDay timeToDay);

    TimeToDay getTimeToDayById(long id);

    void delete(long id);
}