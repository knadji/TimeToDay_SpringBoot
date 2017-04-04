package app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.TimeToDayDao;
import app.model.TimeToDay;
import app.service.TimeToDayService;

@Service
@Transactional
public class TimeToDayServiceImpl implements TimeToDayService {

    @Autowired
    private TimeToDayDao timeToDayDao;

    @Override
    public void create(final TimeToDay timeToDay) {
        timeToDayDao.create(timeToDay);
    }

}
