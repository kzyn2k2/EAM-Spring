package com.eam.app.util;

import org.springframework.data.domain.Page;

import com.eam.app.dto.Pager;
import com.eam.app.dto.department.DepartmentDTO;
import com.eam.app.dto.department.DepartmentInfo;
import com.eam.app.dto.department.DepartmentRegisterForm;
import com.eam.app.model.Department;

public interface DepartmentUtil {

	Department mapEntity(DepartmentRegisterForm form);
	
	Pager<DepartmentInfo> mapToDepartmentInfo(Page<Department> page);
	
	DepartmentDTO mapDTO(Department department);
}
