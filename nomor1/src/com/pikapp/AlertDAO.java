package com.pikapp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public interface AlertDAO {

    UUID addAlert(Date time);


    Date getAlert(UUID id);
}
