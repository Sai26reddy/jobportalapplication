package com.digit.jobPortalApplication.serviceInterface;

import com.digit.jobPortalApplication.exceptionHandling.NoIdExistsException;
import com.digit.jobPortalApplication.model.Admin;

public interface AdminServiceInterface {
public Admin findById(long user_id) throws NoIdExistsException;
}
