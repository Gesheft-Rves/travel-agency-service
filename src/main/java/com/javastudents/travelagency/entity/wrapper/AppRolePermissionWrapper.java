package com.javastudents.travelagency.entity.wrapper;

import com.javastudents.travelagency.entity.AppPermission;
import com.javastudents.travelagency.entity.AppRole;
import com.javastudents.travelagency.entity.Entity;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class AppRolePermissionWrapper implements Entity {
    private Integer appRolePermissionId;
    private AppRole appRole;
    private AppPermission appPermission;
}
